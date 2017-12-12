package view.beans.paymentsummary;

import java.util.Date;

public class PaymentPojo {
    public PaymentPojo() {
        super();
    }
    
    private Integer projectNumber = 507;
    private String projectName = "AL-BABTAIN TOWER";
    private Integer paymentNumber = 2;
    private String description = "";
    private String contractNumber = "Test01";
    private String supplierName = "TEST";
    private String supplierType = "SUBCONTRACTOR";
    private Date paymentDate = new Date();

    public void setProjectNumber(Integer projectNumber) {
        this.projectNumber = projectNumber;
    }

    public Integer getProjectNumber() {
        return projectNumber;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setPaymentNumber(Integer paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public Integer getPaymentNumber() {
        return paymentNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierType(String supplierType) {
        this.supplierType = supplierType;
    }

    public String getSupplierType() {
        return supplierType;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }
}
