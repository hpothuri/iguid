package view.beans.paymentsummary;

import java.math.BigDecimal;

public class VariationPojo {
    private String sno;
    private String desc;
    private String UOM;
    private BigDecimal prevmonthqty;
    private BigDecimal currMonthQty;
    private BigDecimal totQty;
    private BigDecimal qtyUsed;
    private BigDecimal balQty;
    private BigDecimal completePct;
    private BigDecimal rate;
    private BigDecimal qty;


    public VariationPojo() {
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

    public void setPrevmonthqty(BigDecimal prevmonthqty) {
        this.prevmonthqty = prevmonthqty;
    }

    public BigDecimal getPrevmonthqty() {
        return prevmonthqty;
    }

    public void setCurrMonthQty(BigDecimal currMonthQty) {
        this.currMonthQty = currMonthQty;
    }

    public BigDecimal getCurrMonthQty() {
        return currMonthQty;
    }

    public void setTotQty(BigDecimal totQty) {
        this.totQty = totQty;
    }

    public BigDecimal getTotQty() {
        return totQty;
    }

    public void setQtyUsed(BigDecimal qtyUsed) {
        this.qtyUsed = qtyUsed;
    }

    public BigDecimal getQtyUsed() {
        return qtyUsed;
    }

    public void setBalQty(BigDecimal balQty) {
        this.balQty = balQty;
    }

    public BigDecimal getBalQty() {
        return balQty;
    }

    public void setCompletePct(BigDecimal completePct) {
        this.completePct = completePct;
    }

    public BigDecimal getCompletePct() {
        return completePct;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getQty() {
        return qty;
    }
}
