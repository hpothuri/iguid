package com.iguid.loc.view.beans;

import java.math.BigDecimal;

import java.util.Date;

public class LCSummaryPojo {
    public LCSummaryPojo() {
        super();
    }
    
    private String bank;
    private Date sentDate;
    private String type;
    private String lcNo;
    private Date expiryDate;
    private String area;
    private String project;
    private String status;
    private String action;
    private String currency;
    private BigDecimal current;
    private BigDecimal received;
    private BigDecimal remaining;
    
    public LCSummaryPojo(String bank,Date sentDate,String type,String lcNo,Date expiryDate,
                         String area,String project, String status, String action, String currency,
                         BigDecimal current,BigDecimal received,BigDecimal remaining){
        this.bank = bank;
        this.sentDate = sentDate;
        this.type = type;
        this.lcNo = lcNo;
        this.expiryDate = expiryDate;
        this.area = area;
        this.project = project;
        this.status = status;
        this.action = action;
        this.currency = currency;
        this.current = current;
        this.received = received;
        this.remaining = remaining;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBank() {
        return bank;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public Date getSentDate() {
        return sentDate;
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

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getProject() {
        return project;
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

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrent(BigDecimal current) {
        this.current = current;
    }

    public BigDecimal getCurrent() {
        return current;
    }

    public void setReceived(BigDecimal received) {
        this.received = received;
    }

    public BigDecimal getReceived() {
        return received;
    }

    public void setRemaining(BigDecimal remaining) {
        this.remaining = remaining;
    }

    public BigDecimal getRemaining() {
        return remaining;
    }
}
