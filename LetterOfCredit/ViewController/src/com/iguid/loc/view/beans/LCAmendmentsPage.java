package com.iguid.loc.view.beans;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;

public class LCAmendmentsPage {
    public LCAmendmentsPage() {
        super();
        LCAmendmentInfoPojo pojo1 = new LCAmendmentInfoPojo(1, "Amend Amount", new BigDecimal("1000.00"), new Date(), "Under Signature", "", new Date(), Boolean.TRUE);
        infoList.add(pojo1);
        LCAmendTrackPojo pojo2 = new LCAmendTrackPojo(1, "N/A", "Purchasing", new Date(), "Sent to Bank", "");
        LCAmendTrackPojo pojo3 = new LCAmendTrackPojo(1, "Purchasing", "Financials", new Date(), "Pending", "");
        trackList.add(pojo2);
        trackList.add(pojo3);
    }
    
    private ArrayList<LCAmendTrackPojo> trackList = new ArrayList<LCAmendTrackPojo>(); 
    private ArrayList<LCAmendmentInfoPojo> infoList = new ArrayList<LCAmendmentInfoPojo>();

    public void setTrackList(ArrayList<LCAmendTrackPojo> trackList) {
        this.trackList = trackList;
    }

    public ArrayList<LCAmendTrackPojo> getTrackList() {
        return trackList;
    }

    public void setInfoList(ArrayList<LCAmendmentInfoPojo> infoList) {
        this.infoList = infoList;
    }

    public ArrayList<LCAmendmentInfoPojo> getInfoList() {
        return infoList;
    }
}
