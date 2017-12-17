package view.beans.paymentsummary;

import java.math.BigDecimal;

import java.util.ArrayList;

public class PieDataControl {
    public ArrayList<PieChartContractData> pieData = new ArrayList<PieChartContractData>();
    public ArrayList<PaymentVariationsPojo> variationData = new ArrayList<PaymentVariationsPojo>();
    public ArrayList<VariationPojo> meterialonsiteData = new ArrayList<VariationPojo>();
    public ArrayList<DeductionPaymentLinesPojo> dedData = new ArrayList<DeductionPaymentLinesPojo>();
    public PieDataControl() {
        super();
        PieChartContractData d1 = new PieChartContractData();
        d1.setAmounts(new BigDecimal(4172000));
        d1.setRec("Total Contract Value");
        pieData.add(d1);
        PieChartContractData d2 = new PieChartContractData();
        d2.setAmounts(new BigDecimal(417440));
        d2.setRec("Total Executed Value");
        pieData.add(d2);
        PieChartContractData d3 = new PieChartContractData();
        d3.setAmounts(new BigDecimal(208240));
        d3.setRec("This Month Executed Value");
        pieData.add(d3);
        PieChartContractData d4 = new PieChartContractData();
        d4.setAmounts(new BigDecimal(7120));
        d4.setRec("80 % Total Meterial On Site");
        pieData.add(d4);
        PieChartContractData d5 = new PieChartContractData();
        d5.setAmounts(new BigDecimal(90));
        d5.setRec("Total Deductions (-)");
        pieData.add(d5);
        PieChartContractData d6 = new PieChartContractData();
        d6.setAmounts(new BigDecimal(10000));
        d6.setRec("Total Variations");
        pieData.add(d6);
        PieChartContractData d7 = new PieChartContractData();
        d7.setAmounts(new BigDecimal(225360));
        d7.setRec("Subtotal Accumulative Value");
        pieData.add(d7);
        
        
    }

    public void setPieData(ArrayList<PieChartContractData> pieData) {
        this.pieData = pieData;
    }

    public ArrayList<PieChartContractData> getPieData() {
        return pieData;
    }

    public void setVariationData(ArrayList<PaymentVariationsPojo> variationData) {
        this.variationData = variationData;
    }

    public ArrayList<PaymentVariationsPojo> getVariationData() {
        return variationData;
    }

    public void setMeterialonsiteData(ArrayList<VariationPojo> meterialonsiteData) {
        this.meterialonsiteData = meterialonsiteData;
    }

    public ArrayList<VariationPojo> getMeterialonsiteData() {
        return meterialonsiteData;
    }

    public void setDedData(ArrayList<DeductionPaymentLinesPojo> dedData) {
        this.dedData = dedData;
    }

    public ArrayList<DeductionPaymentLinesPojo> getDedData() {
        return dedData;
    }
}
