package SalicView.backing;

import SalicView.backing.Utils.ADFUtils;
import SalicView.backing.Utils.DBUtils;

import java.sql.SQLException;

import javax.faces.event.ActionEvent;

import oracle.adf.model.OperationBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelDashboard;
import oracle.adf.view.rich.component.rich.layout.RichPanelSplitter;

import oracle.adf.view.rich.component.rich.output.RichOutputLabel;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;
import oracle.jbo.server.ApplicationModuleImpl;

import oracle.jbo.server.ViewObjectImpl;

import oracle.jdbc.internal.OracleTypes;

import org.apache.myfaces.trinidad.component.UIXGroup;

public class HrAdminPage {
    
    private RichTable t1;
    private UIXGroup g1;
    private RichPanelSplitter ps1;
    private RichTable t2;
    private UIXGroup g2;
    private UIXGroup g3;
    private RichPanelDashboard pd2;
    
    private RichOutputLabel totaReq;
    private RichOutputLabel penAppr;
    private RichOutputLabel appr;
    private RichOutputLabel reje;



    private RichInputText mgrItSearch;
    private RichTable mgrTable;
    
    
    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void setG1(UIXGroup g1) {
        this.g1 = g1;
    }

    public UIXGroup getG1() {
        return g1;
    }

    public void setPs1(RichPanelSplitter ps1) {
        this.ps1 = ps1;
    }

    public RichPanelSplitter getPs1() {
        return ps1;
    }

    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }

    public void setG2(UIXGroup g2) {
        this.g2 = g2;
    }

    public UIXGroup getG2() {
        return g2;
    }

    public void setG3(UIXGroup g3) {
        this.g3 = g3;
    }

    public UIXGroup getG3() {
        return g3;
    }

    public void setPd2(RichPanelDashboard pd2) {
        this.pd2 = pd2;
    }

    public RichPanelDashboard getPd2() {
        return pd2;
    }

    public void setTotaReq(RichOutputLabel totaReq) {
        this.totaReq = totaReq;
    }

    public RichOutputLabel getTotaReq() {
        return totaReq;
    }

    public void setPenAppr(RichOutputLabel penAppr) {
        this.penAppr = penAppr;
    }

    public RichOutputLabel getPenAppr() {
        return penAppr;
    }

    public void setAppr(RichOutputLabel appr) {
        this.appr = appr;
    }

    public RichOutputLabel getAppr() {
        return appr;
    }

    public void setReje(RichOutputLabel reje) {
        this.reje = reje;
    }

    public RichOutputLabel getReje() {
        return reje;
    }

    public void setMgrItSearch(RichInputText mgrItSearch) {
        this.mgrItSearch = mgrItSearch;
    }

    public RichInputText getMgrItSearch() {
        return mgrItSearch;
    }

    public void setMgrTable(RichTable mgrTable) {
        this.mgrTable = mgrTable;
    }

    public RichTable getMgrTable() {
        return mgrTable;
    }
    
    public void onClickMDashSearchACL(ActionEvent actionEvent) {
        ViewObject mgrVo=ADFUtils.findIterator("XxQpActionHistoryTVO1Iterator").getViewObject();
        if(mgrItSearch.getValue()!=null){
            ViewCriteria vc=mgrVo.createViewCriteria();
            ViewCriteriaRow vcr=vc.createViewCriteriaRow();
            vcr.setAttribute("ReqNumber", "like %"+mgrItSearch.getValue()+"%");
            vc.addRow(vcr);
            mgrVo.applyViewCriteria(vc);
            mgrVo.executeQuery();
        }else{
            ViewCriteria vc=mgrVo.createViewCriteria();
            ViewCriteriaRow vcr=vc.createViewCriteriaRow();
            vcr.setAttribute("ReqNumber", "");
            vc.addRow(vcr);
            mgrVo.applyViewCriteria(vc);
            mgrVo.executeQuery();
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(mgrTable);
    }
    
    Object[][] dobProcArgs=null;
    public void update_approve(Object header_id, String approver_flag,
                                 String req_num,String User) {
           String str = null;
           Number hdrId=null;
           String userName =User;
        try {
            hdrId= new Number(header_id);
        } catch (SQLException e) {
        }
        ApplicationModuleImpl am =
               (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(null);
           dobProcArgs =
                   new Object[][] { { "IN", hdrId, OracleTypes.NUMBER }, //0
                       { "IN", approver_flag, OracleTypes.VARCHAR }, //1
                       { "IN", userName, OracleTypes.VARCHAR }, //2
                       { "IN", "H", OracleTypes.VARCHAR }, //3  
                       { "IN", "OT", OracleTypes.VARCHAR },//4 p_page
                       { "IN", req_num, OracleTypes.VARCHAR },//5 p_req_number
                       { "OUT", str, OracleTypes.VARCHAR } //6
                       } ;
           try {
               System.err.println("==11====");
               DBUtils.callDBStoredProcedure(am.getDBTransaction(),
                                             "call xx_boq_update_approval(?,?,?,?,?,?,?)",
                                             dobProcArgs);
               System.err.println("==22====");
           } catch (SQLException e) {
               System.err.println("===EXE==" + e.toString());
           }
           str = (String)dobProcArgs[6][1];
           System.err.println("===SEND==" + str);

       }
    public void approveACL(ActionEvent actionEvent) {
        ViewObject mgrVO  = ADFUtils.findIterator("XxQpActionHistoryTVO1Iterator").getViewObject();
    //        mgrVO.getCurrentRow().getAttribute("");
        update_approve(mgrVO.getCurrentRow().getAttribute("HeaderId"), "Y", (String)mgrVO.getCurrentRow().getAttribute("ReqNumber"),
                       (String)mgrVO.getCurrentRow().getAttribute("ApproverUserName"));
        mgrVO.executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(mgrTable);
        OperationBinding ob = (OperationBinding)ADFUtils.getBindingContainer().getOperationBinding("load");
        ob.execute();
        AdfFacesContext.getCurrentInstance().addPartialTarget(totaReq);
        AdfFacesContext.getCurrentInstance().addPartialTarget(penAppr);
        AdfFacesContext.getCurrentInstance().addPartialTarget(appr);
        AdfFacesContext.getCurrentInstance().addPartialTarget(reje);
    }

    public void rejectACL(ActionEvent actionEvent) {
        ViewObject mgrVO  = ADFUtils.findIterator("XxQpActionHistoryTVO1Iterator").getViewObject();
        //        mgrVO.getCurrentRow().getAttribute("");
        update_approve(mgrVO.getCurrentRow().getAttribute("HeaderId"), "N", (String)mgrVO.getCurrentRow().getAttribute("ReqNumber"),
                       (String)mgrVO.getCurrentRow().getAttribute("ApproverUserName"));
        mgrVO.executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(mgrTable);
        OperationBinding ob = (OperationBinding)ADFUtils.getBindingContainer().getOperationBinding("load");
        ob.execute();
        AdfFacesContext.getCurrentInstance().addPartialTarget(totaReq);
        AdfFacesContext.getCurrentInstance().addPartialTarget(penAppr);
        AdfFacesContext.getCurrentInstance().addPartialTarget(appr);
        AdfFacesContext.getCurrentInstance().addPartialTarget(reje);
    }
   
    public void load(){
        ViewObject mgrVo=ADFUtils.findIterator("XxQpActionHistoryTVO1Iterator1").getViewObject();
        System.err.println("total request "+mgrVo.getEstimatedRowCount());
        totaReq.setValue(mgrVo.getEstimatedRowCount());
        AdfFacesContext.getCurrentInstance().addPartialTarget(totaReq);
    }

    public void filterFromInfoletACL(ActionEvent actionEvent) {
        ViewObject mgrVo=ADFUtils.findIterator("XxQpActionHistoryTVO1Iterator1").getViewObject();
        ViewCriteria vcccc=mgrVo.createViewCriteria();
        ViewCriteriaRow vccccr=vcccc.createViewCriteriaRow();
        vccccr.setAttribute("ReqNumber", "");
        vcccc.addRow(vccccr);
        mgrVo.applyViewCriteria(vcccc);
        mgrVo.executeQuery();
        ADFContext aDFContext = ADFContext.getCurrent();
        aDFContext.getPageFlowScope().put("total", mgrVo.getEstimatedRowCount());
        AdfFacesContext.getCurrentInstance().addPartialTarget(mgrTable);
    }

    public void apprInfoletACL(ActionEvent actionEvent) {
        ViewObject mgrVo=ADFUtils.findIterator("XxQpActionHistoryTVO1Iterator1").getViewObject();
        ViewCriteria vc=mgrVo.createViewCriteria();
        ViewCriteriaRow vcr=vc.createViewCriteriaRow();
        vcr.setAttribute("ApproverFlag", "Y");
        vc.addRow(vcr);
        mgrVo.applyViewCriteria(vc);
        mgrVo.executeQuery();
        System.err.println("Approved request "+mgrVo.getEstimatedRowCount());
        ADFContext.getCurrent().getPageFlowScope().put("approved", mgrVo.getEstimatedRowCount());
        AdfFacesContext.getCurrentInstance().addPartialTarget(mgrTable);
    }

    public void rejectInfoletACL(ActionEvent actionEvent) {
        ViewObject mgrVo=ADFUtils.findIterator("XxQpActionHistoryTVO1Iterator1").getViewObject();
        ViewCriteria vcc=mgrVo.createViewCriteria();
        ViewCriteriaRow vccr=vcc.createViewCriteriaRow();
        vccr.setAttribute("ApproverFlag", "N");
        vcc.addRow(vccr);
        mgrVo.applyViewCriteria(vcc);
        mgrVo.executeQuery();
        System.err.println("Rejected request "+mgrVo.getEstimatedRowCount());
         ADFContext.getCurrent().getPageFlowScope().put("rejected", mgrVo.getEstimatedRowCount());
        AdfFacesContext.getCurrentInstance().addPartialTarget(mgrTable);
        
    }

    public void pendingACL(ActionEvent actionEvent) {
        ViewObject mgrVo=ADFUtils.findIterator("XxQpActionHistoryTVO1Iterator1").getViewObject();
        ViewCriteria vccc=mgrVo.createViewCriteria();
        ViewCriteriaRow vcccr=vccc.createViewCriteriaRow();
        vcccr.setAttribute("ApproverFlag", "is null");
        vccc.addRow(vcccr);
        mgrVo.applyViewCriteria(vccc);
        mgrVo.executeQuery();
        System.err.println("Pending request "+mgrVo.getEstimatedRowCount());
        ADFContext.getCurrent().getPageFlowScope().put("pending", mgrVo.getEstimatedRowCount());
    }

    public void onClickFilterTotalStatus(ActionEvent actionEvent) {
        filterHrDashboardStatus(null);
    }

    public void onClickFilterApprovedStatus(ActionEvent actionEvent) {
        filterHrDashboardStatus("APPROVE");
    }

    public void onClickFilterPendingStatus(ActionEvent actionEvent) {
        filterHrDashboardStatus("Pending Approval");
    }

    public void onClickFilterRejectedStatus(ActionEvent actionEvent) {
        filterHrDashboardStatus("REJECT");
    }

    public void onClickFilterDelegateStatus(ActionEvent actionEvent) {
        filterHrDashboardStatus("Delegate");
    }
    
    public void filterHrDashboardStatus(String statusVal) {
          ViewObject employeeVO =
              ADFUtils.findIterator("hrAdminObjROVO1Iterator").getViewObject();
          ViewObjectImpl employeeVOImpl =
              (ViewObjectImpl)employeeVO.getViewObject();
          ViewCriteria employeeVC =
              employeeVOImpl.getViewCriteria("filterByStatus");
          employeeVO.applyViewCriteria(employeeVC);
          employeeVO.setNamedWhereClauseParam("p_Status", statusVal);
          employeeVO.executeQuery();
      }
}
