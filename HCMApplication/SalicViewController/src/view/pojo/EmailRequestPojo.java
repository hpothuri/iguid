package view.pojo;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class EmailRequestPojo {
    public EmailRequestPojo() {
        super();
    }
    
    private Integer requestId;
    private String empId;
    private String empName;
    private String requestNo;
    private String[] toEmail;
    private String message;
    private String subject;
    private ArrayList<String> tableContentColumns = new ArrayList<String>();
    private String detailsQuery;
    private LinkedHashMap<String, String> tableColumnDatatypes = new LinkedHashMap<String, String>();
    private String toEmpName;
    private LinkedHashMap<String, String> actionButtons = new LinkedHashMap<String, String>();

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setToEmail(String[] toEmail) {
        this.toEmail = toEmail;
    }

    public String[] getToEmail() {
        return toEmail;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setTableContentColumns(ArrayList<String> tableContentColumns) {
        this.tableContentColumns = tableContentColumns;
    }

    public ArrayList<String> getTableContentColumns() {
        return tableContentColumns;
    }

    public void setDetailsQuery(String detailsQuery) {
        this.detailsQuery = detailsQuery;
    }

    public String getDetailsQuery() {
        return detailsQuery;
    }

    public void setTableColumnDatatypes(LinkedHashMap<String, String> tableColumnDatatypes) {
        this.tableColumnDatatypes = tableColumnDatatypes;
    }

    public LinkedHashMap<String, String> getTableColumnDatatypes() {
        return tableColumnDatatypes;
    }

    public void setToEmpName(String toEmpName) {
        this.toEmpName = toEmpName;
    }

    public String getToEmpName() {
        return toEmpName;
    }

    public void setActionButtons(LinkedHashMap<String, String> actionButtons) {
        this.actionButtons = actionButtons;
    }

    public LinkedHashMap<String, String> getActionButtons() {
        return actionButtons;
    }
}
