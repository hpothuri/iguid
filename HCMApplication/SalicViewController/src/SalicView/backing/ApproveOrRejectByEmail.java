package SalicView.backing;

import SalicView.backing.Utils.ADFUtils;

import SalicView.backing.Utils.DBUtils;

import common.AESEncryption;

import java.math.BigDecimal;

import java.sql.SQLException;

import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;
import oracle.jbo.server.ApplicationModuleImpl;

import oracle.jdbc.internal.OracleTypes;

public class ApproveOrRejectByEmail {
    public ApproveOrRejectByEmail() {
        super();
    }
    
    public void initAppOrRejByMail(){
        String reqId = AESEncryption.decryptText((String) ADFUtils.evaluateEL("#{param.reqId}"));
        String appOrRejFlag = (String) ADFUtils.evaluateEL("#{param.appOrRej}");
        String approverId = (String) ADFUtils.evaluateEL("#{param.approverId}");
        System.out.println("Req ID : "+reqId);
        System.out.println("App Or Rej flag : "+appOrRejFlag);
        System.out.println("Approver Id : "+approverId);
        
        ViewObject mgrVo =
            ADFUtils.findIterator("managerDashbaordROVO1Iterator").getViewObject();
        mgrVo.setNamedWhereClauseParam("p_emp_logged_in", new BigDecimal(approverId));
        mgrVo.executeQuery();
        oracle.jbo.Row rows[] = mgrVo.getFilteredRows("ReqId", new BigDecimal(reqId));
        if(rows != null && rows.length > 0){
            mgrVo.setCurrentRow(rows[0]);
            if(appOrRejFlag != null && "A".equals(appOrRejFlag)){
                approveACL(reqId,appOrRejFlag,approverId);
            }
            else if(appOrRejFlag != null && "R".equals(appOrRejFlag)){
                rejectACL(reqId, appOrRejFlag, approverId);
            }
        }
    }
    
    public void approveACL(String reqId, String appOrRejFlag, String personId) {
       
        updateApproveRejection(reqId, appOrRejFlag,personId);
        //refresh();
        
        //send emails
        oracle.binding.OperationBinding op = ADFUtils.findOperation("prepareMailTemplateAndSend");
        op.getParamsMap().put("approveOrReject", appOrRejFlag);
        op.execute();
    }
    
    public void rejectACL(String reqId, String appOrRejFlag, String personId) {

        updateApproveRejection(reqId, appOrRejFlag,personId);
        
        //refresh();
        
        oracle.binding.OperationBinding op = ADFUtils.findOperation("prepareMailTemplateAndSend");
        op.getParamsMap().put("approveOrReject", appOrRejFlag);
        op.execute();        
    }
    
    public void updateApproveRejection(Object header_id, String approver_flag, String personId) {
        String str = null;
        Number hdrId = null;
        try {
            hdrId = new Number(header_id);
        } catch (SQLException e) {
        }
        
        ViewObject mgrVo =
            ADFUtils.findIterator("managerDashbaordROVO1Iterator").getViewObject();
        
        BigDecimal empId = new BigDecimal(personId);
        BigDecimal ownerReqId =(BigDecimal)mgrVo.getCurrentRow().getAttribute("EmpId");
        String reqType = (String)mgrVo.getCurrentRow().getAttribute("ReqType");
        String ApprComments = (String)mgrVo.getCurrentRow().getAttribute("ApprComments");
            //ApprComments
        Object[][] dobProcArgs = null;     
        
        ApplicationModuleImpl am =
            (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(null);
        try {
            dobProcArgs = new Object[][] {
                { "IN", approver_flag, OracleTypes.VARCHAR }, //0
                { "IN", reqType, OracleTypes.VARCHAR },
                { "IN", new oracle.jbo.domain.Number(ownerReqId), OracleTypes.NUMBER },
                { "IN", new oracle.jbo.domain.Number(empId), OracleTypes.NUMBER },
                { "IN", hdrId, OracleTypes.NUMBER }, //1 
                { "IN", ApprComments, OracleTypes.VARCHAR },
                { "OUT", str, OracleTypes.VARCHAR }
            };
        } catch (SQLException e) {
        }
        try {
            System.err.println("==11====");
            DBUtils.callDBStoredProcedure(am.getDBTransaction(),
                                          "call XXSALIC_HCM_PKG.XXSALIC_APPROVAL_PRC(?,?,?,?,?,?,?)",
                                          dobProcArgs);
            System.err.println("==22====");
        } catch (SQLException e) {
            System.err.println("===EXE==" + e.toString());
        }
    }
}
