package com.iguid.loc.view.beans;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;

public class LCSummaryPage {
    public LCSummaryPage() {
        super();
        LCSummaryPojo pojo1 = new LCSummaryPojo("Bank Of America",  null, "LC", "LC001-Test", new Date(), "B", "HR-SanFrancisco", "Closed", null, "USD", new BigDecimal("1010.00"), new BigDecimal("100.00"), new BigDecimal("910.00"));
        LCSummaryPojo pojo2 = new LCSummaryPojo("Bank Of America",  new Date(), "LC Amend", "LC001-Test", null, "B", "HR-SanFrancisco", "Approved", null, "USD", new BigDecimal("10.00"), new BigDecimal("100.00"), new BigDecimal("910.00"));
        LCSummaryPojo pojo3 = new LCSummaryPojo("Bank Of America",  null, "LC Bill", "LC001-Test", null, "B", "HR-SanFrancisco", "Approved", null, "USD", new BigDecimal("100.00"), new BigDecimal("100.00"), new BigDecimal("910.00"));
        summaryData.add(pojo1);
        summaryData.add(pojo2);
        summaryData.add(pojo3);
    }
    
    ArrayList<LCSummaryPojo> summaryData = new ArrayList<LCSummaryPojo>();
    LCSearchPojo searchForm = new LCSearchPojo();

    public void setSummaryData(ArrayList<LCSummaryPojo> summaryData) {
        this.summaryData = summaryData;
    }

    public ArrayList<LCSummaryPojo> getSummaryData() {
        return summaryData;
    }

    public void setSearchForm(LCSearchPojo searchForm) {
        this.searchForm = searchForm;
    }

    public LCSearchPojo getSearchForm() {
        return searchForm;
    }
}
