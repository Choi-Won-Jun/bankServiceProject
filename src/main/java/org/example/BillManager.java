package org.example;

import java.util.ArrayList;

public class BillManager {

    private static ArrayList<Bill> bills = new ArrayList<>();

    public static void getAllBills(String accountNum) {
        for ( Bill bill : bills ) {
            if(bill.getAccountNum().equals(accountNum) )
            {
                AccountRepository accountRepository = new AccountRepository();

                String[] linkedString = accountNum.split("-");

                String AccountNumMasking = linkedString[0]+"-"+linkedString[1] + "-" + accountRepository.accountNoMasking(linkedString[2]);

                System.out.println(String.format("은행 : %s, 계좌번호 : %s, 입/출금 여부 : %s, 거래 금액 : ￦%,d, 거래일자 : %s, 거래 시간  : %s"  ,
                        bill.getBankName(),AccountNumMasking,bill.getDepositOrWithdraw(),bill.getDealAmount(),bill.getDealDate(),bill.getDealTime()));
            }
        }
    }

    public static void recordBill(Bill bill){
        bills.add(bill);
    }

}