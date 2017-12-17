package view.beans.paymentsummary;

import java.math.BigDecimal;

public class DeductionPaymentLinesPojo {
    private String sno;
    private String desc;
    private String UOM;
    private BigDecimal unitrate;
    private BigDecimal prevmonthqty;
    private BigDecimal prevpct;
    private BigDecimal prevnet;
    private BigDecimal qty;
    private BigDecimal dedqty;
    
    private BigDecimal completePct;
    private BigDecimal dedNetQty;
    private BigDecimal diff;
    
    public DeductionPaymentLinesPojo() {
        super();
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

    public void setUnitrate(BigDecimal unitrate) {
        this.unitrate = unitrate;
    }

    public BigDecimal getUnitrate() {
        return unitrate;
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

    public void setDedqty(BigDecimal dedqty) {
        this.dedqty = dedqty;
    }

    public BigDecimal getDedqty() {
        return dedqty;
    }

    public void setCompletePct(BigDecimal completePct) {
        this.completePct = completePct;
    }

    public BigDecimal getCompletePct() {
        return completePct;
    }

    public void setDedNetQty(BigDecimal dedNetQty) {
        this.dedNetQty = dedNetQty;
    }

    public BigDecimal getDedNetQty() {
        return dedNetQty;
    }

    public void setDiff(BigDecimal diff) {
        this.diff = diff;
    }

    public BigDecimal getDiff() {
        return diff;
    }
}
