package SalicView.backing;

import java.sql.SQLException;

import java.text.ParseException;

import SalicView.backing.Utils.ADFUtils;
import SalicView.backing.Utils.DBUtils;
import SalicView.backing.Utils.GeneralUtils;
import SalicView.backing.Utils.JSFUtils;

import java.math.BigDecimal;

import java.sql.SQLException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import java.util.Locale;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.OperationBinding;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandMenuItem;
import oracle.adf.view.rich.component.rich.nav.RichTrain;
import oracle.adf.view.rich.component.rich.nav.RichTrainButtonBar;

import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.ItemEvent;

import oracle.adf.view.rich.event.ReturnPopupEvent;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;


import oracle.jbo.domain.Number;
import oracle.jbo.server.ApplicationModuleImpl;

import oracle.jdbc.OracleTypes;

import org.apache.myfaces.trinidad.component.UIXGroup;

import oracle.jbo.domain.BlobDomain;

import org.apache.commons.io.IOUtils;
import org.apache.myfaces.trinidad.model.UploadedFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.text.ParseException;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.adf.view.rich.event.LaunchPopupEvent;

import oracle.adf.view.rich.util.ResetUtils;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;

import oracle.jbo.ViewCriteriaManager;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

import view.session.LoginBean;


public class Employee {

    private String displayReqStatus;
    private RichInputListOfValues employeeNameTRANSId;
    private UIXGroup g1;
    private RichInputText it1;
    private RichTrainButtonBar tbb1;
    private RichTrain t1;
    private RichPopup p1;
    private RichInputDate id3;
    private RichInputText it6;
    private RichCommandButton appMenu;
    private RichTable dtlTable;
    private Date minDate = new Date();
    private Date minOtDate = new Date();
    private RichOutputText ot10;
    private RichTable attTable;
    private RichInputDate salStDt;
    private RichSelectOneChoice soc2;
    private RichSelectOneChoice leaveLOV;
    private RichInputListOfValues empLov;
    private RichPanelFormLayout eduForm;
    private RichPanelCollection eduTable;
    private RichPanelBox eduPanel;
    private RichSelectOneChoice semSOC;
    private RichInputListOfValues childTRANS;
    private RichInputText maxAmt;
    private RichInputText avlAmt;
    private RichInputText noOfDays;
    private RichInputText totPerdiem;
    private RichInputDate id1;
    private RichSelectOneChoice destCategoryLOV;
    private RichInputDate bstStDt;
    private RichInputDate bstEdDt;
    private RichSelectOneChoice bstDestCateLOV;
    private RichInputText bstNoOfDays;
    private RichSelectOneChoice btAirtickTyp;
    private RichSelectOneChoice bussTravelReqNo;
    private RichInputListOfValues leaveLov;
    private RichInputListOfValues bussTrReq1;
    private RichInputText prDM;
    private RichSelectOneChoice btDestCountryCity;
    private RichSelectOneChoice bstDestCount;
    private RichSelectOneChoice bstCountryLOV;
    private RichSelectOneChoice destCountryLOV;
    private BigDecimal countryValue;
    private RichPopup approve;
    private RichPopup reject;

    private RichPopup cancel;
    private RichPopup reqmore;
    private RichPopup withdraw;

    private RichOutputText totalAmount;
    
    private Boolean approveReject;
    private RichTable purposeOfTrvTable;
    private RichTable purposeOfTravelBtcTable;
    private String btUsed;
    private Boolean enableReqEdit;

    public void setEmployeeNameTRANSId(RichInputListOfValues employeeNameTRANSId) {
        this.employeeNameTRANSId = employeeNameTRANSId;
    }

    public RichInputListOfValues getEmployeeNameTRANSId() {
        return employeeNameTRANSId;
    }

    public void setG1(UIXGroup g1) {
        this.g1 = g1;
    }

    public UIXGroup getG1() {
        return g1;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setTbb1(RichTrainButtonBar tbb1) {
        this.tbb1 = tbb1;
    }

    public RichTrainButtonBar getTbb1() {
        return tbb1;
    }

    public void setT1(RichTrain t1) {
        this.t1 = t1;
    }

    public RichTrain getT1() {
        return t1;
    }

    public void saveAndCloseACL(ActionEvent actionEvent) {
        //        ViewObject otHdrVO =
        //            ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
        //        otHdrVO.getCurrentRow().setAttribute("Status", "Draft");
        //        otHdrVO.getCurrentRow().setAttribute("ApprovalTemplateId", new BigDecimal(1));
        //        ADFUtils.findOperation("Commit").execute();
        //        JSFUtils.addFacesInformationMessage("Information Saved Successfully");

        //        ViewCriteria vc=variationSearchVo.createViewCriteria();
        //        ViewCriteriaRow vcr=vc.createViewCriteriaRow();
        //        vcr.setAttribute("RequestNumber", "");
        //        vc.addRow(vcr);
        //        variationSearchVo.applyViewCriteria(vc);
        //        variationSearchVo.executeQuery();
        //            approve_hierachy(otHdrVO.getCurrentRow().getAttribute("ReqId"), "H",otHdrVO.getCurrentRow().getAttribute("RequestNumber"));


    }
    Object dobProcArgs;

    public void approve_hierachy(Object header_id, String type,
                                 Object req_num) {
        String flag = "sam";
        ApplicationModuleImpl am =
            (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(null);
        dobProcArgs =
                new Object[][] { { "IN", header_id, OracleTypes.NUMBER }, //0
                    { "IN", type, OracleTypes.VARCHAR }, //1
                    { "IN", flag, OracleTypes.VARCHAR }, //2
                    { "IN", "OT", OracleTypes.VARCHAR }, //3
                    { "IN", req_num, OracleTypes.VARCHAR } //4
                    } ;
        try {
            //            System.err.println("==11====");
            DBUtils.callDBStoredProcedure(am.getDBTransaction(),
                                          "call xxfocus_boq_apprv_prc(?,?,?,?,?)",
                                          (Object[][])dobProcArgs);
            //            System.err.println("==22====");
        } catch (SQLException e) {
            System.err.println("===EXE==" + e.toString());
        }
        //        System.err.println("===SEND==" + flag);

    }

    public void onCloseBGPopup(ActionEvent actionEvent) {
        p1.cancel();
    }

    public void sameDateVCL(ValueChangeEvent date) {
        ViewObject dtlsVo =
            ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject();
        if (date.getNewValue() != null) {
            oracle.jbo.domain.Date otDate =
                (oracle.jbo.domain.Date)date.getNewValue();
            ViewObject variationSearchVo =
                ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO1Iterator").getViewObject();
            ViewCriteria vc = variationSearchVo.createViewCriteria();
            ViewCriteriaRow vcr = vc.createViewCriteriaRow();
            vcr.setAttribute("OvertimeDate", date.getNewValue());
            vc.addRow(vcr);
            variationSearchVo.applyViewCriteria(vc);
            variationSearchVo.executeQuery();
            if (variationSearchVo.getEstimatedRowCount() > 0) {
                //                        variationSearchVo.getCurrentRow().setAttribute("OvertimeDate", null);
                id3.setValue(null);
                AdfFacesContext.getCurrentInstance().addPartialTarget(id3);
                JSFUtils.addFacesInformationMessage("Over Time Date cannot be Repeated");
            }
        }
    }

    public void saveACL(ActionEvent actionEvent) {
        BigDecimal totHours = new BigDecimal(0);
        BigDecimal currentPageHours = new BigDecimal(0);
        ViewObject otHdrVO =
            ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();

        //        otHdrVO.getCurrentRow().setAttribute("ApprovalTemplateId", new BigDecimal(1));
        ViewObject lineVO =
            ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject();
        if ("ot".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {

            //        System.err.println("d------>  "+otHdrVO.getCurrentRow().getAttribute("EmpId"));
            try {
                totHours =
                        validateHours(otHdrVO.getCurrentRow().getAttribute("EmpId"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            BigDecimal linBigHours = new BigDecimal(0);
            Number lineHourss = new Number(0);
            RowSetIterator lineRS = lineVO.createRowSetIterator(null);
            while (lineRS.hasNext()) {
                Row cuLine = lineRS.next();
                lineHourss = (Number)cuLine.getAttribute("OvertimeHours");
                linBigHours = lineHourss.bigDecimalValue();
                currentPageHours = currentPageHours.add(linBigHours);
            }
            currentPageHours = currentPageHours.add(totHours);
            BigDecimal fixedHours = new BigDecimal(40);
            if (totHours.compareTo(fixedHours) == 0) {
                JSFUtils.addFacesInformationMessage("Total OT Hours in this Month Exceeded!");
            } else if (totHours.compareTo(fixedHours) == 1) {
                JSFUtils.addFacesInformationMessage("Total OT Hours in this Month Exceeded!");
            } else {
                if (lineVO.first() != null) {
                    otHdrVO.getCurrentRow().setAttribute("Status", "Draft");
                    otHdrVO.getCurrentRow().setAttribute("ReqType", "ot");
                    ADFUtils.findOperation("Commit").execute();
                    JSFUtils.addFacesInformationMessage("Information Saved Successfully");
                } else {
                    JSFUtils.addFacesInformationMessage("Please provide Over Time Details!..");

                }
            }
        } 
        else if ("house".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            //            ViewObject otHdrVO =
            //                        ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
            ViewObject probCheckVO =
                ADFUtils.findIterator("hireROVO1Iterator").getViewObject();
            ViewObject ethnicVO =
                ADFUtils.findIterator("ethnicROVO1Iterator").getViewObject();
            ethnicVO.setNamedWhereClauseParam("pers",
                                              otHdrVO.getCurrentRow().getAttribute("EmpId"));
            ethnicVO.executeQuery();

            if (ethnicVO.first() != null) {
                if (ethnicVO.first().getAttribute("Ethnic").equals("SALIC01")) {
                    probCheckVO.setNamedWhereClauseParam("per",
                                                         otHdrVO.getCurrentRow().getAttribute("EmpId"));
                    probCheckVO.executeQuery();
                    if (probCheckVO.first() != null) {
                        BigDecimal prob =
                            (BigDecimal)probCheckVO.first().getAttribute("Days"); //Days
                        if (prob.compareTo(new BigDecimal(367)) == -1) {
                            JSFUtils.addFacesInformationMessage("One Year of Employment should be completed!");

                        } else {
                            //                            ViewObject lineVO =
                            //                                ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject();//EmpId XxhcmOvertimeHeadersAllVO1Iterator1 XxhcmOvertimeDetailsAllVO2Iterator1
                            if (lineVO.first() != null) {

                                otHdrVO.getCurrentRow().setAttribute("Status",
                                                                     "Draft");
                                otHdrVO.getCurrentRow().setAttribute("ReqType",
                                                                     "house");
                                ADFUtils.findOperation("Commit").execute();
                                JSFUtils.addFacesInformationMessage("Information Saved Successfully");

                            } else {
                                JSFUtils.addFacesInformationMessage("Please provide Housing in Advance Details!..");

                            }
                        }

                    }
                } else {
                    probCheckVO.setNamedWhereClauseParam("per",
                                                         otHdrVO.getCurrentRow().getAttribute("EmpId"));
                    probCheckVO.executeQuery();
                    if (probCheckVO.first() != null) {
                        BigDecimal prob =
                            (BigDecimal)probCheckVO.first().getAttribute("Days"); //Days
                        if (prob.compareTo(new BigDecimal(14)) == -1) {
                            JSFUtils.addFacesInformationMessage("you can raise the Request only after 2 weeks of Data of Joining!");

                        } else {
                            //                            ViewObject lineVO =
                            //                                ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject();//EmpId XxhcmOvertimeHeadersAllVO1Iterator1 XxhcmOvertimeDetailsAllVO2Iterator1
                            if (lineVO.first() != null) {


                                otHdrVO.getCurrentRow().setAttribute("Status",
                                                                     "Draft");
                                otHdrVO.getCurrentRow().setAttribute("ReqType",
                                                                     "house");
                                ADFUtils.findOperation("Commit").execute();
                                JSFUtils.addFacesInformationMessage("Information Saved Successfully");

                            } else {
                                JSFUtils.addFacesInformationMessage("Please provide Housing in Advance Details!..");
                                //                                returnActivity=null;
                            }
                        }

                    }
                }
            } else {
                JSFUtils.addFacesInformationMessage("There is no Nationality Details!..");
            }


        } 
        else if ("vacation".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            ViewObject hdr1 =
                ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator2").getViewObject();
            ViewCriteria vc = hdr1.createViewCriteria();
            ViewCriteriaRow vcr = vc.createViewCriteriaRow();
            vcr.setAttribute("EmpId",
                             otHdrVO.getCurrentRow().getAttribute("EmpId"));
            vcr.setAttribute("ReqType", "vacation");
            
            vc.addRow(vcr);
            hdr1.applyViewCriteria(vc);
            hdr1.executeQuery();
            if (hdr1.first() != null) {
                AdfFacesContext.getCurrentInstance().addPartialTarget(empLov);
                JSFUtils.addFacesInformationMessage("Already you have Raised Vacation Allowance for this Year!");
            } else {

                if (lineVO.first() != null) {
                    otHdrVO.getCurrentRow().setAttribute("Status", "Draft");
                    otHdrVO.getCurrentRow().setAttribute("ReqType",
                                                         "vacation");
                    ADFUtils.findOperation("Commit").execute();
                    JSFUtils.addFacesInformationMessage("Information Saved Successfully");
                } else {
                    JSFUtils.addFacesInformationMessage("Please provide Vacation Allowance Details!..");

                }
            }

        } 
        else if ("salary".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            ViewObject probCheckVO =
                ADFUtils.findIterator("hireROVO1Iterator").getViewObject();
            probCheckVO.setNamedWhereClauseParam("per",
                                                 otHdrVO.getCurrentRow().getAttribute("EmpId"));
            probCheckVO.executeQuery();
            if (probCheckVO.first() != null) {
                BigDecimal prob =
                    (BigDecimal)probCheckVO.first().getAttribute("Days"); //Days
                if (prob.compareTo(new BigDecimal(90)) == -1) {
                    JSFUtils.addFacesInformationMessage("Probation is not completed!");

                } else {
                    if ("edit".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("mode"))) {
                        ADFUtils.findOperation("Commit").execute();
                        //                returnActivity= "save";
                        JSFUtils.addFacesInformationMessage("Information Saved Successfully");
                    } else {
                        if (lineVO.first() != null) {
                            //            otHdrVO.getCurrentRow().setAttribute("Status", "Draft");
                            //                otHdrVO.getCurrentRow().setAttribute("ReqType", "salary");

                            if (otHdrVO.getCurrentRow().getAttribute("Status") !=
                                "Draft") {
                                otHdrVO.getCurrentRow().setAttribute("Status",
                                                                     "Draft");
                                otHdrVO.getCurrentRow().setAttribute("ReqType",
                                                                     "salary");
                            }

                            ViewObject hdr1 =
                                ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator2").getViewObject();
                            ViewCriteria vc = hdr1.createViewCriteria();
                            ViewCriteriaRow vcr = vc.createViewCriteriaRow();
                            vcr.setAttribute("EmpId",
                                             otHdrVO.getCurrentRow().getAttribute("EmpId"));
                            vcr.setAttribute("Attribute1",
                                             lineVO.getCurrentRow().getAttribute("SalPeriod"));
                            vc.addRow(vcr);
                            hdr1.applyViewCriteria(vc);
                            hdr1.executeQuery();
                            if (hdr1.first() != null) {
                                JSFUtils.addFacesInformationMessage("Already you have Raised Salary in Advance for this Month!..");
                                lineVO.getCurrentRow().setAttribute("SalPeriod",
                                                                    "");
                                AdfFacesContext.getCurrentInstance().addPartialTarget(soc2);
                                //                                returnActivity=null;
                            } else {
                                ADFUtils.findOperation("Commit").execute();
                                AdfFacesContext.getCurrentInstance().addPartialTarget(ot10);
                                //                                returnActivity= "save";
                                JSFUtils.addFacesInformationMessage("Information Saved Successfully");
                            }


                            //            ADFUtils.findOperation("Commit").execute();
                            //            JSFUtils.addFacesInformationMessage("Information Saved Successfully");
                        } else {
                            JSFUtils.addFacesInformationMessage("Please provide Salary in Advance Details!..");

                        }
                    }
                }


            }

        }
        else if ("edu".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            ViewObject attVo =
                ADFUtils.findIterator("XxhcmMasterAttachment_VO2Iterator").getViewObject();
            ViewObject lineCurrVO =
                ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator1").getViewObject();
            BigDecimal empId = ((oracle.jbo.domain.Number)otHdrVO.getCurrentRow().getAttribute("EmpId")).getBigDecimalValue();
            Boolean isValid = validateForMaxThreeChilds(empId,
                                          (java.sql.Date) lineCurrVO.getCurrentRow().getAttribute("InvDate"),
                                                        (BigDecimal) lineCurrVO.getCurrentRow().getAttribute("Contactpersonid"));
            if(isValid == null || !isValid){
                JSFUtils.addFacesErrorMessage("Claim is allowed only for a maximum of three childs per year.");
                return;
            }
            
            isValid = isValidTotalAmountForChild();
            if(isValid == null || !isValid){
                return;
            }
            
            if (attVo.first() != null) {
                if (lineVO.first() != null) {
                    otHdrVO.getCurrentRow().setAttribute("Status", "Draft");
                    otHdrVO.getCurrentRow().setAttribute("ReqType", "edu");
                    ADFUtils.findOperation("Commit").execute();
                    JSFUtils.addFacesInformationMessage("Information Saved Successfully");
                } else {
                    JSFUtils.addFacesInformationMessage("Please provide Education Allowance Details!..");
                }
            } else {
                JSFUtils.addFacesInformationMessage("Attachment is Mandatory!");
            }

        } else if ("letter".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            if (lineVO.first() != null) {
                otHdrVO.getCurrentRow().setAttribute("Status", "Draft");
                otHdrVO.getCurrentRow().setAttribute("ReqType", "letter");
                ADFUtils.findOperation("Commit").execute();
                JSFUtils.addFacesInformationMessage("Information Saved Successfully");
            } else {
                JSFUtils.addFacesInformationMessage("Please provide HR Letter Details!..");

            }

        }

        else if ("BusinessTrip".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            if (lineVO.first() != null) {
                otHdrVO.getCurrentRow().setAttribute("Status", "Draft");
                otHdrVO.getCurrentRow().setAttribute("ReqType",
                                                     "BusinessTrip");
                if ("add".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("mode"))) {
                    lineVO.getCurrentRow().setAttribute("OrigStartDate",
                                                        lineVO.getCurrentRow().getAttribute("StartDate"));
                    lineVO.getCurrentRow().setAttribute("OrigEndDate",
                                                        lineVO.getCurrentRow().getAttribute("EndDate"));

                }
                System.err.println("------AirType" +
                                   this.btAirtickTyp.getValue());
                System.err.println("------CityCountry" +
                                   this.btDestCountryCity.getValue());
                
                System.err.println("------Country" +
                                   this.destCountryLOV.getValue());
                
                System.err.println("------Country" +countryValue);

                lineVO.getCurrentRow().setAttribute("AirlineTicketType",
                                                    ADFContext.getCurrent().getPageFlowScope().get("airTicket"));
                lineVO.getCurrentRow().setAttribute("DestinationCountry",countryValue);
                lineVO.getCurrentRow().setAttribute("DestCountryCity",
                                                    ADFContext.getCurrent().getPageFlowScope().get("DestCount"));
                
                

                System.err.println("------BS");


                ViewObject ovo =
                    ADFUtils.findIterator("OnValidateStartDateEndDateROVO1Iterator").getViewObject();
                ViewCriteriaManager vcm = ovo.getViewCriteriaManager();
                ViewCriteria vc = vcm.getViewCriteria("ValidateEmpDates");
                ovo.applyViewCriteria(vc);
                System.err.println("----emp" +
                                   otHdrVO.getCurrentRow().getAttribute("EmpId"));
                System.err.println("----SD" +
                                   lineVO.getCurrentRow().getAttribute("StartDate"));
                System.err.println("----ED" +
                                   lineVO.getCurrentRow().getAttribute("EndDate"));

                String strDate =
                    lineVO.getCurrentRow().getAttribute("StartDate").toString();
                String endDate =
                    lineVO.getCurrentRow().getAttribute("EndDate").toString();
                SimpleDateFormat sdfSource = new SimpleDateFormat("dd-MM-yy");

                Date date1 = null;
                Date date2 = null;

                try {
                    date2 = sdfSource.parse(endDate);
                    date1 = sdfSource.parse(strDate);

                    System.err.println("----SDD" + date1);
                    System.err.println("----EDD" + date2);

                } catch (ParseException e) {
                }
                ovo.setNamedWhereClauseParam("P_EMP",
                                             otHdrVO.getCurrentRow().getAttribute("EmpId"));
                ovo.setNamedWhereClauseParam("P_STARTDATE", date1);
                ovo.setNamedWhereClauseParam("P_ENDDATE", date2);
                ovo.executeQuery();
                System.err.println("-----Count" + ovo.getEstimatedRowCount());
                if (ovo.getEstimatedRowCount() > 0) {
                    JSFUtils.addFacesInformationMessage("Already this Resource had booked in these dates, please provide different Dates");
                } else {
                    ADFUtils.findOperation("Commit").execute();
                    //returnActivity = "save";
                    JSFUtils.addFacesInformationMessage("Information Saved Successfully");
                }
            } else {
                JSFUtils.addFacesInformationMessage("Please provide Business Trip Details!..");

            }

        }

        else if ("BusinessTripCompletion".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            if (lineVO.first() != null) {
                otHdrVO.getCurrentRow().setAttribute("Status", "Draft");
                otHdrVO.getCurrentRow().setAttribute("ReqType",
                                                     "BusinessTripCompletion");
                
//                lineVO.getCurrentRow().setAttribute("StartDate",
//                                                    this.bstStDt.getValue());
//                lineVO.getCurrentRow().setAttribute("EndDate",
//                                                    this.bstEdDt.getValue());
                lineVO.getCurrentRow().setAttribute("DestCategory",
                                                    this.bstDestCateLOV.getValue());
                lineVO.getCurrentRow().setAttribute("DestinationCountry", countryValue);

                System.err.println("HELLOOOO--" +
                                   ADFContext.getCurrent().getPageFlowScope().get("bussTripReqNo"));
                lineVO.getCurrentRow().setAttribute("BussTravReqNum",
                                                    ADFContext.getCurrent().getPageFlowScope().get("bussTripReqNo"));


                System.err.println("NOFDAYS" + this.bstNoOfDays.getValue());
                lineVO.getCurrentRow().setAttribute("NumberOfDays",
                                                    new BigDecimal(this.bstNoOfDays.getValue() ==
                                                                   null ? "0" :
                                                                   this.bstNoOfDays.getValue().toString()));

                lineVO.getCurrentRow().setAttribute("DestCountryCity",
                                                    this.bstDestCount.getValue());

                ADFUtils.findOperation("Commit").execute();
                JSFUtils.addFacesInformationMessage("Information Saved Successfully");
            } else {
                JSFUtils.addFacesInformationMessage("Please provide Business Trip Completion Details!..");

            }

        }
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void setId3(RichInputDate id3) {
        this.id3 = id3;
    }

    public RichInputDate getId3() {
        return id3;
    }

    public void calcHoursVCL(ValueChangeEvent vce) {
//        if (vce.getNewValue() != null) {
//            
//            Number otHours = (Number)vce.getNewValue();
//            Row row = ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getCurrentRow();
//            String overtype = (String)row.getAttribute("OvertimeType");
//            if(overtype.equalsIgnoreCase("OT_WD") && otHours.intValue() > 16  || otHours.intValue() <= 0){
//                JSFUtils.addFacesErrorMessage(vce.getComponent().getClientId(FacesContext.getCurrentInstance()), "Invalid over time hours. Enter hours between 1 to 16");                
//                return;
//            }
//            if(overtype.equalsIgnoreCase("OT_WE") && (otHours.intValue() > 24 || otHours.intValue() <= 0)){
//                JSFUtils.addFacesErrorMessage(vce.getComponent().getClientId(FacesContext.getCurrentInstance()), "Invalid over time hours. Enter hours between 1 to 16");                
//                return;
//            }
//            Number calcHours = otHours.multiply(1.5);
//            it6.setValue(calcHours);
//            AdfFacesContext.getCurrentInstance().addPartialTarget(it6);
//        }
    }

    public void setIt6(RichInputText it6) {
        this.it6 = it6;
    }

    public RichInputText getIt6() {
        return it6;
    }
    public void onPopupLaunchBr(LaunchPopupEvent launchPopupEvent) {
      BindingContext bctx = BindingContext.getCurrent();
      BindingContainer bindings = bctx.getCurrentBindingsEntry();
      JUCtrlListBinding lov = 
           (JUCtrlListBinding)bindings.get("BussTravReqNumValue");
      lov.getListIterBinding().getViewObject().setNamedWhereClauseParam("bind_empid", ADFContext.getCurrent().getSessionScope().get("empfil"));
        lov.getListIterBinding().getViewObject().executeQuery();
    }

    public void onPopupLaunch(LaunchPopupEvent launchPopupEvent) {
      BindingContext bctx = BindingContext.getCurrent();
      BindingContainer bindings = bctx.getCurrentBindingsEntry();
      JUCtrlListBinding lov = 
           (JUCtrlListBinding)bindings.get("Leave");
      lov.getListIterBinding().getViewObject().setNamedWhereClauseParam("BV_PER_ID", ADFContext.getCurrent().getSessionScope().get("empfilv"));
    }
    
    public void generateReqNumVCL(ValueChangeEvent valueChangeEvent) {

        ViewObject variationSearchVo =
            ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
        ViewObject line =
            ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator1").getViewObject();
        ViewObject lineVO =
            ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject();
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if ("house".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            //valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            
            //validateEmpHousingAdvEligibility
            String errorMsg = validateEmpHousingAdvEligibility((oracle.jbo.domain.Number)variationSearchVo.getCurrentRow().getAttribute("EmpId"));
            if(errorMsg!=null){
                empLov.setSubmittedValue(valueChangeEvent.getNewValue());
                empLov.setValid(false);
                addMessageToComponent(errorMsg);
                AdfFacesContext.getCurrentInstance().addPartialTarget(empLov);
            }else{
                empLov.setValid(true);
                AdfFacesContext.getCurrentInstance().addPartialTarget(empLov);
                DateFormat dateFormat =
                    new SimpleDateFormat("dd/MM/yyyy'T'kk:mm:ss"); ////2016/11/16
                //        DateFormat time = new SimpleDateFormat("kk:mm:ss");//12:08:43
                Date date = new Date();
                //        System.out.println(dateFormat.format(date));
                //        System.out.println(dateFormat.format(date));
                dateFormat.getTimeInstance().format(date);
                variationSearchVo.getCurrentRow().setAttribute("RequestNumber",
                                                               dateFormat.format(date) +
                                                               "-HA-" +
                                                               variationSearchVo.getCurrentRow().getAttribute("ReqId"));

                ViewObject ethnicVO =
                    ADFUtils.findIterator("salaryROVO1Iterator").getViewObject();
                
                ethnicVO.setNamedWhereClauseParam("sal",
                                                  variationSearchVo.getCurrentRow().getAttribute("EmpId"));
                ethnicVO.executeQuery();
                BigDecimal salary = new BigDecimal(0);
                if (ethnicVO.first() != null) {
                    salary =
                            (BigDecimal)ethnicVO.first().getAttribute("SalaryAmount");

                }
                BigDecimal month = new BigDecimal((String)lineVO.getCurrentRow().getAttribute("Months"));
                lineVO.getCurrentRow().setAttribute("AdvAmt",salary.multiply(month).multiply(new BigDecimal(0.25)));
            }            
            
            //line.executeQuery();


        } else if ("ot".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            //valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            
            String errorMsg = validateEmpOverTimeEligibility((oracle.jbo.domain.Number)variationSearchVo.getCurrentRow().getAttribute("EmpId"));
            if(errorMsg!=null){
                empLov.setValue(valueChangeEvent.getNewValue());
                empLov.setValid(false);
                addMessageToComponent(errorMsg);
                AdfFacesContext.getCurrentInstance().addPartialTarget(empLov);
                
            }else{
                empLov.setValid(true);
                AdfFacesContext.getCurrentInstance().addPartialTarget(empLov);
            }
            DateFormat dateFormat =
                new SimpleDateFormat("dd/MM/yyyy'T'kk:mm:ss"); ////2016/11/16
            //        DateFormat time = new SimpleDateFormat("kk:mm:ss");//12:08:43
            Date date = new Date();
            //        System.out.println(dateFormat.format(date));
            //        System.out.println(dateFormat.format(date));
            dateFormat.getTimeInstance().format(date);
            variationSearchVo.getCurrentRow().setAttribute("RequestNumber",
                                                           dateFormat.format(date) +
                                                           "-OT-" +
                                                           variationSearchVo.getCurrentRow().getAttribute("ReqId"));
        } else if ("vacation".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            //valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            String errorMsg = validateEmpVacationEligibility((oracle.jbo.domain.Number)variationSearchVo.getCurrentRow().getAttribute("EmpId"));
            if(errorMsg!=null){
                empLov.setValue(valueChangeEvent.getNewValue());
                empLov.setValid(false);
                addMessageToComponent(errorMsg);
                AdfFacesContext.getCurrentInstance().addPartialTarget(empLov);
                
            }else{
                empLov.setValid(true);
                AdfFacesContext.getCurrentInstance().addPartialTarget(empLov);
                
                ADFContext.getCurrent().getSessionScope().put("empfilv",
                                                              variationSearchVo.getCurrentRow().getAttribute("EmpId"));
                JUCtrlListBinding listBinding =
                                (JUCtrlListBinding)ADFUtils.getBindingContainer().get("Leave");
                            listBinding.getListIterBinding().executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(leaveLov);
                
                DateFormat dateFormat =
                    new SimpleDateFormat("dd/MM/yyyy'T'kk:mm:ss"); ////2016/11/16
                //        DateFormat time = new SimpleDateFormat("kk:mm:ss");//12:08:43
                Date date = new Date();
                //        System.out.println(dateFormat.format(date));
                //        System.out.println(dateFormat.format(date));
                dateFormat.getTimeInstance().format(date);
                variationSearchVo.getCurrentRow().setAttribute("RequestNumber",
                                                               dateFormat.format(date) +
                                                               "-VC-" +
                                                               variationSearchVo.getCurrentRow().getAttribute("ReqId"));
            }
            
            //                        ViewObject hdr1 =
            //                            ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator2").getViewObject();
            //                        ViewCriteria vc=hdr1.createViewCriteria();
            //                        ViewCriteriaRow vcr=vc.createViewCriteriaRow();
            //                        System.err.println("emp id - - "+ variationSearchVo.getCurrentRow().getAttribute("EmpId"));
            //                        vcr.setAttribute("EmpId",   variationSearchVo.getCurrentRow().getAttribute("EmpId"));
            //                        vcr.setAttribute("ReqType", "vacation");
            //                        vc.addRow(vcr);
            //                        hdr1.applyViewCriteria(vc);
            //                        hdr1.executeQuery();
            //                        if(hdr1.first()!=null){
            //                            empLov.setValue("");
            ////                            variationSearchVo.getCurrentRow().setAttribute("EmpId", "");
            ////                            variationSearchVo.executeQuery();
            //                            AdfFacesContext.getCurrentInstance().addPartialTarget(empLov);
            //                            JSFUtils.addFacesInformationMessage("Already you have Raised Vacation Allowance for this Year!");
            //                        }

        } else if ("salary".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            //valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            String errorMsg = validateEmployeeSalaryAdvanceEligibility((oracle.jbo.domain.Number)variationSearchVo.getCurrentRow().getAttribute("EmpId"));
            if(errorMsg!=null){
                empLov.setValue(valueChangeEvent.getNewValue());
                empLov.setValid(false);
                addMessageToComponent(errorMsg);
                AdfFacesContext.getCurrentInstance().addPartialTarget(empLov);
                
            }else{
                empLov.setValid(true);
                AdfFacesContext.getCurrentInstance().addPartialTarget(empLov);
                
                DateFormat dateFormat =
                    new SimpleDateFormat("dd/MM/yyyy'T'kk:mm:ss"); ////2016/11/16
                //        DateFormat time = new SimpleDateFormat("kk:mm:ss");//12:08:43
                Date date = new Date();
                //        System.out.println(dateFormat.format(date));
                //        System.out.println(dateFormat.format(date));
                dateFormat.getTimeInstance().format(date);
                variationSearchVo.getCurrentRow().setAttribute("RequestNumber",
                                                               dateFormat.format(date) +
                                                               "-SA-" +
                                                               variationSearchVo.getCurrentRow().getAttribute("ReqId"));
            }
            

        } else if ("letter".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {

            DateFormat dateFormat =
                new SimpleDateFormat("dd/MM/yyyy'T'kk:mm:ss"); ////2016/11/16
            //        DateFormat time = new SimpleDateFormat("kk:mm:ss");//12:08:43
            Date date = new Date();
            //        System.out.println(dateFormat.format(date));
            //        System.out.println(dateFormat.format(date));
            dateFormat.getTimeInstance().format(date);
            variationSearchVo.getCurrentRow().setAttribute("RequestNumber",
                                                           dateFormat.format(date) +
                                                           "-HRL-" +
                                                           variationSearchVo.getCurrentRow().getAttribute("ReqId"));

        }

        else if ("BusinessTripCompletion".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            //EmployeeId

               //Object object =
               //valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
                ADFContext.getCurrent().getSessionScope().put("empfil",
                                                              variationSearchVo.getCurrentRow().getAttribute("EmpId"));

                JUCtrlListBinding listBinding =
                                (JUCtrlListBinding)ADFUtils.getBindingContainer().get("BussTravReqNum1");
                            listBinding.getListIterBinding().executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(bussTrReq1);
                
            

            DateFormat dateFormat =
                new SimpleDateFormat("dd/MM/yyyy'T'kk:mm:ss"); ////2016/11/16
            //        DateFormat time = new SimpleDateFormat("kk:mm:ss");//12:08:43
            Date date = new Date();
            //        System.out.println(dateFormat.format(date));
            //        System.out.println(dateFormat.format(date));
            dateFormat.getTimeInstance().format(date);
            variationSearchVo.getCurrentRow().setAttribute("RequestNumber",
                                                           dateFormat.format(date) +
                                                           "-BTC-" +
                                                           variationSearchVo.getCurrentRow().getAttribute("ReqId"));

        }

        else if ("BusinessTrip".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {

            DateFormat dateFormat =
                new SimpleDateFormat("dd/MM/yyyy'T'kk:mm:ss"); ////2016/11/16
            //        DateFormat time = new SimpleDateFormat("kk:mm:ss");//12:08:43
            Date date = new Date();
            //        System.out.println(dateFormat.format(date));
            //        System.out.println(dateFormat.format(date));
            dateFormat.getTimeInstance().format(date);
            variationSearchVo.getCurrentRow().setAttribute("RequestNumber",
                                                           dateFormat.format(date) +
                                                           "-BT-" +
                                                           variationSearchVo.getCurrentRow().getAttribute("ReqId"));

        } else if ("edu".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {

            DateFormat dateFormat =
                new SimpleDateFormat("dd/MM/yyyy'T'kk:mm:ss"); ////2016/11/16
            //        DateFormat time = new SimpleDateFormat("kk:mm:ss");//12:08:43
            Date date = new Date();
            //        System.out.println(dateFormat.format(date));
            //        System.out.println(dateFormat.format(date));
            valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            ADFContext.getCurrent().getSessionScope().put("empfil",
                                                          variationSearchVo.getCurrentRow().getAttribute("EmpId"));

            JUCtrlListBinding listBinding =
                            (JUCtrlListBinding)ADFUtils.getBindingContainer().get("childTRANS");
                        listBinding.getListIterBinding().executeQuery();
            dateFormat.getTimeInstance().format(date);
            variationSearchVo.getCurrentRow().setAttribute("RequestNumber",
                                                           dateFormat.format(date) +
                                                           "-EA-" +
                                                           variationSearchVo.getCurrentRow().getAttribute("ReqId"));
            
            BigDecimal empId = ((oracle.jbo.domain.Number)variationSearchVo.getCurrentRow().getAttribute("EmpId")).getBigDecimalValue();
            BigDecimal maxAmt = fetchMaxAmountForEmployee(empId);
            line.getCurrentRow().setAttribute("MaxAmt", maxAmt);
            line.getCurrentRow().setAttribute("AvlAmt", maxAmt);
        }
        //        variationSearchVo.executeQuery();

        ViewObject attVO =
            ADFUtils.findIterator("XxhcmMasterAttachment_VO2Iterator").getViewObject();
        //lineVO.createRow();


        //lineVO.executeQuery();
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

            lineVO.getCurrentRow().setAttribute("SalPeriod", Month);
            AdfFacesContext.getCurrentInstance().addPartialTarget(soc2);
            //String reqNumber,oracle.jbo.domain.Number empId,String reqType
            //            ViewObject hdr1 =
            //                ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator2").getViewObject();
            //            ViewCriteria vc=hdr1.createViewCriteria();
            //            ViewCriteriaRow vcr=vc.createViewCriteriaRow();
            //            vcr.setAttribute("EmpId",   variationSearchVo.getCurrentRow().getAttribute("EmpId"));
            //            vcr.setAttribute("Attribute1", "like%"+Month+"%");
            //            vc.addRow(vcr);
            //            hdr1.applyViewCriteria(vc);
            //            hdr1.executeQuery();
            //            if(hdr1.first() != null) {
            //                JSFUtils.addFacesInformationMessage("Already you have Raised Salary in Advance for" +
            //                                                    Month + " !..");
            //                lineVO.getCurrentRow().setAttribute("SalPeriod", "");
            //                AdfFacesContext.getCurrentInstance().addPartialTarget(soc2);
            //            }
            //                    ViewObject lineVO1 =
            //                        ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO1Iterator").getViewObject();
            //                    ViewCriteria vcc=lineVO1.createViewCriteria();
            //                                       ViewCriteriaRow vccr=vcc.createViewCriteriaRow();
            //                                       vccr.setAttribute("EmpId",   variationSearchVo.getCurrentRow().getAttribute("EmpId"));
            //                                       vccr.setAttribute("SalPeriod", "like %"+Month+"%");
            //                                       vcc.addRow(vccr);
            //                                       lineVO1.applyViewCriteria(vcc);
            //                                       lineVO1.executeQuery();
            //                                       if(lineVO1.first()!=null){
            //                                           JSFUtils.addFacesInformationMessage("Already you have Raised Salary in Advance for"+Month+" !..");
            //                                           lineVO.getCurrentRow().setAttribute("SalPeriod", "");
            //                                           AdfFacesContext.getCurrentInstance().addPartialTarget(soc2);
            //                                       }
        }
        
        //populateApproversForReqest
        oracle.binding.OperationBinding op = ADFUtils.findOperation("populateApproversForReqest");
        //RequestNumber
        op.getParamsMap().put("reqStatus", "SUBMITTED");
        op.getParamsMap().put("reqNumber", variationSearchVo.getCurrentRow().getAttribute("RequestNumber"));
        op.getParamsMap().put("empId", (oracle.jbo.domain.Number)variationSearchVo.getCurrentRow().getAttribute("EmpId"));
        op.getParamsMap().put("reqType", (String)ADFContext.getCurrent().getSessionScope().get("page"));
        op.getParamsMap().put("req_id", variationSearchVo.getCurrentRow().getAttribute("ReqId"));
        op.execute();
        //        lineVO.executeQuery();
        //        attVO.createRow();
        //        attVO.executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(dtlTable);
        AdfFacesContext.getCurrentInstance().addPartialTarget(attTable);
        //        System.err.println("emp id --> "+variationSearchVo.getCurrentRow().getAttribute("EmpId"));
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
                        facesContext.addMessage(empLov.getClientId(facesContext),fm);
    }
    
    public void addMessageToPage(String errorMsg){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage(errorMsg);
                            fm.setSummary(null);
                            fm.setDetail(errorMsg);
                            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                        facesContext.addMessage(null,fm);
    }
    public String validateEmpOverTimeEligibility(oracle.jbo.domain.Number empId){
        String errorMsg = null;
        ViewObject lineVO1 =
            ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator1").getViewObject();
        BigDecimal totlHrs = new BigDecimal(0);
        java.sql.Date overtimeDate = (java.sql.Date)ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator1").getCurrentRow().getAttribute("OvertimeDate");
        String err = null;
        int month = overtimeDate.getMonth();
        String[] months = {"January", "February",
              "March", "April", "May", "June", "July",
              "August", "September", "October", "November",
              "December"};
              int i = 0; 
              String monthStr = months[month];
              int yearToCheck = 0;
              for(String month1 : months)      {
                  totlHrs = new BigDecimal(0);
                  RowSetIterator rsi = lineVO1.createRowSetIterator("total");
                  java.sql.Date otdate = null;
                  i = i + 1;     
                  System.out.println("Month selected is ==>"+month1);
                  while(rsi.hasNext()){
                      Row row = rsi.next();
                      Calendar calendar = Calendar.getInstance();
                      otdate = (java.sql.Date)row.getAttribute("OvertimeDate");
                      
                      String monthS = getMonthFromSqlDate(otdate);
                      if(month1.equalsIgnoreCase(monthS)){
                      yearToCheck = getYearFromSqlDate(otdate);
                      oracle.jbo.domain.Number hrs = (oracle.jbo.domain.Number)row.getAttribute("OvertimeHours");
                     
                      totlHrs = totlHrs.add(hrs.bigDecimalValue());
                      }
                  }
                  rsi.closeRowSetIterator();
                  if(totlHrs.compareTo(new BigDecimal(0)) == 1){
                  ViewObject countcheckVO =
                      ADFUtils.findIterator("OvertimeHoursForEmpROVO1Iterator").getViewObject();
                  countcheckVO.setNamedWhereClauseParam("bind_empid",empId.bigDecimalValue());
                  //bind_date
                  Calendar c = Calendar.getInstance();    
                  c.set(yearToCheck,i-1,1); //------>
                  c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
                  
                  countcheckVO.setNamedWhereClauseParam("bind_date",new java.sql.Date(c.getTimeInMillis()));
                  countcheckVO.executeQuery();
                  BigDecimal count = (BigDecimal)countcheckVO.first().getAttribute("Totalhrs");
                  totlHrs = totlHrs.add(count!=null ? count : new BigDecimal(0));
                  }
                  if(totlHrs.compareTo(new BigDecimal(40)) == 1){
                      err = "You have exceeded 40 hours in the "+month1+" month. Total Overtime hours booked is : "+totlHrs;
                     break;
                     
                  }
              }
        
        if(err!=null){            
           return err;
        }
        return err;
    }
    
    public String getMonthFromSqlDate(java.sql.Date dates){
        String[] chkmonths = {"January", "February",
              "March", "April", "May", "June", "July",
              "August", "September", "October", "November",
              "December"};
        Calendar calendar = Calendar.getInstance();
        java.sql.Date otdate = dates;
        Date date = calendar.getTime();
        date.setTime(otdate.getTime());
        calendar.setTime(date);
        int monthn = calendar.get(Calendar.MONTH);
        String monthS = chkmonths[monthn];
        return chkmonths[monthn];
    }
    
    
    public int getYearFromSqlDate(java.sql.Date dates){
        
        Calendar calendar = Calendar.getInstance();
        java.sql.Date otdate = dates;
        Date date = calendar.getTime();
        date.setTime(otdate.getTime());
        calendar.setTime(date);
        int yearn = calendar.get(Calendar.YEAR);
        
        return yearn;
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
    
    public void autoApproveRequest(){
        ViewObject otHdrVO =
            ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
        //(oracle.jbo.domain.Number)otHdrVO.getCurrentRow().getAttribute("EmpId")
        oracle.binding.OperationBinding opJobLevel = ADFUtils.findOperation("getJobLevel");
        opJobLevel.getParamsMap().put("empId", (oracle.jbo.domain.Number)otHdrVO.getCurrentRow().getAttribute("EmpId"));
        opJobLevel.execute();
        String res = (String)opJobLevel.getResult();
        if(res == null || (res!=null && !res.equalsIgnoreCase("0"))){
        oracle.binding.OperationBinding opap = ADFUtils.findOperation("updateApproverStatus");
        opap.execute();
        }
        if(res!=null && res.equalsIgnoreCase("0")){
        oracle.binding.OperationBinding op = ADFUtils.findOperation("updateAutoApprove");
        op.getParamsMap().put("empId", (oracle.jbo.domain.Number)otHdrVO.getCurrentRow().getAttribute("EmpId"));
        op.execute();
        }
        //updateAutoApprove
    }
    public String approvalSubmitACL() {
        String returnActivity = null;
        boolean isValidated = true;
        
        ViewObject otHdrVO =
            ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
        ViewObject lineVO =
            ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject();
        if (lineVO.first() != null) {

            otHdrVO.getCurrentRow().setAttribute("ApprovalTemplateId",
                                                 new BigDecimal(1));

                String reqStatus = (String)otHdrVO.getCurrentRow().getAttribute("ReqStatus");
                if(reqStatus.equalsIgnoreCase("New"))      {
                    otHdrVO.getCurrentRow().setAttribute("ReqStatus","SUBMITTED");
                }
            if ("ot".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
                String errorMsg = validateEmpOverTimeEligibility((oracle.jbo.domain.Number)otHdrVO.getCurrentRow().getAttribute("EmpId"));
                if(errorMsg!=null){
                    empLov.setValid(false);
                    addMessageToPage(errorMsg);
                    isValidated = false;
                    AdfFacesContext.getCurrentInstance().addPartialTarget(empLov);                    
                    returnActivity = null;
                }else{
                    empLov.setValid(true);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(empLov);
                    
                    otHdrVO.getCurrentRow().setAttribute("ReqType", "ot");
                    otHdrVO.getCurrentRow().setAttribute("Status",
                                                         "Pending Approval");
                    autoApproveRequest();
                    ADFUtils.findOperation("Commit").execute();
                    JSFUtils.addFacesInformationMessage("Request has been submitted for Approval");
//                    approve_hierachy(otHdrVO.getCurrentRow().getAttribute("ReqId"),
//                                     "H",
//                                     otHdrVO.getCurrentRow().getAttribute("RequestNumber"));
                    appMenu.setDisabled(true);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(appMenu);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(ot10);
                    returnActivity = "save";
                    
                    
                    //code to prepare email template for submitted employee
                    
                }
                
            } 
            else if ("house".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {

                //                    ViewObject otHdrVO =
                //                                ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
                
                String errorMsg = validateEmpHousingAdvEligibility((oracle.jbo.domain.Number)otHdrVO.getCurrentRow().getAttribute("EmpId"));
                if(errorMsg!=null){
                    GeneralUtils gu = new GeneralUtils();
                    empLov.setValid(false);
                    gu.displayMessage(errorMsg, "FATAL");
                    isValidated = false;
                    AdfFacesContext.getCurrentInstance().addPartialTarget(empLov);
                    isValidated = false;
                    returnActivity = null;
                }else{
                    empLov.setValid(true);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(empLov);
                    
                    if (lineVO.first() != null) {
                        otHdrVO.getCurrentRow().setAttribute("ReqType","house");
                        otHdrVO.getCurrentRow().setAttribute("Status","Pending Approval");
                        autoApproveRequest();
                        ADFUtils.findOperation("Commit").execute();
                        JSFUtils.addFacesInformationMessage("Request has been submitted for Approval");
//                        approve_hierachy(otHdrVO.getCurrentRow().getAttribute("ReqId"),
//                                         "H",otHdrVO.getCurrentRow().getAttribute("RequestNumber"));
                        appMenu.setDisabled(true);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(appMenu);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(ot10);
                        returnActivity = "save";
                    } else {
                        JSFUtils.addFacesInformationMessage("Please provide Housing in Advance Details!..");
                        isValidated = false;
                        returnActivity = null;
                    }
                    
                }

            }
            else if ("vacation".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
                String errorMsg = validateEmpVacationEligibility((oracle.jbo.domain.Number)otHdrVO.getCurrentRow().getAttribute("EmpId"));
                if(errorMsg!=null){
                    GeneralUtils gu = new GeneralUtils();
                    empLov.setValid(false);
                    gu.displayMessage(errorMsg, "FATAL");
                    isValidated = false;
                    AdfFacesContext.getCurrentInstance().addPartialTarget(empLov);
                    returnActivity = null;
                }else{
                    empLov.setValid(true);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(empLov);
                    otHdrVO.getCurrentRow().setAttribute("ReqType",
                                                         "vacation");
                    otHdrVO.getCurrentRow().setAttribute("Status",
                                                         "Pending Approval");
                    autoApproveRequest();
                    ADFUtils.findOperation("Commit").execute();
                    JSFUtils.addFacesInformationMessage("Request has been submitted for Approval");
//                    approve_hierachy(otHdrVO.getCurrentRow().getAttribute("ReqId"),"H",
//                                     otHdrVO.getCurrentRow().getAttribute("RequestNumber"));
                    appMenu.setDisabled(true);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(appMenu);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(ot10);
                    returnActivity = "save";
                }
//                ViewObject hdr2 =
//                    ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator2").getViewObject();
//                ViewCriteria vcc = hdr2.createViewCriteria();
//                ViewCriteriaRow vccr = vcc.createViewCriteriaRow();
//                vccr.setAttribute("EmpId",
//                                  otHdrVO.getCurrentRow().getAttribute("EmpId"));
//                vccr.setAttribute("ReqType", "vacation");
//                vcc.addRow(vccr);
//                hdr2.applyViewCriteria(vcc);
//                hdr2.executeQuery();
//                if (hdr2.first() != null) {
//                    empLov.setValue("");
//                    AdfFacesContext.getCurrentInstance().addPartialTarget(empLov);
//                    JSFUtils.addFacesInformationMessage("Already you have Raised Vacation Allowance for this Year!");
//                    returnActivity = null;
//                } else {
//                    
//                }
            } 
            else if ("edu".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {

                Boolean isValid = validateEducationAllowance();
                if(!isValid){
                    isValidated = false;
                    returnActivity = null;
                }else{
                    lineVO =
                        ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator1").getViewObject();
                    
//                    RowSetIterator rs = lineVO.createRowSetIterator(null);
//                    while(rs.hasNext()){
//                        Row row = rs.next();
//                        BigDecimal invTotal = (BigDecimal)row.getAttribute("InvTotal");
//                        BigDecimal avlAmt = (BigDecimal)row.getAttribute("AvlAmt");
//                        if(invTotal.compareTo(avlAmt) == -1){
//                            row.setAttribute("ActAmt", invTotal);
//                        }
//                        else if(invTotal.compareTo(avlAmt) == 1){
//                            row.setAttribute("ActAmt", avlAmt);
//                        }
//                        else{
//                            row.setAttribute("ActAmt", invTotal);
//                        }
//                    }
                    
                    isValid = isValidTotalAmountForChild();
                    if(!isValid){
                        isValidated = false;
                        returnActivity = null;
                    }
                    else{
                        ViewObject attVo =
                            ADFUtils.findIterator("XxhcmMasterAttachment_VO2Iterator").getViewObject();
                        if (attVo.first() != null) {
                            otHdrVO.getCurrentRow().setAttribute("ReqType", "edu");
                            otHdrVO.getCurrentRow().setAttribute("Status",
                                                                 "Pending Approval");
                            autoApproveRequest();
                            ADFUtils.findOperation("Commit").execute();
                            JSFUtils.addFacesInformationMessage("Request has been submitted for Approval");
    
                            appMenu.setDisabled(true);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(appMenu);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(ot10);
                            returnActivity = "save";
                        } else {
                            JSFUtils.addFacesInformationMessage("Attachment is Mandatory!");
                            isValidated = false;
                            returnActivity = null;
                        } 
                    }
                }
                


            } else if ("salary".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
                //                        ViewObject otHdrVO =
                //                                    ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
                otHdrVO.getCurrentRow().setAttribute("ReqType", "salary");

                if ("edit".equalsIgnoreCase((String) ADFContext.getCurrent()
                                                               .getSessionScope()
                                                               .get("mode"))) {
                    otHdrVO.getCurrentRow().setAttribute("Status", "Pending Approval");
                    
                    ADFUtils.findOperation("Commit").execute();
                    JSFUtils.addFacesInformationMessage("Request has been submitted for Approval");
//                    approve_hierachy(otHdrVO.getCurrentRow().getAttribute("ReqId"), "H",
//                                     otHdrVO.getCurrentRow().getAttribute("RequestNumber"));
                    appMenu.setDisabled(true);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(appMenu);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(ot10);
                    returnActivity = "save";
                } else {
                    String errorMsg = validateEmployeeSalaryAdvanceEligibility((oracle.jbo.domain.Number) otHdrVO.getCurrentRow().getAttribute("EmpId"));
                    if (errorMsg != null) {
                        GeneralUtils gu = new GeneralUtils();
                        empLov.setValid(false);
                        gu.displayMessage(errorMsg, "FATAL");
                        isValidated = false;
                        AdfFacesContext.getCurrentInstance().addPartialTarget(empLov);
                        returnActivity = null;
                    } else {
                        empLov.setValid(true);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(empLov);
                        otHdrVO.getCurrentRow().setAttribute("Status", "Pending Approval");
                        autoApproveRequest();
                        ADFUtils.findOperation("Commit").execute();
                        JSFUtils.addFacesInformationMessage("Request has been submitted for Approval");
//                        approve_hierachy(otHdrVO.getCurrentRow().getAttribute("ReqId"), "H",
//                                         otHdrVO.getCurrentRow().getAttribute("RequestNumber"));
                        appMenu.setDisabled(true);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(appMenu);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(ot10);
                        returnActivity = "save";
                    }
                }
                //            else{
            //                if("ot".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))){
            //                    JSFUtils.addFacesInformationMessage("Please provide Over Time Details!..");
            //                }
            //                else  if("house".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))){
            //                    JSFUtils.addFacesInformationMessage("Please provide Housing in Advance Details!..");
            //                }
            //                else  if("vacation".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))){
            //                    JSFUtils.addFacesInformationMessage("Please provide Vacation Allowance Details!..");
            //                }
            //                else  if("salary".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))){
            //                    JSFUtils.addFacesInformationMessage("Please provide Salary in Advance Details!..");
            //                }
            //                else  if("edu".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))){
            //                    JSFUtils.addFacesInformationMessage("Please provide Education Allowance Details!..");
            //                }
            //                returnActivity=null;
            //            }


            }else if ("letter".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {

                if (lineVO.first() != null) {
                    otHdrVO.getCurrentRow().setAttribute("Status",
                                                         "Pending Approval");
                    otHdrVO.getCurrentRow().setAttribute("ReqType", "letter");
                    autoApproveRequest();
                    ADFUtils.findOperation("Commit").execute();
                    returnActivity = "save";
//                    approve_hierachy(otHdrVO.getCurrentRow().getAttribute("ReqId"), "H",
//                                     otHdrVO.getCurrentRow().getAttribute("RequestNumber"));
                    JSFUtils.addFacesInformationMessage("Request has been submitted for Approval");
                } else {
                    JSFUtils.addFacesInformationMessage("Please provide HR Letter Details!..");
                    isValidated = false;
                }

            }

            else if ("BusinessTrip".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
                long purposeRows = ADFUtils.findIterator("XxhcmPurposeOfTrvl_VO1Iterator").getViewObject().getEstimatedRowCount();
                if(purposeRows == 0){
                    JSFUtils.addFacesInformationMessage("At least one line is mandatory in Purpose of travel.");
                    isValidated = false;
                    return null;
                }

                if (lineVO.first() != null) {
                    otHdrVO.getCurrentRow().setAttribute("ReqType",
                                                         "BusinessTrip");
                    if ("add".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("mode"))) {
                        lineVO.getCurrentRow().setAttribute("OrigStartDate",
                                                            lineVO.getCurrentRow().getAttribute("StartDate"));
                        lineVO.getCurrentRow().setAttribute("OrigEndDate",
                                                            lineVO.getCurrentRow().getAttribute("EndDate"));

                    }
                    System.err.println("------AirType" +
                                       this.btAirtickTyp.getValue());
                    System.err.println("------CityCountry" +
                                       this.btDestCountryCity.getValue());
                    System.err.println("------Country" +
                                       this.destCountryLOV.getValue());

                    lineVO.getCurrentRow().setAttribute("AirlineTicketType",
                                                        ADFContext.getCurrent().getPageFlowScope().get("airTicket"));
                    
                    lineVO.getCurrentRow().setAttribute("DestinationCountry",this.destCountryLOV.getValue());
                    
                    lineVO.getCurrentRow().setAttribute("DestCountryCity",
                                                        ADFContext.getCurrent().getPageFlowScope().get("DestCount"));
                    
                   

                    System.err.println("------BS");

                    //OnValidateStartDateEndDateROVO1Iterator
                    ViewObject ovo =
                        ADFUtils.findIterator("OnValidateStartDateEndDateROVO1Iterator").getViewObject();
                    ViewCriteriaManager vcm = ovo.getViewCriteriaManager();
                    ViewCriteria vc = vcm.getViewCriteria("ValidateEmpDates");
                    ovo.applyViewCriteria(vc);
                    System.err.println("----emp" +
                                       otHdrVO.getCurrentRow().getAttribute("EmpId"));
                    System.err.println("----SD" +
                                       lineVO.getCurrentRow().getAttribute("StartDate"));
                    System.err.println("----ED" +
                                       lineVO.getCurrentRow().getAttribute("EndDate"));

                    String strDate =
                        lineVO.getCurrentRow().getAttribute("StartDate").toString();
                    String endDate =
                        lineVO.getCurrentRow().getAttribute("EndDate").toString();
                    SimpleDateFormat sdfSource =
                        new SimpleDateFormat("yyyy-MM-dd");

                    Date date1 = null;
                    Date date2 = null;

                    try {
                        date2 = sdfSource.parse(endDate);
                        date1 = sdfSource.parse(strDate);

                        System.err.println("----SDD" + date1);
                        System.err.println("----EDD" + date2);

                    } catch (ParseException e) {
                    }
                    ovo.setNamedWhereClauseParam("P_EMP",
                                                 otHdrVO.getCurrentRow().getAttribute("EmpId"));
                    ovo.setNamedWhereClauseParam("p_startdate1", new oracle.jbo.domain.Date(new java.sql.Date(date1.getTime())));
                    ovo.setNamedWhereClauseParam("p_enddate1", new oracle.jbo.domain.Date(new java.sql.Date(date2.getTime())));

                    
                    ovo.executeQuery();
                    System.err.println("-----Count" +
                                       ovo.getEstimatedRowCount());
                    if (ovo.getEstimatedRowCount() > 0) {
                        RowSetIterator rs = ovo.createRowSetIterator(null);                        
                        String str = "";
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        while(rs.hasNext()){
                            Row row = rs.next();
                            String startDate = row.getAttribute("StartDate") != null ? sdf.format(new java.util.Date(((oracle.jbo.domain.Date)row.getAttribute("StartDate")).dateValue().getTime())) : null;
                            String endDateStr = row.getAttribute("EndDate") != null ? sdf.format(new java.util.Date(((oracle.jbo.domain.Date)row.getAttribute("EndDate")).dateValue().getTime())) : null;
                            str += row.getAttribute("RequestNumber")+"("+startDate+"-"+endDateStr+");";
                        }
//                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//                        Row earlierRow = ovo.first();
//                        String reqDate = earlierRow.getAttribute("RequestDate") != null ? sdf.format(new java.util.Date(((java.sql.Date)earlierRow.getAttribute("RequestDate")).getTime())) : null;
//                        String startDate = earlierRow.getAttribute("StartDate") != null ? sdf.format(new java.util.Date(((oracle.jbo.domain.Date)earlierRow.getAttribute("StartDate")).dateValue().getTime())) : null;
//                        String endDateStr = earlierRow.getAttribute("EndDate") != null ? sdf.format(new java.util.Date(((oracle.jbo.domain.Date)earlierRow.getAttribute("EndDate")).dateValue().getTime())) : null;
                        JSFUtils.addFacesErrorMessage("Your current request is overlapping with other request(s) : "+str);
//                        ("Already this Resource had booked in these dates, please provide different Dates");
                        isValidated = false;
                        return null;
                    } else {
                        otHdrVO.getCurrentRow().setAttribute("Status",
                                                             "Pending Approval");
                        autoApproveRequest();
                        ADFUtils.findOperation("Commit").execute();
                        returnActivity = "save";
//                        approve_hierachy(otHdrVO.getCurrentRow().getAttribute("ReqId"), "H",
//                                         otHdrVO.getCurrentRow().getAttribute("RequestNumber"));
                        JSFUtils.addFacesInformationMessage("Request has been submitted for Approval");
                    }


                } else {
                    isValidated = false;
                    JSFUtils.addFacesInformationMessage("Please provide Business Trip Details!..");

                }

            }

            else if ("BusinessTripCompletion".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {

//XxhcmAttachmentsTVO1
                Boolean isError =false;
                //XxhcmOtherExpenseTVO1Iterator
                //XxhcmAttachmentsTVO1Iterator
                //if(ADFUtils.findIterator("XxhcmOtherExpenseTVO1Iterator").getEstimatedRowCount() > 0){
                    if(ADFUtils.findIterator("XxhcmAttachmentsTVO1Iterator").getEstimatedRowCount() ==0){
                     JSFUtils.addFacesErrorMessage("Attachment of trip report is mandtory");
                        isError = true;
                        isValidated = false;
                     returnActivity = null;   
                    }
                //}
                if (lineVO.first() != null && !isError) {
                    otHdrVO.getCurrentRow().setAttribute("ReqType",
                                                         "BusinessTripCompletion");
//                    lineVO.getCurrentRow().setAttribute("StartDate",
//                                                        this.bstStDt.getValue());
//                    lineVO.getCurrentRow().setAttribute("EndDate",
//                                                        this.bstEdDt.getValue());
                    lineVO.getCurrentRow().setAttribute("DestCategory",
                                                        this.bstDestCateLOV.getValue());
                    
//                    lineVO.getCurrentRow().setAttribute("DestinationCountry",countryValue);
                    System.err.println("NOFDAYS" +
                                       this.bstNoOfDays.getValue());
                    //lineVO.getCurrentRow().setAttribute("NumberOfDays",
                    //new BigDecimal(this.bstNoOfDays.getValue()==null?"0":this.bstNoOfDays.getValue().toString()));
                    System.err.println("HELLOOOO--" +
                                       ADFContext.getCurrent().getPageFlowScope().get("bussTripReqNo"));
                    lineVO.getCurrentRow().setAttribute("BussTravReqNum",
                                                        ADFContext.getCurrent().getPageFlowScope().get("bussTripReqNo"));
                    lineVO.getCurrentRow().setAttribute("DestCountryCity",
                                                        this.bstDestCount.getValue());
                    otHdrVO.getCurrentRow().setAttribute("Status",
                                                         "Pending Approval");

                    autoApproveRequest();
                    ADFUtils.findOperation("Commit").execute();
                    returnActivity = "save";
//                    approve_hierachy(otHdrVO.getCurrentRow().getAttribute("ReqId"), "H",
//                                     otHdrVO.getCurrentRow().getAttribute("RequestNumber"));
                    JSFUtils.addFacesInformationMessage("Request has been submitted for Approval");
                } else if(lineVO.first() == null && !isError){
                    isValidated = false;
                    JSFUtils.addFacesInformationMessage("Please provide Business Trip Completion Details!..");

                }
                

            }
            
        }
        
        
        
    
        oracle.binding.OperationBinding opJobLevel = ADFUtils.findOperation("getJobLevel");
        opJobLevel.getParamsMap().put("empId", (oracle.jbo.domain.Number)otHdrVO.getCurrentRow().getAttribute("EmpId"));
        opJobLevel.execute();
        String res = (String)opJobLevel.getResult();
        if(res == null || (res!=null && !res.equalsIgnoreCase("0"))){
        
        }
        //TODO
        if(isValidated && (res!=null && !res.equalsIgnoreCase("0"))){
            oracle.binding.OperationBinding op = ADFUtils.findOperation("prepareMailTemplateAndSend");
            op.execute();
        }    
        return returnActivity;

    }



    public String approveNewACL() {
        ViewObject mgrVO =
            ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();

        updateApproveRejection(mgrVO.getCurrentRow().getAttribute("ReqId"), "A",
                       (String)mgrVO.getCurrentRow().getAttribute("RequestNumber")
                       );
        LoginBean usersb =
            (LoginBean) ADFUtils.evaluateEL("#{loginBean}");
        
        
        BigDecimal empId = new BigDecimal(usersb.getPersonId());
        ADFContext aDFContext = ADFContext.getCurrent();
        aDFContext.getPageFlowScope().put("mempId",empId);
        oracle.binding.OperationBinding op = ADFUtils.findOperation("prepareMailTemplateAndSend1");
        op.getParamsMap().put("approveOrReject", "A");
        op.execute();
        if(op.getErrors().isEmpty()){
            mgrVO.executeQuery();
            approve.hide();
            return "save";
        }
        return null;
    }


    public void updateApproveRejection(Object header_id, String approver_flag,
                                String User) {
        String str = null;
        oracle.jbo.domain.Number hdrId = null;
        String userName = User;
        try {
            hdrId = new oracle.jbo.domain.Number(header_id.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ViewObject mgrVo =
            ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
        String getAttr = approver_flag.equalsIgnoreCase("A") ? "approveComment" : "rejectComment";
        String comment = (String)AdfFacesContext.getCurrentInstance().getPageFlowScope().get(getAttr);
        //XXSALIC_HCM_PKG.XXSALIC_APPROVAL_PRC
        //LoginBean  lb = (LoginBean)JSFUtils.getFromSession("loginBean");
        LoginBean usersb =
            (LoginBean) ADFUtils.evaluateEL("#{loginBean}");
        
        
        BigDecimal empId = new BigDecimal(usersb.getPersonId());
        oracle.jbo.domain.Number empIdN = (oracle.jbo.domain.Number)mgrVo.getCurrentRow().getAttribute("EmpId");
        BigDecimal ownerReqId =(BigDecimal)empIdN.bigDecimalValue();
        String reqType = (String)mgrVo.getCurrentRow().getAttribute("ReqType");
        
        ApplicationModuleImpl am =
            (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(null);
        try {
            dobProcArgs = new Object[][] {
                { "IN", approver_flag, oracle.jdbc.internal.OracleTypes.VARCHAR }, //0
                { "IN", reqType, oracle.jdbc.internal.OracleTypes.VARCHAR },
                { "IN", new oracle.jbo.domain.Number(ownerReqId), oracle.jdbc.internal.OracleTypes.NUMBER },
                { "IN", new oracle.jbo.domain.Number(empId), oracle.jdbc.internal.OracleTypes.NUMBER },
                { "IN", hdrId, oracle.jdbc.internal.OracleTypes.NUMBER }, //1 
                { "IN", comment, OracleTypes.VARCHAR },
                { "OUT", str, oracle.jdbc.internal.OracleTypes.VARCHAR }
            };
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            System.err.println("==11====");
            DBUtils.callDBStoredProcedure(am.getDBTransaction(),
                                          "call XXSALIC_HCM_PKG.XXSALIC_APPROVAL_PRC(?,?,?,?,?,?,?)",
                                          (Object[][])dobProcArgs);
            System.err.println("==22====");
        } catch (Exception e) {
            System.err.println("===EXE==" + e.toString());
        }
        
    }
    public void createOtLineACL(ActionEvent actionEvent) {
        ADFUtils.invokeEL("#{bindings.CreateInsert.execute}");

    }

    public void deleteOtLine(ActionEvent actionEvent) {
        ADFUtils.invokeEL("#{bindings.Delete.execute}");

    }

    public void dayfInderVCL(ValueChangeEvent dayy) {
        RichInputDate otdate = (RichInputDate)dayy.getComponent();
        ViewObject lineVO =
            ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject();
        
        java.sql.Date ottemp = (java.sql.Date)lineVO.getCurrentRow().getAttribute("otdatetemp");
        if(dayy.getNewValue() == null && ottemp !=null){
            JSFUtils.addComponentFacesMessage(FacesMessage.SEVERITY_ERROR,"Already you raised over time request for selected date!..",dayy.getComponent().getClientId(FacesContext.getCurrentInstance()));       
            otdate.setValid(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(dayy.getComponent());
            AdfFacesContext.getCurrentInstance().addPartialTarget(dtlTable);
            
            return;
        }
        String result = checkDuplicateOverTimeDate(dayy.getNewValue());
        java.sql.Date day1 =
            (java.sql.Date)dayy.getNewValue();
        //XxhcmOvertimeHeadersAllVO1Iterator
        ViewObject headerVO =
            ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
        
        ViewObject hdr1 =
            ADFUtils.findIterator("ValidateOverTimeReqVO1Iterator").getViewObject();
        hdr1.setNamedWhereClauseParam("bind_empid",
                         ((oracle.jbo.domain.Number)headerVO.getCurrentRow().getAttribute("EmpId")).bigDecimalValue());
        //        vcr.setAttribute("ReqType", "ot");
        hdr1.setNamedWhereClauseParam("bind_otdate", day1);
        hdr1.executeQuery();
//        BigDecimal otcount = (BigDecimal)hdr1.first().getAttribute("Countot");
        
            
        if (hdr1.first() != null) {
            String reqNumber = (String)hdr1.first().getAttribute("RequestNumber");
            JSFUtils.addComponentFacesMessage(FacesMessage.SEVERITY_ERROR,"Already you raised over time request for selected date - "+day1+" with request number "+hdr1.first().getAttribute("RequestNumber")+"!..",dayy.getComponent().getClientId(FacesContext.getCurrentInstance()));
            //lineVO.getCurrentRow().setAttribute("OvertimeDate", null);
            
            //otdate.setSubmittedValue(day1);
            otdate.setValid(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(dayy.getComponent());
            AdfFacesContext.getCurrentInstance().addPartialTarget(dtlTable);
            //lineVO.executeQuery();
            //AdfFacesContext.getCurrentInstance().addPartialTarget(dtlTable);
        } else {
            //ValidateOTonLeaveROVO1Iterator
            ViewObject hdr2 =
                ADFUtils.findIterator("ValidateOTonLeaveROVO1Iterator").getViewObject();
            hdr2.setNamedWhereClauseParam("bind_empid",
                             ((oracle.jbo.domain.Number)headerVO.getCurrentRow().getAttribute("EmpId")).bigDecimalValue());
            hdr2.setNamedWhereClauseParam("bind_date", day1);
            hdr2.executeQuery();
            BigDecimal otPersonId = null;
            if(hdr2.first() != null){
                otPersonId = (BigDecimal)hdr2.first().getAttribute("PersonId");
            }
            if(otPersonId!=null){
                String leavePeriod = (String)hdr2.first().getAttribute("AnnualLeave");
                JSFUtils.addComponentFacesMessage(FacesMessage.SEVERITY_ERROR,"Over Time cannot be raised on approved leave period("+leavePeriod+")",dayy.getComponent().getClientId(FacesContext.getCurrentInstance()));
                
                //lineVO.getCurrentRow().setAttribute("OvertimeDate", null);
                //RichInputDate otdate = (RichInputDate)dayy.getComponent();
              //  otdate.setSubmittedValue(day1);
                otdate.setValid(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(dayy.getComponent());
                AdfFacesContext.getCurrentInstance().addPartialTarget(dtlTable);
                    
            }else{
        
            
            if (result.equals("N")) {
                //RichInputDate otdate = (RichInputDate)dayy.getComponent();
                java.sql.Date dummyd = null;
                lineVO.getCurrentRow().setAttribute("otdatetemp", dummyd);
                otdate.setValid(true);
                AdfFacesContext.getCurrentInstance().addPartialTarget(dayy.getComponent());
                Calendar calendar = Calendar.getInstance();
                Date date = calendar.getTime();
                java.sql.Date domaiDay =
                    (java.sql.Date)dayy.getNewValue();
                java.sql.Date sqldate = (java.sql.Date)dayy.getNewValue();
                date = new Date(sqldate.getTime());
                Date day = date;
                //        System.out.println(new SimpleDateFormat("EE", Locale.ENGLISH).format(date.getTime()));
                //            System.out.println(new SimpleDateFormat("EEEE",
                //                                                    Locale.ENGLISH).format(day.getTime()));
                BigDecimal dummy = null;
                //OT_HOL
                
                oracle.binding.OperationBinding op = ADFUtils.findOperation("validatePublicHoliday");
                op.getParamsMap().put("otdate", domaiDay);
                op.execute();
                Integer holCnt = (Integer)op.getResult();
                if(holCnt > 0){
                    lineVO.getCurrentRow().setAttribute("OvertimeType",
                                                        "OT_HOL");
                    //OvertimeHours
                    lineVO.getCurrentRow().setAttribute("OvertimeHours",
                                                        dummy);
                    lineVO.getCurrentRow().setAttribute("CalculatedHours",
                                                        dummy);
                    
                    AdfFacesContext.getCurrentInstance().addPartialTarget(dtlTable);
                }
                else if (new SimpleDateFormat("EEEE",
                                         Locale.ENGLISH).format(day.getTime()).equalsIgnoreCase("friday")) {
                    lineVO.getCurrentRow().setAttribute("OvertimeType",
                                                        "OT_WE");
                    //OvertimeHours
                    lineVO.getCurrentRow().setAttribute("OvertimeHours",
                                                        dummy);
                    lineVO.getCurrentRow().setAttribute("CalculatedHours",
                                                        dummy);
                    
                    AdfFacesContext.getCurrentInstance().addPartialTarget(dtlTable);
                } else if (new SimpleDateFormat("EEEE",
                                                Locale.ENGLISH).format(day.getTime()).equalsIgnoreCase("saturday")) {
                    lineVO.getCurrentRow().setAttribute("OvertimeType",
                                                        "OT_WE");
                    lineVO.getCurrentRow().setAttribute("OvertimeHours",
                                                        dummy);
                    lineVO.getCurrentRow().setAttribute("CalculatedHours",
                                                        dummy);
                    
                    AdfFacesContext.getCurrentInstance().addPartialTarget(dtlTable);
                } else {
                    lineVO.getCurrentRow().setAttribute("OvertimeType",
                                                        "OT_WD");
                    lineVO.getCurrentRow().setAttribute("OvertimeHours",
                                                        dummy);
                    lineVO.getCurrentRow().setAttribute("CalculatedHours",
                                                        dummy);
                    //CalculatedHours
                    AdfFacesContext.getCurrentInstance().addPartialTarget(dtlTable);
                }
            } else {
                JSFUtils.addComponentFacesMessage(FacesMessage.SEVERITY_ERROR,"Already you raised over time request for selected date "+day1 +" !..",dayy.getComponent().getClientId(FacesContext.getCurrentInstance()));
                lineVO.getCurrentRow().setAttribute("otdatetemp", dayy.getNewValue());
                //lineVO.getCurrentRow().setAttribute("OvertimeDate", null);
                //RichInputText otdate = (RichInputText)dayy.getComponent();
                //otdate.setSubmittedValue(day1);
                otdate.setValid(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(dayy.getComponent());
                AdfFacesContext.getCurrentInstance().addPartialTarget(dtlTable);
            }
            }
        }
        
    }

    public String checkDuplicateOverTimeDate(Object currDate) {
        String isDuplicate = "N";
        ViewObject lineVO =
            ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject();
        RowSetIterator lineVORS = lineVO.createRowSetIterator(null);
        while (lineVORS.hasNext()) {
            Row currentRow = lineVORS.next();
            Object s1 = currentRow.getAttribute("OvertimeDate");
            if (currDate.equals(s1))
                isDuplicate = "Y";
        }
        return isDuplicate;
    }


    public void setDtlTable(RichTable dtlTable) {
        this.dtlTable = dtlTable;
    }

    public RichTable getDtlTable() {
        return dtlTable;
    }
    Object[][] dobProcArgs1 = null;

    public void update_approve(Object header_id, String approver_flag,
                               String req_num, String User) {
        String str = null;
        Number hdrId = null;
        String userName = User;
        try {
            hdrId = new Number(header_id);
        } catch (SQLException e) {
        }
        ApplicationModuleImpl am =
            (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(null);
        dobProcArgs1 =
                new Object[][] { { "IN", hdrId, oracle.jdbc.internal.OracleTypes.NUMBER },
                    //0
                    { "IN", approver_flag,
                      oracle.jdbc.internal.OracleTypes.VARCHAR }, //1
                    { "IN", userName,
                      oracle.jdbc.internal.OracleTypes.VARCHAR }, //2
                    { "IN", "H", oracle.jdbc.internal.OracleTypes.VARCHAR },
                    //3
                    { "IN", "OT", oracle.jdbc.internal.OracleTypes.VARCHAR },
                    //4 p_page
                    { "IN", req_num,
                      oracle.jdbc.internal.OracleTypes.VARCHAR },
                    //5 p_req_number
                    { "OUT", str,
                      oracle.jdbc.internal.OracleTypes.VARCHAR } //6
                    } ;
        try {
            //            System.err.println("==11====");
            DBUtils.callDBStoredProcedure(am.getDBTransaction(),
                                          "call xx_boq_update_approval(?,?,?,?,?,?,?)",
                                          dobProcArgs1);
            //            System.err.println("==22====");
        } catch (SQLException e) {
            System.err.println("===EXE==" + e.toString());
        }
        str = (String)dobProcArgs1[6][1];
        //        System.err.println("===SEND==" + str);

    }

    public String rejectNewACL() {
        LoginBean usersb =
            (LoginBean) ADFUtils.evaluateEL("#{loginBean}");
        BigDecimal empId = new BigDecimal(usersb.getPersonId());
        ADFContext aDFContext = ADFContext.getCurrent();
        aDFContext.getPageFlowScope().put("mempId",empId);
        
        ViewObject mgrVO =
            ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();

        updateApproveRejection(mgrVO.getCurrentRow().getAttribute("ReqId"), "R",
                       (String)mgrVO.getCurrentRow().getAttribute("RequestNumber"));
        
        oracle.binding.OperationBinding op = ADFUtils.findOperation("prepareMailTemplateAndSend1");
        op.getParamsMap().put("approveOrReject", "R");
        op.execute();
        if(op.getErrors().isEmpty()){
            mgrVO.executeQuery();
            approve.hide();
            return "save";
        }
        return null;
    }


    public void approveACL(ActionEvent actionEvent) {
        ViewObject mgrVO =
            ADFUtils.findIterator("XxQpActionHistoryTVO1Iterator").getViewObject();
        //        mgrVO.getCurrentRow().getAttribute("");
        update_approve(mgrVO.first().getAttribute("HeaderId"), "Y",
                       (String)mgrVO.first().getAttribute("ReqNumber"),
                       (String)mgrVO.first().getAttribute("ApproverUserName"));
        mgrVO.executeQuery();
        // AdfFacesContext.getCurrentInstance().addPartialTarget(mgrTable);
        OperationBinding ob =
            (OperationBinding)ADFUtils.getBindingContainer().getOperationBinding("load");
        ob.execute();
        //        AdfFacesContext.getCurrentInstance().addPartialTarget(totaReq);
        //        AdfFacesContext.getCurrentInstance().addPartialTarget(penAppr);
        //        AdfFacesContext.getCurrentInstance().addPartialTarget(appr);
        //        AdfFacesContext.getCurrentInstance().addPartialTarget(reje);
    }

    public void rejectACL(ActionEvent actionEvent) {
        LoginBean usersb =
            (LoginBean) ADFUtils.evaluateEL("#{loginBean}");
        
        
        BigDecimal empId = new BigDecimal(usersb.getPersonId());
        ADFContext aDFContext = ADFContext.getCurrent();
        aDFContext.getPageFlowScope().put("mempId",empId);
        
        ViewObject mgrVO =
            ADFUtils.findIterator("XxQpActionHistoryTVO1Iterator").getViewObject();
        //        mgrVO.getCurrentRow().getAttribute("");
        update_approve(mgrVO.first().getAttribute("HeaderId"), "N",
                       (String)mgrVO.first().getAttribute("ReqNumber"),
                       (String)mgrVO.first().getAttribute("ApproverUserName"));
        mgrVO.executeQuery();
        // AdfFacesContext.getCurrentInstance().addPartialTarget(mgrTable);
        OperationBinding ob =
            (OperationBinding)ADFUtils.getBindingContainer().getOperationBinding("load");
        ob.execute();
        //        AdfFacesContext.getCurrentInstance().addPartialTarget(totaReq);
        //        AdfFacesContext.getCurrentInstance().addPartialTarget(penAppr);
        //        AdfFacesContext.getCurrentInstance().addPartialTarget(appr);
        //        AdfFacesContext.getCurrentInstance().addPartialTarget(reje);
    }

    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }
    
    

    public Date getMinDate() {
        try {
            Calendar now = Calendar.getInstance();
            java.util.Date date = now.getTime();
            GregorianCalendar cal = new GregorianCalendar();
                            cal.setTime(date);
                            cal.add(Calendar.DATE, -1);
                                            
                            
            date = cal.getTime();
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = formatter.format(date);
            return formatter.parse(currentDate);
            //return formatter.parse(currentDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    Number otHours = new Number(0);

    public String saveAC() {
        String returnActivity = null;
        if ("house".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            ViewObject otHdrVO =
                ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
            ViewObject probCheckVO =
                ADFUtils.findIterator("hireROVO1Iterator").getViewObject();
            ViewObject ethnicVO =
                ADFUtils.findIterator("ethnicROVO1Iterator").getViewObject();
            ethnicVO.setNamedWhereClauseParam("pers",
                                              otHdrVO.getCurrentRow().getAttribute("EmpId"));
            ethnicVO.executeQuery();

            if (ethnicVO.first() != null) {
                if (ethnicVO.first().getAttribute("Ethnic").equals("SALIC01")) {
                    probCheckVO.setNamedWhereClauseParam("per",
                                                         otHdrVO.getCurrentRow().getAttribute("EmpId"));
                    probCheckVO.executeQuery();
                    if (probCheckVO.first() != null) {
                        BigDecimal prob =
                            (BigDecimal)probCheckVO.first().getAttribute("Days"); //Days
                        if (prob.compareTo(new BigDecimal(367)) == -1) {
                            JSFUtils.addFacesInformationMessage("One Year of Employment should be completed!");
                            returnActivity = null;
                        } else {
                            ViewObject lineVO =
                                ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject(); //EmpId XxhcmOvertimeHeadersAllVO1Iterator1 XxhcmOvertimeDetailsAllVO2Iterator1
                            if (lineVO.first() != null) {

                                if (otHdrVO.getCurrentRow().getAttribute("Status") !=
                                    "Draft") {
                                    otHdrVO.getCurrentRow().setAttribute("Status",
                                                                         "Draft");
                                    otHdrVO.getCurrentRow().setAttribute("ReqType",
                                                                         "house");
                                }
                                ADFUtils.findOperation("Commit").execute();
                                returnActivity = "save";
                                JSFUtils.addFacesInformationMessage("Information Saved Successfully");
                            } else {
                                JSFUtils.addFacesInformationMessage("Please provide Housing in Advance Details!..");
                                returnActivity = null;
                            }
                        }

                    }
                } else {
                    probCheckVO.setNamedWhereClauseParam("per",
                                                         otHdrVO.getCurrentRow().getAttribute("EmpId"));
                    probCheckVO.executeQuery();
                    if (probCheckVO.first() != null) {
                        BigDecimal prob =
                            (BigDecimal)probCheckVO.first().getAttribute("Days"); //Days
                        if (prob.compareTo(new BigDecimal(14)) == -1) {
                            JSFUtils.addFacesInformationMessage("you can raise the Request only after 2 weeks of Data of Joining!");
                            returnActivity = null;
                        } else {
                            ViewObject lineVO =
                                ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject(); //EmpId XxhcmOvertimeHeadersAllVO1Iterator1 XxhcmOvertimeDetailsAllVO2Iterator1
                            if (lineVO.first() != null) {

                                if (otHdrVO.getCurrentRow().getAttribute("Status") !=
                                    "Draft") {
                                    otHdrVO.getCurrentRow().setAttribute("Status",
                                                                         "Draft");
                                    otHdrVO.getCurrentRow().setAttribute("ReqType",
                                                                         "house");
                                }
                                ADFUtils.findOperation("Commit").execute();
                                returnActivity = "save";
                                JSFUtils.addFacesInformationMessage("Information Saved Successfully");
                            } else {
                                JSFUtils.addFacesInformationMessage("Please provide Housing in Advance Details!..");
                                returnActivity = null;
                            }
                        }

                    }
                }
            } else {
                JSFUtils.addFacesInformationMessage("There is no Nationality Details!..");
            }


        } else if ("ot".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            BigDecimal totHours = new BigDecimal(0);
            BigDecimal currentPageHours = new BigDecimal(0);

            ViewObject otHdrVO =
                ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
            ViewObject otHdrVO1 =
                ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator1").getViewObject();
            ViewObject lineVO =
                ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject(); //EmpId XxhcmOvertimeHeadersAllVO1Iterator1 XxhcmOvertimeDetailsAllVO2Iterator1
            ViewObject lineVO1 =
                ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator1").getViewObject();
            try {
                totHours =
                        validateHours(otHdrVO.getCurrentRow().getAttribute("EmpId"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            BigDecimal linBigHours = new BigDecimal(0);
            Number lineHourss = new Number(0);
            RowSetIterator lineRS = lineVO.createRowSetIterator(null);
            while (lineRS.hasNext()) {
                Row cuLine = lineRS.next();
                lineHourss = (Number)cuLine.getAttribute("OvertimeHours");
                linBigHours = lineHourss.bigDecimalValue();
                currentPageHours = currentPageHours.add(linBigHours);
            }
            currentPageHours = currentPageHours.add(totHours);
            BigDecimal fixedHours = new BigDecimal(40);
            if (currentPageHours.compareTo(fixedHours) == 0) {
                JSFUtils.addFacesInformationMessage("Total OT Hours in this Month Exceeded!");
            } else if (currentPageHours.compareTo(fixedHours) == 1) {
                JSFUtils.addFacesInformationMessage("Total OT Hours in this Month Exceeded!");
            } else {
                if (lineVO.first() != null) {

                    if (otHdrVO.getCurrentRow().getAttribute("Status") !=
                        "Draft") {
                        otHdrVO.getCurrentRow().setAttribute("Status",
                                                             "Draft");
                        otHdrVO.getCurrentRow().setAttribute("ReqType", "ot");
                    }
                    ADFUtils.findOperation("Commit").execute();
                    returnActivity = "save";
                    JSFUtils.addFacesInformationMessage("Information Saved Successfully");
                } else {
                    JSFUtils.addFacesInformationMessage("Please provide Over Time Details!..");
                    returnActivity = null;
                }
            }

        } else if ("vacation".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            ViewObject otHdrVO =
                ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
            ViewObject lineVO =
                ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject(); //EmpId XxhcmOvertimeHeadersAllVO1Iterator1 XxhcmOvertimeDetailsAllVO2Iterator1

            ViewObject hdr1 =
                ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator2").getViewObject();
            ViewCriteria vc = hdr1.createViewCriteria();
            ViewCriteriaRow vcr = vc.createViewCriteriaRow();
            vcr.setAttribute("EmpId",
                             otHdrVO.getCurrentRow().getAttribute("EmpId"));
            vcr.setAttribute("ReqType", "vacation");
            vc.addRow(vcr);
            hdr1.applyViewCriteria(vc);
            hdr1.executeQuery();
            if (hdr1.first() != null) {
                empLov.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(empLov);
                JSFUtils.addFacesInformationMessage("Already you have Raised Vacation Allowance for this Year!");
                returnActivity = null;
            } else {
                if (lineVO.first() != null) {

                    if (otHdrVO.getCurrentRow().getAttribute("Status") !=
                        "Draft") {
                        otHdrVO.getCurrentRow().setAttribute("Status",
                                                             "Draft");
                        otHdrVO.getCurrentRow().setAttribute("ReqType",
                                                             "vacation");
                    }
                    ADFUtils.findOperation("Commit").execute();
                    returnActivity = "save";
                    JSFUtils.addFacesInformationMessage("Information Saved Successfully");
                } else {
                    JSFUtils.addFacesInformationMessage("Please provide Vacation Allowance Details!..");
                    returnActivity = null;
                }
            }

        } else if ("salary".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {

            ViewObject otHdrVO =
                ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
            ViewObject probCheckVO =
                ADFUtils.findIterator("hireROVO1Iterator").getViewObject();
            probCheckVO.setNamedWhereClauseParam("per",
                                                 otHdrVO.getCurrentRow().getAttribute("EmpId"));
            probCheckVO.executeQuery();
            if (probCheckVO.first() != null) {
                BigDecimal prob =
                    (BigDecimal)probCheckVO.first().getAttribute("Days"); //Days
                if (prob.compareTo(new BigDecimal(90)) == -1) {
                    JSFUtils.addFacesInformationMessage("Probation is not completed!");
                    returnActivity = null;
                } else {
                    if ("edit".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("mode"))) {
                        ADFUtils.findOperation("Commit").execute();
                        returnActivity = "save";
                        JSFUtils.addFacesInformationMessage("Information Saved Successfully");
                    } else {
                        List months = new ArrayList();
                        Calendar calendar = Calendar.getInstance();
                        String Month =
                            new SimpleDateFormat("MMM").format(calendar.getTime());
                        System.err.println("start-->  " + Month);
                        months.add(Month);
                        calendar.add(Calendar.MONTH, 1);
                        String nextMonth =
                            new SimpleDateFormat("MMM").format(calendar.getTime());
                        System.err.println("start-->  " + nextMonth);
                        months.add(nextMonth);


                        ViewObject lineVO =
                            ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject(); //EmpId XxhcmOvertimeHeadersAllVO1Iterator1 XxhcmOvertimeDetailsAllVO2Iterator1
                        if (lineVO.first() != null) {
                            if (months.contains(lineVO.getCurrentRow().getAttribute("SalPeriod"))) {
                                if (otHdrVO.getCurrentRow().getAttribute("Status") !=
                                    "Draft") {
                                    otHdrVO.getCurrentRow().setAttribute("Status",
                                                                         "Draft");
                                    otHdrVO.getCurrentRow().setAttribute("ReqType",
                                                                         "salary");
                                }

                                ViewObject hdr1 =
                                    ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator2").getViewObject();
                                ViewCriteria vc = hdr1.createViewCriteria();
                                ViewCriteriaRow vcr =
                                    vc.createViewCriteriaRow();
                                vcr.setAttribute("EmpId",
                                                 otHdrVO.getCurrentRow().getAttribute("EmpId"));
                                vcr.setAttribute("Attribute1",
                                                 lineVO.getCurrentRow().getAttribute("SalPeriod"));
                                vc.addRow(vcr);
                                hdr1.applyViewCriteria(vc);
                                hdr1.executeQuery();
                                if (hdr1.first() != null) {
                                    JSFUtils.addFacesInformationMessage("Already you have Raised Salary in Advance for this Month!..");
                                    lineVO.getCurrentRow().setAttribute("SalPeriod",
                                                                        "");
                                    AdfFacesContext.getCurrentInstance().addPartialTarget(soc2);
                                    returnActivity = null;
                                } else {
                                    ADFUtils.findOperation("Commit").execute();
                                    returnActivity = "save";
                                    JSFUtils.addFacesInformationMessage("Information Saved Successfully");
                                }
                            } else {
                                JSFUtils.addFacesInformationMessage("You can't raise Salary in Advance for selected Month!..");
                                returnActivity = null;
                            }
                        } else {
                            JSFUtils.addFacesInformationMessage("Please provide Salary in Advance Details!..");
                            returnActivity = null;
                        }
                    }
                }
            } else {
                JSFUtils.addFacesInformationMessage("Probation is not updated!");
            }
        } else if ("edu".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            ViewObject attVo =
                ADFUtils.findIterator("XxhcmMasterAttachment_VO2Iterator").getViewObject();
            if (attVo.first() != null) {
                ViewObject otHdrVO =
                    ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
                ViewObject lineVO =
                    ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject(); //EmpId XxhcmOvertimeHeadersAllVO1Iterator1 XxhcmOvertimeDetailsAllVO2Iterator1
                if (otHdrVO.getCurrentRow().getAttribute("Status") !=
                    "Draft") {
                    otHdrVO.getCurrentRow().setAttribute("Status", "Draft");
                    otHdrVO.getCurrentRow().setAttribute("ReqType", "edu");
                }
                ADFUtils.findOperation("Commit").execute();
                returnActivity = "save";
                JSFUtils.addFacesInformationMessage("Information Saved Successfully");
                //                ViewObject childValidVO =
                //                    ADFUtils.findIterator("childValidationROVO1Iterator").getViewObject();
                //
                //                childValidVO.setNamedWhereClauseParam("emp", lineVO.getCurrentRow().getAttribute("empIdTRANS"));
                //                childValidVO.executeQuery();
                //                if(childValidVO.getEstimatedRowCount()>=3){
                //                    if(childValidVO.getEstimatedRowCount()==3){
                //                        ViewObject childSemVO =
                //                            ADFUtils.findIterator("childSemROVO1Iterator").getViewObject();
                //                        childSemVO.setNamedWhereClauseParam("sem", lineVO.getCurrentRow().getAttribute("Semester"));
                //                        childSemVO.setNamedWhereClauseParam("emp", lineVO.getCurrentRow().getAttribute("empIdTRANS"));
                //                        childSemVO.setNamedWhereClauseParam("cont", lineVO.getCurrentRow().getAttribute("Contactpersonid"));
                //                        childSemVO.executeQuery();
                //                        System.err.println("ssss- - "+childSemVO.getEstimatedRowCount());
                //                        if(childSemVO.getEstimatedRowCount()==0){
                //                            ViewObject childSemCheckVO =
                //                                ADFUtils.findIterator("childSemCheckROVO1Iterator").getViewObject();
                //                            childSemCheckVO.setNamedWhereClauseParam("con", lineVO.getCurrentRow().getAttribute("Contactpersonid"));
                //                            childSemCheckVO.executeQuery();
                //                            System.err.println("check- - "+childSemCheckVO.getEstimatedRowCount());
                //
                //                        if(childSemCheckVO.getEstimatedRowCount()==2){
                //                            JSFUtils.addFacesInformationMessage("Already you Raised Educational Allowance for 3 Childs!");
                //                            returnActivity=null;
                //                        }
                //                        else{
                //                            if(childSemCheckVO.first()!=null){
                //                                if(lineVO.getCurrentRow().getAttribute("Semester").equals(childSemCheckVO.first().getAttribute("Semester"))){
                //                                                JSFUtils.addFacesInformationMessage("Already you Raised Educational Allowance for selected Semester!");
                //                                                returnActivity=null;
                //                                            }
                //                                            else{
                //                                                 if(otHdrVO.getCurrentRow().getAttribute("Status")!="Draft"){
                //                                                                            otHdrVO.getCurrentRow().setAttribute("Status", "Draft");
                //                                                                            otHdrVO.getCurrentRow().setAttribute("ReqType", "edu");
                //                                                                        }
                //                                                                        ADFUtils.findOperation("Commit").execute();
                //                                                                        returnActivity= "save";
                //                                                                        JSFUtils.addFacesInformationMessage("Information Saved Successfully");
                //                                            }
                //                            }
                //                            else{
                //                                JSFUtils.addFacesInformationMessage("Already you Raised Educational Allowance for 3 Childs!!");
                //                                returnActivity=null;
                //                            }
                //
                //
                //                        }
                //
                //                        }
                //                        else{
                //                            if(childSemVO.getEstimatedRowCount()==1){
                //                                JSFUtils.addFacesInformationMessage("Already you Raised Educational Allowance for selected Semester!");
                //                                returnActivity=null;
                //                            }
                //                            else{
                //                                if(otHdrVO.getCurrentRow().getAttribute("Status")!="Draft"){
                //                                                           otHdrVO.getCurrentRow().setAttribute("Status", "Draft");
                //                                                           otHdrVO.getCurrentRow().setAttribute("ReqType", "edu");
                //                                                       }
                //                                                       ADFUtils.findOperation("Commit").execute();
                //                                                       returnActivity= "save";
                //                                                       JSFUtils.addFacesInformationMessage("Information Saved Successfully");
                //                            }
                //
                //                        }
                //
                //                    }
                //                    else{
                //                        JSFUtils.addFacesInformationMessage("Already you Raised Educational Allowance for 3 Childs!");
                //                                                returnActivity=null;
                //                    }
                //                                 }
                //                else{
                //
                //                    ViewObject childSemVO =
                //                        ADFUtils.findIterator("childSemROVO1Iterator").getViewObject();
                //                    childSemVO.setNamedWhereClauseParam("sem", lineVO.getCurrentRow().getAttribute("Semester"));
                //                    childSemVO.setNamedWhereClauseParam("emp", lineVO.getCurrentRow().getAttribute("empIdTRANS"));
                //                    childSemVO.setNamedWhereClauseParam("cont", lineVO.getCurrentRow().getAttribute("Contactpersonid"));
                //                    childSemVO.executeQuery();
                //                    if(childSemVO.first()!=null){
                //                        JSFUtils.addFacesInformationMessage("Already you Raised Educational Allowance for selected Semester!");
                //                        returnActivity=null;
                //                    }
                //                    else{
                //                        if(otHdrVO.getCurrentRow().getAttribute("Status")!="Draft"){
                //                                                   otHdrVO.getCurrentRow().setAttribute("Status", "Draft");
                //                                                   otHdrVO.getCurrentRow().setAttribute("ReqType", "edu");
                //                                               }
                //                                               ADFUtils.findOperation("Commit").execute();
                //                                               returnActivity= "save";
                //                                               JSFUtils.addFacesInformationMessage("Information Saved Successfully");
                //                    }
                //                                      }
                //                ViewObject childValidVO =
                //                    ADFUtils.findIterator("childValidationROVO1Iterator").getViewObject();
                //                childValidVO.setNamedWhereClauseParam("emp", lineVO.getCurrentRow().getAttribute("empIdTRANS"));
                //                childValidVO.executeQuery();
                //                if(childValidVO.getEstimatedRowCount()==3){
                //                    JSFUtils.addFacesInformationMessage("Already you Raised Educational Allowance for 3 Childs!");
                //                    returnActivity=null;
                //                }
                //                else{
                //                    if(lineVO.first()!=null){
                //
                //                      /*  if(otHdrVO.getCurrentRow().getAttribute("Status")!="Draft"){
                //                            otHdrVO.getCurrentRow().setAttribute("Status", "Draft");
                //                            otHdrVO.getCurrentRow().setAttribute("ReqType", "edu");
                //                        }
                //                        ADFUtils.findOperation("Commit").execute();
                //                        returnActivity= "save";
                //                        JSFUtils.addFacesInformationMessage("Information Saved Successfully");*/
                //                    }
                //                    else{
                //                        JSFUtils.addFacesInformationMessage("Please provide Education Allowance Details!..");
                //                        returnActivity=null;
                //                    }
                //                }

            } else {
                JSFUtils.addFacesInformationMessage("Attachment is Mandatory!..");
                returnActivity = null;
            }


        } else if ("letter".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            ViewObject otHdrVO =
                ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
            ViewObject lineVO =
                ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject();
            if (lineVO.first() != null) {
                otHdrVO.getCurrentRow().setAttribute("Status", "Draft");
                otHdrVO.getCurrentRow().setAttribute("ReqType", "letter");
                ADFUtils.findOperation("Commit").execute();
                returnActivity = "save";
                JSFUtils.addFacesInformationMessage("Information Saved Successfully");
            } else {
                JSFUtils.addFacesInformationMessage("Please provide HR Letter Details!..");

            }

        }

        else if ("BusinessTrip".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            ViewObject otHdrVO =
                ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
            ViewObject lineVO =
                ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject();
            if (lineVO.first() != null) {
                otHdrVO.getCurrentRow().setAttribute("Status", "Draft");
                otHdrVO.getCurrentRow().setAttribute("ReqType",
                                                     "BusinessTrip");
                if ("add".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("mode"))) {
                    lineVO.getCurrentRow().setAttribute("OrigStartDate",
                                                        lineVO.getCurrentRow().getAttribute("StartDate"));
                    lineVO.getCurrentRow().setAttribute("OrigEndDate",
                                                        lineVO.getCurrentRow().getAttribute("EndDate"));

                }
                System.err.println("------AirType" +
                                   this.btAirtickTyp.getValue());
                System.err.println("------CityCountry" +
                                   this.btDestCountryCity.getValue());

                lineVO.getCurrentRow().setAttribute("AirlineTicketType",
                                                    ADFContext.getCurrent().getPageFlowScope().get("airTicket"));
                lineVO.getCurrentRow().setAttribute("DestCountryCity",
                                                    ADFContext.getCurrent().getPageFlowScope().get("DestCount"));


                System.err.println("------BS");


                ViewObject ovo =
                    ADFUtils.findIterator("OnValidateStartDateEndDateROVO1Iterator").getViewObject();
                ViewCriteriaManager vcm = ovo.getViewCriteriaManager();
                ViewCriteria vc = vcm.getViewCriteria("ValidateEmpDates");
                ovo.applyViewCriteria(vc);
                System.err.println("----emp" +
                                   otHdrVO.getCurrentRow().getAttribute("EmpId"));
                System.err.println("----SD" +
                                   lineVO.getCurrentRow().getAttribute("StartDate"));
                System.err.println("----ED" +
                                   lineVO.getCurrentRow().getAttribute("EndDate"));

                String strDate =
                    lineVO.getCurrentRow().getAttribute("StartDate").toString();
                String endDate =
                    lineVO.getCurrentRow().getAttribute("EndDate").toString();
                SimpleDateFormat sdfSource = new SimpleDateFormat("dd-MM-yy");

                Date date1 = null;
                Date date2 = null;

                try {
                    date2 = sdfSource.parse(endDate);
                    date1 = sdfSource.parse(strDate);

                    System.err.println("----SDD" + date1);
                    System.err.println("----EDD" + date2);

                } catch (ParseException e) {
                }
                ovo.setNamedWhereClauseParam("P_EMP",
                                             otHdrVO.getCurrentRow().getAttribute("EmpId"));
                ovo.setNamedWhereClauseParam("P_STARTDATE", date1);
                ovo.setNamedWhereClauseParam("P_ENDDATE", date2);
                ovo.executeQuery();
                System.err.println("-----Count" + ovo.getEstimatedRowCount());
                if (ovo.getEstimatedRowCount() > 0) {
                    JSFUtils.addFacesInformationMessage("Already this Resource had booked in these dates, please provide different Dates");
                } else {
                    ADFUtils.findOperation("Commit").execute();
                    returnActivity = "save";
                    JSFUtils.addFacesInformationMessage("Information Saved Successfully");
                }


            } else {
                JSFUtils.addFacesInformationMessage("Please provide Business Trip Details!..");

            }

        }

        else if ("BusinessTripCompletion".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
            ViewObject otHdrVO =
                ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
            ViewObject lineVO =
                ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject();
            if (lineVO.first() != null) {
                otHdrVO.getCurrentRow().setAttribute("Status", "Draft");
                otHdrVO.getCurrentRow().setAttribute("ReqType",
                                                     "BusinessTripCompletion");

//                lineVO.getCurrentRow().setAttribute("StartDate",
//                                                    this.bstStDt.getValue());
//                lineVO.getCurrentRow().setAttribute("EndDate",
//                                                    this.bstEdDt.getValue());
                lineVO.getCurrentRow().setAttribute("DestCategory",
                                                    this.bstDestCateLOV.getValue());
                System.err.println("NOFDAYS" + this.bstNoOfDays.getValue());
                lineVO.getCurrentRow().setAttribute("NumberOfDays",
                                                    new BigDecimal(this.bstNoOfDays.getValue() ==
                                                                   null ? "0" :
                                                                   this.bstNoOfDays.getValue().toString()));
                System.err.println("HELLOOOO--" +
                                   ADFContext.getCurrent().getPageFlowScope().get("bussTripReqNo"));
                lineVO.getCurrentRow().setAttribute("BussTravReqNum",
                                                    ADFContext.getCurrent().getPageFlowScope().get("bussTripReqNo"));
                lineVO.getCurrentRow().setAttribute("DestCountryCity",
                                                    this.bstDestCount.getValue());


                ADFUtils.findOperation("Commit").execute();
                returnActivity = "save";
                JSFUtils.addFacesInformationMessage("Information Saved Successfully");
            } else {
                JSFUtils.addFacesInformationMessage("Please provide Business Trip Completion Details!..");

            }

        }
        return returnActivity;
    }

    public void setOt10(RichOutputText ot10) {
        this.ot10 = ot10;
    }

    public RichOutputText getOt10() {
        return ot10;
    }
    Object[][] dobProcArgs2 = null;

    public BigDecimal validateHours(Object employee_id) {
        BigDecimal count = new BigDecimal(0);

        ApplicationModuleImpl am =
            (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(null);
        dobProcArgs2 =
                new Object[][] { { "IN", employee_id, oracle.jdbc.internal.OracleTypes.NUMBER },
                    //0
                    { "OUT", count,
                      oracle.jdbc.internal.OracleTypes.NUMBER } //1
                    } ;
        try {
            //            System.err.println("==11====");
            DBUtils.callDBStoredProcedure(am.getDBTransaction(),
                                          "call total_ot_hours(?,?)",
                                          dobProcArgs2);
            //            System.err.println("==22====");
        } catch (SQLException e) {
            System.err.println("===EXE==" + e.toString());
        }
        count = (BigDecimal)dobProcArgs2[1][1];
        //        System.err.println("===SEND==" + count);
        return count;
    }

    public void OnFileUpload(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            UploadFileActionToDB((UploadedFile)vce.getNewValue());

        }
    }


    public void OnExpenseFileUpload(ValueChangeEvent vce) {

        if (vce.getNewValue() != null) {
            ExpenseUploadFileActionToDB((UploadedFile)vce.getNewValue());

        }
    }


    public String ExpenseUploadFileActionToDB(UploadedFile file) {
        UploadedFile myfile = file;
        if (myfile != null) {
            DCIteratorBinding imageIter =
                (DCIteratorBinding)getBindingsCont().get("XxhcmAttachmentsTVO1Iterator");
            ViewObject vo = imageIter.getViewObject();
            Row curRow = vo.getCurrentRow();
            String filename = myfile.getFilename();
            String ContentType = myfile.getContentType();

            try {

                System.err.println("this is the attachment file name----->" +
                                   filename);
                System.err.println("this is the attachment file name----->" +
                                   ContentType);
                curRow.setAttribute("Attribute1", filename);
                curRow.setAttribute("AttachFileType", ContentType);
                curRow.setAttribute("AttachFile", createBlobDomain(myfile));

                //curRow.setAttachment(createBlobDomain(myfile));
            } catch (Exception ex) {
                System.out.println("Exception-" + ex);
            }
        }
        return null;
    }

    public String UploadFileActionToDB(UploadedFile file) {
        UploadedFile myfile = file;
        if (myfile != null) {
            DCIteratorBinding imageIter =
                (DCIteratorBinding)getBindingsCont().get("XxhcmMasterAttachment_VO2Iterator");
            ViewObject vo = imageIter.getViewObject();
            Row curRow = vo.getCurrentRow();
            String filename = myfile.getFilename();
            String ContentType = myfile.getContentType();

            try {

                System.err.println("this is the attachment file name----->" +
                                   filename);
                System.err.println("this is the attachment file name----->" +
                                   ContentType);
                curRow.setAttribute("FileName", filename);
                curRow.setAttribute("FileType", ContentType);
                curRow.setAttribute("Attachment", createBlobDomain(myfile));
                //                                           curRow.setAttachment(createBlobDomain(myfile));
            } catch (Exception ex) {
                System.out.println("Exception-" + ex);
            }
        }
        return null;
    }


    public void downloadFileListener2(FacesContext facesContext,
                                      OutputStream outputStream) {
        ViewObject vc =
            view.backing.ADFUtils.findIterator("XxhcmAttachmentsTVO1Iterator").getViewObject();
        BlobDomain blob =
            (BlobDomain)vc.getCurrentRow().getAttribute("AttachFile");
        try {
            IOUtils.copy(blob.getInputStream(), outputStream);
            blob.closeInputStream();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void downloadFileListener(FacesContext facesContext,
                                     OutputStream outputStream) {
        ViewObject vc =
            view.backing.ADFUtils.findIterator("XxhcmMasterAttachment_VO2Iterator").getViewObject();
        BlobDomain blob =
            (BlobDomain)vc.getCurrentRow().getAttribute("Attachment");
        if(blob!=null){
        try {
            IOUtils.copy(blob.getInputStream(), outputStream);
            blob.closeInputStream();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }

    private BlobDomain createBlobDomain(UploadedFile file) {
        InputStream in = null;
        BlobDomain blobDomain = null;
        OutputStream out = null;
        try {
            in = file.getInputStream();
            blobDomain = new BlobDomain();
            out = blobDomain.getBinaryOutputStream();
            IOUtils.copy(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
        return blobDomain;
    }

    private DCBindingContainer getBindingsCont() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }


    public String withdrawACL() {
        LoginBean usersb =
            (LoginBean) ADFUtils.evaluateEL("#{loginBean}");
        
        
        BigDecimal empId = new BigDecimal(usersb.getPersonId());
        ADFContext aDFContext = ADFContext.getCurrent();
        aDFContext.getPageFlowScope().put("mempId",empId);
        String wdReason = (String)aDFContext.getPageFlowScope().get("wdComment");
        ViewObject otHdrVO =
            ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
        otHdrVO.getCurrentRow().setAttribute("Status", "Draft");
        otHdrVO.getCurrentRow().setAttribute("ReqStatus","WITHDRAWN");
        otHdrVO.getCurrentRow().setAttribute("WdReason",wdReason);
        otHdrVO.getCurrentRow().setAttribute("ApprovalTemplateId",
                                             new BigDecimal(1));
        ViewObject actionHisVO =
            ADFUtils.findIterator("XxQpActionHistoryTVO1Iterator").getViewObject();
        java.sql.Date dummyDate = null;
//        oracle.binding.OperationBinding opd =  ADFUtils.findOperation("deleteActionReqHist");
//        opd.getParamsMap().put("reqId", ((oracle.jbo.domain.Number)otHdrVO.getCurrentRow().getAttribute("ReqId")).bigDecimalValue())  ;
//        opd.execute();
//        
                
        //updateRequestForCWR	void	String, String, Number, String, Number
        oracle.binding.OperationBinding opu = ADFUtils.findOperation("updateRequestForCWR");
        opu.getParamsMap().put("reqStatus", "WITHDRAWN");
        opu.getParamsMap().put("reqNumber", otHdrVO.getCurrentRow().getAttribute("RequestNumber"));
        opu.getParamsMap().put("empId", (oracle.jbo.domain.Number)otHdrVO.getCurrentRow().getAttribute("EmpId"));
        opu.getParamsMap().put("reqType", (String)ADFContext.getCurrent().getSessionScope().get("page"));
        opu.getParamsMap().put("req_id", otHdrVO.getCurrentRow().getAttribute("ReqId"));
        opu.execute();
        
              
        oracle.binding.OperationBinding op = ADFUtils.findOperation("populateApproversForReqest");
        op.getParamsMap().put("reqStatus", "WITHDRAWN");
        op.getParamsMap().put("reqNumber", otHdrVO.getCurrentRow().getAttribute("RequestNumber"));
        op.getParamsMap().put("empId", (oracle.jbo.domain.Number)otHdrVO.getCurrentRow().getAttribute("EmpId"));
        op.getParamsMap().put("reqType", (String)ADFContext.getCurrent().getSessionScope().get("page"));
        op.getParamsMap().put("req_id", otHdrVO.getCurrentRow().getAttribute("ReqId"));
        op.execute();
        
        autoApproveRequest();
        ADFUtils.findOperation("Commit").execute();
        
        actionHisVO.executeQuery();
        
        
        op = ADFUtils.findOperation("prepareMailTemplateAndSend1");
        op.getParamsMap().put("approveOrReject", "W");
        op.execute();
        
        JSFUtils.addFacesInformationMessage("Request is Withdrawn!");
        //TODO : KMA : Send Email for manager
        //TODO : KMA : Send Email for employee also stating the request is withdrawn
        AdfFacesContext.getCurrentInstance().addPartialTarget(ot10);
        
        return "save";
    }
    public String reqMoreACL() {
        LoginBean usersb =
            (LoginBean) ADFUtils.evaluateEL("#{loginBean}");
        
        
        BigDecimal empId = new BigDecimal(usersb.getPersonId());
        ADFContext aDFContext = ADFContext.getCurrent();
        aDFContext.getPageFlowScope().put("mempId",empId);
        
        
        ViewObject otHdrVO =
            ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
        otHdrVO.getCurrentRow().setAttribute("Status", "Draft");
        otHdrVO.getCurrentRow().setAttribute("ReqStatus","REQUESTMOREINFO");
        //otHdrVO.getCurrentRow().setAttribute("ReqStatus","REQUESTMOREINFO");
        otHdrVO.getCurrentRow().setAttribute("ApprovalTemplateId",
                                             new BigDecimal(1));
        
        String reason = (String)aDFContext.getPageFlowScope().get("reqComment");
        oracle.jbo.domain.Number reqId = (oracle.jbo.domain.Number)otHdrVO.getCurrentRow().getAttribute("ReqId");
        oracle.binding.OperationBinding opures = ADFUtils.findOperation("updateRequestReasonForCWR");
        opures.getParamsMap().put("reqNumber", otHdrVO.getCurrentRow().getAttribute("RequestNumber"));
        opures.getParamsMap().put("req_id", reqId.bigDecimalValue());
        opures.getParamsMap().put("reason", reason);
        opures.getParamsMap().put("empLogged", usersb.getPersonId());
        opures.execute();
        
        
        ViewObject actionHisVO =
            ADFUtils.findIterator("XxQpActionHistoryTVO1Iterator").getViewObject();
        java.sql.Date dummyDate = null;
           
        actionHisVO.executeQuery();
        oracle.binding.OperationBinding opu = ADFUtils.findOperation("updateRequestForCWR");
        opu.getParamsMap().put("reqStatus", "REQUESTMOREINFO");
        opu.getParamsMap().put("reqNumber", otHdrVO.getCurrentRow().getAttribute("RequestNumber"));
        opu.getParamsMap().put("empId", (oracle.jbo.domain.Number)otHdrVO.getCurrentRow().getAttribute("EmpId"));
        opu.getParamsMap().put("reqType", (String)ADFContext.getCurrent().getSessionScope().get("page"));
        opu.getParamsMap().put("req_id", otHdrVO.getCurrentRow().getAttribute("ReqId"));
        opu.execute();
         
        actionHisVO.executeQuery();
        //ADFUtils.findOperation("Commit").execute();
        oracle.binding.OperationBinding op = ADFUtils.findOperation("populateApproversForReqest");
        op.getParamsMap().put("reqStatus", "REQUESTMOREINFO");
        op.getParamsMap().put("reqNumber", otHdrVO.getCurrentRow().getAttribute("RequestNumber"));
        op.getParamsMap().put("empId", (oracle.jbo.domain.Number)otHdrVO.getCurrentRow().getAttribute("EmpId"));
        op.getParamsMap().put("reqType", (String)ADFContext.getCurrent().getSessionScope().get("page"));
        op.getParamsMap().put("req_id", otHdrVO.getCurrentRow().getAttribute("ReqId"));
        op.execute();
        autoApproveRequest();
        ADFUtils.findOperation("Commit").execute();
        
        oracle.binding.OperationBinding op1 = ADFUtils.findOperation("prepareMailTemplateAndSend1");
        op1.getParamsMap().put("approveOrReject", "M");
        op1.execute();
                
        
        JSFUtils.addFacesInformationMessage("Requested employee to update more information");
        //TODO : KMA : Send Email for manager
        //TODO : KMA : Send Email for employee also stating the request is withdrawn
        AdfFacesContext.getCurrentInstance().addPartialTarget(ot10);
        return "save";
    }

    public void setAppMenu(RichCommandButton appMenu) {
        this.appMenu = appMenu;
    }

    public RichCommandButton getAppMenu() {
        return appMenu;
    }

    public String deleteReqACL() {
        LoginBean usersb =
            (LoginBean) ADFUtils.evaluateEL("#{loginBean}");
        
        
        BigDecimal empId = new BigDecimal(usersb.getPersonId());
        ADFContext aDFContext = ADFContext.getCurrent();
        aDFContext.getPageFlowScope().put("mempId",empId);
        String reason = (String)aDFContext.getPageFlowScope().get("cancelComment");
        ViewObject otHdrVO =
            ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
        otHdrVO.getCurrentRow().setAttribute("Status", "Draft");
        otHdrVO.getCurrentRow().setAttribute("CancelReason",reason);
        otHdrVO.getCurrentRow().setAttribute("ReqStatus","DELETED");
        ViewObject actionHisVO =
            ADFUtils.findIterator("XxQpActionHistoryTVO1Iterator").getViewObject();

        oracle.binding.OperationBinding opu = ADFUtils.findOperation("updateRequestForCWR");
        opu.getParamsMap().put("reqStatus", "DELETED");
        opu.getParamsMap().put("reqNumber", otHdrVO.getCurrentRow().getAttribute("RequestNumber"));
        opu.getParamsMap().put("empId", (oracle.jbo.domain.Number)otHdrVO.getCurrentRow().getAttribute("EmpId"));
        opu.getParamsMap().put("reqType", (String)ADFContext.getCurrent().getSessionScope().get("page"));
        opu.getParamsMap().put("req_id", otHdrVO.getCurrentRow().getAttribute("ReqId"));
        opu.execute();
         
        actionHisVO.executeQuery();
        //ADFUtils.findOperation("Commit").execute();
        actionHisVO.executeQuery();
        oracle.binding.OperationBinding op = ADFUtils.findOperation("populateApproversForReqest");
        op.getParamsMap().put("reqStatus", "DELETED");
        op.getParamsMap().put("reqNumber", otHdrVO.getCurrentRow().getAttribute("RequestNumber"));
        op.getParamsMap().put("empId", (oracle.jbo.domain.Number)otHdrVO.getCurrentRow().getAttribute("EmpId"));
        op.getParamsMap().put("reqType", (String)ADFContext.getCurrent().getSessionScope().get("page"));
        op.getParamsMap().put("req_id", otHdrVO.getCurrentRow().getAttribute("ReqId"));
        op.execute();
        autoApproveRequest();
        ADFUtils.findOperation("Commit").execute();
        
        op = ADFUtils.findOperation("prepareMailTemplateAndSend1");
        op.getParamsMap().put("approveOrReject", "C");
        op.execute();
        
        JSFUtils.addFacesInformationMessage("Request is cancelled successfully!");
        
        return "save";
    }

    public void setAttTable(RichTable attTable) {
        this.attTable = attTable;
    }

    public RichTable getAttTable() {
        return attTable;
    }

    public void salaryDateValVCL(ValueChangeEvent valueChangeEvent) {
        Calendar calendar = Calendar.getInstance();
        String Month = new SimpleDateFormat("MMM").format(calendar.getTime());
        System.err.println("start-->  " + Month);
        calendar.add(Calendar.MONTH, 1);
        String nextMonth =
            new SimpleDateFormat("MMM").format(calendar.getTime());
        System.err.println("start-->  " + nextMonth);

        DateFormat dateFormat =
            new SimpleDateFormat("yyyy-MM-dd"); ////2016/11/16
        //        DateFormat time = new SimpleDateFormat("kk:mm:ss");//12:08:43
        Date date = new Date();
        //    dateFormat.format(date);
        Set month = null;
        month.add("jan");
        month.add("feb");
        salStDt.setDisabledMonths(month);
        //        salStDt.setMinValue(new Date());
        AdfFacesContext.getCurrentInstance().addPartialTarget(salStDt);
        //        salStDt.setMaxValue();

        //        Date date = calendar.getTime();
        //        oracle.jbo.domain.Date domaiDay =
        //            (oracle.jbo.domain.Date)dayy.getNewValue();
        //        java.sql.Date sqldate = domaiDay.dateValue();
        //        date = new Date(sqldate.getTime());
        //        Date day = date;
    }

    public void setSalStDt(RichInputDate salStDt) {
        this.salStDt = salStDt;
    }

    public RichInputDate getSalStDt() {
        return salStDt;
    }

    public void setSoc2(RichSelectOneChoice soc2) {
        this.soc2 = soc2;
    }

    public RichSelectOneChoice getSoc2() {
        return soc2;
    }

    public void salChangeMonthVCL(ValueChangeEvent vce) {
        ViewObject variationSearchVo =
            ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
        variationSearchVo.getCurrentRow().setAttribute("Attribute1",
                                                       vce.getNewValue());
        //variationSearchVo.executeQuery();
    }

    public void setLeaveLOV(RichSelectOneChoice leaveLOV) {
        this.leaveLOV = leaveLOV;
    }

    public RichSelectOneChoice getLeaveLOV() {
        return leaveLOV;
    }


    public void setEmpLov(RichInputListOfValues empLov) {
        this.empLov = empLov;
    }

    public RichInputListOfValues getEmpLov() {
        return empLov;
    }

    public String editEduAC() {
        eduTable.setRendered(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(eduTable);

        eduPanel.setRendered(true);
        AdfFacesContext.getCurrentInstance().addPartialTarget(eduPanel);
        return null;
    }

    public String addEduAC() {
        eduTable.setRendered(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(eduTable);

        eduPanel.setRendered(true);
        AdfFacesContext.getCurrentInstance().addPartialTarget(eduPanel);
        return null;
    }

    public void setEduForm(RichPanelFormLayout eduForm) {
        this.eduForm = eduForm;
    }

    public RichPanelFormLayout getEduForm() {
        return eduForm;
    }

    public void setEduTable(RichPanelCollection eduTable) {
        this.eduTable = eduTable;
    }

    public RichPanelCollection getEduTable() {
        return eduTable;
    }

    public void setEduPanel(RichPanelBox eduPanel) {
        this.eduPanel = eduPanel;
    }

    public RichPanelBox getEduPanel() {
        return eduPanel;
    }

    public String closeForm() {
        eduTable.setRendered(true);
        AdfFacesContext.getCurrentInstance().addPartialTarget(eduTable);

        eduPanel.setRendered(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(eduPanel);
        return null;
    }

    public void addMessageToComp(String errMsg, String compId){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage(errMsg);
                            fm.setSummary(null);
                            fm.setDetail(errMsg);
                            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                        facesContext.addMessage(compId,fm);
    }
    public void childVCL(ValueChangeEvent semSel) {
        if (childTRANS.getValue() != null) {
            List comCheck = new ArrayList();
            String sem = (String)semSel.getNewValue();
            String semCheck = "";
            semSel.getComponent().processUpdates(FacesContext.getCurrentInstance());
            ViewObject otHdrVO =
                ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
            ViewObject lineVO =
                ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject(); //EmpId XxhcmOvertimeHeadersAllVO1Iterator1 XxhcmOvertimeDetailsAllVO2Iterator1
            if (lineVO.getEstimatedRowCount() > 1) {
                RowSetIterator rs = lineVO.createRowSetIterator(null);
                while (rs.hasNext()) {
                    Row cu = rs.next();
                    System.err.println("ss" + cu.getAttribute("Semester"));
                    System.err.println("ss" + cu.getAttribute("childTRANS"));
                    String combin =
                        (String)cu.getAttribute("childTRANS") + " " +
                        cu.getAttribute("Semester");
                    comCheck.add(combin);
                }
                rs.closeRowSetIterator();
                String childName = childTRANS.getValue().toString();
                String combin1 = childName + " " + sem;
                if (comCheck.contains(combin1)) {
                    //JSFUtils.addFacesInformationMessage("Already you Raised Educational Allowance for selected Semester!");
//                    semSOC.setValue("");
//                    AdfFacesContext.getCurrentInstance().addPartialTarget(semSOC);
//                    childTRANS.setValue("");
//                    AdfFacesContext.getCurrentInstance().addPartialTarget(childTRANS);
                    addMessageToComp("Already you Raised Educational Allowance for selected Semester!",semSel.getComponent().getClientId(FacesContext.getCurrentInstance()));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(semSOC);
                } else {
                    ViewObject childValidVO =
                        ADFUtils.findIterator("childValidationROVO1Iterator").getViewObject();

                    childValidVO.setNamedWhereClauseParam("emp",
                                                          lineVO.getCurrentRow().getAttribute("empIdTRANS"));
                    childValidVO.executeQuery();
                    if (childValidVO.getEstimatedRowCount() >= 3) {
                        if (childValidVO.getEstimatedRowCount() == 3) {
                            ViewObject childSemVO =
                                ADFUtils.findIterator("childSemROVO1Iterator").getViewObject();
                            childSemVO.setNamedWhereClauseParam("sem", sem);
                            childSemVO.setNamedWhereClauseParam("emp",
                                                                lineVO.getCurrentRow().getAttribute("empIdTRANS"));
                            childSemVO.setNamedWhereClauseParam("cont",
                                                                lineVO.getCurrentRow().getAttribute("Contactpersonid"));
                            childSemVO.executeQuery();
                            System.err.println("ssss- - " +
                                               childSemVO.getEstimatedRowCount());
                            ViewObject childSemCheckVO =
                                ADFUtils.findIterator("childSemCheckROVO1Iterator").getViewObject();
                            childSemCheckVO.setNamedWhereClauseParam("con",
                                                                     lineVO.getCurrentRow().getAttribute("Contactpersonid"));
                            childSemCheckVO.executeQuery();
                            System.err.println("check- - " +
                                               childSemCheckVO.getEstimatedRowCount());
                            if (childSemCheckVO.first() != null) {
                                semCheck =
                                        (String)childSemCheckVO.first().getAttribute("Semester");
                            }
                            if (childSemVO.getEstimatedRowCount() == 0) {


                                if (childSemCheckVO.getEstimatedRowCount() ==
                                    2) {
                                    addMessageToComp("Already you Raised Educational Allowance for 3 Childs!",semSel.getComponent().getClientId(FacesContext.getCurrentInstance()));
//                                    JSFUtils.addFacesInformationMessage("Already you Raised Educational Allowance for 3 Childs!");
//                                    semSOC.setValue("");
                                   AdfFacesContext.getCurrentInstance().addPartialTarget(semSOC);

                                } else {
                                    if (childSemCheckVO.first() != null) {
                                        if (sem.equals(semCheck)) {
                                            addMessageToComp("Already you Raised Educational Allowance for selected Semester!",semSel.getComponent().getClientId(FacesContext.getCurrentInstance()));
//                                            JSFUtils.addFacesInformationMessage("Already you Raised Educational Allowance for selected Semester!");
//                                            semSOC.setValue("");
                                            AdfFacesContext.getCurrentInstance().addPartialTarget(semSOC);
                                        }

                                    } else {
                                        addMessageToComp("Already you Raised Educational Allowance for 3 Childs!!",semSel.getComponent().getClientId(FacesContext.getCurrentInstance()));
//                                        JSFUtils.addFacesInformationMessage("Already you Raised Educational Allowance for 3 Childs!!");
//                                        semSOC.setValue("");
                                        AdfFacesContext.getCurrentInstance().addPartialTarget(semSOC);
                                    }


                                }

                            } else {
                                if (childSemVO.getEstimatedRowCount() == 1) {
                                    addMessageToComp("Already you Raised Educational Allowance for selected Semester!",semSel.getComponent().getClientId(FacesContext.getCurrentInstance()));
//                                    JSFUtils.addFacesInformationMessage("Already you Raised Educational Allowance for selected Semester!");
//                                    semSOC.setValue("");
AdfFacesContext.getCurrentInstance().addPartialTarget(semSOC);
                                }


                            }

                        } else {
                            addMessageToComp("Already you Raised Educational Allowance for 3 Childs!",semSel.getComponent().getClientId(FacesContext.getCurrentInstance()));
//                            JSFUtils.addFacesInformationMessage("Already you Raised Educational Allowance for 3 Childs!");
//                            semSOC.setValue("");
                            AdfFacesContext.getCurrentInstance().addPartialTarget(semSOC);
                        }
                    } else {

                        ViewObject childSemVO =
                            ADFUtils.findIterator("childSemROVO1Iterator").getViewObject();
                        childSemVO.setNamedWhereClauseParam("sem", sem);
                        childSemVO.setNamedWhereClauseParam("emp",
                                                            lineVO.getCurrentRow().getAttribute("empIdTRANS"));
                        childSemVO.setNamedWhereClauseParam("cont",
                                                            lineVO.getCurrentRow().getAttribute("Contactpersonid"));
                        childSemVO.executeQuery();
                        if (childSemVO.first() != null) {
                            addMessageToComp("Already you Raised Educational Allowance for selected Semester!",semSel.getComponent().getClientId(FacesContext.getCurrentInstance()));
//                            JSFUtils.addFacesInformationMessage("Already you Raised Educational Allowance for selected Semester!");
//                            semSOC.setValue("");
                            AdfFacesContext.getCurrentInstance().addPartialTarget(semSOC);
                        }

                    }
                }

            } else {
                ViewObject childValidVO =
                    ADFUtils.findIterator("childValidationROVO1Iterator").getViewObject();

                childValidVO.setNamedWhereClauseParam("emp",
                                                      lineVO.getCurrentRow().getAttribute("empIdTRANS"));
                childValidVO.executeQuery();
                if (childValidVO.getEstimatedRowCount() >= 3) {
                    if (childValidVO.getEstimatedRowCount() == 3) {
                        ViewObject childSemVO =
                            ADFUtils.findIterator("childSemROVO1Iterator").getViewObject();
                        childSemVO.setNamedWhereClauseParam("sem", sem);
                        childSemVO.setNamedWhereClauseParam("emp",
                                                            lineVO.getCurrentRow().getAttribute("empIdTRANS"));
                        childSemVO.setNamedWhereClauseParam("cont",
                                                            lineVO.getCurrentRow().getAttribute("Contactpersonid"));
                        childSemVO.executeQuery();
                        System.err.println("ssss- - " +
                                           childSemVO.getEstimatedRowCount());
                        ViewObject childSemCheckVO =
                            ADFUtils.findIterator("childSemCheckROVO1Iterator").getViewObject();
                        childSemCheckVO.setNamedWhereClauseParam("con",
                                                                 lineVO.getCurrentRow().getAttribute("Contactpersonid"));
                        childSemCheckVO.executeQuery();
                        System.err.println("check- - " +
                                           childSemCheckVO.getEstimatedRowCount());
                        if (childSemCheckVO.first() != null) {
                            semCheck =
                                    (String)childSemCheckVO.first().getAttribute("Semester");
                        }
                        if (childSemVO.getEstimatedRowCount() == 0) {


                            if (childSemCheckVO.getEstimatedRowCount() == 2) {
                                addMessageToComp("Already you Raised Educational Allowance for 3 Childs!",semSel.getComponent().getClientId(FacesContext.getCurrentInstance()));
//                                JSFUtils.addFacesInformationMessage("Already you Raised Educational Allowance for 3 Childs!");
//                                semSOC.setValue("");
                                AdfFacesContext.getCurrentInstance().addPartialTarget(semSOC);

                            } else {
                                if (childSemCheckVO.first() != null) {
                                    if (sem.equals(semCheck)) {
                                        addMessageToComp("Already you Raised Educational Allowance for selected Semester!",semSel.getComponent().getClientId(FacesContext.getCurrentInstance()));
//                                        JSFUtils.addFacesInformationMessage("Already you Raised Educational Allowance for selected Semester!");
//                                        semSOC.setValue("");
                                        AdfFacesContext.getCurrentInstance().addPartialTarget(semSOC);
                                    }

                                } else {
                                    addMessageToComp("Already you Raised Educational Allowance for 3 Childs!",semSel.getComponent().getClientId(FacesContext.getCurrentInstance()));
//                                    JSFUtils.addFacesInformationMessage("Already you Raised Educational Allowance for 3 Childs!!");
//                                    semSOC.setValue("");
                                    AdfFacesContext.getCurrentInstance().addPartialTarget(semSOC);
                                }


                            }

                        } else {
                            if (childSemVO.getEstimatedRowCount() == 1) {
                                addMessageToComp("Already you Raised Educational Allowance for selected Semester!",semSel.getComponent().getClientId(FacesContext.getCurrentInstance()));
//                                JSFUtils.addFacesInformationMessage("Already you Raised Educational Allowance for selected Semester!");
//                                semSOC.setValue("");
                                AdfFacesContext.getCurrentInstance().addPartialTarget(semSOC);
                            }


                        }

                    } else {
                        addMessageToComp("Already you Raised Educational Allowance for 3 Childs!",semSel.getComponent().getClientId(FacesContext.getCurrentInstance()));
//                        JSFUtils.addFacesInformationMessage("Already you Raised Educational Allowance for 3 Childs!");
//                        semSOC.setValue("");
                        AdfFacesContext.getCurrentInstance().addPartialTarget(semSOC);
                    }
                } else {

                    ViewObject childSemVO =
                        ADFUtils.findIterator("childSemROVO1Iterator").getViewObject();
                    childSemVO.setNamedWhereClauseParam("sem", sem);
                    childSemVO.setNamedWhereClauseParam("emp",
                                                        lineVO.getCurrentRow().getAttribute("empIdTRANS"));
                    childSemVO.setNamedWhereClauseParam("cont",
                                                        lineVO.getCurrentRow().getAttribute("Contactpersonid"));
                    childSemVO.executeQuery();
                    if (childSemVO.first() != null) {
                        addMessageToComp("Already you Raised Educational Allowance for selected Semester!",semSel.getComponent().getClientId(FacesContext.getCurrentInstance()));
//                        JSFUtils.addFacesInformationMessage("Already you Raised Educational Allowance for selected Semester!");
//                        semSOC.setValue("");
                        AdfFacesContext.getCurrentInstance().addPartialTarget(semSOC);
                    }

                }
            }

        } else {
            addMessageToComp("Please select Child!",semSel.getComponent().getClientId(FacesContext.getCurrentInstance()));
//            JSFUtils.addFacesInformationMessage("Please select Child!");
//            semSOC.setValue("");
            AdfFacesContext.getCurrentInstance().addPartialTarget(semSOC);
        }


    }

    public void setSemSOC(RichSelectOneChoice semSOC) {
        this.semSOC = semSOC;
    }

    public RichSelectOneChoice getSemSOC() {
        return semSOC;
    }

    public void setChildTRANS(RichInputListOfValues childTRANS) {
        this.childTRANS = childTRANS;
    }

    public RichInputListOfValues getChildTRANS() {
        return childTRANS;
    }

    public void actAmtVCL(ValueChangeEvent actAmt) {
        actAmt.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject lineVO =
            ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject(); //EmpId XxhcmOvertimeHeadersAllVO1Iterator1 XxhcmOvertimeDetailsAllVO2Iterator1
        if (actAmt.getNewValue() != null) {

            if (lineVO.getEstimatedRowCount() == 1) {
                BigDecimal actAm = (BigDecimal)actAmt.getNewValue();
                BigDecimal maxAm = (BigDecimal)maxAmt.getValue();
                BigDecimal avlAm = maxAm.subtract(actAm);
                avlAmt.setValue(avlAm);
                AdfFacesContext.getCurrentInstance().addPartialTarget(avlAmt);
            } else {

                ViewObject hcmDtls =
                    ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO1Iterator").getViewObject();

                ViewCriteria vc = hcmDtls.createViewCriteria();
                ViewCriteriaRow vcr = vc.createViewCriteriaRow();
                vcr.setAttribute("Contactpersonid",
                                 lineVO.getCurrentRow().getAttribute("Contactpersonid"));
                vcr.setAttribute("empIdTRANS",
                                 lineVO.getCurrentRow().getAttribute("empIdTRANS"));
                vc.addRow(vcr);
                hcmDtls.applyViewCriteria(vc);
                hcmDtls.executeQuery();
                System.err.println("ssss- - " +
                                   hcmDtls.getEstimatedRowCount());

                BigDecimal chilAvl = new BigDecimal(0);
                if (hcmDtls.getEstimatedRowCount() == 1) {
                    chilAvl =
                            (BigDecimal)hcmDtls.first().getAttribute("AvlAmt");
                }
                RowSetIterator rs = lineVO.createRowSetIterator(null);
                BigDecimal avlAmt1 = new BigDecimal(0);
                while (rs.hasNext()) {
                    Row cu = rs.next();
                    System.err.println("ss" + cu.getAttribute("MaxAmt"));
                    System.err.println("ss" + cu.getAttribute("AvlAmt"));
                    avlAmt1.add((BigDecimal)cu.getAttribute("AvlAmt"));
                }
rs.closeRowSetIterator();
            }
        }
    }

    public void setMaxAmt(RichInputText maxAmt) {
        this.maxAmt = maxAmt;
    }

    public RichInputText getMaxAmt() {
        return maxAmt;
    }

    public void setAvlAmt(RichInputText avlAmt) {
        this.avlAmt = avlAmt;
    }

    public RichInputText getAvlAmt() {
        return avlAmt;
    }

    public void BusinessTravelReqVCL(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        Object busTravlReqNum = ADFUtils.evaluateEL("#{bindings.BussTravReqNum.inputValue}");
        ADFContext.getCurrent().getPageFlowScope().put("bussTripReqNo",
                                                       busTravlReqNum);
        System.err.println("HEllo---" + busTravlReqNum);
        ViewObject hdr2 =
            ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO1Iterator1").getViewObject();
        ViewCriteria vcc = hdr2.createViewCriteria();
        ViewCriteriaRow vccr = vcc.createViewCriteriaRow();
        vccr.setAttribute("ReqId", busTravlReqNum);
        vcc.addRow(vccr);
        hdr2.applyViewCriteria(vcc);
        hdr2.executeQuery();
        System.err.println("ROW Count---" + hdr2.getEstimatedRowCount());
        if (hdr2.getEstimatedRowCount() > 0) {
            Row oldRow = hdr2.first();
            ViewObject hdr3 =
                ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject();
            Row currRow = hdr3.getCurrentRow();
            System.err.println("Welcome--" + oldRow.getAttribute("TripType") ==
                               null ? "" : oldRow.getAttribute("TripType"));
            currRow.setAttribute("TripType",
                                 oldRow.getAttribute("TripType") == null ? "" :
                                 oldRow.getAttribute("TripType"));
//            currRow.setAttribute("BussTravReqNumValue",
//                                 oldRow.getAttribute("BussTravReqNumValue") == null ? "" :
//                                 oldRow.getAttribute("BussTravReqNumValue"));
            currRow.setAttribute("AirlineTicketType",
                                 oldRow.getAttribute("AirlineTicketType") ==
                                 null ? "" :
                                 oldRow.getAttribute("AirlineTicketType"));
            currRow.setAttribute("StartDate",
                                 oldRow.getAttribute("StartDate") == null ?
                                 "" : oldRow.getAttribute("StartDate"));
            currRow.setAttribute("EndDate",
                                 oldRow.getAttribute("EndDate") == null ? "" :
                                 oldRow.getAttribute("EndDate"));


            currRow.setAttribute("OrigStartDate",
                                        oldRow.getAttribute("StartDate") == null ?
                                        "" : oldRow.getAttribute("StartDate"));
            currRow.setAttribute("OrigEndDate",
                                        oldRow.getAttribute("EndDate") == null ? "" :
                                        oldRow.getAttribute("EndDate"));


            currRow.setAttribute("DestCategory",
                                 oldRow.getAttribute("DestCategory") == null ?
                                 "" : oldRow.getAttribute("DestCategory"));
            currRow.setAttribute("NumberOfDays",
                                 oldRow.getAttribute("NumberOfDays") == null ?
                                 "" : oldRow.getAttribute("NumberOfDays"));
            currRow.setAttribute("ExitRerentryVisa",
                                 oldRow.getAttribute("ExitRerentryVisa") ==
                                 null ? "" :
                                 oldRow.getAttribute("ExitRerentryVisa"));
            currRow.setAttribute("DestVisaRequired",
                                 oldRow.getAttribute("DestVisaRequired") ==
                                 null ? "" :
                                 oldRow.getAttribute("DestVisaRequired"));
            currRow.setAttribute("DestinationCountry",
                                 oldRow.getAttribute("DestinationCountry") ==
                                 null ? "" :
                                 oldRow.getAttribute("DestinationCountry"));
            currRow.setAttribute("DestCountryCity",
                                 oldRow.getAttribute("DestCountryCity") ==
                                 null ? "" :
                                 oldRow.getAttribute("DestCountryCity"));
            currRow.setAttribute("ProjType",
                                 oldRow.getAttribute("ProjType") == null ? "" :
                                 oldRow.getAttribute("ProjType"));
            currRow.setAttribute("AdvPerdiem",
                                 oldRow.getAttribute("AdvPerdiem") == null ?
                                 "" : oldRow.getAttribute("AdvPerdiem"));
            
            if(currRow.getAttribute("AdvPerdiem") != null && "NO".equalsIgnoreCase(currRow.getAttribute("AdvPerdiem").toString())){
                currRow.setAttribute("OrigStartDate", null);
                currRow.setAttribute("OrigEndDate", null);
            }
            
            currRow.setAttribute("Description",
                                 oldRow.getAttribute("Description") == null ?
                                 "" : oldRow.getAttribute("Description"));
            currRow.setAttribute("Comments",
                                 oldRow.getAttribute("Comments") == null ? "" :
                                 oldRow.getAttribute("Comments"));
            ViewObject otHdrVO =
                ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
            
            oracle.binding.OperationBinding op = ADFUtils.findOperation("getPerDMRate");
            op.getParamsMap().put("dest", oldRow.getAttribute("DestCategory"));
                    op.getParamsMap().put("grade", otHdrVO.getCurrentRow().getAttribute("gradeTRANS"));
                    oracle.jbo.domain.Number perdiem =(oracle.jbo.domain.Number)op.execute();
                    if(perdiem!=null)
                    currRow.setAttribute("PerdiemPerDay", perdiem.bigDecimalValue());
                    AdfFacesContext.getCurrentInstance().addPartialTarget(prDM);
            ViewObject lineVO =
                ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject();
            String noOfDays =
                lineVO.getCurrentRow().getAttribute("NumberOfDays") == null ? "0" :
                lineVO.getCurrentRow().getAttribute("NumberOfDays").toString();
            String perdimday =
                lineVO.getCurrentRow().getAttribute("PerdiemPerDay") == null ?
                "0" :
                lineVO.getCurrentRow().getAttribute("PerdiemPerDay").toString();

            BigDecimal NoofDays = new BigDecimal(noOfDays);
            BigDecimal Perdiem = new BigDecimal(perdimday);

            BigDecimal Total = NoofDays.multiply(Perdiem);

//            this.totPerdiem.setValue(Total);
            ADFUtils.setEL("#{bindings.TotalPerdiem.inputValue}", Total);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.noOfDays);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.totPerdiem);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.totalAmount);
                
            ViewObjectImpl oldPurposeVO =
                (ViewObjectImpl) ADFUtils.findIterator("XxhcmPurposeOfTrvl_VO2Iterator").getViewObject();
            System.err.println("purpose vo row count : "+oldPurposeVO.getEstimatedRowCount());
            ViewObjectImpl newPurposeVO =
                (ViewObjectImpl) ADFUtils.findIterator("XxhcmPurposeOfTrvl_VO1Iterator").getViewObject();
            System.err.println("purpose vo row count : "+newPurposeVO.getEstimatedRowCount());
            RowSetIterator rs  = oldPurposeVO.createRowSetIterator(null);
            RowSetIterator rsNew = newPurposeVO.createRowSetIterator(null);
            if(rsNew.first()!=null){
            rsNew.first().remove();
            }
            while(rsNew.hasNext()){
                rsNew.next().remove();
            }
            rsNew.closeRowSetIterator();
            while(rs.hasNext()){
                Row oldPurposeRow = rs.next();
                Row newPurposeRow = newPurposeVO.createRow();
                newPurposeRow.setAttribute("StartDate",
                                     oldPurposeRow.getAttribute("StartDate") == null ? "" :
                                     oldPurposeRow.getAttribute("StartDate"));
                newPurposeRow.setAttribute("EndDate",
                                     oldPurposeRow.getAttribute("EndDate") == null ? "" :
                                     oldPurposeRow.getAttribute("EndDate"));
                newPurposeRow.setAttribute("Activity",
                                     oldPurposeRow.getAttribute("Activity") == null ? "" :
                                     oldPurposeRow.getAttribute("Activity"));
                newPurposeVO.insertRow(newPurposeRow);
            }
            
        }


    }

    public void onCalculateNoOfDays() {
        ViewObject lineVO =
            ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject();
        System.err.println("StartDate" +
                           lineVO.getCurrentRow().getAttribute("StartDate"));

        if (lineVO.getCurrentRow().getAttribute("StartDate") != null &&
            lineVO.getCurrentRow().getAttribute("EndDate") != null) {
            String dateStart =
                lineVO.getCurrentRow().getAttribute("StartDate").toString();
            String dateEnd =
                lineVO.getCurrentRow().getAttribute("EndDate").toString();

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date d1 = null;
            Date d2 = null;


            try {
                d1 = format.parse(dateStart);
                d2 = format.parse(dateEnd);
                int diff =
                    (int)((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));

                System.err.println("Diff" + diff);
                diff = diff + 1;
                Object temp = this.getDestCategoryLOV().getValue();
                System.err.println("temp Objetc" + temp);
                if (temp != null) {
                    String descCat = temp.toString();
                    if (descCat.equalsIgnoreCase("GCC")) {
                        diff = diff + 1;
                        this.noOfDays.setValue(diff);
                    } else if (descCat.equalsIgnoreCase("Other Countries")) {
                        diff = diff + 2;
                        this.noOfDays.setValue(diff);
                    } else if (descCat.equalsIgnoreCase("Saudi Arabia")) {
                        this.noOfDays.setValue(diff);
                    }
                    AdfFacesContext.getCurrentInstance().addPartialTarget(this.noOfDays);
                }


            } catch (ParseException e) {
            }
        }


    }

    public void onChangeStartDate(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());

        onCalculateNoOfDays();
        if(ADFUtils.findIterator("XxhcmPurposeOfTrvl_VO1Iterator").getViewObject().first() != null){
            ADFUtils.findIterator("XxhcmPurposeOfTrvl_VO1Iterator").getViewObject().first().setAttribute("StartDate", valueChangeEvent.getNewValue());
            purposeOfTrvTable.resetStampState();
            ResetUtils.reset(purposeOfTrvTable);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.purposeOfTrvTable);
        }
    }

    public void onChangeEndDate(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        onCalculateNoOfDays();
        purposeOfTrvTable.resetStampState();
        ResetUtils.reset(purposeOfTrvTable);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.purposeOfTrvTable);
    }
    
    public void onCalculateNoOfActualDays() {
        ViewObject lineVO =
            ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject();
        System.err.println("StartDate" +
                           lineVO.getCurrentRow().getAttribute("OrigStartDate"));

        if (lineVO.getCurrentRow().getAttribute("OrigStartDate") != null &&
            lineVO.getCurrentRow().getAttribute("OrigEndDate") != null) {
            String dateStart =
                lineVO.getCurrentRow().getAttribute("OrigStartDate").toString();
            String dateEnd =
                lineVO.getCurrentRow().getAttribute("OrigEndDate").toString();

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date d1 = null;
            Date d2 = null;


            try {
                d1 = format.parse(dateStart);
                d2 = format.parse(dateEnd);
                int diff =
                    (int)((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));

                System.err.println("Diff" + diff);
                diff = diff + 1;
                Object temp = this.getDestCategoryLOV().getValue();
                System.err.println("temp Objetc" + temp);
                if (temp != null) {
                    String descCat = temp.toString();
                    if (descCat.equalsIgnoreCase("GCC")) {
                        diff = diff + 1;
                        this.bstNoOfDays.setValue(diff);
                    } else if (descCat.equalsIgnoreCase("Other Countries")) {
                        diff = diff + 2;
                        this.bstNoOfDays.setValue(diff);
                    } else if (descCat.equalsIgnoreCase("Saudi Arabia")) {
                        this.bstNoOfDays.setValue(diff);
                    }
                    AdfFacesContext.getCurrentInstance().addPartialTarget(this.bstNoOfDays);
                }
                
                String perdimday =
                    lineVO.getCurrentRow().getAttribute("PerdiemPerDay") == null ?
                    "0" :
                    lineVO.getCurrentRow().getAttribute("PerdiemPerDay").toString();

                BigDecimal NoofDays = new BigDecimal(diff);
                BigDecimal Perdiem = new BigDecimal(perdimday);
                lineVO.getCurrentRow().setAttribute("NumberOfDays", NoofDays);
                BigDecimal Total = NoofDays.multiply(Perdiem);
                
                ADFUtils.setEL("#{bindings.TotalPerdiem.inputValue}", Total);
//                this.totPerdiem.setValue(Total);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.totPerdiem);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.totalAmount);


            } catch (ParseException e) {
            }
        }
    }
    
    public void onCalculateNoOfDaysInBTC() {
        ViewObject lineVO =
            ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject();
        System.err.println("StartDate" +
                           lineVO.getCurrentRow().getAttribute("StartDate"));

        if (lineVO.getCurrentRow().getAttribute("StartDate") != null &&
            lineVO.getCurrentRow().getAttribute("EndDate") != null) {
            String dateStart =
                lineVO.getCurrentRow().getAttribute("StartDate").toString();
            String dateEnd =
                lineVO.getCurrentRow().getAttribute("EndDate").toString();

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date d1 = null;
            Date d2 = null;


            try {
                d1 = format.parse(dateStart);
                d2 = format.parse(dateEnd);
                int diff =
                    (int)((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));

                System.err.println("Diff" + diff);
                diff = diff + 1;
                Object temp = this.getDestCategoryLOV().getValue();
                System.err.println("temp Objetc" + temp);
                if (temp != null) {
                    String descCat = temp.toString();
                    if (descCat.equalsIgnoreCase("GCC")) {
                        diff = diff + 1;
                        this.bstNoOfDays.setValue(diff);
                    } else if (descCat.equalsIgnoreCase("Other Countries")) {
                        diff = diff + 2;
                        this.bstNoOfDays.setValue(diff);
                    } else if (descCat.equalsIgnoreCase("Saudi Arabia")) {
                        this.bstNoOfDays.setValue(diff);
                    }
                    AdfFacesContext.getCurrentInstance().addPartialTarget(this.bstNoOfDays);
                }
                
                String perdimday =
                    lineVO.getCurrentRow().getAttribute("PerdiemPerDay") == null ?
                    "0" :
                    lineVO.getCurrentRow().getAttribute("PerdiemPerDay").toString();

                BigDecimal NoofDays = new BigDecimal(diff);
                BigDecimal Perdiem = new BigDecimal(perdimday);
                lineVO.getCurrentRow().setAttribute("NumberOfDays", NoofDays);
                BigDecimal Total = NoofDays.multiply(Perdiem);
                
                ADFUtils.setEL("#{bindings.TotalPerdiem.inputValue}", Total);
    //                this.totPerdiem.setValue(Total);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.totPerdiem);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.totalAmount);


            } catch (ParseException e) {
            }
        }
    }

    public void setNoOfDays(RichInputText noOfDays) {
        this.noOfDays = noOfDays;
    }

    public RichInputText getNoOfDays() {
        return noOfDays;
    }

    public void onChangePerdim(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject lineVO =
            ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject();
        String noOfDays =
            lineVO.getCurrentRow().getAttribute("NumberOfDays") == null ? "0" :
            lineVO.getCurrentRow().getAttribute("NumberOfDays").toString();
        String perdimday =
            lineVO.getCurrentRow().getAttribute("PerdiemPerDay") == null ?
            "0" :
            lineVO.getCurrentRow().getAttribute("PerdiemPerDay").toString();

        BigDecimal NoofDays = new BigDecimal(noOfDays);
        BigDecimal Perdiem = new BigDecimal(perdimday);

        BigDecimal Total = NoofDays.multiply(Perdiem);

        this.totPerdiem.setValue(Total);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.noOfDays);


    }

    public void setTotPerdiem(RichInputText totPerdiem) {
        this.totPerdiem = totPerdiem;
    }

    public RichInputText getTotPerdiem() {
        return totPerdiem;
    }

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }


    public void onChangeDestCategory(ValueChangeEvent valueChangeEvent) {
        System.err.println("welcome---" + valueChangeEvent.getNewValue());
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        onCalculateNoOfDays();
        oracle.binding.OperationBinding op = ADFUtils.findOperation("getAirTicketType");
        op.getParamsMap().put("dest", valueChangeEvent.getNewValue());
        String tCType = (String)op.execute();
        ADFContext.getCurrent().getPageFlowScope().put("airTicket",tCType);
        
        ViewObject lineVO =
            ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject();
        lineVO.getCurrentRow().setAttribute("AirlineTicketType",tCType);
        AdfFacesContext.getCurrentInstance().addPartialTarget(btAirtickTyp);
    }


    public void setDestCategoryLOV(RichSelectOneChoice destCategoryLOV) {
        this.destCategoryLOV = destCategoryLOV;
    }

    public RichSelectOneChoice getDestCategoryLOV() {
        return destCategoryLOV;
    }

    public void setBstStDt(RichInputDate bstStDt) {
        this.bstStDt = bstStDt;
    }

    public RichInputDate getBstStDt() {
        return bstStDt;
    }

    public void setBstEdDt(RichInputDate bstEdDt) {
        this.bstEdDt = bstEdDt;
    }

    public RichInputDate getBstEdDt() {
        return bstEdDt;
    }

    public void setBstDestCateLOV(RichSelectOneChoice bstDestCateLOV) {
        this.bstDestCateLOV = bstDestCateLOV;
    }

    public RichSelectOneChoice getBstDestCateLOV() {
        return bstDestCateLOV;
    }

    public void setBstNoOfDays(RichInputText bstNoOfDays) {
        this.bstNoOfDays = bstNoOfDays;
    }

    public RichInputText getBstNoOfDays() {
        return bstNoOfDays;
    }

    public void setBtAirtickTyp(RichSelectOneChoice btAirtickTyp) {
        this.btAirtickTyp = btAirtickTyp;
    }

    public RichSelectOneChoice getBtAirtickTyp() {
        return btAirtickTyp;
    }

    public void onChangeAirTicketType(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        System.err.println("=========" + valueChangeEvent.getNewValue());
        ADFContext.getCurrent().getPageFlowScope().put("airTicket",
                                                       valueChangeEvent.getNewValue());


    }

    public void onChangeDestCountryCity(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        System.err.println("=========" + valueChangeEvent.getNewValue());
        ADFContext.getCurrent().getPageFlowScope().put("DestCount",
                                                       valueChangeEvent.getNewValue());
        ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getCurrentRow().setAttribute("DestCountryCity", valueChangeEvent.getNewValue());
    }
    
    public void onChangeDestCountry(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        System.err.println("=========" + valueChangeEvent.getNewValue());
        ADFContext.getCurrent().getPageFlowScope().put("DestCountry",
                                                       valueChangeEvent.getNewValue());
        ADFContext.getCurrent().getSessionScope().put("CurrentCountry", valueChangeEvent.getNewValue());
        countryValue= (BigDecimal)valueChangeEvent.getNewValue();
        ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getCurrentRow().setAttribute("DestinationCountry", valueChangeEvent.getNewValue());
    }

    public void actualSdate(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());

        onCalculateNoOfActualDays();

    }

    public void actualEdate(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());

        onCalculateNoOfActualDays();

    }

    public void setBussTravelReqNo(RichSelectOneChoice bussTravelReqNo) {
        this.bussTravelReqNo = bussTravelReqNo;
    }

    public RichSelectOneChoice getBussTravelReqNo() {
        return bussTravelReqNo;
    }

    public void setLeaveLov(RichInputListOfValues leaveLov) {
        this.leaveLov = leaveLov;
    }

    public RichInputListOfValues getLeaveLov() {
        return leaveLov;
    }

    public void setBussTrReq1(RichInputListOfValues bussTrReq1) {
        this.bussTrReq1 = bussTrReq1;
    }

    public RichInputListOfValues getBussTrReq1() {
        return bussTrReq1;
    }

    public void setPrDM(RichInputText prDM) {
        this.prDM = prDM;
    }

    public RichInputText getPrDM() {
        return prDM;
    }

    public void changeCurrency(ValueChangeEvent valueChangeEvent) {
        ViewObject lineVO =
            ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject();
        ViewObject otHdrVO =
            ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
        
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        BindingContainer container = BindingContext.getCurrent().getCurrentBindingsEntry();  
           valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());  
           AttributeBinding attrIdBinding = (AttributeBinding)container.getControlBinding("Currency");  
           //Deptno is ID of an Attribute Binding in pageDef 
          
           String Id = (String)attrIdBinding.getInputValue();  
           System.out.println("selected currency =>"+Id);
           

        ADFUtils.findIterator("XxhcmOtherExpenseTVO1Iterator").getCurrentRow().setAttribute("OtherExpn", null);
        ADFUtils.findIterator("XxhcmOtherExpenseTVO1Iterator").getCurrentRow().setAttribute("TotalAmount", null);
           
           if(Id != null && "SAR".equalsIgnoreCase(Id)){
               ADFUtils.findIterator("XxhcmOtherExpenseTVO1Iterator").getCurrentRow().setAttribute("ExchnRate", new BigDecimal(1));
           }
           else{
        oracle.binding.OperationBinding op = ADFUtils.findOperation("getCurrwncyRate");
        op.getParamsMap().put("fromcurr", valueChangeEvent.getNewValue());
                op.getParamsMap().put("grade", otHdrVO.getCurrentRow().getAttribute("gradeTRANS"));
                oracle.jbo.domain.Number currRate =(oracle.jbo.domain.Number)op.execute();
                if(currRate!=null){
        ADFUtils.findIterator("XxhcmOtherExpenseTVO1Iterator").getCurrentRow().setAttribute("ExchnRate", currRate.bigDecimalValue());
                }else{
JSFUtils.addFacesErrorMessage("No Exchange rate available for the request date");
                }
           }
    }

    public void changeExpAmount(ValueChangeEvent valueChangeEvent) {
        BigDecimal inputAmt = (BigDecimal)valueChangeEvent.getNewValue();
        BigDecimal exchRate = (BigDecimal)ADFUtils.findIterator("XxhcmOtherExpenseTVO1Iterator").getCurrentRow().getAttribute("ExchnRate");
        if(inputAmt!=null)
        ADFUtils.findIterator("XxhcmOtherExpenseTVO1Iterator").getCurrentRow().setAttribute("TotalAmount", inputAmt.multiply(exchRate));
    }

    public void addNewChildRow(ActionEvent actionEvent) {
        ViewObject variationSearchVo =
            ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
        ViewObject lineVO =
            ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator1").getViewObject();
        oracle.binding.OperationBinding op = ADFUtils.findOperation("CreateInsert2");
        op.execute();
        BigDecimal empId = ((oracle.jbo.domain.Number)variationSearchVo.getCurrentRow().getAttribute("EmpId")).getBigDecimalValue();
        BigDecimal maxAmt = fetchMaxAmountForEmployee(empId);
        lineVO.getCurrentRow().setAttribute("MaxAmt", maxAmt);
        lineVO.getCurrentRow().setAttribute("AvlAmt", maxAmt);
        AdfFacesContext.getCurrentInstance().addPartialTarget(eduTable);
    }
    
//    public BigDecimal fetchAvlAmountForChild(BigDecimal childId, java.sql.Date invDate, BigDecimal maxAmt){


    public void invDateVC(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject lineVO =
            ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator1").getViewObject();
        BigDecimal avlAmt = calculateAvlAmtForChild((BigDecimal) lineVO.getCurrentRow().getAttribute("Contactpersonid"),
                                    (java.sql.Date) lineVO.getCurrentRow().getAttribute("InvDate"),
                                    (BigDecimal) lineVO.getCurrentRow().getAttribute("MaxAmt"));
        lineVO.getCurrentRow().setAttribute("AvlAmt", avlAmt);
//        BigDecimal empId = ((oracle.jbo.domain.Number)otHdrVO.getCurrentRow().getAttribute("EmpId")).getBigDecimalValue();
//        Boolean isValid = validateForMaxThreeChilds(empId,
//                                      (java.sql.Date) lineVO.getCurrentRow().getAttribute("InvDate"),
//                                                    (BigDecimal) lineVO.getCurrentRow().getAttribute("Contactpersonid"));
//        if(isValid == null || !isValid){
//            JSFUtils.addFacesErrorMessage("Claim is allowed only for a maximum of three childs per year.");
//        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(eduTable);
    }
    
    private BigDecimal calculateAvlAmtForChild(BigDecimal childId, java.sql.Date invDate, BigDecimal maxAmt){
        oracle.binding.OperationBinding op = ADFUtils.findOperation("fetchAvlAmountForChild");
        op.getParamsMap().put("childId", childId);
        op.getParamsMap().put("invDate", invDate);
        op.getParamsMap().put("maxAmt", maxAmt);
        BigDecimal avlAmt = (BigDecimal) op.execute();
        return avlAmt;
    }

    public void childVC(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject lineVO =
            ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator1").getViewObject();
        BigDecimal avlAmt = calculateAvlAmtForChild((BigDecimal) lineVO.getCurrentRow().getAttribute("Contactpersonid"),
                                    (java.sql.Date) lineVO.getCurrentRow().getAttribute("InvDate"),
                                    (BigDecimal) lineVO.getCurrentRow().getAttribute("MaxAmt"));
        lineVO.getCurrentRow().setAttribute("AvlAmt", avlAmt);
//        BigDecimal empId = ((oracle.jbo.domain.Number)otHdrVO.getCurrentRow().getAttribute("EmpId")).getBigDecimalValue();
//        Boolean isValid = validateForMaxThreeChilds(empId,
//                                      (java.sql.Date) lineVO.getCurrentRow().getAttribute("InvDate"),
//                                                    (BigDecimal) lineVO.getCurrentRow().getAttribute("Contactpersonid"));
//        if(isValid == null || !isValid){
//            JSFUtils.addFacesErrorMessage("Claim is allowed only for a maximum of three childs per year.");
//        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(eduTable);
    }
    
//    public Boolean validateThreeChildsPerYear(BigDecimal empId, java.sql.Date invDate, BigDecimal childId){
    private Boolean validateForMaxThreeChilds(BigDecimal empId, java.sql.Date invDate, BigDecimal childId){
        oracle.binding.OperationBinding op = ADFUtils.findOperation("validateThreeChildsPerYear");
        op.getParamsMap().put("childId", childId);
        op.getParamsMap().put("invDate", invDate);
        op.getParamsMap().put("empId", empId);
        Boolean isValid = (Boolean) op.execute();
        return isValid;
    }
    
    private ArrayList fetchCurrentChilds(BigDecimal empId){
        oracle.binding.OperationBinding op = ADFUtils.findOperation("fetchCurrentChildsInYear");
        op.getParamsMap().put("empId", empId);
        ArrayList childList = (ArrayList) op.execute();
        return childList;
    }

    public void setBtDestCountryCity(RichSelectOneChoice btDestCountryCity) {
        this.btDestCountryCity = btDestCountryCity;
    }

    public RichSelectOneChoice getBtDestCountryCity() {
        return btDestCountryCity;
    }

    public void setBstDestCount(RichSelectOneChoice bstDestCount) {
        this.bstDestCount = bstDestCount;
    }

    public RichSelectOneChoice getBstDestCount() {
        return bstDestCount;
    }

    public void setBstCountryLOV(RichSelectOneChoice bstCountryLOV) {
        this.bstCountryLOV = bstCountryLOV;
    }

    public RichSelectOneChoice getBstCountryLOV() {
        return bstCountryLOV;
    }

    public void setDestCountryLOV(RichSelectOneChoice destCountryLOV) {
        this.destCountryLOV = destCountryLOV;
    }

    public RichSelectOneChoice getDestCountryLOV() {
        return destCountryLOV;
    }
    
    private Boolean validateEducationAllowance(){
        ViewObject lineVO =
            ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator1").getViewObject();
        ViewObject otHdrVO =
            ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
      
        BigDecimal empId = ((oracle.jbo.domain.Number)otHdrVO.getCurrentRow().getAttribute("EmpId")).getBigDecimalValue();
        Boolean isValid = validateForMaxThreeChilds(empId,
                                      (java.sql.Date) lineVO.getCurrentRow().getAttribute("InvDate"),
                                                    (BigDecimal) lineVO.getCurrentRow().getAttribute("Contactpersonid"));
        if(isValid == null || !isValid){
            JSFUtils.addFacesErrorMessage("Claim is allowed only for a maximum of three childs per year.");
            return Boolean.FALSE;
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(eduTable);
        
        //In memory
        ArrayList childList = fetchCurrentChilds(empId);
        RowSetIterator rs = lineVO.createRowSetIterator(null);
        int noOfChilds = childList != null ? childList.size() : 0;
        while(rs.hasNext()){
            Row row = rs.next();
            if(!childList.contains(row.getAttribute("Contactpersonid"))){
                childList.add(row.getAttribute("Contactpersonid"));
                noOfChilds++;
            }
        }
        
        if(noOfChilds > 3){
            JSFUtils.addFacesErrorMessage("Claim is allowed only for a maximum of three childs per year.");
            return Boolean.FALSE;
        }
        
        //check if invoice numnber is unique
        
        //check if combination of invoice date, child, semester is unique
        
        
        return Boolean.TRUE;
    }

    public void setApprove(RichPopup approve) {
        this.approve = approve;
    }

    public RichPopup getApprove() {
        return approve;
    }

    public void setReject(RichPopup reject) {
        this.reject = reject;
    }

    public RichPopup getReject() {
        return reject;
    }
    
    public void approveOkRequest(ActionEvent actionEvent){
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("approveComment", null);
        approve.show(new RichPopup.PopupHints());
    }
    public void approveCancelRequest(ActionEvent actionEvent){
        approve.hide();
    }
    
    public void rejectOkRequest(ActionEvent actionEvent){
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("rejectComment", null);
        reject.show(new RichPopup.PopupHints());
    }
    
    public void rejectCancelRequest(ActionEvent actionEvent){
    reject.hide();
    }

    public java.util.Date getMinDateForEduAllowance() {
        try { 
            Calendar cal = Calendar.getInstance();
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);
            Integer startYear = 0;
            if(month >= 9){
                startYear = year-1;
            }
            else{
                startYear = year-2;
            }
            String dateStr = "01-09-"+startYear;
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            java.util.Date date = sdf.parse(dateStr+" 00:00:00");
            return date;
        } catch (Exception e) {
            return null;
        }
    }
    
    public java.util.Date getMaxDateForEduAllowance() {
        try {
            Calendar cal = Calendar.getInstance();
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);
            Integer endYear = 0;
            if(month >= 9){
                endYear = year+1;
            }
            else{
                endYear = year;
            }
            String dateStr = "31-08-"+endYear;
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            java.util.Date date = sdf.parse(dateStr+" 00:00:00");
            return date;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Boolean isValidTotalAmountForChild(){
        String failed = (String) ADFUtils.findOperation("validateChildTotalAmount").execute();
        if(failed != null && !"".equals(failed)){
            JSFUtils.addFacesErrorMessage(failed);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public void setTotalAmount(RichOutputText totalAmount) {
        this.totalAmount = totalAmount;
    }

    public RichOutputText getTotalAmount() {
        return totalAmount;
    }

    public void setApproveReject(Boolean approveReject) {
        this.approveReject = approveReject;
    }

    public Boolean getApproveReject() {
        //getUserARStatusROVO1Iterator
        LoginBean usersb =
            (LoginBean) ADFUtils.evaluateEL("#{loginBean}");
        BigDecimal empId = new BigDecimal(usersb.getPersonId());
        ViewObject mgrVo =
            ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
        BigDecimal reqId = ((oracle.jbo.domain.Number)mgrVo.getCurrentRow().getAttribute("ReqId")).bigDecimalValue();
        ViewObject statusVO =
            ADFUtils.findIterator("getUserARStatusROVO1Iterator").getViewObject();
        statusVO.setNamedWhereClauseParam("p_emp_logged_in",empId);
        statusVO.setNamedWhereClauseParam("p_req_id",reqId);
        statusVO.executeQuery();
        if (statusVO.first() != null) {
            System.out.println("Logged in employee id ==>"+empId+" Reques id selected ==>"+reqId);
            String approverFlag = (String) statusVO.first().getAttribute("ApproverFlag");
            if (approverFlag.equalsIgnoreCase("R") || approverFlag.equalsIgnoreCase("A")) {
                return true;
            }else{
                return false;
            }
        } else {
            return false;
        }
        //return false;
    }

    public void setPurposeOfTrvTable(RichTable purposeOfTrvTable) {
        this.purposeOfTrvTable = purposeOfTrvTable;
    }

    public RichTable getPurposeOfTrvTable() {
        return purposeOfTrvTable;
    }


    public void setDisplayReqStatus(String displayReqStatus) {
        this.displayReqStatus = displayReqStatus;
    }

    public String getDisplayReqStatus() {
        ViewObject mgrVo =
            ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
        String reqStatus = (String)mgrVo.getCurrentRow().getAttribute("Status");
        String reqActionStatus = (String)mgrVo.getCurrentRow().getAttribute("ReqStatus");
        String payRollStatus = (String)mgrVo.getCurrentRow().getAttribute("PayrollTansStatus");
        //Update payroll transfer
        //Pending Approval
        //REJECT
        //APPROVE
        //Draft
        //New
        if(payRollStatus!=null && payRollStatus.equalsIgnoreCase("COMPLETED")){
            return "Transferred to Payroll";
        }        
        if(reqStatus == null || (reqStatus!=null && reqStatus.equalsIgnoreCase("New"))){
            return "New";
        }
        if(reqStatus.equalsIgnoreCase("Draft") && reqActionStatus != null && (reqActionStatus.equalsIgnoreCase("Draft")||reqActionStatus.equalsIgnoreCase("WITHDRAWN") || reqActionStatus.equalsIgnoreCase("REQUESTMOREINFO") | reqActionStatus.equalsIgnoreCase("DELETED"))){
            return "Draft";
        }
        // Cancelled, Pending Approval
        if(reqStatus.equalsIgnoreCase("Pending Approval") && reqActionStatus != null && reqActionStatus.equalsIgnoreCase("DELETED")){
            return "Cancelled and resubmitted, Pending Approval";
        }
        if(reqStatus.equalsIgnoreCase("Pending Approval") && reqActionStatus != null && reqActionStatus.equalsIgnoreCase("WITHDRAWN")){
            return "Withdrawn and resubmitted, Pending Approval";
        }
        //Pending Approval
        if(reqStatus.equalsIgnoreCase("Pending Approval")){
            return "Pending Approval";
        }        
        if(reqStatus.equalsIgnoreCase("APPROVE") && reqActionStatus != null && reqActionStatus.equalsIgnoreCase("DELETED")){
            return "Cancelled and resubmitted, Approved";
        }
        if(reqStatus.equalsIgnoreCase("REJECT") && reqActionStatus != null && reqActionStatus.equalsIgnoreCase("DELETED")){
            return "Cancelled and resubmitted, Rejected";
        }
        
        if(reqStatus.equalsIgnoreCase("APPROVE") && reqActionStatus != null && reqActionStatus.equalsIgnoreCase("WITHDRAWN")){
            return "Withdrawn and resubmitted, Approved";
        }
        if(reqStatus.equalsIgnoreCase("REJECT") && reqActionStatus != null && reqActionStatus.equalsIgnoreCase("WITHDRAWN")){
            return "Withdrawn and resubmitted, Rejected";
        }
        
        if(reqStatus.equalsIgnoreCase("APPROVE") && reqActionStatus != null && reqActionStatus.equalsIgnoreCase("APPROVE")){
            return "Approved";
        }
        if(reqStatus.equalsIgnoreCase("REJECT") && reqActionStatus != null && reqActionStatus.equalsIgnoreCase("REJECT")){
            return "Rejected";
        }
        return displayReqStatus;
    }

    public void cancelOkRequest(ActionEvent actionEvent){
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("cancelComment", null);
        cancel.show(new RichPopup.PopupHints());
    }
    
    public void cancelCancelRequest(ActionEvent actionEvent){
    cancel.hide();
    }
    
    public void reqmoreOkRequest(ActionEvent actionEvent){
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("reqComment", null);
        reqmore.show(new RichPopup.PopupHints());
    }
    
    public void reqmoreCancelRequest(ActionEvent actionEvent){
    reqmore.hide();
    }
    
    public void withdrawOkRequest(ActionEvent actionEvent){
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("wdComment", null);
        withdraw.show(new RichPopup.PopupHints());
    }
    
    public void withdrawCancelRequest(ActionEvent actionEvent){
    withdraw.hide();
    }
    
    public void onBtcEndDateVC(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        onCalculateNoOfDaysInBTC();
        purposeOfTravelBtcTable.resetStampState();
        ResetUtils.reset(purposeOfTravelBtcTable);
        AdfFacesContext.getCurrentInstance().addPartialTarget(eduTable);
    }

    public void onBtcStartDateVC(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        onCalculateNoOfDaysInBTC();
        purposeOfTravelBtcTable.resetStampState();
        ResetUtils.reset(purposeOfTravelBtcTable);
        AdfFacesContext.getCurrentInstance().addPartialTarget(eduTable);
    }

    public void setMinOtDate(Date minOtDate) {
        this.minOtDate = minOtDate;
    }

    public Date getMinOtDate() {
        try {
            Calendar now = Calendar.getInstance();
            java.util.Date date = now.getTime();
            GregorianCalendar cal = new GregorianCalendar();
                            cal.setTime(date);
                            //cal.add(Calendar.DATE, 0);
                                            
                            
            date = cal.getTime();
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = formatter.format(date);
            return formatter.parse(currentDate);
            //return formatter.parse(currentDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setPurposeOfTravelBtcTable(RichTable purposeOfTravelBtcTable) {
        this.purposeOfTravelBtcTable = purposeOfTravelBtcTable;
    }

    public RichTable getPurposeOfTravelBtcTable() {
        return purposeOfTravelBtcTable;
    }

    public String onCompleteDeleteReqACL() {
        ViewObject otHdrVO =
            ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
        
        oracle.jbo.domain.Number reqId = (Number) otHdrVO.getCurrentRow().getAttribute("ReqId");
        
        Object[][] dobProcArgs = null; 
        ApplicationModuleImpl am =
            (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(null);
     
            dobProcArgs = new Object[][] {
                { "IN", reqId, oracle.jdbc.internal.OracleTypes.NUMBER }
            };
     
        try {
            System.err.println("==11====");
            DBUtils.callDBStoredProcedure(am.getDBTransaction(),
                                          "call XXSALIC_HCM_PKG.DELETE_REQUEST(?)",
                                          dobProcArgs);
            System.err.println("==22====");
        } catch (SQLException e) {
            System.err.println("===EXE==" + e.toString());
        }
        
        JSFUtils.addFacesInformationMessage("Request is deleted successfully!");
        
        return "save";
    }

    public void setCancel(RichPopup cancel) {
        this.cancel = cancel;
    }

    public RichPopup getCancel() {
        return cancel;
    }

    public void setReqmore(RichPopup reqmore) {
        this.reqmore = reqmore;
    }

    public RichPopup getReqmore() {
        return reqmore;
    }

    public void setWithdraw(RichPopup withdraw) {
        this.withdraw = withdraw;
    }

    public RichPopup getWithdraw() {
        return withdraw;
    }

    public void createNewAttachment(ActionEvent actionEvent) {
Row hdrRow = 
            ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getCurrentRow();
        oracle.jbo.domain.Number reqId = (oracle.jbo.domain.Number)hdrRow.getAttribute("ReqId");
        ADFUtils.findOperation("CreateInsert5").execute();
//        Row row = ADFUtils.findIterator("XxhcmAttachmentsTVO1Iterator").getCurrentRow();
//        row.setAttribute("ReqId", reqId.bigDecimalValue());
           }
    public String isBTUsedinBtc(){
        oracle.binding.OperationBinding op = ADFUtils.findOperation("checkBtUsed");
        String isValid = (String) op.execute();
        return isValid;
    }

    public void setBtUsed(String btUsed) {
        this.btUsed = btUsed;
    }

    public String getBtUsed() {
        oracle.binding.OperationBinding op = ADFUtils.findOperation("checkBtUsed");
        String isValid = (String) op.execute();
        return isValid;
    }

    public void setEnableReqEdit(Boolean enableReqEdit) {
        this.enableReqEdit = enableReqEdit;
    }

    public Boolean getEnableReqEdit() {
        Row hdrRow = 
                    ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getCurrentRow();
                oracle.jbo.domain.Number reqId = (oracle.jbo.domain.Number)hdrRow.getAttribute("EmpId");
        return enableReqEdit;
    }
}
