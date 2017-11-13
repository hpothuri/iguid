package SalicView.backing;

import SalicView.backing.Utils.ADFUtils;
import SalicView.backing.Utils.DBUtils;
import SalicView.backing.Utils.JSFUtils;

import java.math.BigDecimal;

import java.sql.SQLException;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.nav.RichTrain;
import oracle.adf.view.rich.component.rich.nav.RichTrainButtonBar;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;

import oracle.jbo.ViewObject;

import oracle.jbo.domain.Number;

import oracle.jbo.server.ApplicationModuleImpl;

import oracle.jdbc.OracleTypes;

import org.apache.myfaces.trinidad.component.UIXGroup;

public class OvertimeHdr {
    private RichPanelFormLayout pfl1;
    private RichInputText it1;
    private RichInputDate id1;
    private UIXGroup g1;
    private RichTrainButtonBar tbb1;
    private RichInputText it2;
    private RichInputDate id2;
    private RichTrain t1;
    private RichPopup p1;
    private RichInputText it6;
    private RichInputDate id3;

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setG1(UIXGroup g1) {
        this.g1 = g1;
    }

    public UIXGroup getG1() {
        return g1;
    }

    public void setTbb1(RichTrainButtonBar tbb1) {
        this.tbb1 = tbb1;
    }

    public RichTrainButtonBar getTbb1() {
        return tbb1;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
    }

    public void setT1(RichTrain t1) {
        this.t1 = t1;
    }

    public RichTrain getT1() {
        return t1;
    }

    public void onCloseBGPopup(ActionEvent actionEvent) {
       p1.cancel();
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }
   


    public void saveAndCloseACL(ActionEvent actionEvent) {
        JSFUtils.addFacesInformationMessage("Information Saved Successfully");
        ViewObject variationSearchVo=ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
//        ViewCriteria vc=variationSearchVo.createViewCriteria();
//        ViewCriteriaRow vcr=vc.createViewCriteriaRow();
//        vcr.setAttribute("RequestNumber", "");
//        vc.addRow(vcr);
//        variationSearchVo.applyViewCriteria(vc);
//        variationSearchVo.executeQuery();
        approve_hierachy(variationSearchVo.getCurrentRow().getAttribute("ReqId"), "H");
    }
    Object dobProcArgs;
    public void approve_hierachy(Object header_id, String type) {
            String flag = "sam";
            ApplicationModuleImpl am =
                (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(null);
            dobProcArgs =
                    new Object[][] { { "IN", header_id, OracleTypes.NUMBER }, //0
                        { "IN", type, OracleTypes.VARCHAR }, //1
                        { "IN", flag, OracleTypes.VARCHAR } //2
                        } ;
            try {
                System.err.println("==11====");
                DBUtils.callDBStoredProcedure(am.getDBTransaction(),
                                              "call xxfocus_boq_apprv_prc(?,?,?)", (Object[][])dobProcArgs);
                System.err.println("==22====");
            } catch (SQLException e) {
                System.err.println("===EXE==" + e.toString());
            }
            System.err.println("===SEND==" + flag);

        }
    public void saveACL(ActionEvent actionEvent) {
        ADFUtils.findOperation("Commit").execute(); 
         JSFUtils.addFacesInformationMessage("Information Saved Successfully");
//        ViewObject variationSearchVo=ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
//        ViewCriteria vc=variationSearchVo.createViewCriteria();
//        ViewCriteriaRow vcr=vc.createViewCriteriaRow();
//        vcr.setAttribute("RequestNumber", "");
//        vc.addRow(vcr);
//        variationSearchVo.applyViewCriteria(vc);
//        variationSearchVo.executeQuery();
    }

    public void calcHoursVCL(ValueChangeEvent vce) {
        if(vce.getNewValue()!=null){
            Number otHours = (Number)vce.getNewValue();
            Number calcHours = otHours.multiply(1.5);
            it6.setValue(calcHours);
            AdfFacesContext.getCurrentInstance().addPartialTarget(it6);
        }
    }

    public void setIt6(RichInputText it6) {
        this.it6 = it6;
    }

    public RichInputText getIt6() {
        return it6;
    }

    public void sameDateVCL(ValueChangeEvent date) {
        ViewObject dtlsVo=ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO2Iterator").getViewObject();
        if(date.getNewValue()!=null){
            oracle.jbo.domain.Date otDate = (oracle.jbo.domain.Date)date.getNewValue();
                    ViewObject variationSearchVo=ADFUtils.findIterator("XxhcmOvertimeDetailsAllVO1Iterator").getViewObject();
                    ViewCriteria vc=variationSearchVo.createViewCriteria();
                    ViewCriteriaRow vcr=vc.createViewCriteriaRow();
                    vcr.setAttribute("OvertimeDate", date.getNewValue());
                    vc.addRow(vcr);
                    variationSearchVo.applyViewCriteria(vc);
                    variationSearchVo.executeQuery();
                    if(variationSearchVo.getEstimatedRowCount()>0){
//                        variationSearchVo.getCurrentRow().setAttribute("OvertimeDate", null);
                        id3.setValue(null);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(id3);
                        JSFUtils.addFacesInformationMessage("Over Time Date cannot be Repeated");
                    }
        }
    }

    public void setId3(RichInputDate id3) {
        this.id3 = id3;
    }

    public RichInputDate getId3() {
        return id3;
    }

    public void generateReqNumVCL(ValueChangeEvent valueChangeEvent) {
                ViewObject variationSearchVo=ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy THH:mm");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
        variationSearchVo.getCurrentRow().setAttribute("RequestNumber", dateFormat.format(date)+"-OT-"+variationSearchVo.getCurrentRow().getAttribute("ReqId"));
        variationSearchVo.executeQuery();
    }
}
