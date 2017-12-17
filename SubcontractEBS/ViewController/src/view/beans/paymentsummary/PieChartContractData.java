package view.beans.paymentsummary;

import java.math.BigDecimal;

public class PieChartContractData {
    public PieChartContractData() {
        super();
    }
    private String rec;
    private BigDecimal amounts;

    public void setRec(String rec) {
        this.rec = rec;
    }

    public String getRec() {
        return rec;
    }

    public void setAmounts(BigDecimal amounts) {
        this.amounts = amounts;
    }

    public BigDecimal getAmounts() {
        return amounts;
    }
}
