package com.iguid.loc.view.beans;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;

public class LCExpensePage {
    public LCExpensePage() {
        super();
        LCExpensePojo pojo1 = new LCExpensePojo(1, "Amendment Expenses", new Date(),
                                                new BigDecimal("20.00"), "", "LC Amend", "USD", null);
        LCExpensePojo pojo2 = new LCExpensePojo(2, "Transportation Expenses", new Date(),
                                                new BigDecimal("30.00"), "", "LC", "USD", null);
        expList.add(pojo1);
        expList.add(pojo2);
    }
    
    private ArrayList<LCExpensePojo> expList = new ArrayList<LCExpensePojo>();

    public void setExpList(ArrayList<LCExpensePojo> expList) {
        this.expList = expList;
    }

    public ArrayList<LCExpensePojo> getExpList() {
        return expList;
    }
}
