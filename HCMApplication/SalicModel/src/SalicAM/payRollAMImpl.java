package SalicAM;


import SalicAM.common.payRollAM;

import SalicROVO.FetchEmailActionLinkVOImpl;

import SalicROVO.FetchReqDtlsForPayrollMailImpl;

import SalicView.XxhcmOtherExpenseTVOImpl;

import common.AESEncryption;
import common.GenerateEmailTemplate;

import common.pojo.EmailRequestPojo;
import common.pojo.EmailTableDetailsPojo;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import oracle.adf.share.ADFContext;

import oracle.jbo.Row;
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

    /**
     * Container's getter for XxhcmOtherExpenseTVO1.
     * @return XxhcmOtherExpenseTVO1
     */
    public XxhcmOtherExpenseTVOImpl getXxhcmOtherExpenseTVO1() {
        return (XxhcmOtherExpenseTVOImpl) findViewObject("XxhcmOtherExpenseTVO1");
    }
    
    public void prepareMailTemplateAndSend(BigDecimal reqId) {
        EmailRequestPojo emailReq = new EmailRequestPojo();
        
        ViewObjectImpl emailVO = getFetchEmailActionLinkVO1();
        emailVO.executeQuery();
        String emailUrl = "";
        if(emailVO.first() != null){
            emailUrl = (String) emailVO.first().getAttribute("LookupValueNameDisp");
        }
        
        FetchReqDtlsForPayrollMailImpl fetchVO = getFetchReqDtlsForPayrollMail1();
        fetchVO.setbindReqId(reqId);
        fetchVO.executeQuery();
        
        emailReq.setRequestId(((BigDecimal) fetchVO.first().getAttribute("ReqId")).intValue());
        emailReq.setRequestNo((String)  fetchVO.first().getAttribute("RequestNumber"));
        emailReq.setEmpId((BigDecimal)  fetchVO.first().getAttribute("EmpId")+"");
        emailReq.setEmpName((String)  fetchVO.first().getAttribute("EmpName"));
        
        String reqPage = (String)fetchVO.first().getAttribute("ReqType");
        
        String reqType = getStringBasedOnReqType((String)fetchVO.first().getAttribute("ReqType"));
        
//        fetchVO.first().getAttribute("EmailAddress");
        
        ArrayList<String> toRecepients = new ArrayList<String>();

        String[] to = { "paas.user@salic.com" }; //TODO get logged in user email
        emailReq.setToEmail(to);
        emailReq.setToEmpName(emailReq.getEmpName());
        //                    emailReq.setToEmail((String[]) toRecepients.toArray());

        emailReq.setMessage("<b> " + reqType + " request" +
                            "</b> is transferred to payroll and under payment process with hereunder details:");
        emailReq.setSubject(reqType + " request (" + emailReq.getRequestNo() + ")"+
                            " is transferred to payroll (FYI)");
        
        if (reqPage.equalsIgnoreCase("ot")) {
            
            ArrayList<EmailTableDetailsPojo> emailTableDetails = new ArrayList<EmailTableDetailsPojo>();    
            EmailTableDetailsPojo tableDetail = new EmailTableDetailsPojo(); 
            ArrayList<String> tableContentCols = new ArrayList<String>();
            LinkedHashMap<String, String> tableColumnDatatypes = null;
            
            tableContentCols.add("Over Time Date");
            tableContentCols.add("Over Time Type");
            tableContentCols.add("Over Time Hours");
            tableContentCols.add("Calculated Hours");
            tableContentCols.add("Description");

            tableDetail.setTableContentColumns(tableContentCols);


            tableDetail.setDetailsQuery("select OVERTIME_DATE,(select dtl.lookup_value_name_disp from xxfnd_lookup_types_t hdr,xxfnd_lookup_values_t dtl where hdr.lookup_type_id = dtl.lookup_type_id and  hdr.lookup_type_name = 'OT_TYPE' and dtl.lookup_value_name=OVERTIME_TYPE) OVERTIME_TYPE,OVERTIME_HOURS,CALCULATED_HOURS,MISSIONS from XXHCM_OVERTIME_DETAILS_ALL where REQ_ID=" +
                                     emailReq.getRequestId());

            tableColumnDatatypes = new LinkedHashMap<String, String>();
            tableColumnDatatypes.put("OVERTIME_DATE", "DATE");
            tableColumnDatatypes.put("OVERTIME_TYPE", "STRING");
            tableColumnDatatypes.put("OVERTIME_HOURS", "STRING");
            tableColumnDatatypes.put("CALCULATED_HOURS", "STRING");
            tableColumnDatatypes.put("MISSIONS", "STRING");
            tableDetail.setTableColumnDatatypes(tableColumnDatatypes);
            
            emailTableDetails.add(tableDetail);
            emailReq.setTableDetails(emailTableDetails);
        }
        else if(reqPage.equalsIgnoreCase("salary")){
            
            ArrayList<EmailTableDetailsPojo> emailTableDetails = new ArrayList<EmailTableDetailsPojo>();    
            EmailTableDetailsPojo tableDetail = new EmailTableDetailsPojo(); 
            ArrayList<String> tableContentCols = new ArrayList<String>();
            LinkedHashMap<String, String> tableColumnDatatypes = null;
            
            tableContentCols.add("Salary Period");
            tableContentCols.add("Comments");

            tableDetail.setTableContentColumns(tableContentCols);


            tableDetail.setDetailsQuery("select SAL_PERIOD,MISSIONS from XXHCM_OVERTIME_DETAILS_ALL where REQ_ID=" +
                                     emailReq.getRequestId());

            tableColumnDatatypes = new LinkedHashMap<String, String>();
            tableColumnDatatypes.put("SAL_PERIOD", "STRING");
            tableColumnDatatypes.put("MISSIONS", "STRING");
            tableDetail.setTableColumnDatatypes(tableColumnDatatypes);
            
            emailTableDetails.add(tableDetail);
            emailReq.setTableDetails(emailTableDetails);
            
        }
        else if(reqPage.equalsIgnoreCase("BusinessTrip")){
            
            ArrayList<EmailTableDetailsPojo> emailTableDetails = new ArrayList<EmailTableDetailsPojo>();    
            EmailTableDetailsPojo tableDetail = new EmailTableDetailsPojo(); 
            ArrayList<String> tableContentCols = new ArrayList<String>();
            LinkedHashMap<String, String> tableColumnDatatypes = null;
            
            tableContentCols.add("Trip Type");
            tableContentCols.add("Airline Ticket Type");
            tableContentCols.add("Start Date");
            tableContentCols.add("End Date");
            tableContentCols.add("Destination Category");
            tableContentCols.add("Number Of Days");
            tableContentCols.add("Exit Reentry Visa");
            tableContentCols.add("Destination Country");
            tableContentCols.add("Advance PerDiem");
            tableContentCols.add("Destination Visa Required");
            tableContentCols.add("Project Type");
            tableContentCols.add("Comments");
            
            
            tableDetail.setTableContentColumns(tableContentCols);


            tableDetail.setDetailsQuery("select TRIP_TYPE,AIRLINE_TICKET_TYPE,START_DATE,END_DATE,DEST_CATEGORY,NUMBER_OF_DAYS,EXIT_RERENTRY_VISA,(select country_name from country where country_id = DESTINATION_COUNTRY) DESTINATION_COUNTRY,ADV_PERDIEM,DEST_VISA_REQUIRED,(select dtl.lookup_value_name_disp from xxfnd_lookup_types_t hdr,xxfnd_lookup_values_t dtl where hdr.lookup_type_id = dtl.lookup_type_id and  hdr.lookup_type_name = 'PROJ_TYPE' and dtl.lookup_value_name=PROJ_TYPE) PROJ_TYPE,COMMENTS from XXHCM_OVERTIME_DETAILS_ALL where REQ_ID=" +
                                     emailReq.getRequestId());

            tableColumnDatatypes = new LinkedHashMap<String, String>();
            tableColumnDatatypes.put("TRIP_TYPE", "STRING");
            tableColumnDatatypes.put("AIRLINE_TICKET_TYPE", "STRING");
            tableColumnDatatypes.put("START_DATE", "DATE");
            tableColumnDatatypes.put("END_DATE", "DATE");
            tableColumnDatatypes.put("DEST_CATEGORY", "STRING");
            tableColumnDatatypes.put("NUMBER_OF_DAYS", "STRING");
            tableColumnDatatypes.put("EXIT_RERENTRY_VISA", "STRING");
            tableColumnDatatypes.put("DESTINATION_COUNTRY", "STRING");
            tableColumnDatatypes.put("ADV_PERDIEM", "STRING");
            tableColumnDatatypes.put("DEST_VISA_REQUIRED", "STRING");
            tableColumnDatatypes.put("PROJ_TYPE", "STRING");
            tableColumnDatatypes.put("COMMENTS", "STRING");
            tableDetail.setTableColumnDatatypes(tableColumnDatatypes);
            
            emailTableDetails.add(tableDetail);
            
            tableDetail = new EmailTableDetailsPojo(); 
            
            tableContentCols = new ArrayList<String>();
            tableContentCols.add("Start Date");
            tableContentCols.add("End Date");
            tableContentCols.add("Activity");
            
            tableDetail.setTableContentColumns(tableContentCols);


            tableDetail.setDetailsQuery(" select start_date, end_date, activity from XXHCM_PURPOSE_OF_TRVL where REQ_DTLS_ID = (select req_dtls_id from XXHCM_OVERTIME_DETAILS_ALL where req_id = " +
                                     emailReq.getRequestId()+")");
            
            tableColumnDatatypes = new LinkedHashMap<String, String>();
            tableColumnDatatypes.put("START_DATE", "DATE");
            tableColumnDatatypes.put("END_DATE", "DATE");
            tableColumnDatatypes.put("ACTIVITY", "STRING");
            tableDetail.setTableLabel("Trip Activity");
            tableDetail.setTableColumnDatatypes(tableColumnDatatypes);
            
            emailTableDetails.add(tableDetail);
            
            emailReq.setTableDetails(emailTableDetails);
        }
        else if(reqPage.equalsIgnoreCase("BusinessTripCompletion")){
            
            ArrayList<EmailTableDetailsPojo> emailTableDetails = new ArrayList<EmailTableDetailsPojo>();    
            EmailTableDetailsPojo tableDetail = new EmailTableDetailsPojo(); 
            ArrayList<String> tableContentCols = new ArrayList<String>();
            LinkedHashMap<String, String> tableColumnDatatypes = null;
            
            tableContentCols.add("Business Travel Request Number");
            tableContentCols.add("Trip Type");
            tableContentCols.add("Airline Ticket Type");
            tableContentCols.add("Start Date");
            tableContentCols.add("End Date");
            tableContentCols.add("Destination Category");
            tableContentCols.add("Number Of Days");
            tableContentCols.add("Exit Reentry Visa");
            tableContentCols.add("Destination Country");
            tableContentCols.add("Advance PerDiem");
            tableContentCols.add("Destination Visa Required");
            tableContentCols.add("Project Type");
            tableContentCols.add("Comments");
            
            
            tableDetail.setTableContentColumns(tableContentCols);


            tableDetail.setDetailsQuery("select BUSS_TRAV_REQ_NUM_VALUE,TRIP_TYPE,AIRLINE_TICKET_TYPE,START_DATE,END_DATE,DEST_CATEGORY,NUMBER_OF_DAYS,EXIT_RERENTRY_VISA,(select country_name from country where country_id = DESTINATION_COUNTRY) DESTINATION_COUNTRY,ADV_PERDIEM,DEST_VISA_REQUIRED,(select dtl.lookup_value_name_disp from xxfnd_lookup_types_t hdr,xxfnd_lookup_values_t dtl where hdr.lookup_type_id = dtl.lookup_type_id and  hdr.lookup_type_name = 'PROJ_TYPE' and dtl.lookup_value_name=PROJ_TYPE) PROJ_TYPE,COMMENTS from XXHCM_OVERTIME_DETAILS_ALL where REQ_ID=" +
                                     emailReq.getRequestId());

            tableColumnDatatypes = new LinkedHashMap<String, String>();
            tableColumnDatatypes.put("BUSS_TRAV_REQ_NUM_VALUE", "STRING");
            tableColumnDatatypes.put("TRIP_TYPE", "STRING");
            tableColumnDatatypes.put("AIRLINE_TICKET_TYPE", "STRING");
            tableColumnDatatypes.put("START_DATE", "DATE");
            tableColumnDatatypes.put("END_DATE", "DATE");
            tableColumnDatatypes.put("DEST_CATEGORY", "STRING");
            tableColumnDatatypes.put("NUMBER_OF_DAYS", "STRING");
            tableColumnDatatypes.put("EXIT_RERENTRY_VISA", "STRING");
            tableColumnDatatypes.put("DESTINATION_COUNTRY", "STRING");
            tableColumnDatatypes.put("ADV_PERDIEM", "STRING");
            tableColumnDatatypes.put("DEST_VISA_REQUIRED", "STRING");
            tableColumnDatatypes.put("PROJ_TYPE", "STRING");
            tableColumnDatatypes.put("COMMENTS", "STRING");
            tableDetail.setTableColumnDatatypes(tableColumnDatatypes);
            
            emailTableDetails.add(tableDetail);
            
            tableDetail = new EmailTableDetailsPojo(); 
            
            tableContentCols = new ArrayList<String>();
            tableContentCols.add("Expense Description");
            tableContentCols.add("Currency");
            tableContentCols.add("Exchange Rate");
            tableContentCols.add("Expense Amount");
            tableContentCols.add("Amount in SAR");
            
            tableDetail.setTableContentColumns(tableContentCols);


            tableDetail.setDetailsQuery(" select expn_desc, currency, exchn_rate, other_expn, total_amount  from XXHCM_OTHER_EXPENSE where REQ_DTLS_ID = (select req_dtls_id from XXHCM_OVERTIME_DETAILS_ALL where req_id = " +
                                     emailReq.getRequestId()+")");
            
            tableColumnDatatypes = new LinkedHashMap<String, String>();
            tableColumnDatatypes.put("EXPN_DESC", "STRING");
            tableColumnDatatypes.put("CURRENCY", "STRING");
            tableColumnDatatypes.put("EXCHN_RATE", "STRING");
            tableColumnDatatypes.put("OTHER_EXPN", "STRING");
            tableColumnDatatypes.put("TOTAL_AMOUNT", "STRING");
            tableDetail.setTableLabel("Other Expenses");
            
            tableDetail.setTableColumnDatatypes(tableColumnDatatypes);
            
            emailTableDetails.add(tableDetail);
            
            tableDetail = new EmailTableDetailsPojo(); 
            
            tableContentCols = new ArrayList<String>();
            tableContentCols.add("Grand Total");
            
            tableDetail.setTableContentColumns(tableContentCols);


            tableDetail.setDetailsQuery("select (total_perdiem + (select sum(total_amount) from XXHCM_OTHER_EXPENSE where REQ_DTLS_ID = " +
                "(select req_dtls_id from XXHCM_OVERTIME_DETAILS_ALL where req_id = "+emailReq.getRequestId()+"))) Grand_Total " +
                       "from XXHCM_OVERTIME_DETAILS_ALL where req_id = " +emailReq.getRequestId());
            
            tableColumnDatatypes = new LinkedHashMap<String, String>();
            tableColumnDatatypes.put("GRAND_TOTAL", "STRING");
            tableDetail.setTableLabel("Grand Total");
            
            tableDetail.setTableColumnDatatypes(tableColumnDatatypes);
            
            emailTableDetails.add(tableDetail);
            
            emailReq.setTableDetails(emailTableDetails);
        }
        else if(reqPage.equalsIgnoreCase("edu")){
            
            ArrayList<EmailTableDetailsPojo> emailTableDetails = new ArrayList<EmailTableDetailsPojo>();    
            EmailTableDetailsPojo tableDetail = new EmailTableDetailsPojo(); 
            ArrayList<String> tableContentCols = new ArrayList<String>();
            LinkedHashMap<String, String> tableColumnDatatypes = null;
            
            tableContentCols.add("Invoice Number");
            tableContentCols.add("Invoice Date");
            tableContentCols.add("Child Name");
            tableContentCols.add("School Grade");
            tableContentCols.add("Actual Amount");
            tableContentCols.add("School");
            tableContentCols.add("Age");
            tableContentCols.add("Semester");
            tableContentCols.add("Max Eligible Amount");
            tableContentCols.add("Available Amount");
            
            tableDetail.setTableContentColumns(tableContentCols);


            tableDetail.setDetailsQuery("select INV_NUM,INV_DATE,(select display_name from XXSTG_PERSON where person_id = contactpersonid) CHILD,GRADE,ACT_AMT,SCHOOL,AGE,SEMESTER,MAX_AMT,AVL_AMT from XXHCM_OVERTIME_DETAILS_ALL where REQ_ID=" +
                                     emailReq.getRequestId());

            tableColumnDatatypes = new LinkedHashMap<String, String>();
            tableColumnDatatypes.put("INV_NUM", "STRING");
            tableColumnDatatypes.put("INV_DATE", "DATE");
            tableColumnDatatypes.put("CHILD", "STRING");
            tableColumnDatatypes.put("GRADE", "STRING");
            tableColumnDatatypes.put("ACT_AMT", "STRING");
            tableColumnDatatypes.put("SCHOOL", "STRING");
            tableColumnDatatypes.put("AGE", "STRING");
            tableColumnDatatypes.put("SEMESTER", "STRING");
            tableColumnDatatypes.put("MAX_AMT", "STRING");
            tableColumnDatatypes.put("AVL_AMT", "STRING");
            tableDetail.setTableColumnDatatypes(tableColumnDatatypes);
            
            emailTableDetails.add(tableDetail);
            emailReq.setTableDetails(emailTableDetails);
        }
        else if(reqPage.equalsIgnoreCase("letter")){
            
            ArrayList<EmailTableDetailsPojo> emailTableDetails = new ArrayList<EmailTableDetailsPojo>();    
            EmailTableDetailsPojo tableDetail = new EmailTableDetailsPojo(); 
            ArrayList<String> tableContentCols = new ArrayList<String>();
            LinkedHashMap<String, String> tableColumnDatatypes = null;
            
            tableContentCols.add("Letter Type");
            tableContentCols.add("Letter To");
            tableContentCols.add("Others");
            
            tableDetail.setTableContentColumns(tableContentCols);


            tableDetail.setDetailsQuery("select (select dtl.lookup_value_name_disp from xxfnd_lookup_types_t hdr,xxfnd_lookup_values_t dtl where hdr.lookup_type_id = dtl.lookup_type_id and  hdr.lookup_type_name = 'LETTER_TYPE' and dtl.lookup_value_name=LETTER_TYPE) LETTER_TYPE,LETTER_TO,OTHER from XXHCM_OVERTIME_DETAILS_ALL where REQ_ID=" +
                                     emailReq.getRequestId());

            tableColumnDatatypes = new LinkedHashMap<String, String>();
            tableColumnDatatypes.put("LETTER_TYPE", "STRING");
            tableColumnDatatypes.put("LETTER_TO", "STRING");
            tableColumnDatatypes.put("OTHER", "STRING");
            tableDetail.setTableColumnDatatypes(tableColumnDatatypes);
            
            emailTableDetails.add(tableDetail);
            emailReq.setTableDetails(emailTableDetails);
        }
        else if(reqPage.equalsIgnoreCase("vacation")){
            
            ArrayList<EmailTableDetailsPojo> emailTableDetails = new ArrayList<EmailTableDetailsPojo>();    
            EmailTableDetailsPojo tableDetail = new EmailTableDetailsPojo(); 
            ArrayList<String> tableContentCols = new ArrayList<String>();
            LinkedHashMap<String, String> tableColumnDatatypes = null;
            
            tableContentCols.add("Leave");
            tableContentCols.add("Comments");
            
            tableDetail.setTableContentColumns(tableContentCols);


            tableDetail.setDetailsQuery("select LEAVE,MISSIONS from XXHCM_OVERTIME_DETAILS_ALL where REQ_ID=" +
                                     emailReq.getRequestId());

            tableColumnDatatypes = new LinkedHashMap<String, String>();
            tableColumnDatatypes.put("LEAVE", "STRING");
            tableColumnDatatypes.put("MISSIONS", "STRING");
            tableDetail.setTableColumnDatatypes(tableColumnDatatypes);
            
            emailTableDetails.add(tableDetail);
            emailReq.setTableDetails(emailTableDetails);
        }
        else if(reqPage.equalsIgnoreCase("house")){
            
            ArrayList<EmailTableDetailsPojo> emailTableDetails = new ArrayList<EmailTableDetailsPojo>();    
            EmailTableDetailsPojo tableDetail = new EmailTableDetailsPojo(); 
            ArrayList<String> tableContentCols = new ArrayList<String>();
            LinkedHashMap<String, String> tableColumnDatatypes = null;
            
            tableContentCols.add("Advance Amount");
            tableContentCols.add("Comments");
            
            tableDetail.setTableContentColumns(tableContentCols);


            tableDetail.setDetailsQuery("select ADV_AMT,COMMENTS from XXHCM_OVERTIME_DETAILS_ALL where REQ_ID=" +
                                     emailReq.getRequestId());

            tableColumnDatatypes = new LinkedHashMap<String, String>();
            tableColumnDatatypes.put("ADV_AMT", "STRING");
            tableColumnDatatypes.put("COMMENTS", "STRING");
            tableDetail.setTableColumnDatatypes(tableColumnDatatypes);
            
            emailTableDetails.add(tableDetail);
            emailReq.setTableDetails(emailTableDetails);
        }
        LinkedHashMap<String, String> actionButtons = new LinkedHashMap<String, String>();
        actionButtons.put("More Info", "");
        emailReq.setActionButtons(actionButtons);
        
        Map<String, Object> emailHapmap =
            GenerateEmailTemplate.prepareEmailTemplate(emailReq, getDBTransaction());

        //Code for Sending email
        GenerateEmailTemplate.sendFromGMail(emailReq.getToEmail(), emailHapmap.get("subject")+"", emailHapmap.get("body")+"", (ArrayList) emailHapmap.get("bodyParts"));
    }
    
    private String getStringBasedOnReqType(String reqType){
        String reqty = null;
        if(reqType.equalsIgnoreCase("ot"))
            return "Over Time";       
        if(reqType.equalsIgnoreCase("salary"))
            return "Salary In Advance";
        if(reqType.equalsIgnoreCase("BusinessTrip"))
            return "Business Trip";
        if(reqType.equalsIgnoreCase("BusinessTripCompletion"))
            return "Business Trip Completion";
        if(reqType.equalsIgnoreCase("edu"))
            return "Education Allowance";
        if(reqType.equalsIgnoreCase("letter"))
            return "HR Letter";
        if(reqType.equalsIgnoreCase("vacation"))
            return "Vacation Allowance";
        if(reqType.equalsIgnoreCase("house"))
            return "Housing Advance";
        
        //house
        
        return reqty;
    }

    /**
     * Container's getter for FetchEmailActionLinkVO1.
     * @return FetchEmailActionLinkVO1
     */
    public FetchEmailActionLinkVOImpl getFetchEmailActionLinkVO1() {
        return (FetchEmailActionLinkVOImpl) findViewObject("FetchEmailActionLinkVO1");
    }

    /**
     * Container's getter for FetchReqDtlsForPayrollMail1.
     * @return FetchReqDtlsForPayrollMail1
     */
    public FetchReqDtlsForPayrollMailImpl getFetchReqDtlsForPayrollMail1() {
        return (FetchReqDtlsForPayrollMailImpl) findViewObject("FetchReqDtlsForPayrollMail1");
    }
}
