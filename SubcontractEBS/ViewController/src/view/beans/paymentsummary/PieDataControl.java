package view.beans.paymentsummary;

import java.math.BigDecimal;

import java.util.ArrayList;

public class PieDataControl {
    public ArrayList<PieChartContractData> pieData = new ArrayList<PieChartContractData>();
    public ArrayList<PaymentVariationsPojo> variationData = new ArrayList<PaymentVariationsPojo>();
    public ArrayList<VariationPojo> meterialonsiteData = new ArrayList<VariationPojo>();
    public ArrayList<DeductionPaymentLinesPojo> dedData = new ArrayList<DeductionPaymentLinesPojo>();
    public ArrayList<PaymentLinesSummary> payLineData = new ArrayList<PaymentLinesSummary>();
    //PaymentLinesSummary
    
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
        PaymentVariationsPojo variations =new PaymentVariationsPojo();
        variations.setTaskno("01.01.90");
        variations.setSno("1");
        variations.setDesc("Doors");
        variations.setUOM("NOS");
        variations.setCompletePct(new BigDecimal(100));
        variations.setNetQty(new BigDecimal(10000));
        variations.setPrevmonthqty(new BigDecimal(0));
        variations.setPrevnet(new BigDecimal(0));
        variations.setPrevpct(new BigDecimal(0));
        variations.setQty(new BigDecimal(10));
        variations.setRate(new BigDecimal(1000));
        variations.setTotVal(new BigDecimal(10000));
        variationData.add(variations);
        VariationPojo metOnsite = new VariationPojo();
        metOnsite.setSno("1");
        metOnsite.setDesc("Portland Cement");
        metOnsite.setUOM("TON");
        metOnsite.setPrevmonthqty(new BigDecimal(0));
        metOnsite.setCurrMonthQty(new BigDecimal(1000));
        metOnsite.setTotQty(new BigDecimal(100));
        metOnsite.setQty(new BigDecimal(1000));
        metOnsite.setQtyUsed(new BigDecimal(0));
        metOnsite.setRate(new BigDecimal(10));
        metOnsite.setBalQty(new BigDecimal(100));        
        metOnsite.setCompletePct(new BigDecimal(100));
        meterialonsiteData.add(metOnsite);
        DeductionPaymentLinesPojo dpl = new DeductionPaymentLinesPojo();
        dpl.setCompletePct(new BigDecimal(100));
        dpl.setDedNetQty(new BigDecimal(900));
        dpl.setDesc("Labors");
        dpl.setDiff(new BigDecimal(900));
        dpl.setPrevmonthqty(new BigDecimal(0));
        dpl.setPrevnet(new BigDecimal(0));
        dpl.setPrevpct(new BigDecimal(0));
        dpl.setQty(new BigDecimal(20));
        dpl.setSno("1");
        dpl.setUOM("LUMP SUM");
        dpl.setUnitrate(new BigDecimal(10));
        dedData.add(dpl);
        PaymentLinesSummary pl1 = new PaymentLinesSummary();
        pl1.setActid("001");
        pl1.setContrValue(new BigDecimal(12000));
        pl1.setCurrMonValue(new BigDecimal(240));
        pl1.setDescr("Apply and supply HD");
        pl1.setMonIncr(new BigDecimal(2));
        pl1.setPctComp(new BigDecimal(12));
        pl1.setPctValue(new BigDecimal(1440));
        pl1.setPreMonth(new BigDecimal(10));
        pl1.setRemarks("");
        pl1.setTaskNo("01.01.90");
        PaymentLinesSummary pl2 = new PaymentLinesSummary();
        pl2.setActid("002");
        pl2.setContrValue(new BigDecimal(4160000));
        pl2.setCurrMonValue(new BigDecimal(208000));
        pl2.setDescr("Apply and suppy com");
        pl2.setMonIncr(new BigDecimal(5));
        pl2.setPctComp(new BigDecimal(10));
        pl2.setPctValue(new BigDecimal(416000));
        pl2.setPreMonth(new BigDecimal(5));
        pl2.setRemarks("");
        pl2.setTaskNo("01.01.90");
        payLineData.add(pl1);
        payLineData.add(pl2);
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

    public void setPayLineData(ArrayList<PaymentLinesSummary> payLineData) {
        this.payLineData = payLineData;
    }

    public ArrayList<PaymentLinesSummary> getPayLineData() {
        return payLineData;
    }
}
