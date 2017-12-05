package SalicAM.client;

import SalicAM.common.overTimeAM;

import java.math.BigDecimal;

import java.sql.Date;

import java.util.ArrayList;

import oracle.jbo.domain.Number;

import oracle.jbo.client.remote.ApplicationModuleImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Oct 19 10:12:44 GST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class overTimeAMClient extends ApplicationModuleImpl implements overTimeAM {
    /**
     * This is the default constructor (do not remove).
     */
    public overTimeAMClient() {
    }


    public BigDecimal fetchAvlAmountForChild(BigDecimal childId, Date invDate, BigDecimal maxAmt) {
        Object _ret =
            this.riInvokeExportedMethod(this, "fetchAvlAmountForChild",
                                        new String[] { "java.math.BigDecimal", "java.sql.Date",
                                                       "java.math.BigDecimal" },
                                        new Object[] { childId, invDate, maxAmt });
        return (BigDecimal) _ret;
    }

    public ArrayList fetchCurrentChildsInYear(BigDecimal empId) {
        Object _ret =
            this.riInvokeExportedMethod(this, "fetchCurrentChildsInYear", new String[] { "java.math.BigDecimal" },
                                        new Object[] { empId });
        return (ArrayList) _ret;
    }

    public BigDecimal fetchMaxAmountForEmployee(BigDecimal empId) {
        Object _ret =
            this.riInvokeExportedMethod(this, "fetchMaxAmountForEmployee", new String[] { "java.math.BigDecimal" },
                                        new Object[] { empId });
        return (BigDecimal) _ret;
    }

    public void filterReqActionHistory(String reqType, BigDecimal reqId) {
        Object _ret =
            this.riInvokeExportedMethod(this, "filterReqActionHistory",
                                        new String[] { "java.lang.String", "java.math.BigDecimal" },
                                        new Object[] { reqType, reqId });
        return;
    }

    public String getAirTicketType(String grade, String dest) {
        Object _ret =
            this.riInvokeExportedMethod(this, "getAirTicketType",
                                        new String[] { "java.lang.String", "java.lang.String" },
                                        new Object[] { grade, dest });
        return (String) _ret;
    }

    public Number getCurrwncyRate(String fromcurr, String grade) {
        Object _ret =
            this.riInvokeExportedMethod(this, "getCurrwncyRate",
                                        new String[] { "java.lang.String", "java.lang.String" },
                                        new Object[] { fromcurr, grade });
        return (Number) _ret;
    }

    public String getJobLevel(Number empId) {
        Object _ret =
            this.riInvokeExportedMethod(this, "getJobLevel", new String[] { "oracle.jbo.domain.Number" },
                                        new Object[] { empId });
        return (String) _ret;
    }

    public String getOTGradeEligibility(String grade) {
        Object _ret =
            this.riInvokeExportedMethod(this, "getOTGradeEligibility", new String[] { "java.lang.String" },
                                        new Object[] { grade });
        return (String) _ret;
    }

    public Number getPerDMRate(String dest, String grade) {
        Object _ret =
            this.riInvokeExportedMethod(this, "getPerDMRate", new String[] { "java.lang.String", "java.lang.String" },
                                        new Object[] { dest, grade });
        return (Number) _ret;
    }

    public void insertRecords() {
        Object _ret = this.riInvokeExportedMethod(this, "insertRecords", null, null);
        return;
    }

    public void populateApproversForReqest(String reqNumber, Number empId, String reqType, Number req_id) {
        Object _ret =
            this.riInvokeExportedMethod(this, "populateApproversForReqest",
                                        new String[] { "java.lang.String", "oracle.jbo.domain.Number",
                                                       "java.lang.String", "oracle.jbo.domain.Number" },
                                        new Object[] { reqNumber, empId, reqType, req_id });
        return;
    }

    public void prepareMailTemplateAndSend() {
        Object _ret = this.riInvokeExportedMethod(this, "prepareMailTemplateAndSend", null, null);
        return;
    }

    public void prepareMailTemplateAndSend(String approveOrReject) {
        Object _ret =
            this.riInvokeExportedMethod(this, "prepareMailTemplateAndSend", new String[] { "java.lang.String" },
                                        new Object[] { approveOrReject });
        return;
    }

    public void updateApproverStatus() {
        Object _ret = this.riInvokeExportedMethod(this, "updateApproverStatus", null, null);
        return;
    }

    public void updateAutoApprove(Number empId) {
        Object _ret =
            this.riInvokeExportedMethod(this, "updateAutoApprove", new String[] { "oracle.jbo.domain.Number" },
                                        new Object[] { empId });
        return;
    }

    public Boolean validateThreeChildsPerYear(BigDecimal empId, Date invDate, BigDecimal childId) {
        Object _ret =
            this.riInvokeExportedMethod(this, "validateThreeChildsPerYear",
                                        new String[] { "java.math.BigDecimal", "java.sql.Date",
                                                       "java.math.BigDecimal" },
                                        new Object[] { empId, invDate, childId });
        return (Boolean) _ret;
    }
}
