package view.backing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.io.StringReader;

import java.math.BigDecimal;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import java.nio.charset.Charset;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.naming.Context;

import javax.xml.bind.DatatypeConverter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.ParserConfigurationException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;

import okhttp3.Request;
import okhttp3.RequestBody;

import okhttp3.Response;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import oracle.jbo.domain.Date;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;

import org.w3c.dom.Document;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class PayrollTransferBean {
    private RichTable slectPayrollTable;
    private RichTable newPayrollTable;
    private RichPopup p1;

    public PayrollTransferBean() {
    }

    public void onChangeCheckBoxVCL(ValueChangeEvent valueChangeEvent) {
        String newValue = valueChangeEvent.getNewValue().toString();
        ViewObject payrollVO = SalicView.backing
                                        .Utils
                                        .ADFUtils
                                        .findIterator("PayrollTransfer_VO1Iterator")
                                        .getViewObject();
        RowSetIterator dtlsRS = payrollVO.createRowSetIterator(null);
        while (dtlsRS.hasNext()) {
            Row r = dtlsRS.next();
            if (newValue.equals("true")) {
                r.setAttribute("PayrollCheck", true);
            } else {
                r.setAttribute("PayrollCheck", false);
            }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(getNewPayrollTable());
    }

    public void setSlectPayrollTable(RichTable slectPayrollTable) {
        this.slectPayrollTable = slectPayrollTable;
    }

    public RichTable getSlectPayrollTable() {
        return slectPayrollTable;
    }

    public void setNewPayrollTable(RichTable newPayrollTable) {
        this.newPayrollTable = newPayrollTable;
    }

    public RichTable getNewPayrollTable() {
        return newPayrollTable;
    }

    public void payrollTransferDeatilsPopup(PopupFetchEvent popupFetchEvent) {
        this.p1.hide();
        AdfFacesContext.getCurrentInstance().addPartialTarget(getP1());
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public String fileACL(String hdr, String dtl, String FileName) throws FileNotFoundException, MalformedURLException {
        String fileInBase64 = null;

        File f = null;
        boolean bool = false;

        try {

            // create new file
            String fileNn = FileName + ".dat";

            f = new File("ElementEntry.dat");

            String content =
                "METADATA|ElementEntry|SourceSystemOwner|SourceSystemId|ElementEntryId|AssignmentNumber|EffectiveStartDate|EffectiveEndDate|ElementName|LegislativeDataGroupName|MultipleEntryCount|EntryType|CreatorType\n" +
                hdr;
            String detail =
                "METADATA|ElementEntryValue|SourceSystemOwner|SourceSystemId|ElementEntryId|AssignmentNumber|EffectiveStartDate|EffectiveEndDate|ElementName|LegislativeDataGroupName|MultipleEntryCount|InputValueName|ScreenEntryValue\n" +
                dtl;
            BufferedWriter bw = null;
            FileWriter fw = null;
            // tries to create new file in the system
            bool = f.createNewFile();
            String path = new File("").getAbsolutePath();
            // deletes file from the system
            f.delete();
            // tries to create new file in the system
            bool = f.createNewFile();
            fw = new FileWriter(path + "ElementEntry.dat");

            bw = new BufferedWriter(fw);
            bw.write(content);
            bw.write(detail);
            bw.close();
            fw.close();

            byte[] buffer = new byte[1024];
            FileOutputStream fos = new FileOutputStream(path + "test1.zip");

            ZipOutputStream zos = new ZipOutputStream(fos);
            ZipEntry ze = new ZipEntry("ElementEntry.dat");

            zos.putNextEntry(ze);
            FileInputStream in = new FileInputStream(path + "ElementEntry.dat");


            int len;
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }

            in.close();
            zos.closeEntry();

            zos.close();
            String inputFile = path + "test1.zip";
            byte[] fileInBytes = loadFile(inputFile);
            fileInBase64 = DatatypeConverter.printBase64Binary(fileInBytes);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return fileInBase64;
    }

    public static byte[] loadFile(String sourcePath) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(sourcePath);
            return readFully(inputStream);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static byte[] readFully(InputStream stream) throws IOException {
        byte[] buffer = new byte[8192];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int bytesRead;
        while ((bytesRead = stream.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }
        return baos.toByteArray();
    }


    String pp = null;
    String base64code = null;
    String hdr = null;
    String dtl = null;
    String FileName = null;

    public void randomNumber(ActionEvent actionEvent) {
        genraterandomString("dd");
    }
    String generatedString = null;

    public void genraterandomString(String emp) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        generatedString = buffer.toString();
        generatedString = emp + generatedString;


        System.out.println(generatedString);
    }
    String docname = null;
    String hdl = null;
    String ucmRes = null;
    String hdlRes = null;

    public void moveToPayrolACL(ActionEvent actionEvent) throws FileNotFoundException, MalformedURLException,
                                                                IOException, ParserConfigurationException,
                                                                SAXException {
        ADFUtils.findOperation("Commit").execute();
        ViewObject payRollVO = ADFUtils.findIterator("PayrollTransfer_VO1Iterator").getViewObject();
        ViewObject payRollDtlVO = ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject();
        ViewObject hdrVO = ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
        ViewObject othrExpVO = ADFUtils.findIterator("XxhcmOtherExpenseTVO1Iterator").getViewObject();

        SimpleDateFormat hcmDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Row[] rows = payRollVO.getFilteredRows("Attribute2", "Y");
        
        if(rows == null || rows.length == 0){
            JSFUtils.addComponentFacesMessage(FacesMessage.SEVERITY_ERROR,"Select at least one row.", null);
            return;
        }

        for (Row cu : rows) {
            if ("ot".equals(cu.getAttribute("ReqType"))) {
                int i = 1;
                hdr = "";
                dtl = "";

                if (cu.getAttribute("Attribute2") != null) {
                    if (cu.getAttribute("Attribute2").equals("Y")) {
                        String reqNum = (String) cu.getAttribute("RequestNumber"); //EmployeeName
                        String emp = (String) cu.getAttribute("EmployeeNumber");


                        //persId
                        ViewObject personVO = ADFUtils.findIterator("personROVO1Iterator").getViewObject();
                        personVO.setNamedWhereClauseParam("persId", cu.getAttribute("EmpId"));
                        personVO.executeQuery();
                        BigDecimal perNum = (BigDecimal) personVO.first().getAttribute("PersonNumber");
                        //random doc number
                        genraterandomString(emp);
                        Random rand = new Random();
                        docname = generatedString;
                        java.util.Date payrollTransDate = (java.util.Date) cu.getAttribute("PayrollTransDate");
                        
                        FileName = reqNum;
                        Calendar calendar = Calendar.getInstance();
                        if(payrollTransDate!=null)
                        calendar.setTime(payrollTransDate);
                                                
                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");

                        calendar.set(Calendar.DAY_OF_MONTH, 1);

                        int numOfDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                        String st = dateFormat1.format(calendar.getTime());

                        calendar.add(Calendar.DAY_OF_MONTH, numOfDaysInMonth - 1);
                        String end = dateFormat1.format(calendar.getTime());

                        ViewCriteria vc = payRollDtlVO.createViewCriteria();
                        ViewCriteriaRow vcr = vc.createViewCriteriaRow();
                        vcr.setAttribute("ReqId", cu.getAttribute("ReqId"));
                        vc.addRow(vcr);
                        payRollDtlVO.applyViewCriteria(vc);
                        payRollDtlVO.executeQuery();

                        RowSetIterator dtlRS = payRollDtlVO.createRowSetIterator(null);
                        System.err.println("count of details - - " + payRollDtlVO.getEstimatedRowCount());
                        while (dtlRS.hasNext()) {
                            System.err.println("count of details1 - - " + payRollDtlVO.getEstimatedRowCount());
                            int n = rand.nextInt(9999999) + 1;
                            hdr += "MERGE|ElementEntry|HRC_SQLLOADER|1008_MISC_" + n + "|" + n + "|E" + perNum + "|";
                            hdr += st + "|" + end + "|Overtime Payment|SA Legislative Data Group|" + i + "|E|H\n";

                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_REQ|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Overtime Payment|SA Legislative Data Group|" + i +
                                "|Request Number|" + reqNum + "\n";
                            Row curr = dtlRS.next();
                            Number dd = (Number) curr.getAttribute("OvertimeHours");
                            dd.toString();
                            String type = null;
                            if (curr.getAttribute("OvertimeType").equals("OT_HOL")) {
                                type = "Holiday";
                            } else if (curr.getAttribute("OvertimeType").equals("OT_WD")) {
                                type = "Weekday";
                            } else if (curr.getAttribute("OvertimeType").equals("OT_WE")) {
                                type = "Weekend";
                            }


                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_OTH|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Overtime Payment|SA Legislative Data Group|" + i +
                                "|Overtime Hours|" + dd.toString() + "\n";

                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_OTT|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Overtime Payment|SA Legislative Data Group|" + i +
                                "|Overtime Type|" + type + "\n";

                            // MISSION
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_MIS|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Overtime Payment|SA Legislative Data Group|" + i + "|Mission|" +
                                curr.getAttribute("Missions") + "\n";

                            // OT DATE
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_OTD|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Overtime Payment|SA Legislative Data Group|" + i +
                                "|Overtime Date|" + hcmDateFormat.format(curr.getAttribute("OvertimeDate")) + "\n";


                            // CalculatedHours
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_THR|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Overtime Payment|SA Legislative Data Group|" + i + "|Total Hours|" +
                                curr.getAttribute("CalculatedHours") + "\n";

                            System.err.println("count of details2 - - " + payRollDtlVO.getEstimatedRowCount());
                            i++;
                            System.err.println("count of detail3 - - " + payRollDtlVO.getEstimatedRowCount());
                        }
                        i = 0;

                        base64code = fileACL(hdr, dtl, FileName);

                        java.util.Date date = new java.util.Date();
                        SimpleDateFormat dateFormat =
                            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"); //Hours:Minutes:Seconds
                        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

                        long t = date.getTime();
                        java.util.Date expDate;

                        expDate = new java.util.Date(t + (10 * 600));

                        java.util.Date plusOne;


                        plusOne = new java.util.Date(t + (24 * 3600000));

                        String createdTS = dateFormat.format(date);
                        String expiresTS = dateFormat.format(expDate);

                        pp =
                            "<soapenv:Envelope xmlns:erp=\"http://xmlns.oracle.com/apps/financials/commonModules/shared/model/erpIntegrationService/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/commonModules/shared/model/erpIntegrationService/types/\">\n" +
                            "   <soapenv:Header>\n" +
                            "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                            "         <wsu:Timestamp wsu:Id=\"TS-CA8645EA17D44D489D15052969404602\">\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" + "            <wsu:Expires>" +
                            expiresTS + "</wsu:Expires>\n" + "         </wsu:Timestamp>\n" +
                            "         <wsse:UsernameToken wsu:Id=\"UsernameToken-CA8645EA17D44D489D15052969348891\">\n" +
                            "            <wsse:Username>paas.user@salic.com</wsse:Username>\n" +
                            "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Welc@me123</wsse:Password>\n" +
                            "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">iU7oRIFC/+67/n4SkJ3mzQ==</wsse:Nonce>\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                            "         </wsse:UsernameToken>\n" + "      </wsse:Security>\n" + "   </soapenv:Header>\n" +
                            "   <soapenv:Body>\n" + "     <typ:uploadFileToUcm>\n" + "         <typ:document>\n" +
                            "            <erp:Content>" + base64code + "</erp:Content>\n" +
                            "            <erp:FileName>" + FileName + ".zip</erp:FileName>\n" +
                            "            <!--Optional:-->\n" + "            <erp:ContentType>zip</erp:ContentType>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentTitle>ElementEntry.zip</erp:DocumentTitle>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentAuthor>Mahalingam</erp:DocumentAuthor>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentSecurityGroup>FAFusionImportExport</erp:DocumentSecurityGroup>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentAccount>hcm$/dataloader$/import$</erp:DocumentAccount>\n" +
                            "            <!--Optional:-->\n" + "            <erp:DocumentName>" + docname +
                            "</erp:DocumentName>\n" + "            <!--Optional:-->\n" + "         </typ:document>\n" +
                            "      </typ:uploadFileToUcm>\n" + "   </soapenv:Body>\n" + "</soapenv:Envelope>";

                        hdl =
                            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/hcm/common/dataLoader/core/dataLoaderIntegrationService/types/\">\n" +
                            "   <soapenv:Header>\n" +
                            "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                            "         <wsu:Timestamp wsu:Id=\"TS-CA8645EA17D44D489D15055632292379\">\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" + "            <wsu:Expires>" +
                            expiresTS + "</wsu:Expires>\n" + "         </wsu:Timestamp>\n" +
                            "         <wsse:UsernameToken wsu:Id=\"UsernameToken-CA8645EA17D44D489D15055621504837\">\n" +
                            "            <wsse:Username>paas.user@salic.com</wsse:Username>\n" +
                            "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Welc@me123</wsse:Password>\n" +
                            "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">0LK4VNEj89A+UnSOaw0SiQ==</wsse:Nonce>\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                            "         </wsse:UsernameToken>\n" + "      </wsse:Security>\n" + "   </soapenv:Header>\n" +
                            "   <soapenv:Body>\n" + "      <typ:importAndLoadData>\n" + "         <typ:ContentId>" +
                            docname + "</typ:ContentId>\n" + "      </typ:importAndLoadData>\n" +
                            "   </soapenv:Body>\n" + "</soapenv:Envelope>";
                        try {
                            callWebservice();
                            callHDL();

                            ViewObjectImpl impl = (ViewObjectImpl) hdrVO.getViewObject();
                            impl.setNamedWhereClauseParam("BV_ID", cu.getAttribute("RequestNumber"));
                            impl.applyViewCriteria(impl.getViewCriteria("findById"));
                            impl.executeQuery();
                            if (hdrVO.first() != null) {
                                if (ucmRes.equalsIgnoreCase("SUCCESS")) {
                                    hdrVO.getCurrentRow().setAttribute("UcmRes", "SUCCESS");
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "COMPLETED");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                } else {
                                    hdrVO.getCurrentRow().setAttribute("UcmRes", ucmRes); //PayrollTansStatus
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "ERROR");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                }
                                if (hdlRes.equalsIgnoreCase("SUCCESS")) {
                                    hdrVO.getCurrentRow().setAttribute("HdlRes", "SUCCESS");
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "COMPLETED");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                } else {
                                    hdrVO.getCurrentRow().setAttribute("HdlRes", hdlRes);
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "ERROR");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                }
                                //                           hdrVO.executeQuery();
                                ADFUtils.findOperation("Commit").execute();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            System.err.println(e);
                        }
                    }
                }
            } else if ("house".equals(cu.getAttribute("ReqType"))) {
                int i = 1;
                hdr = "";
                dtl = "";

                if (cu.getAttribute("Attribute2") != null) {
                    if (cu.getAttribute("Attribute2").equals("Y")) {
                        String reqNum = (String) cu.getAttribute("RequestNumber"); //EmployeeName
                        String emp = (String) cu.getAttribute("EmployeeNumber");


                        //persId
                        ViewObject personVO = ADFUtils.findIterator("personROVO1Iterator").getViewObject();
                        personVO.setNamedWhereClauseParam("persId", cu.getAttribute("EmpId"));
                        personVO.executeQuery();
                        BigDecimal perNum = (BigDecimal) personVO.first().getAttribute("PersonNumber");
                        //random doc number
                        genraterandomString(emp);
                        Random rand = new Random();
                        docname = generatedString;
                        java.util.Date payrollTransDate = (java.util.Date) cu.getAttribute("PayrollTransDate");
                        
                        FileName = reqNum;
                        Calendar calendar = Calendar.getInstance();
                        if(payrollTransDate!=null)
                        calendar.setTime(payrollTransDate);

                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");

                        calendar.set(Calendar.DAY_OF_MONTH, 1);

                        int numOfDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                        String st = dateFormat1.format(calendar.getTime());

                        calendar.add(Calendar.DAY_OF_MONTH, numOfDaysInMonth - 1);
                        String end = dateFormat1.format(calendar.getTime());

                        ViewCriteria vc = payRollDtlVO.createViewCriteria();
                        ViewCriteriaRow vcr = vc.createViewCriteriaRow();
                        vcr.setAttribute("ReqId", cu.getAttribute("ReqId"));
                        vc.addRow(vcr);
                        payRollDtlVO.applyViewCriteria(vc);
                        payRollDtlVO.executeQuery();

                        RowSetIterator dtlRS = payRollDtlVO.createRowSetIterator(null);
                        System.err.println("count of details - - " + payRollDtlVO.getEstimatedRowCount());
                        while (dtlRS.hasNext()) {
                            System.err.println("count of details1 - - " + payRollDtlVO.getEstimatedRowCount());
                            int n = rand.nextInt(9999999) + 1;
                            hdr += "MERGE|ElementEntry|HRC_SQLLOADER|1008_MISC_" + n + "|" + n + "|E" + perNum + "|";
                            hdr +=
                                st + "|" + end + "|Housing Advance Payment|SA Legislative Data Group|" + i + "|E|H\n";

                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_REQ|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Housing Advance Payment|SA Legislative Data Group|" + i +
                                "|Request Number|" + reqNum + "\n";
                            Row curr = dtlRS.next();
                            /*Number dd = (Number)curr.getAttribute("OvertimeHours");
                                                      dd.toString();
                                                      String type = null;
                                                      if(curr.getAttribute("OvertimeType").equals("OT_HOL")){
                                                          type = "Holiday";
                                                      }
                                                      else if (curr.getAttribute("OvertimeType").equals("OT_WD")){
                                                          type = "Weekday";
                                                      }
                                                      else if (curr.getAttribute("OvertimeType").equals("OT_WE")){
                                                          type = "Weekend";
                                                      }*/
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_HRS|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Housing Advance Payment|SA Legislative Data Group|" + i +
                                "|Installments|" + curr.getAttribute("Months") + "\n";
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_TYP|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Housing Advance Payment|SA Legislative Data Group|" + i +
                                "|Remarks|" + curr.getAttribute("Comments") + "\n";
                            System.err.println("count of details2 - - " + payRollDtlVO.getEstimatedRowCount());
                            i++;
                            System.err.println("count of detail3 - - " + payRollDtlVO.getEstimatedRowCount());
                        }
                        i = 0;

                        base64code = fileACL(hdr, dtl, FileName);

                        java.util.Date date = new java.util.Date();
                        SimpleDateFormat dateFormat =
                            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"); //Hours:Minutes:Seconds
                        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

                        long t = date.getTime();
                        java.util.Date expDate;

                        expDate = new java.util.Date(t + (10 * 600));

                        java.util.Date plusOne;


                        plusOne = new java.util.Date(t + (24 * 3600000));

                        String createdTS = dateFormat.format(date);
                        String expiresTS = dateFormat.format(expDate);

                        pp =
                            "<soapenv:Envelope xmlns:erp=\"http://xmlns.oracle.com/apps/financials/commonModules/shared/model/erpIntegrationService/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/commonModules/shared/model/erpIntegrationService/types/\">\n" +
                            "   <soapenv:Header>\n" +
                            "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                            "         <wsu:Timestamp wsu:Id=\"TS-CA8645EA17D44D489D15052969404602\">\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" + "            <wsu:Expires>" +
                            expiresTS + "</wsu:Expires>\n" + "         </wsu:Timestamp>\n" +
                            "         <wsse:UsernameToken wsu:Id=\"UsernameToken-CA8645EA17D44D489D15052969348891\">\n" +
                            "            <wsse:Username>paas.user@salic.com</wsse:Username>\n" +
                            "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Welc@me123</wsse:Password>\n" +
                            "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">iU7oRIFC/+67/n4SkJ3mzQ==</wsse:Nonce>\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                            "         </wsse:UsernameToken>\n" + "      </wsse:Security>\n" + "   </soapenv:Header>\n" +
                            "   <soapenv:Body>\n" + "     <typ:uploadFileToUcm>\n" + "         <typ:document>\n" +
                            "            <erp:Content>" + base64code + "</erp:Content>\n" +
                            "            <erp:FileName>" + FileName + ".zip</erp:FileName>\n" +
                            "            <!--Optional:-->\n" + "            <erp:ContentType>zip</erp:ContentType>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentTitle>ElementEntry.zip</erp:DocumentTitle>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentAuthor>Mahalingam</erp:DocumentAuthor>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentSecurityGroup>FAFusionImportExport</erp:DocumentSecurityGroup>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentAccount>hcm$/dataloader$/import$</erp:DocumentAccount>\n" +
                            "            <!--Optional:-->\n" + "            <erp:DocumentName>" + docname +
                            "</erp:DocumentName>\n" + "            <!--Optional:-->\n" + "         </typ:document>\n" +
                            "      </typ:uploadFileToUcm>\n" + "   </soapenv:Body>\n" + "</soapenv:Envelope>";

                        hdl =
                            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/hcm/common/dataLoader/core/dataLoaderIntegrationService/types/\">\n" +
                            "   <soapenv:Header>\n" +
                            "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                            "         <wsu:Timestamp wsu:Id=\"TS-CA8645EA17D44D489D15055632292379\">\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" + "            <wsu:Expires>" +
                            expiresTS + "</wsu:Expires>\n" + "         </wsu:Timestamp>\n" +
                            "         <wsse:UsernameToken wsu:Id=\"UsernameToken-CA8645EA17D44D489D15055621504837\">\n" +
                            "            <wsse:Username>paas.user@salic.com</wsse:Username>\n" +
                            "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Welc@me123</wsse:Password>\n" +
                            "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">0LK4VNEj89A+UnSOaw0SiQ==</wsse:Nonce>\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                            "         </wsse:UsernameToken>\n" + "      </wsse:Security>\n" + "   </soapenv:Header>\n" +
                            "   <soapenv:Body>\n" + "      <typ:importAndLoadData>\n" + "         <typ:ContentId>" +
                            docname + "</typ:ContentId>\n" + "      </typ:importAndLoadData>\n" +
                            "   </soapenv:Body>\n" + "</soapenv:Envelope>";
                        try {
                            callWebservice();
                            callHDL();

                            ViewObjectImpl impl = (ViewObjectImpl) hdrVO.getViewObject();
                            impl.setNamedWhereClauseParam("BV_ID", cu.getAttribute("RequestNumber"));
                            impl.applyViewCriteria(impl.getViewCriteria("findById"));
                            impl.executeQuery();
                            if (hdrVO.first() != null) {
                                if (ucmRes.equalsIgnoreCase("SUCCESS")) {
                                    hdrVO.getCurrentRow().setAttribute("UcmRes", "SUCCESS");
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "COMPLETED");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                } else {
                                    hdrVO.getCurrentRow().setAttribute("UcmRes", ucmRes); //PayrollTansStatus
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "ERROR");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                }
                                if (hdlRes.equalsIgnoreCase("SUCCESS")) {
                                    hdrVO.getCurrentRow().setAttribute("HdlRes", "SUCCESS");
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "COMPLETED");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                } else {
                                    hdrVO.getCurrentRow().setAttribute("HdlRes", hdlRes);
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "ERROR");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                }
                                //                           hdrVO.executeQuery();
                                ADFUtils.findOperation("Commit").execute();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            System.err.println(e);
                        }
                    }
                }

                int j = 1;
                hdr = "";
                dtl = "";

                if (cu.getAttribute("Attribute2") != null) {
                    if (cu.getAttribute("Attribute2").equals("Y")) {
                        String reqNum = (String) cu.getAttribute("RequestNumber"); //EmployeeName
                        String emp = (String) cu.getAttribute("EmployeeNumber");


                        //persId
                        ViewObject personVO = ADFUtils.findIterator("personROVO1Iterator").getViewObject();
                        personVO.setNamedWhereClauseParam("persId", cu.getAttribute("EmpId"));
                        personVO.executeQuery();
                        BigDecimal perNum = (BigDecimal) personVO.first().getAttribute("PersonNumber");
                        //random doc number
                        genraterandomString(emp);
                        Random rand = new Random();
                        docname = generatedString;
                        java.util.Date payrollTransDate = (java.util.Date) cu.getAttribute("PayrollTransDate");
                        
                        FileName = reqNum;
                        Calendar calendar = Calendar.getInstance();
                        if(payrollTransDate!=null)
                        calendar.setTime(payrollTransDate);
                        // recovery will start after 1 month from adv
                        calendar.add(Calendar.MONTH, 1);
                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");
                        
                        calendar.set(Calendar.DAY_OF_MONTH, 1);

                        int numOfDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                        String st = dateFormat1.format(calendar.getTime());

                        calendar.add(Calendar.DAY_OF_MONTH, numOfDaysInMonth - 1);
                        String end = dateFormat1.format(calendar.getTime());

                        ViewCriteria vc = payRollDtlVO.createViewCriteria();
                        ViewCriteriaRow vcr = vc.createViewCriteriaRow();
                        vcr.setAttribute("ReqId", cu.getAttribute("ReqId"));
                        vc.addRow(vcr);
                        payRollDtlVO.applyViewCriteria(vc);
                        payRollDtlVO.executeQuery();

                        RowSetIterator dtlRS = payRollDtlVO.createRowSetIterator(null);
                        System.err.println("count of details - - " + payRollDtlVO.getEstimatedRowCount());
                        while (dtlRS.hasNext()) {
                            System.err.println("count of details1 - - " + payRollDtlVO.getEstimatedRowCount());
                            int n = rand.nextInt(9999999) + 1;
                            hdr += "MERGE|ElementEntry|HRC_SQLLOADER|1008_MISC_" + n + "|" + n + "|E" + perNum + "|";
                            hdr +=
                                st + "|" + end + "|Housing Advanced Recovery|SA Legislative Data Group|" + j + "|E|H\n";

                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_REQ|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Housing Advanced Recovery|SA Legislative Data Group|" + j +
                                "|Request Number|" + reqNum + "\n";
                            Row curr = dtlRS.next();
                            /*Number dd = (Number)curr.getAttribute("OvertimeHours");
                                                      dd.toString();
                                                      String type = null;
                                                      if(curr.getAttribute("OvertimeType").equals("OT_HOL")){
                                                          type = "Holiday";
                                                      }
                                                      else if (curr.getAttribute("OvertimeType").equals("OT_WD")){
                                                          type = "Weekday";
                                                      }
                                                      else if (curr.getAttribute("OvertimeType").equals("OT_WE")){
                                                          type = "Weekend";
                                                      }*/
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_HRS|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Housing Advanced Recovery|SA Legislative Data Group|" + j +
                                "|Installments|" + curr.getAttribute("Months") + "\n";

                            System.err.println("count of details2 - - " + payRollDtlVO.getEstimatedRowCount());
                            j++;
                            System.err.println("count of detail3 - - " + payRollDtlVO.getEstimatedRowCount());
                        }
                        j = 0;

                        base64code = fileACL(hdr, dtl, FileName);

                        java.util.Date date = new java.util.Date();
                        SimpleDateFormat dateFormat =
                            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"); //Hours:Minutes:Seconds
                        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

                        long t = date.getTime();
                        java.util.Date expDate;

                        expDate = new java.util.Date(t + (10 * 600));

                        java.util.Date plusOne;


                        plusOne = new java.util.Date(t + (24 * 3600000));

                        String createdTS = dateFormat.format(date);
                        String expiresTS = dateFormat.format(expDate);

                        pp =
                            "<soapenv:Envelope xmlns:erp=\"http://xmlns.oracle.com/apps/financials/commonModules/shared/model/erpIntegrationService/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/commonModules/shared/model/erpIntegrationService/types/\">\n" +
                            "   <soapenv:Header>\n" +
                            "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                            "         <wsu:Timestamp wsu:Id=\"TS-CA8645EA17D44D489D15052969404602\">\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" + "            <wsu:Expires>" +
                            expiresTS + "</wsu:Expires>\n" + "         </wsu:Timestamp>\n" +
                            "         <wsse:UsernameToken wsu:Id=\"UsernameToken-CA8645EA17D44D489D15052969348891\">\n" +
                            "            <wsse:Username>paas.user@salic.com</wsse:Username>\n" +
                            "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Welc@me123</wsse:Password>\n" +
                            "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">iU7oRIFC/+67/n4SkJ3mzQ==</wsse:Nonce>\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                            "         </wsse:UsernameToken>\n" + "      </wsse:Security>\n" + "   </soapenv:Header>\n" +
                            "   <soapenv:Body>\n" + "     <typ:uploadFileToUcm>\n" + "         <typ:document>\n" +
                            "            <erp:Content>" + base64code + "</erp:Content>\n" +
                            "            <erp:FileName>" + FileName + ".zip</erp:FileName>\n" +
                            "            <!--Optional:-->\n" + "            <erp:ContentType>zip</erp:ContentType>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentTitle>ElementEntry.zip</erp:DocumentTitle>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentAuthor>Mahalingam</erp:DocumentAuthor>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentSecurityGroup>FAFusionImportExport</erp:DocumentSecurityGroup>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentAccount>hcm$/dataloader$/import$</erp:DocumentAccount>\n" +
                            "            <!--Optional:-->\n" + "            <erp:DocumentName>" + docname +
                            "</erp:DocumentName>\n" + "            <!--Optional:-->\n" + "         </typ:document>\n" +
                            "      </typ:uploadFileToUcm>\n" + "   </soapenv:Body>\n" + "</soapenv:Envelope>";

                        hdl =
                            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/hcm/common/dataLoader/core/dataLoaderIntegrationService/types/\">\n" +
                            "   <soapenv:Header>\n" +
                            "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                            "         <wsu:Timestamp wsu:Id=\"TS-CA8645EA17D44D489D15055632292379\">\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" + "            <wsu:Expires>" +
                            expiresTS + "</wsu:Expires>\n" + "         </wsu:Timestamp>\n" +
                            "         <wsse:UsernameToken wsu:Id=\"UsernameToken-CA8645EA17D44D489D15055621504837\">\n" +
                            "            <wsse:Username>paas.user@salic.com</wsse:Username>\n" +
                            "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Welc@me123</wsse:Password>\n" +
                            "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">0LK4VNEj89A+UnSOaw0SiQ==</wsse:Nonce>\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                            "         </wsse:UsernameToken>\n" + "      </wsse:Security>\n" + "   </soapenv:Header>\n" +
                            "   <soapenv:Body>\n" + "      <typ:importAndLoadData>\n" + "         <typ:ContentId>" +
                            docname + "</typ:ContentId>\n" + "      </typ:importAndLoadData>\n" +
                            "   </soapenv:Body>\n" + "</soapenv:Envelope>";
                        try {
                            callWebservice();
                            callHDL();

                            ViewObjectImpl impl = (ViewObjectImpl) hdrVO.getViewObject();
                            impl.setNamedWhereClauseParam("BV_ID", cu.getAttribute("RequestNumber"));
                            impl.applyViewCriteria(impl.getViewCriteria("findById"));
                            impl.executeQuery();
                            if (hdrVO.first() != null) {
                                if (ucmRes.equalsIgnoreCase("SUCCESS")) {
                                    hdrVO.getCurrentRow().setAttribute("UcmRes", "SUCCESS");
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "COMPLETED");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                } else {
                                    hdrVO.getCurrentRow().setAttribute("UcmRes", ucmRes); //PayrollTansStatus
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "ERROR");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                }
                                if (hdlRes.equalsIgnoreCase("SUCCESS")) {
                                    hdrVO.getCurrentRow().setAttribute("HdlRes", "SUCCESS");
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "COMPLETED");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                } else {
                                    hdrVO.getCurrentRow().setAttribute("HdlRes", hdlRes);
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "ERROR");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                }
                                //                           hdrVO.executeQuery();
                                ADFUtils.findOperation("Commit").execute();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            System.err.println(e);
                        }
                    }
                }

            } else if ("vacation".equals(cu.getAttribute("ReqType"))) {
                int i = 1;
                hdr = "";
                dtl = "";

                if (cu.getAttribute("Attribute2") != null) {
                    if (cu.getAttribute("Attribute2").equals("Y")) {
                        String reqNum = (String) cu.getAttribute("RequestNumber"); //EmployeeName
                        String emp = (String) cu.getAttribute("EmployeeNumber");


                        //persId
                        ViewObject personVO = ADFUtils.findIterator("personROVO1Iterator").getViewObject();
                        personVO.setNamedWhereClauseParam("persId", cu.getAttribute("EmpId"));
                        personVO.executeQuery();
                        BigDecimal perNum = (BigDecimal) personVO.first().getAttribute("PersonNumber");
                        //random doc number
                        genraterandomString(emp);
                        Random rand = new Random();
                        docname = generatedString;
                        java.util.Date payrollTransDate = (java.util.Date) cu.getAttribute("PayrollTransDate");
                        
                        FileName = reqNum;
                        Calendar calendar = Calendar.getInstance();
                        if(payrollTransDate!=null)
                        calendar.setTime(payrollTransDate);

                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");

                        calendar.set(Calendar.DAY_OF_MONTH, 1);

                        int numOfDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                        String st = dateFormat1.format(calendar.getTime());

                        calendar.add(Calendar.DAY_OF_MONTH, numOfDaysInMonth - 1);
                        String end = dateFormat1.format(calendar.getTime());

                        ViewCriteria vc = payRollDtlVO.createViewCriteria();
                        ViewCriteriaRow vcr = vc.createViewCriteriaRow();
                        vcr.setAttribute("ReqId", cu.getAttribute("ReqId"));
                        vc.addRow(vcr);
                        payRollDtlVO.applyViewCriteria(vc);
                        payRollDtlVO.executeQuery();

                        RowSetIterator dtlRS = payRollDtlVO.createRowSetIterator(null);
                        System.err.println("count of details - - " + payRollDtlVO.getEstimatedRowCount());
                        while (dtlRS.hasNext()) {
                            System.err.println("count of details1 - - " + payRollDtlVO.getEstimatedRowCount());
                            int n = rand.nextInt(9999999) + 1;
                            hdr += "MERGE|ElementEntry|HRC_SQLLOADER|1008_MISC_" + n + "|" + n + "|E" + perNum + "|";
                            hdr +=
                                st + "|" + end + "|Vacation Allowance Payment|SA Legislative Data Group|" + i +
                                "|E|H\n";

                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_REQ|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Vacation Allowance Payment|SA Legislative Data Group|" + i +
                                "|Request Number|" + reqNum + "\n";
                            Row curr = dtlRS.next();

                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_HRS|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Vacation Allowance Payment|SA Legislative Data Group|" + i +
                                "|Absence Dates|" + curr.getAttribute("Leave") + "\n";
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_TYP|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Vacation Allowance Payment|SA Legislative Data Group|" + i +
                                "|Remarks|" + curr.getAttribute("Missions") + "\n";
                            System.err.println("count of details2 - - " + payRollDtlVO.getEstimatedRowCount());
                            i++;
                            System.err.println("count of detail3 - - " + payRollDtlVO.getEstimatedRowCount());
                        }
                        i = 0;

                        base64code = fileACL(hdr, dtl, FileName);

                        java.util.Date date = new java.util.Date();
                        SimpleDateFormat dateFormat =
                            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"); //Hours:Minutes:Seconds
                        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

                        long t = date.getTime();
                        java.util.Date expDate;

                        expDate = new java.util.Date(t + (10 * 600));

                        java.util.Date plusOne;


                        plusOne = new java.util.Date(t + (24 * 3600000));

                        String createdTS = dateFormat.format(date);
                        String expiresTS = dateFormat.format(expDate);

                        pp =
                            "<soapenv:Envelope xmlns:erp=\"http://xmlns.oracle.com/apps/financials/commonModules/shared/model/erpIntegrationService/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/commonModules/shared/model/erpIntegrationService/types/\">\n" +
                            "   <soapenv:Header>\n" +
                            "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                            "         <wsu:Timestamp wsu:Id=\"TS-CA8645EA17D44D489D15052969404602\">\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" + "            <wsu:Expires>" +
                            expiresTS + "</wsu:Expires>\n" + "         </wsu:Timestamp>\n" +
                            "         <wsse:UsernameToken wsu:Id=\"UsernameToken-CA8645EA17D44D489D15052969348891\">\n" +
                            "            <wsse:Username>paas.user@salic.com</wsse:Username>\n" +
                            "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Welc@me123</wsse:Password>\n" +
                            "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">iU7oRIFC/+67/n4SkJ3mzQ==</wsse:Nonce>\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                            "         </wsse:UsernameToken>\n" + "      </wsse:Security>\n" + "   </soapenv:Header>\n" +
                            "   <soapenv:Body>\n" + "     <typ:uploadFileToUcm>\n" + "         <typ:document>\n" +
                            "            <erp:Content>" + base64code + "</erp:Content>\n" +
                            "            <erp:FileName>" + FileName + ".zip</erp:FileName>\n" +
                            "            <!--Optional:-->\n" + "            <erp:ContentType>zip</erp:ContentType>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentTitle>ElementEntry.zip</erp:DocumentTitle>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentAuthor>Mahalingam</erp:DocumentAuthor>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentSecurityGroup>FAFusionImportExport</erp:DocumentSecurityGroup>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentAccount>hcm$/dataloader$/import$</erp:DocumentAccount>\n" +
                            "            <!--Optional:-->\n" + "            <erp:DocumentName>" + docname +
                            "</erp:DocumentName>\n" + "            <!--Optional:-->\n" + "         </typ:document>\n" +
                            "      </typ:uploadFileToUcm>\n" + "   </soapenv:Body>\n" + "</soapenv:Envelope>";

                        hdl =
                            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/hcm/common/dataLoader/core/dataLoaderIntegrationService/types/\">\n" +
                            "   <soapenv:Header>\n" +
                            "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                            "         <wsu:Timestamp wsu:Id=\"TS-CA8645EA17D44D489D15055632292379\">\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" + "            <wsu:Expires>" +
                            expiresTS + "</wsu:Expires>\n" + "         </wsu:Timestamp>\n" +
                            "         <wsse:UsernameToken wsu:Id=\"UsernameToken-CA8645EA17D44D489D15055621504837\">\n" +
                            "            <wsse:Username>paas.user@salic.com</wsse:Username>\n" +
                            "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Welc@me123</wsse:Password>\n" +
                            "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">0LK4VNEj89A+UnSOaw0SiQ==</wsse:Nonce>\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                            "         </wsse:UsernameToken>\n" + "      </wsse:Security>\n" + "   </soapenv:Header>\n" +
                            "   <soapenv:Body>\n" + "      <typ:importAndLoadData>\n" + "         <typ:ContentId>" +
                            docname + "</typ:ContentId>\n" + "      </typ:importAndLoadData>\n" +
                            "   </soapenv:Body>\n" + "</soapenv:Envelope>";
                        try {
                            callWebservice();
                            callHDL();

                            ViewObjectImpl impl = (ViewObjectImpl) hdrVO.getViewObject();
                            impl.setNamedWhereClauseParam("BV_ID", cu.getAttribute("RequestNumber"));
                            impl.applyViewCriteria(impl.getViewCriteria("findById"));
                            impl.executeQuery();
                            if (hdrVO.first() != null) {
                                if (ucmRes.equalsIgnoreCase("SUCCESS")) {
                                    hdrVO.getCurrentRow().setAttribute("UcmRes", "SUCCESS");
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "COMPLETED");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                } else {
                                    hdrVO.getCurrentRow().setAttribute("UcmRes", ucmRes); //PayrollTansStatus
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "ERROR");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                }
                                if (hdlRes.equalsIgnoreCase("SUCCESS")) {
                                    hdrVO.getCurrentRow().setAttribute("HdlRes", "SUCCESS");
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "COMPLETED");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                } else {
                                    hdrVO.getCurrentRow().setAttribute("HdlRes", hdlRes);
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "ERROR");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                }
                                //                           hdrVO.executeQuery();
                                ADFUtils.findOperation("Commit").execute();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            System.err.println(e);
                        }
                    }
                }

            } else if ("edu".equals(cu.getAttribute("ReqType"))) {
                int i = 1;
                hdr = "";
                dtl = "";

                if (cu.getAttribute("Attribute2") != null) {
                    if (cu.getAttribute("Attribute2").equals("Y")) {
                        String reqNum = (String) cu.getAttribute("RequestNumber"); //EmployeeName
                        String emp = (String) cu.getAttribute("EmployeeNumber");


                        //persId
                        ViewObject personVO = ADFUtils.findIterator("personROVO1Iterator").getViewObject();
                        personVO.setNamedWhereClauseParam("persId", cu.getAttribute("EmpId"));
                        personVO.executeQuery();
                        BigDecimal perNum = (BigDecimal) personVO.first().getAttribute("PersonNumber");
                        //random doc number
                        genraterandomString(emp);
                        Random rand = new Random();
                        docname = generatedString;
                        java.util.Date payrollTransDate = (java.util.Date) cu.getAttribute("PayrollTransDate");
                        
                        FileName = reqNum;
                        Calendar calendar = Calendar.getInstance();
                        if(payrollTransDate!=null)
                        calendar.setTime(payrollTransDate);

                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");

                        calendar.set(Calendar.DAY_OF_MONTH, 1);

                        int numOfDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                        String st = dateFormat1.format(calendar.getTime());

                        calendar.add(Calendar.DAY_OF_MONTH, numOfDaysInMonth - 1);
                        String end = dateFormat1.format(calendar.getTime());

                        ViewCriteria vc = payRollDtlVO.createViewCriteria();
                        ViewCriteriaRow vcr = vc.createViewCriteriaRow();
                        vcr.setAttribute("ReqId", cu.getAttribute("ReqId"));
                        vc.addRow(vcr);
                        payRollDtlVO.applyViewCriteria(vc);
                        payRollDtlVO.executeQuery();

                        RowSetIterator dtlRS = payRollDtlVO.createRowSetIterator(null);
                        System.err.println("count of details - - " + payRollDtlVO.getEstimatedRowCount());
                        while (dtlRS.hasNext()) {
                            System.err.println("count of details1 - - " + payRollDtlVO.getEstimatedRowCount());
                            int n = rand.nextInt(9999999) + 1;
                            hdr += "MERGE|ElementEntry|HRC_SQLLOADER|1008_MISC_" + n + "|" + n + "|E" + perNum + "|";
                            hdr += st + "|" + end + "|Education Allowance|SA Legislative Data Group|" + i + "|E|H\n";

                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_REQ|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Education Allowance|SA Legislative Data Group|" + i +
                                "|Request Number|" + reqNum + "\n";
                            Row curr = dtlRS.next();
                            /* Number dd = (Number)curr.getAttribute("OvertimeHours");
                                                      dd.toString();
                                                      String type = null;
                                                      if(curr.getAttribute("OvertimeType").equals("OT_HOL")){
                                                          type = "Holiday";
                                                      }
                                                      else if (curr.getAttribute("OvertimeType").equals("OT_WD")){
                                                          type = "Weekday";
                                                      }
                                                      else if (curr.getAttribute("OvertimeType").equals("OT_WE")){
                                                          type = "Weekend";
                                                      }*/
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_AMT|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Education Allowance|SA Legislative Data Group|" + i + "|Amount|" +
                                curr.getAttribute("ActAmt") + "\n";

                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_INN|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Education Allowance|SA Legislative Data Group|" + i +
                                "|Invoice Number|" + curr.getAttribute("InvNum") + "\n";

                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_IDT|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Education Allowance|SA Legislative Data Group|" + i +
                                "|Invoice Date|" + hcmDateFormat.format(curr.getAttribute("InvDate")) + "\n";

                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_CNM|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Education Allowance|SA Legislative Data Group|" + i +
                                "|Child Name|" + curr.getAttribute("childTRANS") + "\n";
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_SEM|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Education Allowance|SA Legislative Data Group|" + i + "|Semester|" +
                                curr.getAttribute("Semester") + "\n";
                            System.err.println("count of details2 - - " + payRollDtlVO.getEstimatedRowCount());
                            i++;
                            System.err.println("count of detail3 - - " + payRollDtlVO.getEstimatedRowCount());
                        }
                        i = 0;

                        base64code = fileACL(hdr, dtl, FileName);

                        java.util.Date date = new java.util.Date();
                        SimpleDateFormat dateFormat =
                            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"); //Hours:Minutes:Seconds
                        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

                        long t = date.getTime();
                        java.util.Date expDate;

                        expDate = new java.util.Date(t + (10 * 600));

                        java.util.Date plusOne;


                        plusOne = new java.util.Date(t + (24 * 3600000));

                        String createdTS = dateFormat.format(date);
                        String expiresTS = dateFormat.format(expDate);

                        pp =
                            "<soapenv:Envelope xmlns:erp=\"http://xmlns.oracle.com/apps/financials/commonModules/shared/model/erpIntegrationService/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/commonModules/shared/model/erpIntegrationService/types/\">\n" +
                            "   <soapenv:Header>\n" +
                            "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                            "         <wsu:Timestamp wsu:Id=\"TS-CA8645EA17D44D489D15052969404602\">\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" + "            <wsu:Expires>" +
                            expiresTS + "</wsu:Expires>\n" + "         </wsu:Timestamp>\n" +
                            "         <wsse:UsernameToken wsu:Id=\"UsernameToken-CA8645EA17D44D489D15052969348891\">\n" +
                            "            <wsse:Username>paas.user@salic.com</wsse:Username>\n" +
                            "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Welc@me123</wsse:Password>\n" +
                            "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">iU7oRIFC/+67/n4SkJ3mzQ==</wsse:Nonce>\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                            "         </wsse:UsernameToken>\n" + "      </wsse:Security>\n" + "   </soapenv:Header>\n" +
                            "   <soapenv:Body>\n" + "     <typ:uploadFileToUcm>\n" + "         <typ:document>\n" +
                            "            <erp:Content>" + base64code + "</erp:Content>\n" +
                            "            <erp:FileName>" + FileName + ".zip</erp:FileName>\n" +
                            "            <!--Optional:-->\n" + "            <erp:ContentType>zip</erp:ContentType>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentTitle>ElementEntry.zip</erp:DocumentTitle>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentAuthor>Mahalingam</erp:DocumentAuthor>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentSecurityGroup>FAFusionImportExport</erp:DocumentSecurityGroup>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentAccount>hcm$/dataloader$/import$</erp:DocumentAccount>\n" +
                            "            <!--Optional:-->\n" + "            <erp:DocumentName>" + docname +
                            "</erp:DocumentName>\n" + "            <!--Optional:-->\n" + "         </typ:document>\n" +
                            "      </typ:uploadFileToUcm>\n" + "   </soapenv:Body>\n" + "</soapenv:Envelope>";

                        hdl =
                            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/hcm/common/dataLoader/core/dataLoaderIntegrationService/types/\">\n" +
                            "   <soapenv:Header>\n" +
                            "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                            "         <wsu:Timestamp wsu:Id=\"TS-CA8645EA17D44D489D15055632292379\">\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" + "            <wsu:Expires>" +
                            expiresTS + "</wsu:Expires>\n" + "         </wsu:Timestamp>\n" +
                            "         <wsse:UsernameToken wsu:Id=\"UsernameToken-CA8645EA17D44D489D15055621504837\">\n" +
                            "            <wsse:Username>paas.user@salic.com</wsse:Username>\n" +
                            "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Welc@me123</wsse:Password>\n" +
                            "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">0LK4VNEj89A+UnSOaw0SiQ==</wsse:Nonce>\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                            "         </wsse:UsernameToken>\n" + "      </wsse:Security>\n" + "   </soapenv:Header>\n" +
                            "   <soapenv:Body>\n" + "      <typ:importAndLoadData>\n" + "         <typ:ContentId>" +
                            docname + "</typ:ContentId>\n" + "      </typ:importAndLoadData>\n" +
                            "   </soapenv:Body>\n" + "</soapenv:Envelope>";
                        try {
                            callWebservice();
                            callHDL();

                            ViewObjectImpl impl = (ViewObjectImpl) hdrVO.getViewObject();
                            impl.setNamedWhereClauseParam("BV_ID", cu.getAttribute("RequestNumber"));
                            impl.applyViewCriteria(impl.getViewCriteria("findById"));
                            impl.executeQuery();
                            if (hdrVO.first() != null) {
                                if (ucmRes.equalsIgnoreCase("SUCCESS")) {
                                    hdrVO.getCurrentRow().setAttribute("UcmRes", "SUCCESS");
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "COMPLETED");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                } else {
                                    hdrVO.getCurrentRow().setAttribute("UcmRes", ucmRes); //PayrollTansStatus
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "ERROR");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                }
                                if (hdlRes.equalsIgnoreCase("SUCCESS")) {
                                    hdrVO.getCurrentRow().setAttribute("HdlRes", "SUCCESS");
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "COMPLETED");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                } else {
                                    hdrVO.getCurrentRow().setAttribute("HdlRes", hdlRes);
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "ERROR");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                }
                                //                           hdrVO.executeQuery();
                                ADFUtils.findOperation("Commit").execute();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            System.err.println(e);
                        }
                    }
                }
            } else if ("salary".equals(cu.getAttribute("ReqType"))) {
                int i = 1;
                hdr = "";
                dtl = "";

                if (cu.getAttribute("Attribute2") != null) {
                    if (cu.getAttribute("Attribute2").equals("Y")) {
                        String reqNum = (String) cu.getAttribute("RequestNumber"); //EmployeeName
                        String emp = (String) cu.getAttribute("EmployeeNumber");


                        //persId
                        ViewObject personVO = ADFUtils.findIterator("personROVO1Iterator").getViewObject();
                        personVO.setNamedWhereClauseParam("persId", cu.getAttribute("EmpId"));
                        personVO.executeQuery();
                        BigDecimal perNum = (BigDecimal) personVO.first().getAttribute("PersonNumber");
                        //random doc number
                        genraterandomString(emp);
                        Random rand = new Random();
                        docname = generatedString;
                        java.util.Date payrollTransDate = (java.util.Date) cu.getAttribute("PayrollTransDate");
                        
                        FileName = reqNum;
                        Calendar calendar = Calendar.getInstance();
                        if(payrollTransDate!=null)
                        calendar.setTime(payrollTransDate);

                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");

                        calendar.set(Calendar.DAY_OF_MONTH, 1);

                        int numOfDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                        String st = dateFormat1.format(calendar.getTime());

                        calendar.add(Calendar.DAY_OF_MONTH, numOfDaysInMonth - 1);
                        String end = dateFormat1.format(calendar.getTime());

                        ViewCriteria vc = payRollDtlVO.createViewCriteria();
                        ViewCriteriaRow vcr = vc.createViewCriteriaRow();
                        vcr.setAttribute("ReqId", cu.getAttribute("ReqId"));
                        vc.addRow(vcr);
                        payRollDtlVO.applyViewCriteria(vc);
                        payRollDtlVO.executeQuery();

                        RowSetIterator dtlRS = payRollDtlVO.createRowSetIterator(null);
                        System.err.println("count of details - - " + payRollDtlVO.getEstimatedRowCount());
                        while (dtlRS.hasNext()) {
                            System.err.println("count of details1 - - " + payRollDtlVO.getEstimatedRowCount());
                            int n = rand.nextInt(9999999) + 1;
                            hdr += "MERGE|ElementEntry|HRC_SQLLOADER|1008_MISC_" + n + "|" + n + "|E" + perNum + "|";
                            hdr += st + "|" + end + "|Salary Advance Payment|SA Legislative Data Group|" + i + "|E|H\n";

                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_REQ|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Salary Advance Payment|SA Legislative Data Group|" + i +
                                "|Request Number|" + reqNum + "\n";
                            Row curr = dtlRS.next();

                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_HRS|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Salary Advance Payment|SA Legislative Data Group|" + i +
                                "|Advance Month|" + curr.getAttribute("SalPeriod") + "\n";

                            SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String salPeriod = dateFormat2.format(calendar.getTime());
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_SPD|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Salary Advance Payment|SA Legislative Data Group|" + i +
                                "|Salary Period|" + salPeriod + "\n";
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_TYP|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Salary Advance Payment|SA Legislative Data Group|" + i +
                                "|Remarks|" + curr.getAttribute("Comments") + "\n";
                            System.err.println("count of details2 - - " + payRollDtlVO.getEstimatedRowCount());
                            i++;
                            System.err.println("count of detail3 - - " + payRollDtlVO.getEstimatedRowCount());
                        }
                        i = 0;

                        base64code = fileACL(hdr, dtl, FileName);

                        java.util.Date date = new java.util.Date();
                        SimpleDateFormat dateFormat =
                            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"); //Hours:Minutes:Seconds
                        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

                        long t = date.getTime();
                        java.util.Date expDate;

                        expDate = new java.util.Date(t + (10 * 600));

                        java.util.Date plusOne;


                        plusOne = new java.util.Date(t + (24 * 3600000));

                        String createdTS = dateFormat.format(date);
                        String expiresTS = dateFormat.format(expDate);

                        pp =
                            "<soapenv:Envelope xmlns:erp=\"http://xmlns.oracle.com/apps/financials/commonModules/shared/model/erpIntegrationService/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/commonModules/shared/model/erpIntegrationService/types/\">\n" +
                            "   <soapenv:Header>\n" +
                            "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                            "         <wsu:Timestamp wsu:Id=\"TS-CA8645EA17D44D489D15052969404602\">\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" + "            <wsu:Expires>" +
                            expiresTS + "</wsu:Expires>\n" + "         </wsu:Timestamp>\n" +
                            "         <wsse:UsernameToken wsu:Id=\"UsernameToken-CA8645EA17D44D489D15052969348891\">\n" +
                            "            <wsse:Username>paas.user@salic.com</wsse:Username>\n" +
                            "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Welc@me123</wsse:Password>\n" +
                            "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">iU7oRIFC/+67/n4SkJ3mzQ==</wsse:Nonce>\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                            "         </wsse:UsernameToken>\n" + "      </wsse:Security>\n" + "   </soapenv:Header>\n" +
                            "   <soapenv:Body>\n" + "     <typ:uploadFileToUcm>\n" + "         <typ:document>\n" +
                            "            <erp:Content>" + base64code + "</erp:Content>\n" +
                            "            <erp:FileName>" + FileName + ".zip</erp:FileName>\n" +
                            "            <!--Optional:-->\n" + "            <erp:ContentType>zip</erp:ContentType>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentTitle>ElementEntry.zip</erp:DocumentTitle>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentAuthor>Mahalingam</erp:DocumentAuthor>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentSecurityGroup>FAFusionImportExport</erp:DocumentSecurityGroup>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentAccount>hcm$/dataloader$/import$</erp:DocumentAccount>\n" +
                            "            <!--Optional:-->\n" + "            <erp:DocumentName>" + docname +
                            "</erp:DocumentName>\n" + "            <!--Optional:-->\n" + "         </typ:document>\n" +
                            "      </typ:uploadFileToUcm>\n" + "   </soapenv:Body>\n" + "</soapenv:Envelope>";

                        hdl =
                            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/hcm/common/dataLoader/core/dataLoaderIntegrationService/types/\">\n" +
                            "   <soapenv:Header>\n" +
                            "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                            "         <wsu:Timestamp wsu:Id=\"TS-CA8645EA17D44D489D15055632292379\">\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" + "            <wsu:Expires>" +
                            expiresTS + "</wsu:Expires>\n" + "         </wsu:Timestamp>\n" +
                            "         <wsse:UsernameToken wsu:Id=\"UsernameToken-CA8645EA17D44D489D15055621504837\">\n" +
                            "            <wsse:Username>paas.user@salic.com</wsse:Username>\n" +
                            "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Welc@me123</wsse:Password>\n" +
                            "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">0LK4VNEj89A+UnSOaw0SiQ==</wsse:Nonce>\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                            "         </wsse:UsernameToken>\n" + "      </wsse:Security>\n" + "   </soapenv:Header>\n" +
                            "   <soapenv:Body>\n" + "      <typ:importAndLoadData>\n" + "         <typ:ContentId>" +
                            docname + "</typ:ContentId>\n" + "      </typ:importAndLoadData>\n" +
                            "   </soapenv:Body>\n" + "</soapenv:Envelope>";
                        try {
                            callWebservice();
                            callHDL();

                            ViewObjectImpl impl = (ViewObjectImpl) hdrVO.getViewObject();
                            impl.setNamedWhereClauseParam("BV_ID", cu.getAttribute("RequestNumber"));
                            impl.applyViewCriteria(impl.getViewCriteria("findById"));
                            impl.executeQuery();
                            if (hdrVO.first() != null) {
                                if (ucmRes.equalsIgnoreCase("SUCCESS")) {
                                    hdrVO.getCurrentRow().setAttribute("UcmRes", "SUCCESS");
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "COMPLETED");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                } else {
                                    hdrVO.getCurrentRow().setAttribute("UcmRes", ucmRes); //PayrollTansStatus
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "ERROR");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                }
                                if (hdlRes.equalsIgnoreCase("SUCCESS")) {
                                    hdrVO.getCurrentRow().setAttribute("HdlRes", "SUCCESS");
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "COMPLETED");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                } else {
                                    hdrVO.getCurrentRow().setAttribute("HdlRes", hdlRes);
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "ERROR");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                }
                                //                           hdrVO.executeQuery();
                                ADFUtils.findOperation("Commit").execute();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            System.err.println(e);
                        }
                    }
                }
                int j = 1;
                hdr = "";
                dtl = "";

                if (cu.getAttribute("Attribute2") != null) {
                    if (cu.getAttribute("Attribute2").equals("Y")) {
                        String reqNum = (String) cu.getAttribute("RequestNumber"); //EmployeeName
                        String emp = (String) cu.getAttribute("EmployeeNumber");


                        //persId
                        ViewObject personVO = ADFUtils.findIterator("personROVO1Iterator").getViewObject();
                        personVO.setNamedWhereClauseParam("persId", cu.getAttribute("EmpId"));
                        personVO.executeQuery();
                        BigDecimal perNum = (BigDecimal) personVO.first().getAttribute("PersonNumber");
                        //random doc number
                        genraterandomString(emp);
                        Random rand = new Random();
                        docname = generatedString;
                        java.util.Date payrollTransDate = (java.util.Date) cu.getAttribute("PayrollTransDate");
                        
                        FileName = reqNum;
                        Calendar calendar = Calendar.getInstance();
                        if(payrollTransDate!=null)
                        calendar.setTime(payrollTransDate);

                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");

                        calendar.set(Calendar.DAY_OF_MONTH, 1);

                        int numOfDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                        String st = dateFormat1.format(calendar.getTime());

                        calendar.add(Calendar.DAY_OF_MONTH, numOfDaysInMonth - 1);
                        String end = dateFormat1.format(calendar.getTime());

                        ViewCriteria vc = payRollDtlVO.createViewCriteria();
                        ViewCriteriaRow vcr = vc.createViewCriteriaRow();
                        vcr.setAttribute("ReqId", cu.getAttribute("ReqId"));
                        vc.addRow(vcr);
                        payRollDtlVO.applyViewCriteria(vc);
                        payRollDtlVO.executeQuery();

                        RowSetIterator dtlRS = payRollDtlVO.createRowSetIterator(null);
                        System.err.println("count of details - - " + payRollDtlVO.getEstimatedRowCount());
                        while (dtlRS.hasNext()) {
                            System.err.println("count of details1 - - " + payRollDtlVO.getEstimatedRowCount());
                            int n = rand.nextInt(9999999) + 1;
                            hdr += "MERGE|ElementEntry|HRC_SQLLOADER|1008_MISC_" + n + "|" + n + "|E" + perNum + "|";
                            hdr +=
                                st + "|" + end + "|Salary Advance Recovery|SA Legislative Data Group|" + j + "|E|H\n";

                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_REQ|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Salary Advance Recovery|SA Legislative Data Group|" + j +
                                "|Request Number|" + reqNum + "\n";
                            Row curr = dtlRS.next();
                            /*Number dd = (Number)curr.getAttribute("OvertimeHours");
                                                      dd.toString();
                                                      String type = null;
                                                      if(curr.getAttribute("OvertimeType").equals("OT_HOL")){
                                                          type = "Holiday";
                                                      }
                                                      else if (curr.getAttribute("OvertimeType").equals("OT_WD")){
                                                          type = "Weekday";
                                                      }
                                                      else if (curr.getAttribute("OvertimeType").equals("OT_WE")){
                                                          type = "Weekend";
                                                      }*/
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_HRS|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Salary Advance Recovery|SA Legislative Data Group|" + j +
                                "|Advance Month|" + curr.getAttribute("SalPeriod") + "\n";
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_TYP|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Salary Advance Recovery|SA Legislative Data Group|" + j +
                                "|Remarks|" + curr.getAttribute("Comments") + "\n";
                            System.err.println("count of details2 - - " + payRollDtlVO.getEstimatedRowCount());
                            j++;
                            System.err.println("count of detail3 - - " + payRollDtlVO.getEstimatedRowCount());
                        }
                        j = 0;

                        base64code = fileACL(hdr, dtl, FileName);

                        java.util.Date date = new java.util.Date();
                        SimpleDateFormat dateFormat =
                            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"); //Hours:Minutes:Seconds
                        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

                        long t = date.getTime();
                        java.util.Date expDate;

                        expDate = new java.util.Date(t + (10 * 600));

                        java.util.Date plusOne;


                        plusOne = new java.util.Date(t + (24 * 3600000));

                        String createdTS = dateFormat.format(date);
                        String expiresTS = dateFormat.format(expDate);

                        pp =
                            "<soapenv:Envelope xmlns:erp=\"http://xmlns.oracle.com/apps/financials/commonModules/shared/model/erpIntegrationService/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/commonModules/shared/model/erpIntegrationService/types/\">\n" +
                            "   <soapenv:Header>\n" +
                            "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                            "         <wsu:Timestamp wsu:Id=\"TS-CA8645EA17D44D489D15052969404602\">\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" + "            <wsu:Expires>" +
                            expiresTS + "</wsu:Expires>\n" + "         </wsu:Timestamp>\n" +
                            "         <wsse:UsernameToken wsu:Id=\"UsernameToken-CA8645EA17D44D489D15052969348891\">\n" +
                            "            <wsse:Username>paas.user@salic.com</wsse:Username>\n" +
                            "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Welc@me123</wsse:Password>\n" +
                            "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">iU7oRIFC/+67/n4SkJ3mzQ==</wsse:Nonce>\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                            "         </wsse:UsernameToken>\n" + "      </wsse:Security>\n" + "   </soapenv:Header>\n" +
                            "   <soapenv:Body>\n" + "     <typ:uploadFileToUcm>\n" + "         <typ:document>\n" +
                            "            <erp:Content>" + base64code + "</erp:Content>\n" +
                            "            <erp:FileName>" + FileName + ".zip</erp:FileName>\n" +
                            "            <!--Optional:-->\n" + "            <erp:ContentType>zip</erp:ContentType>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentTitle>ElementEntry.zip</erp:DocumentTitle>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentAuthor>Mahalingam</erp:DocumentAuthor>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentSecurityGroup>FAFusionImportExport</erp:DocumentSecurityGroup>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentAccount>hcm$/dataloader$/import$</erp:DocumentAccount>\n" +
                            "            <!--Optional:-->\n" + "            <erp:DocumentName>" + docname +
                            "</erp:DocumentName>\n" + "            <!--Optional:-->\n" + "         </typ:document>\n" +
                            "      </typ:uploadFileToUcm>\n" + "   </soapenv:Body>\n" + "</soapenv:Envelope>";

                        hdl =
                            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/hcm/common/dataLoader/core/dataLoaderIntegrationService/types/\">\n" +
                            "   <soapenv:Header>\n" +
                            "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                            "         <wsu:Timestamp wsu:Id=\"TS-CA8645EA17D44D489D15055632292379\">\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" + "            <wsu:Expires>" +
                            expiresTS + "</wsu:Expires>\n" + "         </wsu:Timestamp>\n" +
                            "         <wsse:UsernameToken wsu:Id=\"UsernameToken-CA8645EA17D44D489D15055621504837\">\n" +
                            "            <wsse:Username>paas.user@salic.com</wsse:Username>\n" +
                            "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Welc@me123</wsse:Password>\n" +
                            "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">0LK4VNEj89A+UnSOaw0SiQ==</wsse:Nonce>\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                            "         </wsse:UsernameToken>\n" + "      </wsse:Security>\n" + "   </soapenv:Header>\n" +
                            "   <soapenv:Body>\n" + "      <typ:importAndLoadData>\n" + "         <typ:ContentId>" +
                            docname + "</typ:ContentId>\n" + "      </typ:importAndLoadData>\n" +
                            "   </soapenv:Body>\n" + "</soapenv:Envelope>";
                        try {
                            callWebservice();
                            callHDL();

                            ViewObjectImpl impl = (ViewObjectImpl) hdrVO.getViewObject();
                            impl.setNamedWhereClauseParam("BV_ID", cu.getAttribute("RequestNumber"));
                            impl.applyViewCriteria(impl.getViewCriteria("findById"));
                            impl.executeQuery();
                            if (hdrVO.first() != null) {
                                if (ucmRes.equalsIgnoreCase("SUCCESS")) {
                                    hdrVO.getCurrentRow().setAttribute("UcmRes", "SUCCESS");
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "COMPLETED");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                } else {
                                    hdrVO.getCurrentRow().setAttribute("UcmRes", ucmRes); //PayrollTansStatus
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "ERROR");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                }
                                if (hdlRes.equalsIgnoreCase("SUCCESS")) {
                                    hdrVO.getCurrentRow().setAttribute("HdlRes", "SUCCESS");
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "COMPLETED");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                } else {
                                    hdrVO.getCurrentRow().setAttribute("HdlRes", hdlRes);
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "ERROR");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                }
                                //                           hdrVO.executeQuery();
                                ADFUtils.findOperation("Commit").execute();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            System.err.println(e);
                        }
                    }
                }
            } else if ("BusinessTrip".equals(cu.getAttribute("ReqType"))) {
                int i = 1;
                hdr = "";
                dtl = "";

                if (cu.getAttribute("Attribute2") != null) {
                    if (cu.getAttribute("Attribute2").equals("Y")) {
                        String reqNum = (String) cu.getAttribute("RequestNumber"); //EmployeeName
                        String emp = (String) cu.getAttribute("EmployeeNumber");


                        //persId
                        ViewObject personVO = ADFUtils.findIterator("personROVO1Iterator").getViewObject();
                        personVO.setNamedWhereClauseParam("persId", cu.getAttribute("EmpId"));
                        personVO.executeQuery();
                        BigDecimal perNum = (BigDecimal) personVO.first().getAttribute("PersonNumber");
                        //random doc number
                        genraterandomString(emp);
                        Random rand = new Random();
                        docname = generatedString;
                        java.util.Date payrollTransDate = (java.util.Date) cu.getAttribute("PayrollTransDate");
                        
                        FileName = reqNum;
                        Calendar calendar = Calendar.getInstance();
                        if(payrollTransDate!=null)
                        calendar.setTime(payrollTransDate);

                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");

                        calendar.set(Calendar.DAY_OF_MONTH, 1);

                        int numOfDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                        String st = dateFormat1.format(calendar.getTime());

                        calendar.add(Calendar.DAY_OF_MONTH, numOfDaysInMonth - 1);
                        String end = dateFormat1.format(calendar.getTime());

                        ViewCriteria vc = payRollDtlVO.createViewCriteria();
                        ViewCriteriaRow vcr = vc.createViewCriteriaRow();
                        vcr.setAttribute("ReqId", cu.getAttribute("ReqId"));
                        vc.addRow(vcr);
                        payRollDtlVO.applyViewCriteria(vc);
                        payRollDtlVO.executeQuery();

                        RowSetIterator dtlRS = payRollDtlVO.createRowSetIterator(null);
                        System.err.println("count of details - - " + payRollDtlVO.getEstimatedRowCount());
                        while (dtlRS.hasNext()) {
                            System.err.println("count of details1 - - " + payRollDtlVO.getEstimatedRowCount());
                            int n = rand.nextInt(9999999) + 1;
                            hdr += "MERGE|ElementEntry|HRC_SQLLOADER|1008_MISC_" + n + "|" + n + "|E" + perNum + "|";
                            hdr +=
                                st + "|" + end + "|Advance Perdiem Business Trip Payment|SA Legislative Data Group|" +
                                i + "|E|H\n";

                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_REQ|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Advance Perdiem Business Trip Payment|SA Legislative Data Group|" +
                                i + "|Request Number|" + reqNum + "\n";
                            Row curr = dtlRS.next();

                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_PRJ|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Advance Perdiem Business Trip Payment|SA Legislative Data Group|" +
                                i + "|Project|" + curr.getAttribute("ProjType") + "\n";
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_REG|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Advance Perdiem Business Trip Payment|SA Legislative Data Group|" +
                                i + "|Region|" + curr.getAttribute("DestCategory") + "\n";


                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_FDT|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Advance Perdiem Business Trip Payment|SA Legislative Data Group|" +
                                i + "|From Date|" + hcmDateFormat.format(curr.getAttribute("StartDate")) + "\n";
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_TDT|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Advance Perdiem Business Trip Payment|SA Legislative Data Group|" +
                                i + "|To Date|" + hcmDateFormat.format(curr.getAttribute("EndDate")) + "\n";
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_TDS|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Advance Perdiem Business Trip Payment|SA Legislative Data Group|" +
                                i + "|Trip Description|" + curr.getAttribute("Description") + "\n";


                            System.err.println("count of details2 - - " + payRollDtlVO.getEstimatedRowCount());
                            i++;
                            System.err.println("count of detail3 - - " + payRollDtlVO.getEstimatedRowCount());
                        }
                        i = 0;

                        base64code = fileACL(hdr, dtl, FileName);

                        java.util.Date date = new java.util.Date();
                        SimpleDateFormat dateFormat =
                            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"); //Hours:Minutes:Seconds
                        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

                        long t = date.getTime();
                        java.util.Date expDate;

                        expDate = new java.util.Date(t + (10 * 600));

                        java.util.Date plusOne;


                        plusOne = new java.util.Date(t + (24 * 3600000));

                        String createdTS = dateFormat.format(date);
                        String expiresTS = dateFormat.format(expDate);

                        pp =
                            "<soapenv:Envelope xmlns:erp=\"http://xmlns.oracle.com/apps/financials/commonModules/shared/model/erpIntegrationService/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/commonModules/shared/model/erpIntegrationService/types/\">\n" +
                            "   <soapenv:Header>\n" +
                            "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                            "         <wsu:Timestamp wsu:Id=\"TS-CA8645EA17D44D489D15052969404602\">\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" + "            <wsu:Expires>" +
                            expiresTS + "</wsu:Expires>\n" + "         </wsu:Timestamp>\n" +
                            "         <wsse:UsernameToken wsu:Id=\"UsernameToken-CA8645EA17D44D489D15052969348891\">\n" +
                            "            <wsse:Username>paas.user@salic.com</wsse:Username>\n" +
                            "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Welc@me123</wsse:Password>\n" +
                            "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">iU7oRIFC/+67/n4SkJ3mzQ==</wsse:Nonce>\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                            "         </wsse:UsernameToken>\n" + "      </wsse:Security>\n" + "   </soapenv:Header>\n" +
                            "   <soapenv:Body>\n" + "     <typ:uploadFileToUcm>\n" + "         <typ:document>\n" +
                            "            <erp:Content>" + base64code + "</erp:Content>\n" +
                            "            <erp:FileName>" + FileName + ".zip</erp:FileName>\n" +
                            "            <!--Optional:-->\n" + "            <erp:ContentType>zip</erp:ContentType>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentTitle>ElementEntry.zip</erp:DocumentTitle>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentAuthor>Mahalingam</erp:DocumentAuthor>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentSecurityGroup>FAFusionImportExport</erp:DocumentSecurityGroup>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentAccount>hcm$/dataloader$/import$</erp:DocumentAccount>\n" +
                            "            <!--Optional:-->\n" + "            <erp:DocumentName>" + docname +
                            "</erp:DocumentName>\n" + "            <!--Optional:-->\n" + "         </typ:document>\n" +
                            "      </typ:uploadFileToUcm>\n" + "   </soapenv:Body>\n" + "</soapenv:Envelope>";

                        hdl =
                            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/hcm/common/dataLoader/core/dataLoaderIntegrationService/types/\">\n" +
                            "   <soapenv:Header>\n" +
                            "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                            "         <wsu:Timestamp wsu:Id=\"TS-CA8645EA17D44D489D15055632292379\">\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" + "            <wsu:Expires>" +
                            expiresTS + "</wsu:Expires>\n" + "         </wsu:Timestamp>\n" +
                            "         <wsse:UsernameToken wsu:Id=\"UsernameToken-CA8645EA17D44D489D15055621504837\">\n" +
                            "            <wsse:Username>paas.user@salic.com</wsse:Username>\n" +
                            "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Welc@me123</wsse:Password>\n" +
                            "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">0LK4VNEj89A+UnSOaw0SiQ==</wsse:Nonce>\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                            "         </wsse:UsernameToken>\n" + "      </wsse:Security>\n" + "   </soapenv:Header>\n" +
                            "   <soapenv:Body>\n" + "      <typ:importAndLoadData>\n" + "         <typ:ContentId>" +
                            docname + "</typ:ContentId>\n" + "      </typ:importAndLoadData>\n" +
                            "   </soapenv:Body>\n" + "</soapenv:Envelope>";
                        try {
                            callWebservice();
                            callHDL();

                            ViewObjectImpl impl = (ViewObjectImpl) hdrVO.getViewObject();
                            impl.setNamedWhereClauseParam("BV_ID", cu.getAttribute("RequestNumber"));
                            impl.applyViewCriteria(impl.getViewCriteria("findById"));
                            impl.executeQuery();
                            if (hdrVO.first() != null) {
                                if (ucmRes.equalsIgnoreCase("SUCCESS")) {
                                    hdrVO.getCurrentRow().setAttribute("UcmRes", "SUCCESS");
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "COMPLETED");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                } else {
                                    hdrVO.getCurrentRow().setAttribute("UcmRes", ucmRes); //PayrollTansStatus
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "ERROR");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                }
                                if (hdlRes.equalsIgnoreCase("SUCCESS")) {
                                    hdrVO.getCurrentRow().setAttribute("HdlRes", "SUCCESS");
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "COMPLETED");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                } else {
                                    hdrVO.getCurrentRow().setAttribute("HdlRes", hdlRes);
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "ERROR");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                }
                                //                           hdrVO.executeQuery();
                                ADFUtils.findOperation("Commit").execute();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            System.err.println(e);
                        }
                    }
                }
            } else if ("BusinessTripCompletion".equals(cu.getAttribute("ReqType"))) {
                int i = 1;
                hdr = "";
                dtl = "";

                if (cu.getAttribute("Attribute2") != null) {
                    if (cu.getAttribute("Attribute2").equals("Y")) {
                        String reqNum = (String) cu.getAttribute("RequestNumber"); //EmployeeName
                        String emp = (String) cu.getAttribute("EmployeeNumber");


                        //persId
                        ViewObject personVO = ADFUtils.findIterator("personROVO1Iterator").getViewObject();
                        personVO.setNamedWhereClauseParam("persId", cu.getAttribute("EmpId"));
                        personVO.executeQuery();
                        BigDecimal perNum = (BigDecimal) personVO.first().getAttribute("PersonNumber");
                        //random doc number
                        genraterandomString(emp);
                        Random rand = new Random();
                        docname = generatedString;
                        java.util.Date payrollTransDate = (java.util.Date) cu.getAttribute("PayrollTransDate");
                        
                        FileName = reqNum;
                        Calendar calendar = Calendar.getInstance();
                        if(payrollTransDate!=null)
                        calendar.setTime(payrollTransDate);

                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");

                        calendar.set(Calendar.DAY_OF_MONTH, 1);

                        int numOfDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                        String st = dateFormat1.format(calendar.getTime());

                        calendar.add(Calendar.DAY_OF_MONTH, numOfDaysInMonth - 1);
                        String end = dateFormat1.format(calendar.getTime());

                        ViewCriteria vc = payRollDtlVO.createViewCriteria();
                        ViewCriteriaRow vcr = vc.createViewCriteriaRow();
                        vcr.setAttribute("ReqId", cu.getAttribute("ReqId"));
                        vc.addRow(vcr);
                        payRollDtlVO.applyViewCriteria(vc);
                        payRollDtlVO.executeQuery();

                        RowSetIterator dtlRS = payRollDtlVO.createRowSetIterator(null);
                        System.err.println("count of details - - " + payRollDtlVO.getEstimatedRowCount());
                        while (dtlRS.hasNext()) {
                            System.err.println("count of details1 - - " + payRollDtlVO.getEstimatedRowCount());
                            int n = rand.nextInt(9999999) + 1;
                            hdr += "MERGE|ElementEntry|HRC_SQLLOADER|1008_MISC_" + n + "|" + n + "|E" + perNum + "|";
                            hdr +=
                                st + "|" + end + "|Perdiem Payment Business Trip|SA Legislative Data Group|" + i +
                                "|E|H\n";

                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_REQ|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Perdiem Payment Business Trip|SA Legislative Data Group|" + i +
                                "|Request Number|" + reqNum + "\n";
                            Row curr = dtlRS.next();

                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_PRJ|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Perdiem Payment Business Trip|SA Legislative Data Group|" + i +
                                "|Project|" + curr.getAttribute("ProjType") + "\n";
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_REG|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Perdiem Payment Business Trip|SA Legislative Data Group|" + i +
                                "|Region|" + curr.getAttribute("DestCategory") + "\n";
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_FDT|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Perdiem Payment Business Trip|SA Legislative Data Group|" + i +
                                "|From Date|" + hcmDateFormat.format(curr.getAttribute("StartDate")) + "\n";
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_TDT|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Perdiem Payment Business Trip|SA Legislative Data Group|" + i +
                                "|To Date|" + hcmDateFormat.format(curr.getAttribute("EndDate")) + "\n";
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_TDS|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Perdiem Payment Business Trip|SA Legislative Data Group|" + i +
                                "|Trip Description|" + curr.getAttribute("Description") + "\n";
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_ADF|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Perdiem Payment Business Trip|SA Legislative Data Group|" + i +
                                "|Adv Date From|" + hcmDateFormat.format(curr.getAttribute("OrigStartDate")) + "\n";
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_ADT|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Perdiem Payment Business Trip|SA Legislative Data Group|" + i +
                                "|Adv Date To|" + hcmDateFormat.format(curr.getAttribute("OrigEndDate")) + "\n";
                            dtl +=
                                "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_ADN|" + n + "|E" + perNum +
                                "|";
                            dtl +=
                                st + "|" + end + "|Perdiem Payment Business Trip|SA Legislative Data Group|" + i +
                                "|Adv Request Number|" + curr.getAttribute("BussTravReqNum") + "\n";


                            System.err.println("count of details2 - - " + payRollDtlVO.getEstimatedRowCount());
                            i++;
                            System.err.println("count of detail3 - - " + payRollDtlVO.getEstimatedRowCount());
                        }
                        i = 0;

                        base64code = fileACL(hdr, dtl, FileName);

                        java.util.Date date = new java.util.Date();
                        SimpleDateFormat dateFormat =
                            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"); //Hours:Minutes:Seconds
                        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

                        long t = date.getTime();
                        java.util.Date expDate;

                        expDate = new java.util.Date(t + (10 * 600));

                        java.util.Date plusOne;


                        plusOne = new java.util.Date(t + (24 * 3600000));

                        String createdTS = dateFormat.format(date);
                        String expiresTS = dateFormat.format(expDate);

                        pp =
                            "<soapenv:Envelope xmlns:erp=\"http://xmlns.oracle.com/apps/financials/commonModules/shared/model/erpIntegrationService/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/commonModules/shared/model/erpIntegrationService/types/\">\n" +
                            "   <soapenv:Header>\n" +
                            "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                            "         <wsu:Timestamp wsu:Id=\"TS-CA8645EA17D44D489D15052969404602\">\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" + "            <wsu:Expires>" +
                            expiresTS + "</wsu:Expires>\n" + "         </wsu:Timestamp>\n" +
                            "         <wsse:UsernameToken wsu:Id=\"UsernameToken-CA8645EA17D44D489D15052969348891\">\n" +
                            "            <wsse:Username>paas.user@salic.com</wsse:Username>\n" +
                            "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Welc@me123</wsse:Password>\n" +
                            "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">iU7oRIFC/+67/n4SkJ3mzQ==</wsse:Nonce>\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                            "         </wsse:UsernameToken>\n" + "      </wsse:Security>\n" + "   </soapenv:Header>\n" +
                            "   <soapenv:Body>\n" + "     <typ:uploadFileToUcm>\n" + "         <typ:document>\n" +
                            "            <erp:Content>" + base64code + "</erp:Content>\n" +
                            "            <erp:FileName>" + FileName + ".zip</erp:FileName>\n" +
                            "            <!--Optional:-->\n" + "            <erp:ContentType>zip</erp:ContentType>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentTitle>ElementEntry.zip</erp:DocumentTitle>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentAuthor>Mahalingam</erp:DocumentAuthor>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentSecurityGroup>FAFusionImportExport</erp:DocumentSecurityGroup>\n" +
                            "            <!--Optional:-->\n" +
                            "            <erp:DocumentAccount>hcm$/dataloader$/import$</erp:DocumentAccount>\n" +
                            "            <!--Optional:-->\n" + "            <erp:DocumentName>" + docname +
                            "</erp:DocumentName>\n" + "            <!--Optional:-->\n" + "         </typ:document>\n" +
                            "      </typ:uploadFileToUcm>\n" + "   </soapenv:Body>\n" + "</soapenv:Envelope>";

                        hdl =
                            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/hcm/common/dataLoader/core/dataLoaderIntegrationService/types/\">\n" +
                            "   <soapenv:Header>\n" +
                            "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                            "         <wsu:Timestamp wsu:Id=\"TS-CA8645EA17D44D489D15055632292379\">\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" + "            <wsu:Expires>" +
                            expiresTS + "</wsu:Expires>\n" + "         </wsu:Timestamp>\n" +
                            "         <wsse:UsernameToken wsu:Id=\"UsernameToken-CA8645EA17D44D489D15055621504837\">\n" +
                            "            <wsse:Username>paas.user@salic.com</wsse:Username>\n" +
                            "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Welc@me123</wsse:Password>\n" +
                            "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">0LK4VNEj89A+UnSOaw0SiQ==</wsse:Nonce>\n" +
                            "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                            "         </wsse:UsernameToken>\n" + "      </wsse:Security>\n" + "   </soapenv:Header>\n" +
                            "   <soapenv:Body>\n" + "      <typ:importAndLoadData>\n" + "         <typ:ContentId>" +
                            docname + "</typ:ContentId>\n" + "      </typ:importAndLoadData>\n" +
                            "   </soapenv:Body>\n" + "</soapenv:Envelope>";
                        try {
                            callWebservice();
                            callHDL();

                            ViewObjectImpl impl = (ViewObjectImpl) hdrVO.getViewObject();
                            impl.setNamedWhereClauseParam("BV_ID", cu.getAttribute("RequestNumber"));
                            impl.applyViewCriteria(impl.getViewCriteria("findById"));
                            impl.executeQuery();
                            if (hdrVO.first() != null) {
                                if (ucmRes.equalsIgnoreCase("SUCCESS")) {
                                    hdrVO.getCurrentRow().setAttribute("UcmRes", "SUCCESS");
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "COMPLETED");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                } else {
                                    hdrVO.getCurrentRow().setAttribute("UcmRes", ucmRes); //PayrollTansStatus
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "ERROR");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                }
                                if (hdlRes.equalsIgnoreCase("SUCCESS")) {
                                    hdrVO.getCurrentRow().setAttribute("HdlRes", "SUCCESS");
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "COMPLETED");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                } else {
                                    hdrVO.getCurrentRow().setAttribute("HdlRes", hdlRes);
                                    hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "ERROR");
                                    hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                }
                                //                           hdrVO.executeQuery();
                                ADFUtils.findOperation("Commit").execute();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            System.err.println(e);
                        }
                    }
                }

                // OTHER EXPENSES
                i = 1;
                hdr = "";
                dtl = "";

                if (cu.getAttribute("Attribute2") != null) {
                    if (cu.getAttribute("Attribute2").equals("Y")) {
                        String reqNum = (String) cu.getAttribute("RequestNumber"); //EmployeeName
                        String emp = (String) cu.getAttribute("EmployeeNumber");


                        //persId
                        ViewObject personVO = ADFUtils.findIterator("personROVO1Iterator").getViewObject();
                        personVO.setNamedWhereClauseParam("persId", cu.getAttribute("EmpId"));
                        personVO.executeQuery();
                        BigDecimal perNum = (BigDecimal) personVO.first().getAttribute("PersonNumber");
                        //random doc number
                        genraterandomString(emp);
                        Random rand = new Random();
                        docname = generatedString;
                        java.util.Date payrollTransDate = (java.util.Date) cu.getAttribute("PayrollTransDate");
                        
                        FileName = reqNum;
                        Calendar calendar = Calendar.getInstance();
                        if(payrollTransDate!=null)
                        calendar.setTime(payrollTransDate);

                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");

                        calendar.set(Calendar.DAY_OF_MONTH, 1);

                        int numOfDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                        String st = dateFormat1.format(calendar.getTime());

                        calendar.add(Calendar.DAY_OF_MONTH, numOfDaysInMonth - 1);
                        String end = dateFormat1.format(calendar.getTime());

                        ViewCriteria vc = payRollDtlVO.createViewCriteria();
                        ViewCriteriaRow vcr = vc.createViewCriteriaRow();
                        vcr.setAttribute("ReqId", cu.getAttribute("ReqId"));
                        vc.addRow(vcr);
                        payRollDtlVO.applyViewCriteria(vc);
                        payRollDtlVO.executeQuery();

                        RowSetIterator dtlRS = payRollDtlVO.createRowSetIterator(null);
                        RowSetIterator othrExpRS = othrExpVO.createRowSetIterator(null);
                        System.err.println("count of details - - " + payRollDtlVO.getEstimatedRowCount());
                        
                        while (dtlRS.hasNext()) {
                            Row detail = dtlRS.next();
                            vc = othrExpVO.createViewCriteria();
                            vcr = vc.createViewCriteriaRow();
                            vcr.setAttribute("ReqDtlsId", detail.getAttribute("ReqDtlsId"));
                            vc.addRow(vcr);
                            othrExpVO.applyViewCriteria(vc);
                            othrExpVO.executeQuery();

                            othrExpRS = othrExpVO.createRowSetIterator(null);
                            System.err.println("count of other expenses " + othrExpVO.getEstimatedRowCount());
                         
                            while (othrExpRS.hasNext()) {
                                int n = rand.nextInt(9999999) + 1;
                                hdr +=
                                    "MERGE|ElementEntry|HRC_SQLLOADER|1008_MISC_" + n + "|" + n + "|E" + perNum + "|";
                                hdr +=
                                    st + "|" + end + "|Perdiem Payment Miscellaneous|SA Legislative Data Group|" + i +
                                    "|E|H\n";
                                dtl +=
                                    "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_REQ|" + n + "|E" +
                                    perNum + "|";
                                dtl +=
                                    st + "|" + end + "|Perdiem Payment Miscellaneous|SA Legislative Data Group|" + i +
                                    "|Request Number|" + reqNum + "\n";

                                Row curr = othrExpRS.next();

                                dtl +=
                                    "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_AMT|" + n + "|E" +
                                    perNum + "|";
                                dtl +=
                                    st + "|" + end + "|Perdiem Payment Miscellaneous|SA Legislative Data Group|" + i +
                                    "|Amount|" + curr.getAttribute("OtherExpn") + "\n";
                                dtl +=
                                    "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_AAT|" + n + "|E" +
                                    perNum + "|";
                                dtl +=
                                    st + "|" + end + "|Perdiem Payment Miscellaneous|SA Legislative Data Group|" + i +
                                    "|Actual Amount|" + curr.getAttribute("TotalAmount") + "\n";
                                dtl +=
                                    "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_CUR|" + n + "|E" +
                                    perNum + "|";
                                dtl +=
                                    st + "|" + end + "|Perdiem Payment Miscellaneous|SA Legislative Data Group|" + i +
                                    "|Currency|" + curr.getAttribute("Currency") + "\n";
                                dtl +=
                                    "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_EXT|" + n + "|E" +
                                    perNum + "|";
                                dtl +=
                                    st + "|" + end + "|Perdiem Payment Miscellaneous|SA Legislative Data Group|" + i +
                                    "|Exchange Rate|" + curr.getAttribute("ExchnRate") + "\n";
                                dtl +=
                                    "MERGE|ElementEntryValue|HRC_SQLLOADER|1008_MISC_" + n + "_EDS|" + n + "|E" +
                                    perNum + "|";
                                dtl +=
                                    st + "|" + end + "|Perdiem Payment Miscellaneous|SA Legislative Data Group|" + i +
                                    "|Expense Description|" + curr.getAttribute("ExpnDesc") + "\n"; 
                            }
                            i = 0;

                            base64code = fileACL(hdr, dtl, FileName);

                            java.util.Date date = new java.util.Date();
                            SimpleDateFormat dateFormat =
                                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"); //Hours:Minutes:Seconds
                            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

                            long t = date.getTime();
                            java.util.Date expDate;

                            expDate = new java.util.Date(t + (10 * 600));

                            java.util.Date plusOne;


                            plusOne = new java.util.Date(t + (24 * 3600000));

                            String createdTS = dateFormat.format(date);
                            String expiresTS = dateFormat.format(expDate);

                            pp =
                                "<soapenv:Envelope xmlns:erp=\"http://xmlns.oracle.com/apps/financials/commonModules/shared/model/erpIntegrationService/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/commonModules/shared/model/erpIntegrationService/types/\">\n" +
                                "   <soapenv:Header>\n" +
                                "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                                "         <wsu:Timestamp wsu:Id=\"TS-CA8645EA17D44D489D15052969404602\">\n" +
                                "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                                "            <wsu:Expires>" + expiresTS + "</wsu:Expires>\n" +
                                "         </wsu:Timestamp>\n" +
                                "         <wsse:UsernameToken wsu:Id=\"UsernameToken-CA8645EA17D44D489D15052969348891\">\n" +
                                "            <wsse:Username>paas.user@salic.com</wsse:Username>\n" +
                                "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Welc@me123</wsse:Password>\n" +
                                "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">iU7oRIFC/+67/n4SkJ3mzQ==</wsse:Nonce>\n" +
                                "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                                "         </wsse:UsernameToken>\n" + "      </wsse:Security>\n" +
                                "   </soapenv:Header>\n" + "   <soapenv:Body>\n" + "     <typ:uploadFileToUcm>\n" +
                                "         <typ:document>\n" + "            <erp:Content>" + base64code +
                                "</erp:Content>\n" + "            <erp:FileName>" + FileName + ".zip</erp:FileName>\n" +
                                "            <!--Optional:-->\n" +
                                "            <erp:ContentType>zip</erp:ContentType>\n" +
                                "            <!--Optional:-->\n" +
                                "            <erp:DocumentTitle>ElementEntry.zip</erp:DocumentTitle>\n" +
                                "            <!--Optional:-->\n" +
                                "            <erp:DocumentAuthor>Mahalingam</erp:DocumentAuthor>\n" +
                                "            <!--Optional:-->\n" +
                                "            <erp:DocumentSecurityGroup>FAFusionImportExport</erp:DocumentSecurityGroup>\n" +
                                "            <!--Optional:-->\n" +
                                "            <erp:DocumentAccount>hcm$/dataloader$/import$</erp:DocumentAccount>\n" +
                                "            <!--Optional:-->\n" + "            <erp:DocumentName>" + docname +
                                "</erp:DocumentName>\n" + "            <!--Optional:-->\n" +
                                "         </typ:document>\n" + "      </typ:uploadFileToUcm>\n" +
                                "   </soapenv:Body>\n" + "</soapenv:Envelope>";

                            hdl =
                                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/hcm/common/dataLoader/core/dataLoaderIntegrationService/types/\">\n" +
                                "   <soapenv:Header>\n" +
                                "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                                "         <wsu:Timestamp wsu:Id=\"TS-CA8645EA17D44D489D15055632292379\">\n" +
                                "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                                "            <wsu:Expires>" + expiresTS + "</wsu:Expires>\n" +
                                "         </wsu:Timestamp>\n" +
                                "         <wsse:UsernameToken wsu:Id=\"UsernameToken-CA8645EA17D44D489D15055621504837\">\n" +
                                "            <wsse:Username>paas.user@salic.com</wsse:Username>\n" +
                                "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Welc@me123</wsse:Password>\n" +
                                "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">0LK4VNEj89A+UnSOaw0SiQ==</wsse:Nonce>\n" +
                                "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                                "         </wsse:UsernameToken>\n" + "      </wsse:Security>\n" +
                                "   </soapenv:Header>\n" + "   <soapenv:Body>\n" + "      <typ:importAndLoadData>\n" +
                                "         <typ:ContentId>" + docname + "</typ:ContentId>\n" +
                                "      </typ:importAndLoadData>\n" + "   </soapenv:Body>\n" + "</soapenv:Envelope>";
                            try {
                                callWebservice();
                                callHDL();

                                ViewObjectImpl impl = (ViewObjectImpl) hdrVO.getViewObject();
                                impl.setNamedWhereClauseParam("BV_ID", cu.getAttribute("RequestNumber"));
                                impl.applyViewCriteria(impl.getViewCriteria("findById"));
                                impl.executeQuery();
                                if (hdrVO.first() != null) {
                                    if (ucmRes.equalsIgnoreCase("SUCCESS")) {
                                        hdrVO.getCurrentRow().setAttribute("UcmRes", "SUCCESS");
                                        hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "COMPLETED");
                                        hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                    } else {
                                        hdrVO.getCurrentRow().setAttribute("UcmRes", ucmRes); //PayrollTansStatus
                                        hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "ERROR");
                                        hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                    }
                                    if (hdlRes.equalsIgnoreCase("SUCCESS")) {
                                        hdrVO.getCurrentRow().setAttribute("HdlRes", "SUCCESS");
                                        hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "COMPLETED");
                                        hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                    } else {
                                        hdrVO.getCurrentRow().setAttribute("HdlRes", hdlRes);
                                        hdrVO.getCurrentRow().setAttribute("PayrollTansStatus", "ERROR");
                                        hdrVO.getCurrentRow().setAttribute("Attribute3", docname);
                                    }
                                    //                           hdrVO.executeQuery();
                                    ADFUtils.findOperation("Commit").execute();
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                                System.err.println(e);
                            }
                        }
                    }
                }
            }
        }
        payRollVO.executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(newPayrollTable);
        p1.cancel();
        AdfFacesContext.getCurrentInstance().addPartialTarget(p1);
        JSFUtils.addFacesInformationMessage("Selected Request Moved to PayRoll!!");
    }

    public String callHDL() {
        try {
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("text/xml");
            String xmlInput = hdl;
            RequestBody body = RequestBody.create(mediaType, xmlInput);


            String error = null;

            Request request = new Request.Builder().url("https://eepz-test.hcm.em2.oraclecloud.com/hcmCommonDataLoader/HCMDataLoader?WSDL")
                                                   .post(body)
                                                   .addHeader("content-type", "text/xml")
                                                   .addHeader("cache-control", "no-cache")
                                                   .build();

            Response response = client.newCall(request).execute();


            InputStream isr = response.body().byteStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(isr));
            StringBuilder out = new StringBuilder();
            String resultsXml;
            while ((resultsXml = reader.readLine()) != null) {
                out.append(resultsXml);
            }


            int responseCode = response.code();
            String temp = out.toString();
            String reportResponse = getResponseAsString(temp); //out.toString());
            if (reportResponse == "SUCCESS") {
                reader.close();
                hdlRes = "SUCCESS";
            } else {

                System.out.println("Report Response-------> " + reportResponse);
                reader.close();
                hdlRes = reportResponse;
            }


        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return hdlRes;
    }

    public String callWebservice() {
        try {
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("text/xml");
            String xmlInput = pp;
            RequestBody body = RequestBody.create(mediaType, xmlInput);


            String error = null;

            Request request = new Request.Builder().url("https://eepz-test.fin.em2.oraclecloud.com/publicFinancialCommonErpIntegration/ErpIntegrationService?WSDL")
                                                   .post(body)
                                                   .addHeader("content-type", "text/xml")
                                                   .addHeader("cache-control", "no-cache")
                                                   .build();

            Response response = client.newCall(request).execute();


            InputStream isr = response.body().byteStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(isr));
            StringBuilder out = new StringBuilder();
            String resultsXml;
            while ((resultsXml = reader.readLine()) != null) {
                out.append(resultsXml);
            }


            int responseCode = response.code();
            String temp = out.toString().substring(out.toString().indexOf("<?xml"));
            temp = temp.substring(0, temp.indexOf("---"));
            String reportResponse = getResponseAsString(temp); //out.toString());
            if (reportResponse == "SUCCESS") {
                reader.close();
                ucmRes = "SUCCESS";
            } else {

                System.out.println("Report Response-------> " + reportResponse);
                reader.close();
                ucmRes = reportResponse;
            }


        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return ucmRes;
    }

    public synchronized static String getResponseAsString(String resp) throws ParserConfigurationException,
                                                                              SAXException, IOException {
        String response = resp;

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        InputSource src = new InputSource();

        src.setCharacterStream(new StringReader(response));

        Document doc = builder.parse(src);

        try {
            response = doc.getElementsByTagName("faultstring")
                          .item(0)
                          .getTextContent();
        } catch (Exception e) {
            response = "SUCCESS";
        }
        return response;


    }


    public String submitAC() {
        ADFUtils.findOperation("Commit").execute();
        ViewObject payObj = ADFUtils.findIterator("PayrollTransfer_VO1Iterator").getViewObject();
        RowSetIterator rs = payObj.createRowSetIterator(null);
        while (rs.hasNext()) {
            Row cu = rs.next();
            System.err.println("ss - -" + cu.getAttribute("Attribute2"));
        }

        return null;
    }

    public void cancelPop(ActionEvent actionEvent) {
        p1.cancel();
        AdfFacesContext.getCurrentInstance().addPartialTarget(p1);
    }
}

