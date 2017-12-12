package view.beans.paymentsummary;

import java.util.ArrayList;

public class SummaryListPojo {
    public SummaryListPojo() {
        super();
        SummaryPojo pojo = new SummaryPojo();
        pojo.setDivision("Subcontracts");
        pojo.setExecutedValue(417440);
        pojo.setSubContractValue(4172000);
        pojo.setThisMonthValue(208240);
        summaryList.add(pojo);
//        SummaryPojo pojo1 = new SummaryPojo();
//        pojo1.setDivision("Subcontracts");
//        pojo1.setExecutedValue(412340);
//        pojo1.setSubContractValue(1232000);
//        pojo1.setThisMonthValue(122240);
//        summaryList.add(pojo1);
    }
    
    private ArrayList<SummaryPojo> summaryList = new ArrayList<SummaryPojo>();

    public void setSummaryList(ArrayList<SummaryPojo> summaryList) {
        this.summaryList = summaryList;
    }

    public ArrayList<SummaryPojo> getSummaryList() {
        return summaryList;
    }
}
