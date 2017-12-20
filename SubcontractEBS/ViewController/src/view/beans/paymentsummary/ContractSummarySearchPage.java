package view.beans.paymentsummary;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;

public class ContractSummarySearchPage {
    public ContractSummarySearchPage() {
        super();
        ContractSummaryHeaderPojo pojo1 = new ContractSummaryHeaderPojo("507", "AL-BOBTAIN TOWERS", "Approved", "Major Subcontractor Contract", "Test01", "Active", new BigDecimal("4172000"), new Date());
        ContractSummaryHeaderPojo pojo2 = new ContractSummaryHeaderPojo("508", "AL-BOBTAIN TOWERS", "Rejected", "Major Subcontractor Contract", "Test02", "Active", new BigDecimal("1000"), new Date());
        summaryList.add(pojo1);
        summaryList.add(pojo2);
    }
    
    private ArrayList<ContractSummaryHeaderPojo> summaryList = new ArrayList<ContractSummaryHeaderPojo>();
    ContractSummaryHeaderPojo searchPojo = new ContractSummaryHeaderPojo();

    public void setSummaryList(ArrayList<ContractSummaryHeaderPojo> summaryList) {
        this.summaryList = summaryList;
    }

    public ArrayList<ContractSummaryHeaderPojo> getSummaryList() {
        return summaryList;
    }

    public void setSearchPojo(ContractSummaryHeaderPojo searchPojo) {
        this.searchPojo = searchPojo;
    }

    public ContractSummaryHeaderPojo getSearchPojo() {
        return searchPojo;
    }
}
