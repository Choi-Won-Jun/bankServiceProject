package org.example;

import java.util.ArrayList;

public class BillManager {

    private static ArrayList<Bill> bills = new ArrayList<>();

    public static void getAllBills(String accountNum) {
        for ( Bill bill : bills ) {
            System.out.println(/* ���� ��� ���� */);
        }
    }

    public static void recordBill(Bill bill){
        bills.add(bill);
    }

}
