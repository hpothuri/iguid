package com.schedule;

import java.io.IOException;
import java.io.StringReader;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import oracle.ldap.util.AccessDeniedException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

//import ws.AccessDeniedException;
//import ws.InvalidParametersException;
//import ws.OperationFailedException;
//import ws.PublicReportService;
//import ws.PublicReportServiceService;
//
//import ws.types.ArrayOfParamNameValue;
//import ws.types.ArrayOfString;
//import ws.types.ParamNameValue;
//import ws.types.ReportRequest;
//import ws.types.ReportResponse;
//import ws.types.ScheduleRequest;

public class GenInvoke {


    public synchronized void processData(SchedulePOJO sP) {

        Context ctx;
        Connection con = null;
        CallableStatement stmt = null, stmt1 = null;
        Statement stmt2 = null;
        ResultSet rs = null;
        List<SchedulePOJO> sPr = new ArrayList<SchedulePOJO>();
        sPr = getData(sP);

        for (SchedulePOJO r : sPr) {
//            System.err.println("Schedule Name : " + r.getSchdName());
            /****************************CHANGING STATUS TO RUNNING************************************/
            try {
                ctx = new InitialContext();
                DataSource ds = (DataSource)ctx.lookup(sP.getDbSrc());
                con = ds.getConnection();
                String query =
                    "UPDATE  XXFND_SCHEDULE_LIST_T " + "SET  SCHEDULE_STATUS = 'RUNNING'" +
                    "WHERE  SCHEDULE_STATUS= 'PENDING'" +
                    "and    SCHEDULE_NAME = '" + r.getSchdName() + "'";
                stmt2 = con.createStatement();
                int i1 = stmt2.executeUpdate(query);
            } catch (Exception e) {
                System.err.println("Exception in Update Running " + e);
            } finally {
                closeCon(rs, stmt2, stmt, stmt1, con);
            }

            try {

                //                                invokeReport(r);
                GenInvokeN gi = new GenInvokeN();
                String temp = gi.invokeReport(r);
                if (temp != null) {
                    throw new Exception(temp);
                }

            } catch (Exception e) {
                /****************************CHANGING STATUS TO ERROR************************************/
                try {
                    ctx = new InitialContext();
                    DataSource ds = (DataSource)ctx.lookup(sP.getDbSrc());
                    con = ds.getConnection();
                    String query =
                        "UPDATE  XXFND_SCHEDULE_LIST_T " + "SET  SCHEDULE_STATUS = 'ERROR'," +
                        "ERROR_MESSAGE = '" + e.getMessage() + "'" +
                        //                    "ERROR_MESSAGE = '" + e + "'" +
                        "WHERE  SCHEDULE_STATUS= 'RUNNING'" +
                        "and    SCHEDULE_NAME = '" + r.getSchdName() + "'";
                    stmt2 = con.createStatement();
                    int i3 = stmt2.executeUpdate(query);
                } catch (Exception e1) {
                    System.err.println("Exception in Update ERROR " + e1);
                } finally {
                    closeCon(rs, stmt2, stmt, stmt1, con);
                }
            }

            /****************************CHANGING STATUS TO COMPLETED************************************/
            try {
                ctx = new InitialContext();
                DataSource ds = (DataSource)ctx.lookup(sP.getDbSrc());
                con = ds.getConnection();
                String query =
                    "UPDATE  XXFND_SCHEDULE_LIST_T " + "SET  SCHEDULE_STATUS = 'COMPLETED'" +
                    "WHERE  SCHEDULE_STATUS= 'RUNNING'" +
                    "and    SCHEDULE_NAME = '" + r.getSchdName() + "'";
                stmt2 = con.createStatement();
                int i2 = stmt2.executeUpdate(query);
            } catch (Exception e) {
                System.err.println("Exception in Update COMPLETED " + e);
            } finally {
                closeCon(rs, stmt2, stmt, stmt1, con);
            }

        }
    }


//    public synchronized void invokeReport(SchedulePOJO sP) throws ParserConfigurationException,
//                                                                  SAXException,
//                                                                  IOException,
//                                                                  InvalidParametersException,
//                                                                  AccessDeniedException,
//                                                                  OperationFailedException {
//
//        String str;
//        Context ctx;
//        Connection con = null;
//        CallableStatement stmt = null, stmt1 = null;
//        Statement stmt2 = null;
//        ResultSet rs = null;
//        ScheduleRequest sreq = new ScheduleRequest();
//        PublicReportServiceService publicReportServiceService =
//            new PublicReportServiceService();
//        PublicReportService publicReportService =
//            publicReportServiceService.getPublicReportService();
//        ReportRequest reportRequest = new ReportRequest();
//        reportRequest.setAttributeFormat("xml");
//        reportRequest.setAttributeLocale("en-US");
//        reportRequest.setAttributeTemplate("Simple");
//        reportRequest.setByPassCache(true);
//        reportRequest.setSizeOfDataChunkDownload(-1);
//        reportRequest.setReportAbsolutePath(sP.getRptPath().trim() + "/" +
//                                            sP.getRptName().trim() + ".xdo");
//        System.out.println("Report Name  : " + sP.getRptName() +
//                           " Param val--> " + sP.getParamVal());
//        ArrayOfParamNameValue pNameValue = new ArrayOfParamNameValue();
//        ParamNameValue nameValue1 = new ParamNameValue();
//        nameValue1.setName("p_last_update_date");
//        ArrayOfString aos1 = new ArrayOfString();
//
//        aos1.getItem().add(sP.getParamVal());
//        // System.err.println("Date : " + sP.getParamVal());
//        nameValue1.setValues(aos1);
//        pNameValue.getItem().add(nameValue1);
//        reportRequest.setParameterNameValues(pNameValue);
//        sreq.setReportRequest(reportRequest);
//        sreq.setSaveDataOption(true);
//        sreq.setScheduleBurstringOption(false);
//        sreq.setSchedulePublicOption(true);
//        sreq.setUserJobName("TEST");
//        ReportResponse response = new ReportResponse();
//
//        response =
//                publicReportService.runReport(reportRequest, sP.getUserName(),
//                                              sP.getPassWord());
//        str = response.getReportBytesAsString();
//        //        System.out.println(" Response string : \n " + str);
//        DocumentBuilder db;
//        db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//        InputSource is = new InputSource();
//        is.setCharacterStream(new StringReader(str));
//        Document doc = db.parse(is);
//        NodeList nodes = doc.getElementsByTagName("G_1");
//        try {
//            if (nodes.getLength() != 0) {
//                ctx = new InitialContext();
//                DataSource ds = (DataSource)ctx.lookup(sP.getDbSrc());
//                con = ds.getConnection();
//                stmt = con.prepareCall("{call " + sP.getRfshPkg() + "(?)}");
//                stmt.setString(1, str);
//                stmt.executeUpdate();
//            }
//        } catch (Exception e) {
//            System.err.println("Exception in Report call " + e);
//        } finally {
//            closeCon(rs, stmt2, stmt, stmt1, con);
//        }
//    }


    public synchronized List<SchedulePOJO> getData(SchedulePOJO sP) {

        Context ctx;
        Connection con = null;
        CallableStatement stmt = null, stmt1 = null;
        Statement stmt2 = null;
        ResultSet rs = null;
        String val = null;
        List<SchedulePOJO> sPl = new ArrayList<SchedulePOJO>();
        try {
            ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup(sP.getDbSrc());
            con = ds.getConnection();
            stmt =
con.prepareCall("{call xxfnd_schedule_pkg.generate_schedule}");
            stmt.executeUpdate();

            String query =
                "SELECT  SCHEDULE_NAME, BI_REPORT_PATH, BI_REPORT_NAME, DB_REFRESH_PKG , LAST_REFRESH_TIME" +
                "                FROM XXFND_SCHEDULE_LIST_T" +
                "               WHERE  SCHEDULE_STATUS= 'PENDING'";
            stmt2 = con.createStatement();
            rs = stmt2.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("LAST_REFRESH_TIME") == null) {
                    val = "01-01-2015 00:00:00";
                } else {
                    val =
new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("LAST_REFRESH_TIME")));
                }

                sPl.add(new SchedulePOJO(rs.getString("SCHEDULE_NAME"),
                                         rs.getString("BI_REPORT_PATH"),
                                         rs.getString("BI_REPORT_NAME"),
                                         rs.getString("DB_REFRESH_PKG"), val));
            }
        } catch (Exception e) {
            System.err.println("Exception in getData " + e);
            e.printStackTrace();
        } finally {
            closeCon(rs, stmt2, stmt, stmt1, con);
        }
        return sPl;
    }

    public void closeCon(ResultSet rs, Statement stmt2, CallableStatement stmt,
                         CallableStatement stmt1, Connection con) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt2 != null) {
                stmt2.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (stmt1 != null) {
                stmt1.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            System.err.println("Exception in Close Connection block " + e);
        }
    }
}
