package SalicAM.common;

import oracle.jbo.ApplicationModule;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Oct 19 10:12:44 GST 2017
// ---------------------------------------------------------------------
public interface overTimeAM extends ApplicationModule {
    void insertRecords();

    String getAirTicketType(String grade, String dest);

    String getOTGradeEligibility(String grade);

    Number getCurrwncyRate(String fromcurr, String grade);

    Number getPerDMRate(String dest, String grade);
}
