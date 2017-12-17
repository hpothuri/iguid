package view.beans.paymentsummary;

import java.math.BigDecimal;

public class PaymentVariationsPojo {
    private String taskno;
    private String sno;
    private String desc;
    private String UOM;
    private BigDecimal rate;
    private BigDecimal prevmonthqty;
    private BigDecimal prevpct;
    private BigDecimal prevnet;
    private BigDecimal qty;
    private BigDecimal totVal;
    private BigDecimal completePct;
    private BigDecimal netQty;
    
    public PaymentVariationsPojo() {
        super();
    }

    public void setTaskno(String taskno) {
        this.taskno = taskno;
    }

    public String getTaskno() {
        return taskno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSno() {
        return sno;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setUOM(String UOM) {
        this.UOM = UOM;
    }

    public String getUOM() {
        return UOM;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setPrevmonthqty(BigDecimal prevmonthqty) {
        this.prevmonthqty = prevmonthqty;
    }

    public BigDecimal getPrevmonthqty() {
        return prevmonthqty;
    }

    public void setPrevpct(BigDecimal prevpct) {
        this.prevpct = prevpct;
    }

    public BigDecimal getPrevpct() {
        return prevpct;
    }

    public void setPrevnet(BigDecimal prevnet) {
        this.prevnet = prevnet;
    }

    public BigDecimal getPrevnet() {
        return prevnet;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setTotVal(BigDecimal totVal) {
        this.totVal = totVal;
    }

    public BigDecimal getTotVal() {
        return totVal;
    }

    public void setCompletePct(BigDecimal completePct) {
        this.completePct = completePct;
    }

    public BigDecimal getCompletePct() {
        return completePct;
    }

    public void setNetQty(BigDecimal netQty) {
        this.netQty = netQty;
    }

    public BigDecimal getNetQty() {
        return netQty;
    }
}
