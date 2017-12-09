package SalicView.backing;

import SalicView.backing.Utils.ADFUtils;

import SalicView.backing.Utils.JSFUtils;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.FileWriter;

import java.io.IOException;

import java.io.InputStream;

import java.math.BigDecimal;

import java.net.MalformedURLException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import javax.xml.bind.DatatypeConverter;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.context.AdfFacesContext;

//import oracle.cloud.storage.CloudStorage;
//import oracle.cloud.storage.CloudStorageConfig;
//
//import oracle.cloud.storage.CloudStorageFactory;

//import oracle.cloud.storage.CloudStorage;
//import oracle.cloud.storage.CloudStorageConfig;
//import oracle.cloud.storage.CloudStorageFactory;

import oracle.jbo.Row;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import view.session.LoginBean;


public class OvertimeSearch {
    ViewObject variationSearchVo=ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
    private RichInputText it1;
    private RichTable t2;
    private RichInputText mgrItSearch;
    private RichTable mgrTable;


    public void onClickSearch(ActionEvent actionEvent) {
        if(it1.getValue()!=null){
            ViewCriteria vc=variationSearchVo.createViewCriteria();
            ViewCriteriaRow vcr=vc.createViewCriteriaRow();
            vcr.setAttribute("RequestNumber", "like %"+it1.getValue()+"%");
            vc.addRow(vcr);
            variationSearchVo.applyViewCriteria(vc);
            variationSearchVo.executeQuery();
        }else{
            ViewCriteria vc=variationSearchVo.createViewCriteria();
            ViewCriteriaRow vcr=vc.createViewCriteriaRow();
            vcr.setAttribute("RequestNumber", "");
            vc.addRow(vcr);
            variationSearchVo.applyViewCriteria(vc);
            variationSearchVo.executeQuery();
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(t2);
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }

    public void onClickMgrDashSearchACL(ActionEvent actionEvent) {
        ViewObject mgrVo=ADFUtils.findIterator("XxQpActionHistoryTVO1Iterator").getViewObject();
        if(mgrItSearch.getValue()!=null){
            ViewCriteria vc=mgrVo.createViewCriteria();
            ViewCriteriaRow vcr=vc.createViewCriteriaRow();
            vcr.setAttribute("ApproverUserName", "like %"+mgrItSearch.getValue()+"%");
            vc.addRow(vcr);
            mgrVo.applyViewCriteria(vc);
            mgrVo.executeQuery();
        }else{
            ViewCriteria vc=mgrVo.createViewCriteria();
            ViewCriteriaRow vcr=vc.createViewCriteriaRow();
            vcr.setAttribute("ApproverUserName", "");
            vc.addRow(vcr);
            mgrVo.applyViewCriteria(vc);
            mgrVo.executeQuery();
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(mgrTable);
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

    public void fileACL(ActionEvent actionEvent) throws FileNotFoundException,
                                                        MalformedURLException {
     /*   CloudStorageConfig myConfig = new CloudStorageConfig();
                      myConfig.setServiceName("https://myservices.us.oraclecloud.com-a486643").setUsername("Abdulmohsen.alaiban@salic.com")
                                      .setPassword("Salic@123".toCharArray()).setServiceUrl("https://storageconsole.us2.oraclecloud.com");
                      CloudStorage myConnection = CloudStorageFactory.getStorage(myConfig);
                      FileInputStream fis = new FileInputStream("hello_world.txt");
                      myConnection.storeObject("ElementEntry", "hello_world.txt", "text/plain", fis);*/
     
        File f = null;
             boolean bool = false;
             
             try {
             
                // create new file
                f = new File("test.dat");
                 String content = "METADATA|ElementEntry|SourceSystemOwner|SourceSystemId|AssignmentNumber|EffectiveStartDate|EffectiveEndDate|ElementName|LegislativeDataGroupName|MultipleEntryCount|EntryType|CreatorType"; 
                 BufferedWriter bw =null;
                 FileWriter fw = null;
                // tries to create new file in the system
                bool = f.createNewFile();
                 String path=new File("").getAbsolutePath();
                       System.err.println("path======>"+path);
                 JSFUtils.addFacesInformationMessage("file  "+path);
                // prints
                System.out.println("File created: "+bool);
                
                // deletes file from the system
                f.delete();
                
                // delete() is invoked
                System.out.println("delete() method is invoked");
                
                // tries to create new file in the system
                bool = f.createNewFile();
                
                // print
                System.out.println("File created: "+bool);
                   System.err.println("sss-->  "+f);
                 JSFUtils.addFacesInformationMessage("file  "+f);
                 fw = new FileWriter(path+"//test.dat");
                 bw = new BufferedWriter(fw);
                        bw.write(content);
                        bw.close();
                        fw.close();

            byte[] buffer = new byte[1024];
            FileOutputStream fos =
                new FileOutputStream(path + "//ElementEntry.zip");
            ZipOutputStream zos = new ZipOutputStream(fos);
            ZipEntry ze = new ZipEntry("test.dat");
            zos.putNextEntry(ze);
            FileInputStream in =
                new FileInputStream(path + "//test.dat");

            int len;
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }

            in.close();
            zos.closeEntry();

            zos.close();

            System.out.println("Done");
                 
                 String inputFile = path+"//ElementEntry.zip";
                           byte[] fileInBytes = loadFile(inputFile);
                           String fileInBase64 = DatatypeConverter.printBase64Binary(fileInBytes);
                           System.out.println(fileInBase64);
                 
                 
                 JSFUtils.addFacesInformationMessage("base64 code    "+fileInBase64);      
             } catch(Exception e) {
                e.printStackTrace();
                 JSFUtils.addFacesInformationMessage("file  "+e.getMessage());
             }
    }
    public static byte[] loadFile(String sourcePath) throws IOException
       {
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
    public String createNewRequest() {
        String returnActivity = null;
        LoginBean usersb =
            (LoginBean) ADFUtils.evaluateEL("#{loginBean}");       
        
        BigDecimal empId = new BigDecimal(usersb.getPersonId());
        
        boolean isSuccess = true;

        ViewObject empRO = ADFUtils.findIterator("employeeROVOByIdIterator").getViewObject();
        empRO.setNamedWhereClauseParam("BV_EMP_ID", usersb.getPersonId());
        empRO.executeQuery();
        Row empRow = empRO.first();
        ViewObject variationSearchVo =
            ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator1").getViewObject();
        ViewObject line =
            ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject();
        Row reqHeaderRow = variationSearchVo.createRow();
        reqHeaderRow.setAttribute("employeeNameTRANS", empRow.getAttribute("EmpName"));
        reqHeaderRow.setAttribute("EmpId", empRow.getAttribute("EmpId"));
        reqHeaderRow.setAttribute("departmentTRANS", empRow.getAttribute("Department"));
        reqHeaderRow.setAttribute("empNumberTRANS", empRow.getAttribute("EmpNumber"));
        reqHeaderRow.setAttribute("gradeTRANS", empRow.getAttribute("Grade"));
        reqHeaderRow.setAttribute("jobTitleTRANS", empRow.getAttribute("JobTitle"));
        reqHeaderRow.setAttribute("lineManagerTRANS", empRow.getAttribute("LineManager"));
        variationSearchVo.insertRow(reqHeaderRow);
        Row reqDetailRow = line.createRow();
        line.insertRow(reqDetailRow);
        ADFContext.getCurrent().getSessionScope().put("empfil",
                                                      reqHeaderRow.getAttribute("EmpId"));
        if ("house".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            String errorMsg = validateEmpHousingAdvEligibility((oracle.jbo.domain.Number)variationSearchVo.getCurrentRow().getAttribute("EmpId"));
            if(errorMsg!=null){
                isSuccess = false;
                addMessageToComponent(errorMsg);
            }else{
                isSuccess = true;
                DateFormat dateFormat =
                    new SimpleDateFormat("dd/MM/yyyy'T'kk:mm:ss"); ////2016/11/16
                    dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kuwait"));
                Date date = new Date();
                dateFormat.getTimeInstance().format(date);
                reqHeaderRow.setAttribute("RequestNumber",
                                                               dateFormat.format(date) +
                                                               "-HA-" +
                                                               reqHeaderRow.getAttribute("ReqId"));

                ViewObject ethnicVO =
                    ADFUtils.findIterator("salaryROVO1Iterator").getViewObject();
                
                ethnicVO.setNamedWhereClauseParam("sal",reqHeaderRow.getAttribute("EmpId"));
                ethnicVO.executeQuery();
                BigDecimal salary = new BigDecimal(0);
                if (ethnicVO.first() != null) {
                    salary =
                            (BigDecimal)ethnicVO.first().getAttribute("SalaryAmount");

                }
                BigDecimal month = new BigDecimal((String)reqDetailRow.getAttribute("Months"));
                reqDetailRow.setAttribute("AdvAmt",salary.multiply(month).multiply(new BigDecimal(0.25)));
            }            
            
            //line.executeQuery();


        } else if ("ot".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            String errorMsg = validateEmpOverTimeEligibility((String)variationSearchVo.getCurrentRow().getAttribute("gradeTRANS"));
            if(errorMsg!=null){
                isSuccess = false;
                addMessageToComponent(errorMsg);
            }else{
                isSuccess = true;
                DateFormat dateFormat =
                    new SimpleDateFormat("dd/MM/yyyy'T'kk:mm:ss"); ////2016/11/16
                    dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kuwait"));
                Date date = new Date();
                
                dateFormat.getTimeInstance().format(date);
                reqHeaderRow.setAttribute("RequestNumber",
                                                               dateFormat.format(date) +
                                                               "-OT-" +
                                                               reqHeaderRow.getAttribute("ReqId"));
            }
            
        } else if ("vacation".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            String errorMsg = validateEmpVacationEligibility((oracle.jbo.domain.Number)variationSearchVo.getCurrentRow().getAttribute("EmpId"));
            if(errorMsg!=null){
                isSuccess = false;
                addMessageToComponent(errorMsg);
                
            }else{
                isSuccess = true;
                ADFContext.getCurrent().getSessionScope().put("empfilv", reqHeaderRow.getAttribute("EmpId"));
//                JUCtrlListBinding listBinding =
//                                (JUCtrlListBinding)ADFUtils.getBindingContainer().get("Leave");
//                            listBinding.getListIterBinding().executeQuery();
//                AdfFacesContext.getCurrentInstance().addPartialTarget(leaveLov);
                
                DateFormat dateFormat =
                    new SimpleDateFormat("dd/MM/yyyy'T'kk:mm:ss"); ////2016/11/16
                    dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kuwait"));
                //        DateFormat time = new SimpleDateFormat("kk:mm:ss");//12:08:43
                Date date = new Date();
                //        System.out.println(dateFormat.format(date));
                //        System.out.println(dateFormat.format(date));
                dateFormat.getTimeInstance().format(date);
                reqHeaderRow.setAttribute("RequestNumber",
                                                               dateFormat.format(date) +
                                                               "-VC-" +
                                                               reqHeaderRow.getAttribute("ReqId"));
            }
            
        } else if ("salary".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            String errorMsg = validateEmployeeSalaryAdvanceEligibility((oracle.jbo.domain.Number)reqHeaderRow.getAttribute("EmpId"));
            if(errorMsg!=null){
                isSuccess = false;
                addMessageToComponent(errorMsg);
            }else{
                isSuccess = true;
                
                DateFormat dateFormat =
                    new SimpleDateFormat("dd/MM/yyyy'T'kk:mm:ss");
                dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kuwait"));
                Date date = new Date();
                dateFormat.getTimeInstance().format(date);
                reqHeaderRow.setAttribute("RequestNumber",
                                                               dateFormat.format(date) +
                                                               "-SA-" +
                                                               reqHeaderRow.getAttribute("ReqId"));
            }
            

        } else if ("letter".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            isSuccess = true;
            DateFormat dateFormat =
                new SimpleDateFormat("dd/MM/yyyy'T'kk:mm:ss"); ////2016/11/16
                dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kuwait"));
            //        DateFormat time = new SimpleDateFormat("kk:mm:ss");//12:08:43
            Date date = new Date();
            //        System.out.println(dateFormat.format(date));
            //        System.out.println(dateFormat.format(date));
            dateFormat.getTimeInstance().format(date);
            reqHeaderRow.setAttribute("RequestNumber",
                                                           dateFormat.format(date) +
                                                           "-HRL-" +
                                                           reqHeaderRow.getAttribute("ReqId"));

        }

        else if ("BusinessTripCompletion".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            isSuccess = true;
                

//                JUCtrlListBinding listBinding =
//                                (JUCtrlListBinding)ADFUtils.getBindingContainer().get("BussTravReqNum1");
//                            listBinding.getListIterBinding().executeQuery();

            DateFormat dateFormat =
                new SimpleDateFormat("dd/MM/yyyy'T'kk:mm:ss"); ////2016/11/16
            //        DateFormat time = new SimpleDateFormat("kk:mm:ss");//12:08:43
            dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kuwait"));
            Date date = new Date();
            //        System.out.println(dateFormat.format(date));
            //        System.out.println(dateFormat.format(date));
            dateFormat.getTimeInstance().format(date);
            reqHeaderRow.setAttribute("RequestNumber",
                                                           dateFormat.format(date) +
                                                           "-BTC-" +
                                                           reqHeaderRow.getAttribute("ReqId"));

        }

        else if ("BusinessTrip".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            isSuccess = true;
            DateFormat dateFormat =
                new SimpleDateFormat("dd/MM/yyyy'T'kk:mm:ss"); 
            dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kuwait"));
            Date date = new Date();
            dateFormat.getTimeInstance().format(date);
            reqHeaderRow.setAttribute("RequestNumber",
                                                           dateFormat.format(date) +
                                                           "-BT-" +
                                                           reqHeaderRow.getAttribute("ReqId"));

            //XxhcmPurposeOfTrvl_VO1Iterator
            ViewObject purposeOfTrv =
                ADFUtils.findIterator("XxhcmPurposeOfTrvl_VO1Iterator").getViewObject();
            Row reqPurposeRow = purposeOfTrv.createRow();
            purposeOfTrv.insertRow(reqPurposeRow);
        } else if ("edu".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            isSuccess = true;
            DateFormat dateFormat =
                new SimpleDateFormat("dd/MM/yyyy'T'kk:mm:ss"); 
            dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kuwait"));
            Date date = new Date();
            ADFContext.getCurrent().getSessionScope().put("empfil",
                                                          reqHeaderRow.getAttribute("EmpId"));

//            JUCtrlListBinding listBinding =
//                            (JUCtrlListBinding)ADFUtils.getBindingContainer().get("childTRANS");
//                        listBinding.getListIterBinding().executeQuery();
            dateFormat.getTimeInstance().format(date);
            reqHeaderRow.setAttribute("RequestNumber",
                                                           dateFormat.format(date) +
                                                           "-EA-" +
                                                           reqHeaderRow.getAttribute("ReqId"));
            
            BigDecimal maxAmt = fetchMaxAmountForEmployee(empId);
            line.getCurrentRow().setAttribute("MaxAmt", maxAmt);
            line.getCurrentRow().setAttribute("AvlAmt", maxAmt);
        }

        if ("salary".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {

            Calendar calendar = Calendar.getInstance();
            String Month =
                new SimpleDateFormat("MMM").format(calendar.getTime());
            System.err.println("start-->  " + Month);
            //            months.add(Month);
            calendar.add(Calendar.MONTH, 1);
            String nextMonth =
                new SimpleDateFormat("MMM").format(calendar.getTime());
            System.err.println("start-->  " + nextMonth);
            //            months.add(nextMonth);

            variationSearchVo.getCurrentRow().setAttribute("Attribute1",
                                                           Month);

            reqDetailRow.setAttribute("SalPeriod", Month);
            
        }
        oracle.binding.OperationBinding op = ADFUtils.findOperation("populateApproversForReqest");
        //RequestNumber
        op.getParamsMap().put("reqNumber", reqHeaderRow.getAttribute("RequestNumber"));
        op.getParamsMap().put("empId", (oracle.jbo.domain.Number)reqHeaderRow.getAttribute("EmpId"));
        op.getParamsMap().put("reqType", (String)ADFContext.getCurrent().getSessionScope().get("page"));
        op.getParamsMap().put("req_id", reqHeaderRow.getAttribute("ReqId"));
        op.execute();
        
        if(isSuccess){
            return "add";
        }else{
            return null;
        }
    }
    
    private BigDecimal fetchMaxAmountForEmployee(BigDecimal empId){
        oracle.binding.OperationBinding op = ADFUtils.findOperation("fetchMaxAmountForEmployee");
        op.getParamsMap().put("empId", empId);
        BigDecimal maxAmt = (BigDecimal) op.execute();
        return maxAmt;
    }
    
    public void addMessageToComponent(String errorMsg){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage(errorMsg);
                            fm.setSummary(null);
                            fm.setDetail(errorMsg);
                            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                        facesContext.addMessage(null,fm);
    }
    public String validateEmpOverTimeEligibility(String grade){
        String errorMsg = null;
        oracle.binding.OperationBinding op = ADFUtils.findOperation("getOTGradeEligibility");
        op.getParamsMap().put("grade", grade);
        String res = (String)op.execute();
        if(res!=null && res.equalsIgnoreCase("N")){
           return "You are not eligible for Over time request";
        }
        return errorMsg;
    }
    
    public String validateEmpBusinessTrip(oracle.jbo.domain.Number empId){
        String errorMsg = null;
        
        return errorMsg;
    }
    
    public String validateEmpBusinessTripCompletion(oracle.jbo.domain.Number empId){
        String errorMsg = null;
        
        return errorMsg;
    }
    
    public String validateEmpHousingAdvEligibility(oracle.jbo.domain.Number empId){
        String errorMsg =null;
        ViewObject countcheckVO =
            ADFUtils.findIterator("CheckEmployeeReqExistsROVO1Iterator").getViewObject();
        countcheckVO.setNamedWhereClauseParam("bind_empid",
                                          empId);
        countcheckVO.setNamedWhereClauseParam("bind_reqtype", "HA");
        countcheckVO.executeQuery();
        oracle.jbo.domain.Number count = (oracle.jbo.domain.Number)countcheckVO.first().getAttribute("Reccount");
        if(count.compareTo(0) == 1){
           return "You already availed this request in past six months";
        }else{
            ViewObject probCheckVO = ADFUtils.findIterator("hireROVO1Iterator").getViewObject();
            ViewObject ethnicVO = ADFUtils.findIterator("ethnicROVO1Iterator").getViewObject();
            ethnicVO.setNamedWhereClauseParam("pers", empId);
            ethnicVO.executeQuery();

            if (ethnicVO.first() != null) {
                if (ethnicVO.first().getAttribute("Ethnic").equals("SALIC01")) {
                    probCheckVO.setNamedWhereClauseParam("per", empId);
                    probCheckVO.executeQuery();
                    if (probCheckVO.first() != null) {
                        BigDecimal prob = (BigDecimal) probCheckVO.first().getAttribute("Days"); //Days
                        if (prob.compareTo(new BigDecimal(367)) == -1) {
                            return "One Year of Employment should be completed!";
                        }
                    }
                } else {
                    probCheckVO.setNamedWhereClauseParam("per", empId);
                    probCheckVO.executeQuery();
                    if (probCheckVO.first() != null) {
                        BigDecimal prob = (BigDecimal) probCheckVO.first().getAttribute("Days"); //Days
                        if (prob.compareTo(new BigDecimal(14)) == -1) {
                            return "you can raise the Request only after 2 weeks of Data of Joining!";
                        }
                    }
                }
            } else {
                return "There is no Nationality Details!..";
            }
        }
        return errorMsg;
    }
    public String validateEmployeeSalaryAdvanceEligibility(oracle.jbo.domain.Number empId){
        String errorMsg = null;
        ViewObject countcheckVO = ADFUtils.findIterator("ValidateSalAdvROVO1Iterator").getViewObject();
        countcheckVO.setNamedWhereClauseParam("bind_empid", empId);
        countcheckVO.setNamedWhereClauseParam("bind_reqtype", "SA");
        countcheckVO.executeQuery();
        oracle.jbo.domain.Number count = (oracle.jbo.domain.Number)countcheckVO.first().getAttribute("Reccount");
        if(count.compareTo(0) == 1){
            errorMsg = "You already availed this request in the current month";
            return errorMsg;
        }else{
            ViewObject probCheckVO = ADFUtils.findIterator("hireROVO1Iterator").getViewObject();
            probCheckVO.setNamedWhereClauseParam("per", empId);
            probCheckVO.executeQuery();
            if (probCheckVO.first() != null) {
                BigDecimal prob = (BigDecimal) probCheckVO.first().getAttribute("Days"); //Days
                if (prob.compareTo(new BigDecimal(90)) == -1) {
                    errorMsg = "Probation is not completed!";
                    return errorMsg;
                }
            }
        }
        return errorMsg;
    }

    public String validateEmpVacationEligibility(oracle.jbo.domain.Number empId){
        String errorMsg = null;
        ViewObject hdr2 = ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator2").getViewObject();
        ViewCriteria vcc = hdr2.createViewCriteria();
        ViewCriteriaRow vccr = vcc.createViewCriteriaRow();
        vccr.setAttribute("EmpId", empId);
        vccr.setAttribute("ReqType", "vacation");
        vcc.addRow(vccr);
        hdr2.applyViewCriteria(vcc);
        hdr2.executeQuery();
        if (hdr2.first() != null) {
            return "Already you have Raised Vacation Allowance for this Year!";
        }else{            
            ViewObject ethnicVO = ADFUtils.findIterator("ethnicROVO1Iterator").getViewObject();
            ethnicVO.setNamedWhereClauseParam("pers", empId);
            ethnicVO.executeQuery();

            if (ethnicVO.first() != null) {
                if (!ethnicVO.first().getAttribute("Ethnic").equals("SALIC01")) {
                    return "Non Saudi employee is not eligible for this request";
                }
            }
        }
        return errorMsg;
    }
       
}
