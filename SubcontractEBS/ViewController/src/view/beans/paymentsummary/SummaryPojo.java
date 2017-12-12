package view.beans.paymentsummary;

public class SummaryPojo {
    public SummaryPojo() {
        super();
    }
    
    private String division;
    private Integer subContractValue;
    private Integer executedValue;
    private Integer thisMonthValue;

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDivision() {
        return division;
    }

    public void setSubContractValue(Integer subContractValue) {
        this.subContractValue = subContractValue;
    }

    public Integer getSubContractValue() {
        return subContractValue;
    }

    public void setExecutedValue(Integer executedValue) {
        this.executedValue = executedValue;
    }

    public Integer getExecutedValue() {
        return executedValue;
    }

    public void setThisMonthValue(Integer thisMonthValue) {
        this.thisMonthValue = thisMonthValue;
    }

    public Integer getThisMonthValue() {
        return thisMonthValue;
    }
}
