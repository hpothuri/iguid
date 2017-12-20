package view.beans.paymentsummary;

import java.math.BigDecimal;

public class PaymentLinesSummary {
    private String actid;
    private String Descr;
    private BigDecimal contrValue;
    private BigDecimal pctComp;
    private BigDecimal pctValue;
    private BigDecimal PreMonth;
    private BigDecimal MonIncr;
    private BigDecimal CurrMonValue;
    private String taskNo;
    private String Remarks;    
    
    public PaymentLinesSummary() {
        super();
    }

    public void setActid(String actid) {
        this.actid = actid;
    }

    public String getActid() {
        return actid;
    }

    public void setDescr(String Descr) {
        this.Descr = Descr;
    }

    public String getDescr() {
        return Descr;
    }

    public void setContrValue(BigDecimal contrValue) {
        this.contrValue = contrValue;
    }

    public BigDecimal getContrValue() {
        return contrValue;
    }

    public void setPctComp(BigDecimal pctComp) {
        this.pctComp = pctComp;
    }

    public BigDecimal getPctComp() {
        return pctComp;
    }

    public void setPctValue(BigDecimal pctValue) {
        this.pctValue = pctValue;
    }

    public BigDecimal getPctValue() {
        return pctValue;
    }

    public void setPreMonth(BigDecimal PreMonth) {
        this.PreMonth = PreMonth;
    }

    public BigDecimal getPreMonth() {
        return PreMonth;
    }

    public void setMonIncr(BigDecimal MonIncr) {
        this.MonIncr = MonIncr;
    }

    public BigDecimal getMonIncr() {
        return MonIncr;
    }

    public void setCurrMonValue(BigDecimal CurrMonValue) {
        this.CurrMonValue = CurrMonValue;
    }

    public BigDecimal getCurrMonValue() {
        return CurrMonValue;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setRemarks(String Remarks) {
        this.Remarks = Remarks;
    }

    public String getRemarks() {
        return Remarks;
    }
}
