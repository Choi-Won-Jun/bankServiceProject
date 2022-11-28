package org.example;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountRepository {

    // 계좌를 다 가지고 있음.
    static ArrayList<Account> accounts = new ArrayList<>();

    // (요구사항 1) 은행은 계좌를 등록한다 ( 단, 계좌번호는 정규 표현식으로 제한 )
    public void registerAccount(String ownerName, String accountNum) {
        // 계좌 생성
        Account account = new Account(ownerName, accountNum);

        // 계좌를 account arraylist에 저장한다.
        accounts.add(account);
    }


    public void removeAccount(String accountNum) {
        if(CheckIfAccountExistsByAccountNum(accountNum)) {
            for (Account account : accounts) {
                if (accountNum.equals(account.getAccountNum())) {
                    accounts.remove(account);
                    System.out.println("해당 계좌를 삭제했습니다.");
                    break;
                }
            }
        } else {
            System.out.println("삭제할 계좌가 존재하지 않습니다.");
        }
    }

    // 계좌는 입금기능이 있다.
    public void depositToAccount(String accountNum, int amount){

        if(CheckIfAccountExistsByAccountNum(accountNum)) {
            for (Account account : accounts) {
                if (accountNum.equals(account.getAccountNum())) {
                    account.deposit(amount);
                }
            }
        } else {
            System.out.println("입금할 계좌가 존재하지 않습니다.");
        }
    }

    // 계좌는 출금기능이 있다.

    public boolean withdrawFromAccount(String accountNum, int amount){

        for (Account account : accounts) {
            if (accountNum.equals(account.getAccountNum())) {
                if (account.getBalance() >= amount) {
                    account.withdraw(amount);
                    return true;    // 출금 성공
                } else {  // 잔액 부족으로 출금 불가
                    return false;
                }
            }
        }
        return false;
    }

    public boolean CheckIfAccountExistsByAccountNum(String accountNum){
        for(Account account : accounts){
            if(accountNum.equals(account.getAccountNum()))
                return true;
        }
        return false;
    }

    public boolean CheckIfAccountExistByOwnerName(String ownerName){
        for(Account account : accounts){
            if(ownerName.equals(account.getOwnerName()))
                return true;
        }
        return false;
    }


    // ( 요구사항 3 ) 은행은 계좌번호로 계좌를 찾을 수 있다.
    public void findAccountByAccountNum(String accountNum) {

        if(CheckIfAccountExistsByAccountNum(accountNum)) {
            for (Account account : accounts) {
                if (accountNum.equals(account.getAccountNum())) {
                    System.out.println("이름 : " + account.getOwnerName()
                            + "\n 계좌번호 : " + account.getAccountNum()
                            + "\n 잔 액 : " + account.getBalance());
                }
            }
        }
        else {
            System.out.println("찾는 계좌가 존재하지 않습니다.");
        }
    }

    // ( 요구사항 4 ) 은행은 계좌의 소유자 명으로 계좌를 찾을 수 있다.
    public ArrayList<Account> findAccountByOwnerName(String ownerName) {

        ArrayList<Account> ownerAccounts = new ArrayList<>();

        int check_count = 0;
        if (accounts.size() != 0) {
            for (Account account : accounts) {
                if (ownerName.equals(account.getOwnerName())) {
                    check_count += 1;
                    ownerAccounts.add(account);
                    System.out.println("이름 : " + account.getOwnerName()
                            + "\n 계좌번호 : " + account.getAccountNum()
                            + "\n 잔 액" + account.getBalance()
                            + "---------------------------------------------");
                }
            }
            if (check_count == 0) {
                System.out.println("등록된 계좌가 존재하지 않습니다.");
            }
        } else {
            System.out.println("등록된 계좌가 존재하지 않습니다.");
        }
        return ownerAccounts;
    }

    public Account getAccountInfoByAccountNum(String accountNum){
        for ( Account account : accounts ){
            if ( accountNum.equals(account.getAccountNum()))
                return account;
        }
        return null;
    }



    // ( 요구사항 5 ) 은행은 모든 계좌의 목록을 조회할 수 있다.
    public void findAllAccounts() {
        if (accounts.size() != 0) {
            for (Account account : AccountRepository.accounts) {
                System.out.println("이름 : " + account.getOwnerName()
                        + "\n 계좌번호 : " + account.getAccountNum()
                        + "\n 잔 액" + account.getBalance()
                        + "---------------------------------------------");  //잔액을 표시해야하는지는 의문
            }
        } else {
            System.out.println("등록된 계좌가 존재하지 않습니다.");
        }
    }

    //고객이 조회할때 : 고객은 자신의 계좌만 조회 가능 but 정규 표현식이 필요 +마스킹 처리
    //split 으로 "-" 제거후 LinkedString [0,1,2]에 삼등분해서 담아놓고 2번 인덱스만 마스킹처리 후 인덱스 0 + 1+ 2 하는방식
    public ArrayList<Account> customerFindAccounts(String customerName) {

        ArrayList<Account> ownerAccounts = new ArrayList<>();

        int accountCounter = 0;

        for (Account account : accounts) {
            if (customerName.equals(account.getOwnerName())) {

                ownerAccounts.add(account);
                accountCounter += 1;

                String[] linkedString = account.getAccountNum().split("-");
                System.out.println( accountCounter + " 르탄 "
                            + linkedString[0]+"-"+linkedString[1] + "-" + accountNoMasking(linkedString[2])
                            + "\n---------------------------------------------");
            }
        }
        return ownerAccounts;
    }
    //고객조회시 마스킹 처리 로직
    public String accountNoMasking(String accountNo){
        // 계좌번호는 숫자만 파악하므로
        String regex = "(^[0-9]+)$";

        Matcher matcher = Pattern.compile(regex).matcher(accountNo);
        if(matcher.find()) {
            int length = accountNo.length();
            if(length >= 5) {
                char[] c = new char[5];
                Arrays.fill(c, '*');

                return accountNo.replace(accountNo, accountNo.substring(0, length-5) + String.valueOf(c));
            }
        }
        return accountNo;
    }
}

