package common.pojo;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class EmailRequestPojo {
    public EmailRequestPojo() {
        super();
    }
    
    private Integer requestId;
    private String empId;
    private String empName;
    private String empNumber;
    private String requestNo;
    private String[] toEmail;
    private String message;
    private String subject;
    private String toEmpName;
    private LinkedHashMap<String, String> actionButtons = new LinkedHashMap<String, String>();
    private ArrayList<EmailTableDetailsPojo> tableDetails = new ArrayList<EmailTableDetailsPojo>();
    

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

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public void setTableDetails(ArrayList<EmailTableDetailsPojo> tableDetails) {
        this.tableDetails = tableDetails;
    }

    public ArrayList<EmailTableDetailsPojo> getTableDetails() {
        return tableDetails;
    }
}
