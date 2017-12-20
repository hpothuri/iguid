package view.beans.paymentsummary;

import java.math.BigDecimal;

import java.util.Date;

public class ContractSummaryHeaderPojo {
    public ContractSummaryHeaderPojo() {
        super();
    }
    
    private String projectNumber;
    private String projectName;
    private String projectStatus;
    private String contractType;
    private String contractNumber;
    private String contractStatus;
    private BigDecimal contractValue;
    private Date startDate;
    
    public ContractSummaryHeaderPojo(String projectNumber, String projectName, String projectStatus,
                                     String contractType, String contractNumber, String contractStatus,
                                     BigDecimal contractValue, Date startDate){
                                         this.projectNumber = projectNumber;
                                         this.projectName = projectName;
                                         this.projectStatus = projectStatus;
                                         this.contractType = contractType;
                                         this.contractNumber = contractNumber;
                                         this.contractStatus = contractStatus;
                                          this.contractValue = contractValue;
                                        this.startDate = startDate;
                                     }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractValue(BigDecimal contractValue) {
        this.contractValue = contractValue;
    }

    public BigDecimal getContractValue() {
        return contractValue;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }
}
