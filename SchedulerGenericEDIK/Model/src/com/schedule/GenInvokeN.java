package com.schedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import java.sql.CallableStatement;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;

import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class GenInvokeN {
    protected static byte[] reportBytes;


    public synchronized String invokeReport(SchedulePOJO sP) throws IOException,
                                                                    ParserConfigurationException,
                                                                    SAXException,
                                                                    Exception {

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("text/xml");
        WsPayload payload = new WsPayload();
        String xmlInput = payload.getPayload(sP);
        RequestBody body = RequestBody.create(mediaType, xmlInput);
        //        System.out.println("Request Payload ----> " + xmlInput);
        Context ctx = null;
        Connection con = null;
        CallableStatement stmt = null;
        String error = null;

        Request request =
            new Request.Builder().url("https://" + sP.getPod().trim() +
                                      "/xmlpserver/services/PublicReportService").post(body).addHeader("content-type",
                                                                                                       "text/xml").addHeader("cache-control",
                                                                                                                             "no-cache").addHeader("SOAPAction",
                                                                                                                                                   "").build();
        try {

            Response response = client.newCall(request).execute();
            InputStream isr = response.body().byteStream();
            BufferedReader reader =
                new BufferedReader(new InputStreamReader(isr));
            StringBuilder out = new StringBuilder();
            String resultsXml;
            while ((resultsXml = reader.readLine()) != null) {
                out.append(resultsXml);
            }

            int responseCode = response.code();
            //            System.out.println("RESPONSE CODE : " + responseCode);
            if (responseCode > 200) {
                String fault = null;

                if (out.toString().contains(";TEXT&gt;")) {
                    fault = getFaultString(out.toString());
                } else {
                    DocumentBuilder builder =
                        DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    InputSource src = new InputSource();
                    src.setCharacterStream(new StringReader(out.toString()));
                    Document doc = builder.parse(src);
                    System.err.println("Error Response----> " +
                                       out.toString());
                    fault =
                            doc.getElementsByTagName("faultstring").item(0).getTextContent();
                }
                return fault;

            } else {
                String reportResponse = getResponseAsString(out.toString());
                //                System.out.println("Report Response-------> " +
                //                                   reportResponse);
                DocumentBuilder db;
                db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                InputSource is = new InputSource();
                is.setCharacterStream(new StringReader(reportResponse));
                Document doc = db.parse(is);
                NodeList nodes = doc.getElementsByTagName("G_1");
                try {
                    if (nodes.getLength() != 0) {
                        ctx = new InitialContext();
                        DataSource ds = (DataSource)ctx.lookup(sP.getDbSrc());
                        con = ds.getConnection();
                        stmt =
con.prepareCall("{call " + sP.getRfshPkg() + "(?)}");
                        stmt.setString(1, reportResponse);
                        stmt.executeUpdate();
                    }
                } catch (Exception e) {
                    error = e.toString();
                    System.err.println("Exception in Package call " + e);
                } finally {
                    closeCon(stmt, con);
                }
            }

            reader.close();
        } catch (Exception e) {
            error = e.toString();
            e.printStackTrace();
            //            throw new Exception(e.getMessage(), e);
        }
        return error;
    }


    public synchronized static String getResponseAsString(String resp) throws ParserConfigurationException,
                                                                              SAXException,
                                                                              IOException {
        String response = resp;
        DocumentBuilder builder =
            DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource src = new InputSource();
        src.setCharacterStream(new StringReader(response));
        Document doc = builder.parse(src);
        response =
                doc.getElementsByTagName("reportBytes").item(0).getTextContent();


        /*******DECODE BYTES TO STRING************/
        byte[] val = DatatypeConverter.parseBase64Binary(response);
        response = new String(val);
        System.out.println("Response String  : " + response);

        return response;
    }


    public synchronized static String getFaultString(String xml) {

        String faultString = "";
        //        System.err.println("===ERROR=======" + xml);
        int firstFault = xml.indexOf(";TEXT&gt;");
        int firstFault_last = xml.indexOf("&lt;/TEXT&");
        //        System.err.println("begin fault message===" + firstFault);
        //        System.err.println("last fault message===" + firstFault_last);
        //        System.out.println("==RESULT===" +
        //                           xml.substring(firstFault + 9, firstFault_last));
        faultString = xml.substring(firstFault + 9, firstFault_last);
        System.err.println("FAULT STRING : " + faultString);
        return faultString;
    }

    public void closeCon(CallableStatement stmt, Connection con) {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            System.err.println("Exception in Close Connection block " + e);
        }
    }
    
    public static String getReportBytesAsString() {
        return new String(reportBytes);
    }

}
