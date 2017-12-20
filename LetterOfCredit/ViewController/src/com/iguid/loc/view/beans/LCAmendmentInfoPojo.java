package com.iguid.loc.view.beans;

import java.math.BigDecimal;

import java.util.Date;

public class LCAmendmentInfoPojo {
    public LCAmendmentInfoPojo() {
        super();
    }
    
    public LCAmendmentInfoPojo(Integer seqNo, String amendDetail, BigDecimal amendedAmount,
                               Date date, String status, String remarks, Date sentToBankDate,
                               Boolean swiftRec){
        this.seqNo = seqNo;
        this.amendDetail = amendDetail;
        this.amendedAmount = amendedAmount;
        this.date = date;
        this.status = status;
        this.remarks = remarks;
        this.sentToBankDate = sentToBankDate;
        this.swiftRec = swiftRec;
    }
    
    private Integer seqNo;
    private String amendDetail;
    private BigDecimal amendedAmount;
    private Date date;
    private String status;
    private String remarks;
    private Date sentToBankDate;
    private Boolean swiftRec;

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setAmendDetail(String amendDetail) {
        this.amendDetail = amendDetail;
    }

    public String getAmendDetail() {
        return amendDetail;
    }

    public void setAmendedAmount(BigDecimal amendedAmount) {
        this.amendedAmount = amendedAmount;
    }

    public BigDecimal getAmendedAmount() {
        return amendedAmount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setSentToBankDate(Date sentToBankDate) {
        this.sentToBankDate = sentToBankDate;
    }

    public Date getSentToBankDate() {
        return sentToBankDate;
    }

    public void setSwiftRec(Boolean swiftRec) {
        this.swiftRec = swiftRec;
    }

    public Boolean getSwiftRec() {
        return swiftRec;
    }
}
