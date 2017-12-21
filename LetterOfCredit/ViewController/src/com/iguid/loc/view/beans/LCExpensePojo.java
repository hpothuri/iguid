package com.iguid.loc.view.beans;

import java.math.BigDecimal;

import java.util.Date;

public class LCExpensePojo {
    public LCExpensePojo() {
        super();
    }
    
    public LCExpensePojo(Integer seqNo, String expenseType, Date expenseDate, BigDecimal totalValue,
                         String description, String docType, String currency, BigDecimal rate) {
        this.seqNo = seqNo;
        this.expenseType = expenseType;
        this.expenseDate = expenseDate;
        this.totalValue = totalValue;
        this.description = description;
        this.docType = docType;
        this.currency = currency;
        this.rate = rate;
    }
    
    private Integer seqNo;
    private String expenseType;
    private Date expenseDate;
    private BigDecimal totalValue;
    private String description;
    private String docType;
    private String currency;
    private BigDecimal rate;

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocType() {
        return docType;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRate() {
        return rate;
    }
}
