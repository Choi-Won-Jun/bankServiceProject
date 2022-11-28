package org.example;

import java.util.ArrayList;

public class BillManager {

    private static ArrayList<Bill> bills = new ArrayList<>();

    public static void getAllBills(String accountNum) {
        for ( Bill bill : bills ) {
            if(bill.getAccountNum().equals(accountNum) )
            {
                System.out.println(String.format("���� : %s, ���¹�ȣ : %s, ��/��� ���� : %s, �ŷ� �ݾ� : ��%,d, �ŷ����� : %s, �ŷ� �ð�  : %s"  ,
                        bill.getBankName(),bill.getAccountNum(),bill.getDepositOrWithdraw(),bill.getDealAmount(),bill.getDealDate(),bill.getDealTime()));
            }
        }
    }

    public static void recordBill(Bill bill){
        bills.add(bill);
    }

}