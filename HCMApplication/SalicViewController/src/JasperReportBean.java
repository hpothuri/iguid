import SalicView.backing.Utils.ADFUtils;

import java.io.OutputStream;

import javax.faces.context.FacesContext;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.input.RichInputComboboxListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.OperationBinding;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import java.io.OutputStream;

import java.sql.Connection;

import java.util.HashMap;
import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;

import javax.faces.context.ExternalContext;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import javax.sql.DataSource;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.WhenNoDataTypeEnum;
import net.sf.jasperreports.engine.util.JRLoader;

import oracle.adf.model.BindingContext;

import oracle.binding.BindingContainer;

import oracle.jbo.Row;
import oracle.jbo.RowSet;
import oracle.jbo.RowSetIterator;
import oracle.jbo.VariableValueManager;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUCtrlValueBinding;

public class JasperReportBean {
    private RichTable overTimeTableId;
    private RichInputComboboxListOfValues requestTypeBND;
    private RichInputDate requestDateFromBND;
    private RichSelectOneChoice otApprovalStatus;
    private RichSelectOneChoice otEmployeeNumber;
    private RichSelectOneChoice otDepartmentName;
    private RichInputDate requestDateToBND;
    private RichInputListOfValues otLineManagerName;

    public JasperReportBean() {
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void onClickPDFReport(FacesContext facesContext,
                                 OutputStream outputStream) {
        //        DCIteratorBinding empIter =
        //            (DCIteratorBinding)getBindings().get("EmpDtlsView1Iterator");
        //        String empId =
        //            empIter.getCurrentRow().getAttribute("Id").toString();
        Map m = new HashMap();
        // m.put("p_empId", empId); // where employeeId is a jasper report parameter
        try {
            runReport("report3.jasper", m, outputStream);
        } catch (Exception e) {
        }

    }


    public void runReport(String repPath, java.util.Map param,
                          OutputStream outputStream) throws Exception {
        Connection conn = null;
        String str = "Quote";
        try {
            HttpServletResponse response = getResponse();
            ServletOutputStream out = response.getOutputStream();
            response.setHeader("Cache-Control", "max-age=0");
            response.setContentType("application/pdf");
            ServletContext context = getContext();
            System.err.println("===repPath Name==" + repPath);
            InputStream fs =
                context.getResourceAsStream("/reports/" + repPath); //we will put the report under folder "reports" under Web Content
            JasperReport template = (JasperReport)JRLoader.loadObject(fs);
            template.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);
            conn = getConnection();
            ByteArrayOutputStream byteArrayOutputStream =
                new ByteArrayOutputStream();
            JasperPrint print =
                JasperFillManager.fillReport(template, param, conn);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(print, baos);
            response.setContentType("application/pdf");
            response.setHeader("Cache-Control", "max-age=0");
            response.setHeader("Content-Disposition",
                               "filename=\"" + str + ".pdf\"");
            out.write(baos.toByteArray());
            out.flush();
            out.close();
            outputStream.write(baos.toByteArray());
            outputStream.flush();
            outputStream.close();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception jex) {
            jex.printStackTrace();
        } finally {
            close(conn);
        }
    }

    public void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
            }
        }
    }

    public Connection getDataSourceConnection(String dataSourceName) throws Exception {
        Context ctx = new InitialContext();
        DataSource ds = (DataSource)ctx.lookup(dataSourceName);
        return ds.getConnection();
    }

    private Connection getConnection() throws Exception {
        return getDataSourceConnection("subcont"); // use datasourse in your application
    }

    public ServletContext getContext() {
        return (ServletContext)getFacesContext().getExternalContext().getContext();
    }

    public HttpServletResponse getResponse() {
        return (HttpServletResponse)getFacesContext().getExternalContext().getResponse();
    }

    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public String onClickOverTimeSearchButton() {
        ViewObject partVO =
            ADFUtils.findIterator("OverTimeRequestSearch_ROVO1Iterator").getViewObject();
        VariableValueManager vMngr = partVO.ensureVariableManager();

        //vMngr.setVariableValue("p_ApproverUserName", null);
        System.err.println("this.getOtApprovalStatus().getValue()" +
                           this.getOtApprovalStatus().getValue());
        vMngr.setVariableValue("p_Status",
                               this.getOtApprovalStatus().getValue());
        vMngr.setVariableValue("p_FromDate",
                               getRequestDateFromBND().getValue());
        vMngr.setVariableValue("p_ToDate", getRequestDateToBND().getValue());
        vMngr.setVariableValue("p_Type", getRequestTypeBND().getValue());
        vMngr.setVariableValue("p_Department",
                               getOtDepartmentName().getValue());
        //vMngr.setVariableValue("p_EmpId", null);
        vMngr.setVariableValue("p_LineManager",
                               getOtLineManagerName().getValue());
        //vMngr.setVariableValue("p_EmpName", null);
        vMngr.setVariableValue("p_EmpNumber",
                               getOtEmployeeNumber().getValue());

        // vMngr.setVariableValue("p_Grade", null);
        // vMngr.setVariableValue("p_JobTitle", null);

        vMngr.setVariableValue("p_RequestNumberFrom", null);
        vMngr.setVariableValue("p_RequestNumberTo", null);

        //vc.addRow(vcRow);
        //partVO.applyViewCriteria(vc);
        partVO.executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(getOverTimeTableId());
        System.err.println("TOTAL SEARCH COUNT--" +
                           partVO.getEstimatedRowCount());
        return null;
    }

    public String onClickOverTimeResetButton() {
        ViewObject partVO =
            ADFUtils.findIterator("OverTimeRequestSearch_ROVO1Iterator").getViewObject();
        partVO.executeEmptyRowSet();
        AdfFacesContext.getCurrentInstance().addPartialTarget(getOverTimeTableId());
        System.err.println("TOTAL REST COUNT--" +
                           partVO.getEstimatedRowCount());
        return null;
    }

    public void setOverTimeTableId(RichTable overTimeTableId) {
        this.overTimeTableId = overTimeTableId;
    }

    public RichTable getOverTimeTableId() {
        return overTimeTableId;
    }

    public void setRequestTypeBND(RichInputComboboxListOfValues requestTypeBND) {
        this.requestTypeBND = requestTypeBND;
    }

    public RichInputComboboxListOfValues getRequestTypeBND() {
        return requestTypeBND;
    }

    public void setRequestDateFromBND(RichInputDate requestDateFromBND) {
        this.requestDateFromBND = requestDateFromBND;
    }

    public RichInputDate getRequestDateFromBND() {
        return requestDateFromBND;
    }

    public void setOtApprovalStatus(RichSelectOneChoice otApprovalStatus) {
        this.otApprovalStatus = otApprovalStatus;
    }

    public RichSelectOneChoice getOtApprovalStatus() {
        return otApprovalStatus;
    }

    public void setOtEmployeeNumber(RichSelectOneChoice otEmployeeNumber) {
        this.otEmployeeNumber = otEmployeeNumber;
    }

    public RichSelectOneChoice getOtEmployeeNumber() {
        return otEmployeeNumber;
    }

    public void setOtDepartmentName(RichSelectOneChoice otDepartmentName) {
        this.otDepartmentName = otDepartmentName;
    }

    public RichSelectOneChoice getOtDepartmentName() {
        return otDepartmentName;
    }

    public void setRequestDateToBND(RichInputDate requestDateToBND) {
        this.requestDateToBND = requestDateToBND;
    }

    public RichInputDate getRequestDateToBND() {
        return requestDateToBND;
    }

    public void setOtLineManagerName(RichInputListOfValues otLineManagerName) {
        this.otLineManagerName = otLineManagerName;
    }

    public RichInputListOfValues getOtLineManagerName() {
        return otLineManagerName;
    }
}
