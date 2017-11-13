package SalicAM;


import SalicAM.common.payRollAM;


import oracle.adf.share.ADFContext;

import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Aug 12 12:31:56 IST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class payRollAMImpl extends ApplicationModuleImpl implements payRollAM {
    /**
     * This is the default constructor (do not remove).
     */
    public payRollAMImpl() {
    }


    /**
     * Container's getter for XxQpActionHistoryTVO1.
     * @return XxQpActionHistoryTVO1
     */
    public ViewObjectImpl getXxQpActionHistoryTVO1() {
        return (ViewObjectImpl)findViewObject("XxQpActionHistoryTVO1");
    }

    public void load() {
        ViewObject mgrVo = this.getpayRollObjROVO2();
        System.err.println("total request " + mgrVo.getEstimatedRowCount());
        ADFContext aDFContext = ADFContext.getCurrent();
        aDFContext.getPageFlowScope().put("total",
                                          mgrVo.getEstimatedRowCount());

        ViewCriteria vccc1 = mgrVo.createViewCriteria();
        ViewCriteriaRow vcccr1 = vccc1.createViewCriteriaRow();
        vcccr1.setAttribute("PayrollTansStatus", "Draft");
        vccc1.addRow(vcccr1);
        mgrVo.applyViewCriteria(vccc1);
        mgrVo.executeQuery();
        System.err.println("Pending request " + mgrVo.getEstimatedRowCount());
        aDFContext.getPageFlowScope().put("pending",
                                          mgrVo.getEstimatedRowCount());

        ViewCriteria vc = mgrVo.createViewCriteria();
        ViewCriteriaRow vcr = vc.createViewCriteriaRow();
        vcr.setAttribute("PayrollTansStatus", "IN_PROCESS");
        vc.addRow(vcr);
        mgrVo.applyViewCriteria(vc);
        mgrVo.executeQuery();
        System.err.println("Approved request " + mgrVo.getEstimatedRowCount());
        aDFContext.getPageFlowScope().put("rejected",
                                          mgrVo.getEstimatedRowCount());

        ViewCriteria vcc = mgrVo.createViewCriteria();
        ViewCriteriaRow vccr = vcc.createViewCriteriaRow();
        vccr.setAttribute("PayrollTansStatus", "COMPLETED");
        vcc.addRow(vccr);
        mgrVo.applyViewCriteria(vcc);
        mgrVo.executeQuery();
        System.err.println("Rejected request " + mgrVo.getEstimatedRowCount());
        aDFContext.getPageFlowScope().put("approved",
                                          mgrVo.getEstimatedRowCount());

        ViewCriteria vccc = mgrVo.createViewCriteria();
        ViewCriteriaRow vcccr = vccc.createViewCriteriaRow();
        vcccr.setAttribute("PayrollTansStatus", "ERROR");
        vccc.addRow(vcccr);
        mgrVo.applyViewCriteria(vccc);
        mgrVo.executeQuery();
        System.err.println("error request " + mgrVo.getEstimatedRowCount());
        aDFContext.getPageFlowScope().put("PayrollError",
                                          mgrVo.getEstimatedRowCount());

        ViewCriteria vcccc = mgrVo.createViewCriteria();
        ViewCriteriaRow vccccr = vcccc.createViewCriteriaRow();
        vccccr.setAttribute("RequestNumber", "");
        vcccc.addRow(vccccr);
        mgrVo.applyViewCriteria(vcccc);
        mgrVo.executeQuery();
        //        mgrVo.getEstimatedRowCount();
        //        AdfFacesContext.getCurrentInstance().addPartialTarget(totaReq);
    }

    /**
     * Container's getter for payRollROVO1.
     * @return payRollROVO1
     */
    public ViewObjectImpl getpayRollROVO1() {
        return (ViewObjectImpl)findViewObject("payRollROVO1");
    }

    /**
     * Container's getter for payRollObjROVO1.
     * @return payRollObjROVO1
     */
    public ViewObjectImpl getpayRollObjROVO1() {
        return (ViewObjectImpl)findViewObject("payRollObjROVO1");
    }

    /**
     * Container's getter for payRollObjROVO2.
     * @return payRollObjROVO2
     */
    public ViewObjectImpl getpayRollObjROVO2() {
        return (ViewObjectImpl)findViewObject("payRollObjROVO2");
    }

    /**
     * Container's getter for getPayrollTransStatus_ROV1.
     * @return getPayrollTransStatus_ROV1
     */
    public ViewObjectImpl getgetPayrollTransStatus_ROV1() {
        return (ViewObjectImpl)findViewObject("getPayrollTransStatus_ROV1");
    }

    /**
     * Container's getter for PayrollTransfer_VO1.
     * @return PayrollTransfer_VO1
     */
    public ViewObjectImpl getPayrollTransfer_VO1() {
        return (ViewObjectImpl)findViewObject("PayrollTransfer_VO1");
    }

    /**
     * Container's getter for XxhcmOvertimeHeadersAllVO1.
     * @return XxhcmOvertimeHeadersAllVO1
     */
    public ViewObjectImpl getXxhcmOvertimeHeadersAllVO1() {
        return (ViewObjectImpl)findViewObject("XxhcmOvertimeHeadersAllVO1");
    }

    /**
     * Container's getter for XxhcmOvertimeDetailsAllVO1.
     * @return XxhcmOvertimeDetailsAllVO1
     */
    public ViewObjectImpl getXxhcmOvertimeDetailsAllVO1() {
        return (ViewObjectImpl) findViewObject("XxhcmOvertimeDetailsAllVO1");
    }

    /**
     * Container's getter for payTransOtDtlVL1.
     * @return payTransOtDtlVL1
     */
    public ViewLinkImpl getpayTransOtDtlVL1() {
        return (ViewLinkImpl)findViewLink("payTransOtDtlVL1");
    }

    /**
     * Container's getter for XxhcmOvertimeDetailsAllVO2.
     * @return XxhcmOvertimeDetailsAllVO2
     */
    public ViewObjectImpl getXxhcmOvertimeDetailsAllVO2() {
        return (ViewObjectImpl) findViewObject("XxhcmOvertimeDetailsAllVO2");
    }

    /**
     * Container's getter for personROVO1.
     * @return personROVO1
     */
    public ViewObjectImpl getpersonROVO1() {
        return (ViewObjectImpl)findViewObject("personROVO1");
    }
}
