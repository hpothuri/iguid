package com.iguid.loc.view.beans;

import java.util.Date;

public class LCAmendTrackPojo {
    public LCAmendTrackPojo() {
        super();
    }
    
    public LCAmendTrackPojo(Integer seqNo, String from, String to, 
                            Date trackDate, String action, String remarks) {
        this.seqNo = seqNo;
        this.from = from;
        this.to = to;
        this.trackDate = trackDate;
        this.action = action;
        this.remarks = remarks;
    }
    
    private Integer seqNo;
    private String from;
    private String to;
    private Date trackDate;
    private String action;
    private String remarks;

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    public void setTrackDate(Date trackDate) {
        this.trackDate = trackDate;
    }

    public Date getTrackDate() {
        return trackDate;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }
}
