package SalicAM;

import SalicAM.common.EmployeeDashboardAM;

import java.math.BigDecimal;

import oracle.adf.share.ADFContext;

import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Aug 14 19:55:06 IST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class EmployeeDashboardAMImpl extends ApplicationModuleImpl implements EmployeeDashboardAM {
    /**
     * This is the default constructor (do not remove).
     */
    public EmployeeDashboardAMImpl() {
    }

    /**
     * Container's getter for XxhcmEmpApprDtlsVO1.
     * @return XxhcmEmpApprDtlsVO1
     */
    public ViewObjectImpl getXxhcmEmpApprDtlsVO1() {
        return (ViewObjectImpl)findViewObject("XxhcmEmpApprDtlsVO1");
    }
    
    
    public void load(){
        ViewObject mgrVo=this.getemployeeDashboardROVO2();
        System.err.println("total request "+mgrVo.getEstimatedRowCount());
        ADFContext aDFContext = ADFContext.getCurrent();
        BigDecimal empId = (BigDecimal)aDFContext.getPageFlowScope().get("eempId");
        
        ViewObject mgrVo1=this.getemployeeDashboardROVO1();
        mgrVo1.setNamedWhereClauseParam("p_emp_logged_in", empId);
        mgrVo1.executeQuery();
        
        mgrVo.setNamedWhereClauseParam("p_emp_logged_in", empId);
        mgrVo.executeQuery();
        aDFContext.getPageFlowScope().put("total", mgrVo.getEstimatedRowCount());
        mgrVo.setNamedWhereClauseParam("p_emp_logged_in", empId);
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
        mgrVo.applyViewCriteria(vcccc);
        mgrVo.executeQuery();
        //        mgrVo.getEstimatedRowCount();
    //        AdfFacesContext.getCurrentInstance().addPartialTarget(totaReq);
    }

    /**
     * Container's getter for XxhcmEmpDashboardReqDtlsVO1.
     * @return XxhcmEmpDashboardReqDtlsVO1
     */
    public ViewObjectImpl getXxhcmEmpDashboardReqDtlsVO1() {
        return (ViewObjectImpl)findViewObject("XxhcmEmpDashboardReqDtlsVO1");
    }

    /**
     * Container's getter for employeeDashboardROVO1.
     * @return employeeDashboardROVO1
     */
    public ViewObjectImpl getemployeeDashboardROVO1() {
        return (ViewObjectImpl)findViewObject("employeeDashboardROVO1");
    }

    /**
     * Container's getter for employeeDashboardROVO2.
     * @return employeeDashboardROVO2
     */
    public ViewObjectImpl getemployeeDashboardROVO2() {
        return (ViewObjectImpl)findViewObject("employeeDashboardROVO2");
    }
}
