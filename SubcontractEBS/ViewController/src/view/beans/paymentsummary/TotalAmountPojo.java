package view.beans.paymentsummary;

import java.math.BigDecimal;

public class TotalAmountPojo {
    public TotalAmountPojo() {
        super();
    }
    
    private Integer totalSubContractValue = 6080000;
    private Integer totalVariations = 10000;
    private BigDecimal progress = new BigDecimal("07.03"); 
    private Integer subTotalAccumulativeValue = 428240;

    public void setTotalSubContractValue(Integer totalSubContractValue) {
        this.totalSubContractValue = totalSubContractValue;
    }

    public Integer getTotalSubContractValue() {
        return totalSubContractValue;
    }

    public void setTotalVariations(Integer totalVariations) {
        this.totalVariations = totalVariations;
    }

    public Integer getTotalVariations() {
        return totalVariations;
    }

    public void setProgress(BigDecimal progress) {
        this.progress = progress;
    }

    public BigDecimal getProgress() {
        return progress;
    }

    public void setSubTotalAccumulativeValue(Integer subTotalAccumulativeValue) {
        this.subTotalAccumulativeValue = subTotalAccumulativeValue;
    }

    public Integer getSubTotalAccumulativeValue() {
        return subTotalAccumulativeValue;
    }
}
