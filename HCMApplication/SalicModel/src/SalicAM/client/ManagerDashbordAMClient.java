package SalicAM.client;

import SalicAM.common.ManagerDashbordAM;

import java.math.BigDecimal;

import oracle.jbo.client.remote.ApplicationModuleImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Aug 09 14:02:44 IST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ManagerDashbordAMClient extends ApplicationModuleImpl implements ManagerDashbordAM {
    /**
     * This is the default constructor (do not remove).
     */
    public ManagerDashbordAMClient() {
    }


    public void deleteActionReqHist(BigDecimal reqId) {
        Object _ret =
            this.riInvokeExportedMethod(this, "deleteActionReqHist", new String[] { "java.math.BigDecimal" },
                                        new Object[] { reqId });
        return;
    }

    public void load() {
        Object _ret = this.riInvokeExportedMethod(this, "load", null, null);
        return;
    }

    public void populateApproversForReqest(String reqNumber, oracle.jbo.domain.Number empId, String reqType,
                                           oracle.jbo.domain.Number req_id) {
        Object _ret =
            this.riInvokeExportedMethod(this, "populateApproversForReqest",
                                        new String[] { "java.lang.String", "oracle.jbo.domain.Number",
                                                       "java.lang.String", "oracle.jbo.domain.Number" },
                                        new Object[] { reqNumber, empId, reqType, req_id });
        return;
    }

    public void prepareMailTemplateAndSend(String approveOrReject) {
        Object _ret =
            this.riInvokeExportedMethod(this, "prepareMailTemplateAndSend", new String[] { "java.lang.String" },
                                        new Object[] { approveOrReject });
        return;
    }

    public void updateHeaderStatus(BigDecimal reqId, BigDecimal approvalTemplateId, String reqStatus, String status) {
        Object _ret =
            this.riInvokeExportedMethod(this, "updateHeaderStatus",
                                        new String[] { "java.math.BigDecimal", "java.math.BigDecimal",
                                                       "java.lang.String", "java.lang.String" },
                                        new Object[] { reqId, approvalTemplateId, reqStatus, status });
        return;
    }
}
