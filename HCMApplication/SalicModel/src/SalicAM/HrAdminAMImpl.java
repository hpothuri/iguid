package SalicAM;


import SalicAM.common.HrAdminAM;

import oracle.adf.share.ADFContext;

import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Aug 11 18:25:47 IST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class HrAdminAMImpl extends ApplicationModuleImpl implements HrAdminAM {
    /**
     * This is the default constructor (do not remove).
     */
    public HrAdminAMImpl() {
    }

    /**
     * Container's getter for HrAdminROVO2.
     * @return HrAdminROVO2
     */
    public ViewObjectImpl getHrAdminROVO2() {
        return (ViewObjectImpl)findViewObject("HrAdminROVO2");
    }

    public void load(){
        ViewObject mgrVo=this.gethrAdminObjROVO2();
        System.err.println("total request "+mgrVo.getEstimatedRowCount());
        ADFContext aDFContext = ADFContext.getCurrent();
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
        mgrVo.applyViewCriteria(vcccc);
        mgrVo.executeQuery();
        //        mgrVo.getEstimatedRowCount();
    //        AdfFacesContext.getCurrentInstance().addPartialTarget(totaReq);
    }

    /**
     * Container's getter for XxQpActionHistoryTVO1.
     * @return XxQpActionHistoryTVO1
     */
    public ViewObjectImpl getXxQpActionHistoryTVO1() {
        return (ViewObjectImpl)findViewObject("XxQpActionHistoryTVO1");
    }

    /**
     * Container's getter for hrAdminObjROVO1.
     * @return hrAdminObjROVO1
     */
    public ViewObjectImpl gethrAdminObjROVO1() {
        return (ViewObjectImpl)findViewObject("hrAdminObjROVO1");
    }

    /**
     * Container's getter for hrAdminObjROVO2.
     * @return hrAdminObjROVO2
     */
    public ViewObjectImpl gethrAdminObjROVO2() {
        return (ViewObjectImpl)findViewObject("hrAdminObjROVO2");
    }
}
