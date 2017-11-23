package SalicAM;

import SalicAM.common.ManagerDashbordAM;

import SalicROVO.GetJobLevelROVOImpl;
import SalicROVO.GetManagerDetailsROVOImpl;
import SalicROVO.getApprovalGrpDetailsROVOImpl;
import SalicROVO.getApprovalGrpDetailsROVORowImpl;
import SalicROVO.getApprovalSetupDetailsROVOImpl;
import SalicROVO.getApprovalSetupDetailsROVORowImpl;

import common.GenerateEmailTemplate;

import common.pojo.EmailRequestPojo;

import java.math.BigDecimal;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import oracle.adf.share.ADFContext;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.SequenceImpl;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Aug 09 14:00:00 IST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ManagerDashbordAMImpl extends ApplicationModuleImpl implements ManagerDashbordAM {
    /**
     * This is the default constructor (do not remove).
     */
    public ManagerDashbordAMImpl() {
    }

    /**
     * Container's getter for XxhcmApprovalDtlsVO1.
     * @return XxhcmApprovalDtlsVO1
     */
    public ViewObjectImpl getXxhcmApprovalDtlsVO1() {
        return (ViewObjectImpl)findViewObject("XxhcmApprovalDtlsVO1");
    }

    /**
     * Container's getter for XxhcmManagerReqDtlsVO1.
     * @return XxhcmManagerReqDtlsVO1
     */
    public ViewObjectImpl getXxhcmManagerReqDtlsVO1() {
        return (ViewObjectImpl)findViewObject("XxhcmManagerReqDtlsVO1");
    }

    /**
     * Container's getter for XxQpActionHistoryTVO1.
     * @return XxQpActionHistoryTVO1
     */
    public ViewObjectImpl getXxQpActionHistoryTVO1() {
        return (ViewObjectImpl)findViewObject("XxQpActionHistoryTVO1");
    }
    public void load(){
//        ADFContext aDFContext = ADFContext.getCurrent();
//        aDFContext.getPageFlowScope().put("mempId",empId);
        ADFContext aDFContext = ADFContext.getCurrent();
        BigDecimal empId = (BigDecimal)aDFContext.getPageFlowScope().get("mempId");
        ViewObject mgrVo1=this.getmanagerDashbaordROVO1();
        mgrVo1.setNamedWhereClauseParam("p_emp_logged_in", empId);
        mgrVo1.executeQuery();
        
        ViewObject mgrVo=this.getmanagerDashbaordROVO2();
        mgrVo.setNamedWhereClauseParam("p_emp_logged_in", empId);
        System.err.println("total request "+mgrVo.getEstimatedRowCount());
        
        aDFContext.getPageFlowScope().put("total", mgrVo.getEstimatedRowCount());
        
        ViewCriteria vc=mgrVo.createViewCriteria();
        ViewCriteriaRow vcr=vc.createViewCriteriaRow();
        vcr.setAttribute("Status", "APPROVE");
        vc.addRow(vcr);
        mgrVo.applyViewCriteria(vc);
        mgrVo.executeQuery();
        System.err.println("Approved request "+mgrVo.getEstimatedRowCount());
        aDFContext.getPageFlowScope().put("approved", mgrVo.getEstimatedRowCount());
        
        ViewCriteria vcc=mgrVo.createViewCriteria();
        ViewCriteriaRow vccr=vcc.createViewCriteriaRow();
        vccr.setAttribute("Status", "REJECT");
        vcc.addRow(vccr);
        mgrVo.applyViewCriteria(vcc);
        mgrVo.executeQuery();
        System.err.println("Rejected request "+mgrVo.getEstimatedRowCount());
        aDFContext.getPageFlowScope().put("rejected", mgrVo.getEstimatedRowCount());
        
        ViewCriteria vccc=mgrVo.createViewCriteria();
        ViewCriteriaRow vcccr=vccc.createViewCriteriaRow();
        vcccr.setAttribute("Status", "Pending Approval");
        vccc.addRow(vcccr);
        mgrVo.applyViewCriteria(vccc);
        mgrVo.executeQuery();
        System.err.println("Pending request "+mgrVo.getEstimatedRowCount());
        aDFContext.getPageFlowScope().put("pending", mgrVo.getEstimatedRowCount());
        
        ViewCriteria vcccc=mgrVo.createViewCriteria();
        ViewCriteriaRow vccccr=vcccc.createViewCriteriaRow();
        vccccr.setAttribute("RequestNumber", "");
        vcccc.addRow(vccccr);
        mgrVo.applyViewCriteria(null);
        mgrVo.executeQuery();
        //        mgrVo.getEstimatedRowCount();
//        AdfFacesContext.getCurrentInstance().addPartialTarget(totaReq);
    }

    /**
     * Container's getter for XxQpActionHistoryTVO2.
     * @return XxQpActionHistoryTVO2
     */
    public ViewObjectImpl getXxQpActionHistoryTVO2() {
        return (ViewObjectImpl)findViewObject("XxQpActionHistoryTVO2");
    }

    /**
     * Container's getter for managerDashbaordROVO1.
     * @return managerDashbaordROVO1
     */
    public ViewObjectImpl getmanagerDashbaordROVO1() {
        return (ViewObjectImpl)findViewObject("managerDashbaordROVO1");
    }

    /**
     * Container's getter for managerDashbaordROVO2.
     * @return managerDashbaordROVO2
     */
    public ViewObjectImpl getmanagerDashbaordROVO2() {
        return (ViewObjectImpl)findViewObject("managerDashbaordROVO2");
    }

    /**
     * Container's getter for managerDashbaordROVO3.
     * @return managerDashbaordROVO3
     */
    public ViewObjectImpl getmanagerDashbaordROVO3() {
        return (ViewObjectImpl)findViewObject("managerDashbaordROVO3");
    }


    /**
     * Container's getter for XxQpActionHistoryTVO4.
     * @return XxQpActionHistoryTVO4
     */
    public ViewObjectImpl getXxQpActionHistoryTVO4() {
        return (ViewObjectImpl)findViewObject("XxQpActionHistoryTVO4");
    }

    /**
     * Container's getter for manager_QpActionHistory_VL2.
     * @return manager_QpActionHistory_VL2
     */
    public ViewLinkImpl getmanager_QpActionHistory_VL2() {
        return (ViewLinkImpl)findViewLink("manager_QpActionHistory_VL2");
    }
    
    public void prepareMailTemplateAndSend(String approveOrReject) {
        EmailRequestPojo emailReq = new EmailRequestPojo();
        
     
        
        ViewObjectImpl otHdrVO = getmanagerDashbaordROVO1();
        
        String reqType =  getStringBasedOnReqType((String) otHdrVO.getCurrentRow().getAttribute("ReqType"));
        
        emailReq.setRequestId(((BigDecimal) otHdrVO.getCurrentRow().getAttribute("ReqId")).intValue());
        emailReq.setRequestNo((String) otHdrVO.getCurrentRow().getAttribute("RequestNumber"));
        emailReq.setEmpId(((BigDecimal) otHdrVO.getCurrentRow().getAttribute("EmpId")).toString());
        emailReq.setEmpName((String) otHdrVO.getCurrentRow().getAttribute("EmployeeName"));
String empNameR = (String) otHdrVO.getCurrentRow().getAttribute("EmployeeName");
        ArrayList<String> toRecepients = new ArrayList<String>();
        
        getXxQpActionHistoryTVO1().setNamedWhereClauseParam("p_req_typ", getDecodedReqType((String) otHdrVO.getCurrentRow().getAttribute("ReqType")));
        getXxQpActionHistoryTVO1().setNamedWhereClauseParam("p_req_id", ((BigDecimal) otHdrVO.getCurrentRow().getAttribute("ReqId")));
        getXxQpActionHistoryTVO1().executeQuery();
        
        BigDecimal empId = (BigDecimal) ADFContext.getCurrent().getPageFlowScope().get("mempId");
        
        BigDecimal approveLevel = null;
        String firstLevelApproverName = "";
        String secondLevelApproverName = "";
        String rejectReason = "";
        
        ArrayList<String> tableContentCols = new ArrayList<String>();
        LinkedHashMap<String, String> tableColumnDatatypes = null;
        String reqPage = (String) otHdrVO.getCurrentRow().getAttribute("ReqType");
        
        if (reqPage.equalsIgnoreCase("ot")) {
            tableContentCols.add("Overtime Date");
            tableContentCols.add("Overtime Type");
            tableContentCols.add("Overtime Hours");
            tableContentCols.add("Calculated Hours");
            tableContentCols.add("Description");

            emailReq.setTableContentColumns(tableContentCols);


            emailReq.setDetailsQuery("select OVERTIME_DATE,OVERTIME_TYPE,OVERTIME_HOURS,CALCULATED_HOURS,MISSIONS from XXHCM_OVERTIME_DETAILS_ALL where REQ_ID=" +
                                     emailReq.getRequestId());

            tableColumnDatatypes = new LinkedHashMap<String, String>();
            tableColumnDatatypes.put("OVERTIME_DATE", "DATE");
            tableColumnDatatypes.put("OVERTIME_TYPE", "STRING");
            tableColumnDatatypes.put("OVERTIME_HOURS", "STRING");
            tableColumnDatatypes.put("CALCULATED_HOURS", "STRING");
            tableColumnDatatypes.put("MISSIONS", "STRING");
            emailReq.setTableColumnDatatypes(tableColumnDatatypes);

        }
        if(approveOrReject != null && "A".equalsIgnoreCase(approveOrReject)){
       
        
        Row[] rows = getXxQpActionHistoryTVO1().getFilteredRows("ApproverId", empId.toString());
        if(rows != null && rows.length > 0){
            approveLevel = (BigDecimal)rows[0].getAttribute("ApproveLevel");
            firstLevelApproverName = (String) rows[0].getAttribute("ApproverUserName");
            rejectReason = (String)rows[0].getAttribute("ApproverComments");
            BigDecimal nextLevel = approveLevel.add(new BigDecimal(1));
            rows = getXxQpActionHistoryTVO1().getFilteredRows("ApproveLevel", nextLevel);
            if(rows != null && rows.length > 0){
                //next level approver is present.
                secondLevelApproverName = (String) rows[0].getAttribute("ApproverUserName");
                
                //sending email to employee about first level approval complete and nexi is pending
                
                String[] to = { "paas.user@salic.com" }; //TODO get logged in user email
                emailReq.setToEmail(to);
                emailReq.setToEmpName(emailReq.getEmpName());
                //                    emailReq.setToEmail((String[]) toRecepients.toArray());

                emailReq.setSubject("Your "+reqType+" request("+emailReq.getRequestNo()+") is approved from "+firstLevelApproverName+"  pending with "+secondLevelApproverName);
                emailReq.setMessage("Your <b> "+reqType+" request </b>is pending for approval from <b>"+secondLevelApproverName+" </b> with hereunder information:");
               
                
                LinkedHashMap<String, String> actionButtons = new LinkedHashMap<String, String>();
                actionButtons.put("More Info", "");
                emailReq.setActionButtons(actionButtons);
                
                Map<String, String> emailHapmap =
                    GenerateEmailTemplate.prepareEmailTemplate(emailReq, getDBTransaction());

                //Code for Sending email to employee about first level approval complete and nexi is pending
                GenerateEmailTemplate.sendFromGMail(emailReq.getToEmail(), emailHapmap.get("subject"), emailHapmap.get("body"));
                
                //To second approver
               String[] managerUsers = { "paas.user@salic.com" }; //TODO get manager email 
               String mgrUserName = secondLevelApproverName;
               emailReq.setToEmpName(mgrUserName);
               emailReq.setToEmail(managerUsers);
               emailReq.setSubject("Action required for "+ reqType +" request ("+emailReq.getRequestNo()+") of "+emailReq.getEmpName());
               emailReq.setMessage("<b> "+ reqType +
                                   " request </b> for <b>"+emailReq.getEmpName()+ "("+emailReq.getEmpId()+") </b> is pending for your approval with hereunder details:");
               actionButtons = new LinkedHashMap<String, String>();
               actionButtons.put("Approve", "");
               actionButtons.put("Reject", "");
               actionButtons.put("More Info", "");
               emailReq.setActionButtons(actionButtons);
               emailHapmap = GenerateEmailTemplate.prepareEmailTemplate(emailReq, getDBTransaction());

               //Code for Sending email for second approver
               GenerateEmailTemplate.sendFromGMail(emailReq.getToEmail(), emailHapmap.get("subject"), emailHapmap.get("body"));
                
            }
            else{
                
                String[] to = { "paas.user@salic.com" }; //TODO get logged in user email
                emailReq.setToEmail(to);
                emailReq.setToEmpName(emailReq.getEmpName());
                emailReq.setSubject("Your "+reqType+" request("+emailReq.getRequestNo()+") is approved.");
                emailReq.setMessage("Your <b> "+reqType+" request </b> is approved with hereunder information:");
                LinkedHashMap<String, String> actionButtons = new LinkedHashMap<String, String>();
                actionButtons = new LinkedHashMap<String, String>();
                actionButtons.put("More Info", "");
                emailReq.setActionButtons(actionButtons);
                Map<String, String> emailHapmap =
                    GenerateEmailTemplate.prepareEmailTemplate(emailReq, getDBTransaction());
                emailHapmap = GenerateEmailTemplate.prepareEmailTemplate(emailReq, getDBTransaction());

                //Code for Sending email for second approver
                GenerateEmailTemplate.sendFromGMail(emailReq.getToEmail(), emailHapmap.get("subject"), emailHapmap.get("body"));
                //empNameR
                    try {
                        sendFYINotification(emailReq.getRequestNo(), new oracle.jbo.domain.Number(emailReq.getEmpId()),
                                            reqPage, new oracle.jbo.domain.Number(emailReq.getRequestId()), empNameR);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
        }
        }
        else if(approveOrReject != null && "R".equalsIgnoreCase(approveOrReject)){
            String[] to = { "paas.user@salic.com" }; //TODO get logged in user email
            emailReq.setToEmail(to);
            emailReq.setToEmpName(emailReq.getEmpName());
            emailReq.setSubject("Your "+reqType+" request("+emailReq.getRequestNo()+") is rejected.");
            emailReq.setMessage("Your <b> "+reqType+" request </b> is rejected with hereunder information: <br> Reject Reason : "+rejectReason);
            LinkedHashMap<String, String> actionButtons = new LinkedHashMap<String, String>();
            actionButtons = new LinkedHashMap<String, String>();
            actionButtons.put("More Info", "");
            emailReq.setActionButtons(actionButtons);
            Map<String, String> emailHapmap =
                GenerateEmailTemplate.prepareEmailTemplate(emailReq, getDBTransaction());
            emailHapmap = GenerateEmailTemplate.prepareEmailTemplate(emailReq, getDBTransaction());

            //Code for Sending email for second approver
            GenerateEmailTemplate.sendFromGMail(emailReq.getToEmail(), emailHapmap.get("subject"), emailHapmap.get("body"));
        }
    }
    
    
    public void sendFYINotification(String reqNumber,oracle.jbo.domain.Number empId,String reqType,oracle.jbo.domain.Number req_id,String empRName){
        BigDecimal empIdB = empId.bigDecimalValue();
        int apprSeqNew = 0;
        ViewObject approvSetup = getgetApprovalSetupDetailsROVO1();
        approvSetup.setNamedWhereClauseParam("p_appr_type", "FYI");
        approvSetup.setNamedWhereClauseParam("p_req_type", getDecodedReqType(reqType));
        approvSetup.executeQuery();
        RowSetIterator rsi  = null;
        RowSetIterator rsigrpDet = null;
        Integer jobLevelInt = null;
        String JobLevel = null;
        ViewObject empJobLev = getGetJobLevelROVO1();
        empJobLev.setNamedWhereClauseParam("p_emp_id", empIdB);
        empJobLev.executeQuery();
        if(empJobLev.hasNext()){
            JobLevel =  (String)empJobLev.first().getAttribute("JobLevel");
            jobLevelInt = Integer.parseInt(JobLevel);
        }
        try {
            rsi = approvSetup.createRowSetIterator("apprSetup");
            rsi.reset();
            while (rsi.hasNext()) {
                getApprovalSetupDetailsROVORowImpl apprSetRow = (getApprovalSetupDetailsROVORowImpl)rsi.next();
                BigDecimal ApprLevel = apprSetRow.getApprLevel();
                BigDecimal ApprGroupId= apprSetRow.getApprGroupId();
                BigDecimal CustApprGroupId= apprSetRow.getCustApprGroupId();
                BigDecimal managerId = null;
                String managerName = null;
                //Superwiser
                if(ApprGroupId.compareTo(new BigDecimal(100012)) == 0){
                    ViewObject empManager = getGetManagerDetailsROVO1();
                    empManager.setNamedWhereClauseParam("p_emp_id", empIdB);
                    empManager.executeQuery();
                    if(empManager.hasNext()){
                        managerId =  (BigDecimal)empManager.first().getAttribute("ManagerId");
                        //BV_EMP_ID
                        ViewObject empManagerDet = getemployeeROVO1();
                        empManagerDet.setNamedWhereClauseParam("BV_EMP_ID", managerId);
                        empManagerDet.executeQuery();
                        if(empManagerDet.hasNext()){
                            managerName =(String)empManagerDet.first().getAttribute("EmpName");
                        }
                        String[] to = { "paas.user@salic.com" }; //TODO get logged in user email
                        EmailRequestPojo emailReq = new EmailRequestPojo();
                        emailReq.setRequestNo(reqNumber);
                        emailReq.setToEmail(to);
                        emailReq.setToEmpName(managerName);
                        emailReq.setSubject("FYI : "+getStringBasedOnReqType(reqType)+" request ("+emailReq.getRequestNo()+") is approved successfully.");
                        emailReq.setMessage(getStringBasedOnReqType(reqType)+" ("+emailReq.getRequestNo()+") for "+empRName+", is approved successfully. This is for your information Only.");
                        LinkedHashMap<String, String> actionButtons = new LinkedHashMap<String, String>();
                        actionButtons = new LinkedHashMap<String, String>();
                        actionButtons.put("More Info", "");
                        emailReq.setActionButtons(actionButtons);
                        Map<String, String> emailHapmap =
                            GenerateEmailTemplate.prepareEmailTemplate(emailReq, getDBTransaction());
                        emailHapmap = GenerateEmailTemplate.prepareEmailTemplate(emailReq, getDBTransaction());

                        //Code for Sending email for second approver
                        GenerateEmailTemplate.sendFromGMail(emailReq.getToEmail(), emailHapmap.get("subject"), emailHapmap.get("body"));
//                        Row vonew = getXxQpActionHistoryTVO1().createRow();
//                        //xx_qp_action_history_s
//                        apprSeqNew = apprSeqNew + 1;
//                        SequenceImpl si = new SequenceImpl("xx_qp_action_history_s",this.getDBTransaction());
//                        vonew.setAttribute("ActionHistoryId", si.getSequenceNumber());
//                        vonew.setAttribute("HeaderId", req_id.bigDecimalValue());
//                        vonew.setAttribute("ApproveLevel", new BigDecimal(apprSeqNew));
//                        vonew.setAttribute("ApproverId", managerId);
//                        vonew.setAttribute("ApproverUserName", managerName);
//                        vonew.setAttribute("ApproverComments", null);
//                        vonew.setAttribute("ApproverFlag", null);
//                        
//                        vonew.setAttribute("Type", "H");
//                        vonew.setAttribute("Page", getStringBasedOnReqType(reqType));
//                        vonew.setAttribute("ApprType", "Approval");
//                        vonew.setAttribute("CreatedBy", empIdB.toString());
//                        //vonew.setAttribute("CreationDate", apprRow.getAttribute(""));
//                        vonew.setAttribute("LastUpdatedBy", empIdB.toString());
//                        //vonew.setAttribute("LastUpdateDate", apprRow.getAttribute(""));
//                        vonew.setAttribute("LastUpdateLogin", empIdB.toString());
//                        //ReqNumber String  REQ_NUMBER      XxQpActionHistoryTEO    Show    
//                        vonew.setAttribute("ReqNumber", reqNumber);
//                        getXxQpActionHistoryTVO1().insertRow(vonew);
                        
                        if(jobLevelInt == 2){     
                            
                            ViewObject empSManager = getGetManagerDetailsROVO1();
                            empSManager.setNamedWhereClauseParam("p_emp_id", managerId);
                            empSManager.executeQuery();
                            if(empSManager.hasNext()){
                                managerId =  (BigDecimal)empSManager.first().getAttribute("ManagerId");
                                //BV_EMP_ID
                                ViewObject empSManagerDet = getemployeeROVO1();
                                empSManagerDet.setNamedWhereClauseParam("BV_EMP_ID", managerId);
                                empSManagerDet.executeQuery();
                                if(empSManagerDet.hasNext()){
                                    managerName =(String)empSManagerDet.first().getAttribute("EmpName");
                                }else{
                                    managerName = null;
                                }
//                                Row vonew1 = getXxQpActionHistoryTVO1().createRow();
//                                //xx_qp_action_history_s
//                                apprSeqNew = apprSeqNew + 1;
//                                SequenceImpl si1 = new SequenceImpl("xx_qp_action_history_s",this.getDBTransaction());
//                                vonew1.setAttribute("ActionHistoryId", si1.getSequenceNumber());
//                                vonew1.setAttribute("HeaderId", req_id.bigDecimalValue());
//                                vonew1.setAttribute("ApproveLevel", new BigDecimal(apprSeqNew));
//                                vonew1.setAttribute("ApproverId", managerId);
//                                vonew1.setAttribute("ApproverUserName", managerName);
//                                vonew1.setAttribute("ApproverComments", null);
//                                vonew1.setAttribute("ApproverFlag", null);
//                                
//                                vonew1.setAttribute("Type", "H");
//                                vonew1.setAttribute("Page", getStringBasedOnReqType(reqType));
//                                vonew1.setAttribute("ApprType", "Approval");
//                                vonew1.setAttribute("CreatedBy", empIdB.toString());
//                                //vonew.setAttribute("CreationDate", apprRow.getAttribute(""));
//                                vonew1.setAttribute("LastUpdatedBy", empIdB.toString());
//                                //vonew.setAttribute("LastUpdateDate", apprRow.getAttribute(""));
//                                vonew1.setAttribute("LastUpdateLogin", empIdB.toString());
//                                //ReqNumber String  REQ_NUMBER      XxQpActionHistoryTEO    Show    
//                                vonew1.setAttribute("ReqNumber", reqNumber);
//                                getXxQpActionHistoryTVO1().insertRow(vonew1);
                        //String[] to = { "paas.user@salic.com" }; //TODO get logged in user email
                        emailReq = new EmailRequestPojo();
                        emailReq.setToEmail(to);
                                emailReq.setRequestNo(reqNumber);
                        emailReq.setToEmpName(managerName);
                        emailReq.setSubject("FYI : "+getStringBasedOnReqType(reqType)+" ("+emailReq.getRequestNo()+") is approved successfully.");
                        emailReq.setMessage(getStringBasedOnReqType(reqType)+" ("+emailReq.getRequestNo()+") for "+empRName+", is approved successfully. This is for your information Only.");
                        actionButtons = new LinkedHashMap<String, String>();
                        actionButtons = new LinkedHashMap<String, String>();
                        actionButtons.put("More Info", "");
                        emailReq.setActionButtons(actionButtons);
                        emailHapmap =
                            GenerateEmailTemplate.prepareEmailTemplate(emailReq, getDBTransaction());
                        emailHapmap = GenerateEmailTemplate.prepareEmailTemplate(emailReq, getDBTransaction());

                        //Code for Sending email for second approver
                        GenerateEmailTemplate.sendFromGMail(emailReq.getToEmail(), emailHapmap.get("subject"), emailHapmap.get("body"));
                            }
                        }
                    }                    
                }
                //Custom Approval group
                if(ApprGroupId.compareTo(new BigDecimal(100011)) == 0){
                    ViewObject approvgrpDet = getgetApprovalGrpDetailsROVO1();
                    approvgrpDet.setNamedWhereClauseParam("p_cust_group_id", CustApprGroupId);
                    approvgrpDet.executeQuery(); 
                    rsigrpDet = approvgrpDet.createRowSetIterator("grp");
                    while(rsigrpDet.hasNext()){
                        getApprovalGrpDetailsROVORowImpl grpRec = (getApprovalGrpDetailsROVORowImpl)rsigrpDet.next();
//                        Row vonewgrp = getXxQpActionHistoryTVO1().createRow();
//                        //xx_qp_action_history_s
//                        apprSeqNew = apprSeqNew + 1;
//                        SequenceImpl si1 = new SequenceImpl("xx_qp_action_history_s",this.getDBTransaction());
//                        vonewgrp.setAttribute("ActionHistoryId", si1.getSequenceNumber());
//                        vonewgrp.setAttribute("HeaderId", req_id.bigDecimalValue());
//                        vonewgrp.setAttribute("ApproveLevel", new BigDecimal(apprSeqNew));
//                        vonewgrp.setAttribute("ApproverId", grpRec.getEmployeeId());
//                        vonewgrp.setAttribute("ApproverUserName", grpRec.getEmployeeName());
//                        vonewgrp.setAttribute("ApproverComments", null);
//                        vonewgrp.setAttribute("ApproverFlag", null);
//                        
//                        vonewgrp.setAttribute("Type", "H");
//                        vonewgrp.setAttribute("Page", getStringBasedOnReqType(reqType));
//                        vonewgrp.setAttribute("ApprType", "Approval");
//                        vonewgrp.setAttribute("CreatedBy", empIdB.toString());
//                        //vonew.setAttribute("CreationDate", apprRow.getAttribute(""));
//                        vonewgrp.setAttribute("LastUpdatedBy", empIdB.toString());
//                        //vonew.setAttribute("LastUpdateDate", apprRow.getAttribute(""));
//                        vonewgrp.setAttribute("LastUpdateLogin", empIdB.toString());
//                        //ReqNumber String  REQ_NUMBER      XxQpActionHistoryTEO    Show    
//                        vonewgrp.setAttribute("ReqNumber", reqNumber);
//                        getXxQpActionHistoryTVO1().insertRow(vonewgrp);   
                        
                        String[] to = { "paas.user@salic.com" }; //TODO get logged in user email
                        EmailRequestPojo emailReq = new EmailRequestPojo();
                        emailReq.setToEmail(to);
                        emailReq.setRequestNo(reqNumber);
                        emailReq.setToEmpName(grpRec.getEmployeeName());
                        emailReq.setSubject("FYI : "+getStringBasedOnReqType(reqType)+" ("+emailReq.getRequestNo()+") is approved successfully.");
                        emailReq.setMessage(getStringBasedOnReqType(reqType)+" ("+emailReq.getRequestNo()+") for "+empRName+", is approved successfully. This is for your information Only.");
                        LinkedHashMap<String, String> actionButtons = new LinkedHashMap<String, String>();
                        actionButtons = new LinkedHashMap<String, String>();
                        actionButtons.put("More Info", "");
                        emailReq.setActionButtons(actionButtons);
                        Map<String, String> emailHapmap =
                            GenerateEmailTemplate.prepareEmailTemplate(emailReq, getDBTransaction());
                        emailHapmap = GenerateEmailTemplate.prepareEmailTemplate(emailReq, getDBTransaction());

                        //Code for Sending email for second approver
                        GenerateEmailTemplate.sendFromGMail(emailReq.getToEmail(), emailHapmap.get("subject"), emailHapmap.get("body"));
                    }
                    rsigrpDet.closeRowSetIterator();
                }
            }
            rsi.closeRowSetIterator();
        } catch (Exception e) {
            if(rsi!=null){
                rsi.closeRowSetIterator();  
            }
            if(rsigrpDet!=null){
                rsigrpDet.closeRowSetIterator(); 
            }
        }
    }
    private String getStringBasedOnReqType(String reqType){
        String reqty = null;
        if(reqType.equalsIgnoreCase("ot"))
            return "Over Time";       
        if(reqType.equalsIgnoreCase("salary"))
            return "Salary In Advance";
        if(reqType.equalsIgnoreCase("BusinessTrip"))
            return "Business Trip";
        if(reqType.equalsIgnoreCase("BusinessTripCompletion"))
            return "Business Trip Completion";
        if(reqType.equalsIgnoreCase("edu"))
            return "Education Allowance";
        if(reqType.equalsIgnoreCase("letter"))
            return "HR Letter";
        if(reqType.equalsIgnoreCase("vacation"))
            return "Vacation Allowance";
        if(reqType.equalsIgnoreCase("house"))
            return "Housing Adavce";
        
        //house
        
        return reqty;
    }
    
    public String getDecodedReqType(String reqType){
        String reqty = null;
        if(reqType.equalsIgnoreCase("ot"))
            return "OVER_TIME";       
        if(reqType.equalsIgnoreCase("salary"))
            return "SAL_ADV";
        if(reqType.equalsIgnoreCase("BusinessTrip"))
            return "BUSINESS_TRIP";
        if(reqType.equalsIgnoreCase("BusinessTripCompletion"))
            return "BUSINESS_TRIP_COM";
        if(reqType.equalsIgnoreCase("edu"))
            return "EDU_ALL";
        if(reqType.equalsIgnoreCase("letter"))
            return "HR_LETTER";
        if(reqType.equalsIgnoreCase("vacation"))
            return "VAC_ALL";
        if(reqType.equalsIgnoreCase("house"))
            return "HOUSE_ADV";
        
        //house
        
        return reqty;
    }

    /**
     * Container's getter for getApprovalSetupDetailsROVO1.
     * @return getApprovalSetupDetailsROVO1
     */
    public getApprovalSetupDetailsROVOImpl getgetApprovalSetupDetailsROVO1() {
        return (getApprovalSetupDetailsROVOImpl) findViewObject("getApprovalSetupDetailsROVO1");
    }

    /**
     * Container's getter for getApprovalGrpDetailsROVO1.
     * @return getApprovalGrpDetailsROVO1
     */
    public getApprovalGrpDetailsROVOImpl getgetApprovalGrpDetailsROVO1() {
        return (getApprovalGrpDetailsROVOImpl) findViewObject("getApprovalGrpDetailsROVO1");
    }

    /**
     * Container's getter for GetJobLevelROVO1.
     * @return GetJobLevelROVO1
     */
    public GetJobLevelROVOImpl getGetJobLevelROVO1() {
        return (GetJobLevelROVOImpl) findViewObject("GetJobLevelROVO1");
    }

    /**
     * Container's getter for GetManagerDetailsROVO1.
     * @return GetManagerDetailsROVO1
     */
    public GetManagerDetailsROVOImpl getGetManagerDetailsROVO1() {
        return (GetManagerDetailsROVOImpl) findViewObject("GetManagerDetailsROVO1");
    }

    /**
     * Container's getter for employeeROVO1.
     * @return employeeROVO1
     */
    public ViewObjectImpl getemployeeROVO1() {
        return (ViewObjectImpl) findViewObject("employeeROVO1");
    }
}
