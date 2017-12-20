package com.iguid.loc.view.beans;

import java.util.Date;

public class LCSearchPojo {
    public LCSearchPojo() {
        super();
    }
    
    private String bank;
    private String type;
    private String lcNo;
    private String status;
    private String action;
    private Date fromSentDate;
    private Date toSentDate;
    private Date fromExpiryDate;
    private Integer daysPlus = 30;
    private Integer daysMinus = 60;
    private Boolean printSimpleBalances = Boolean.TRUE;

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBank() {
        return bank;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setLcNo(String lcNo) {
        this.lcNo = lcNo;
    }

    public String getLcNo() {
        return lcNo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setFromSentDate(Date fromSentDate) {
        this.fromSentDate = fromSentDate;
    }

    public Date getFromSentDate() {
        return fromSentDate;
    }

    public void setToSentDate(Date toSentDate) {
        this.toSentDate = toSentDate;
    }

    public Date getToSentDate() {
        return toSentDate;
    }

    public void setFromExpiryDate(Date fromExpiryDate) {
        this.fromExpiryDate = fromExpiryDate;
    }

    public Date getFromExpiryDate() {
        return fromExpiryDate;
    }

    public void setDaysPlus(Integer daysPlus) {
        this.daysPlus = daysPlus;
    }

    public Integer getDaysPlus() {
        return daysPlus;
    }

    public void setDaysMinus(Integer daysMinus) {
        this.daysMinus = daysMinus;
    }

    public Integer getDaysMinus() {
        return daysMinus;
    }

    public void setPrintSimpleBalances(Boolean printSimpleBalances) {
        this.printSimpleBalances = printSimpleBalances;
    }

    public Boolean getPrintSimpleBalances() {
        return printSimpleBalances;
    }
}
