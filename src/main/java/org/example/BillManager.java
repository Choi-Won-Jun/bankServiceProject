package org.example;

import java.util.ArrayList;

public class BillManager {

    private static ArrayList<Bill> bills = new ArrayList<>();

    public void getAllBills(String accountNum) {
        for ( Bill bill : bills ) {
            System.out.println(/* ���� ��� ���� */);
        }
    }

    public void recordBill(Bill bill){
        bills.add(bill);
    }

}
