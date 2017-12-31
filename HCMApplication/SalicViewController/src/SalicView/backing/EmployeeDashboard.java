package SalicView.backing;


import SalicView.backing.Utils.ADFUtils;

import java.math.BigDecimal;

import javax.faces.component.html.HtmlPanelGroup;

import javax.faces.event.ActionEvent;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelDashboard;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;


import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.component.UIXGroup;

import view.session.LoginBean;


public class EmployeeDashboard {


    private RichPanelDashboard pd1;

    private UIXGroup g1;
    private RichPanelBox pb6;
    private RichOutputLabel ol11;
    private RichOutputLabel ol12;
    private RichPanelBox pb7;
    private RichOutputLabel ol13;
    private RichOutputLabel ol14;
    private RichPanelBox pb8;
    private RichOutputLabel ol15;
    private RichOutputLabel ol16;
    private RichPanelBox pb9;
    private RichOutputLabel ol17;
    private RichOutputLabel ol18;
    private RichPanelBox pb10;
    private RichOutputLabel ol19;
    private RichOutputLabel ol20;
    private RichPanelCollection pc1;
    private RichTable t1;
    private RichCommandLink cl1;
    private RichCommandLink cl2;


    private RichCommandLink cl3;

    private UIXGroup g2;
    private UIXGroup g3;


    private HtmlPanelGroup pg1;


    private RichTable t2;
    private RichPanelBox pb61;
    private RichToolbar t3;
    private RichButton b1;


    public void setPd1(RichPanelDashboard pd1) {
        this.pd1 = pd1;
    }

    public RichPanelDashboard getPd1() {
        return pd1;
    }


    public void setG1(UIXGroup g1) {
        this.g1 = g1;
    }

    public UIXGroup getG1() {
        return g1;
    }


    public void setPb6(RichPanelBox pb6) {
        this.pb6 = pb6;
    }

    public RichPanelBox getPb6() {
        return pb6;
    }

    public void setOl11(RichOutputLabel ol11) {
        this.ol11 = ol11;
    }

    public RichOutputLabel getOl11() {
        return ol11;
    }

    public void setOl12(RichOutputLabel ol12) {
        this.ol12 = ol12;
    }

    public RichOutputLabel getOl12() {
        return ol12;
    }

    public void setPb7(RichPanelBox pb7) {
        this.pb7 = pb7;
    }

    public RichPanelBox getPb7() {
        return pb7;
    }

    public void setOl13(RichOutputLabel ol13) {
        this.ol13 = ol13;
    }

    public RichOutputLabel getOl13() {
        return ol13;
    }

    public void setOl14(RichOutputLabel ol14) {
        this.ol14 = ol14;
    }

    public RichOutputLabel getOl14() {
        return ol14;
    }

    public void setPb8(RichPanelBox pb8) {
        this.pb8 = pb8;
    }

    public RichPanelBox getPb8() {
        return pb8;
    }

    public void setOl15(RichOutputLabel ol15) {
        this.ol15 = ol15;
    }

    public RichOutputLabel getOl15() {
        return ol15;
    }

    public void setOl16(RichOutputLabel ol16) {
        this.ol16 = ol16;
    }

    public RichOutputLabel getOl16() {
        return ol16;
    }

    public void setPb9(RichPanelBox pb9) {
        this.pb9 = pb9;
    }

    public RichPanelBox getPb9() {
        return pb9;
    }

    public void setOl17(RichOutputLabel ol17) {
        this.ol17 = ol17;
    }

    public RichOutputLabel getOl17() {
        return ol17;
    }

    public void setOl18(RichOutputLabel ol18) {
        this.ol18 = ol18;
    }

    public RichOutputLabel getOl18() {
        return ol18;
    }

    public void setPb10(RichPanelBox pb10) {
        this.pb10 = pb10;
    }

    public RichPanelBox getPb10() {
        return pb10;
    }

    public void setOl19(RichOutputLabel ol19) {
        this.ol19 = ol19;
    }

    public RichOutputLabel getOl19() {
        return ol19;
    }

    public void setOl20(RichOutputLabel ol20) {
        this.ol20 = ol20;
    }

    public RichOutputLabel getOl20() {
        return ol20;
    }

    public void setPc1(RichPanelCollection pc1) {
        this.pc1 = pc1;
    }

    public RichPanelCollection getPc1() {
        return pc1;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void setCl1(RichCommandLink cl1) {
        this.cl1 = cl1;
    }

    public RichCommandLink getCl1() {
        return cl1;
    }

    public void setCl2(RichCommandLink cl2) {
        this.cl2 = cl2;
    }

    public RichCommandLink getCl2() {
        return cl2;
    }


    public void setCl3(RichCommandLink cl3) {
        this.cl3 = cl3;
    }

    public RichCommandLink getCl3() {
        return cl3;
    }


    public void setPg1(HtmlPanelGroup pg1) {
        this.pg1 = pg1;
    }

    public HtmlPanelGroup getPg1() {
        return pg1;
    }


    public void setG2(UIXGroup g2) {
        this.g2 = g2;
    }

    public UIXGroup getG2() {
        return g2;
    }

    public void setG3(UIXGroup g3) {
        this.g3 = g3;
    }

    public UIXGroup getG3() {
        return g3;
    }

    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }


    public void setPb61(RichPanelBox pb61) {
        this.pb61 = pb61;
    }

    public RichPanelBox getPb61() {
        return pb61;
    }

    public void onClickTotalRequest(ActionEvent actionEvent) {
        filterEmployeeDashboardStatus(null);
    }

    public void onClickPending(ActionEvent actionEvent) {
        filterEmployeeDashboardStatus("Pending Approval");
    }
    
    public void onClickApprove(ActionEvent actionEvent) {
        filterEmployeeDashboardStatus("APPROVE");
    }

    public void onCLickReject(ActionEvent actionEvent) {
        filterEmployeeDashboardStatus("REJECT");
    }

    public void onClickDelegate(ActionEvent actionEvent) {
        filterEmployeeDashboardStatus("Delegate");
    }

    public void filterEmployeeDashboardStatus(String statusVal) {
        ViewObject employeeVO =
            ADFUtils.findIterator("employeeDashboardROVO1Iterator").getViewObject();
        ViewObjectImpl employeeVOImpl =
            (ViewObjectImpl)employeeVO.getViewObject();
        ViewCriteria employeeVC =
            employeeVOImpl.getViewCriteria("filterByStatus");
        employeeVO.applyViewCriteria(employeeVC);
        employeeVO.setNamedWhereClauseParam("p_Status", statusVal);
        employeeVO.executeQuery();
    }

    public void taskFlowInitializer(){
        LoginBean usersb =
            (LoginBean) ADFUtils.evaluateEL("#{loginBean}");
        BigDecimal empId = new BigDecimal(usersb.getPersonId());
        
                ADFContext aDFContext = ADFContext.getCurrent();
                aDFContext.getPageFlowScope().put("eempId",empId);
        
    }

    public void setT3(RichToolbar t3) {
        this.t3 = t3;
    }

    public RichToolbar getT3() {
        return t3;
    }

    public void setB1(RichButton b1) {
        this.b1 = b1;
    }

    public RichButton getB1() {
        return b1;
    }
}
