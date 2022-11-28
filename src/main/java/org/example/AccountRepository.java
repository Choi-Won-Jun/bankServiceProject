package org.example;

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

    // (요구사항 2) 계좌 수정하기 = 활성화 비활성화여부
    public void updateAccountAvailability(String accountNum){
        for( Account account : accounts ){
            if(account.getAccountNum().equals(accountNum)) // 찾는 계좌면
                if ( account.getAvailability() ) { // 활성화 되어있는 경우
                    System.out.println("계좌가 활성화 상태입니다.");
                    account.
                }

            System.out.println("");
        }
    }


    public void removeAccount(String accountNum) {
        int check_count = 0;
        if (accounts.size() != 0) {
            for (Account account : accounts) {
                if (accountNum.equals(account.getAccountNum())) ;
                accounts.remove(account);
                check_count += 1;
                break;
            }
            if (check_count == 0) {
                System.out.println("등록된 계좌가 존재하지 않습니다.");
            }
        } else {
            System.out.println("등록된 계좌가 존재하지 않습니다.");
        }
    }

    // ( 요구사항 3 ) 은행은 계좌번호로 계좌를 찾을 수 있다.
    public void findAccountByAccountNum(String accountNum) {
        int check_count = 0;
        if (accounts.size() != 0) {
            for (Account account : accounts) {
                if (accountNum.equals(account.getAccountNum())) {
                    check_count += 1;
                    System.out.println("이름 : " + account.getOwnerName()
                            + "\n 계좌번호 : " + account.getAccountNum()
                            + "\n 잔 액" + account.getBalance());
                }
            }
            if (check_count == 0) {
                System.out.println("등록된 계좌가 존재하지 않습니다.");
            }
        } else {
            System.out.println("등록된 계좌가 존재하지 않습니다.");
        }
    }

    // ( 요구사항 4 ) 은행은 계좌의 소유자 명으로 계좌를 찾을 수 있다.
    public void findAccountByOwnerName(String ownerName) {
        int check_count = 0;
        if (accounts.size() != 0) {
            for (Account account : accounts) {
                check_count += 1;
                if (ownerName.equals(account.getOwnerName()))
                    System.out.println("이름 : " + account.getOwnerName()
                            + "\n 계좌번호 : " + account.getAccountNum()
                            + "\n 잔 액" + account.getBalance()
                            + "---------------------------------------------");
            }
            if (check_count == 0) {
                System.out.println("등록된 계좌가 존재하지 않습니다.");
            }
        } else {
            System.out.println("등록된 계좌가 존재하지 않습니다.");
        }
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
    public void customerFindAccount(String customerName) {
        for (Account account : accounts) {
            if (customerName.equals(account)) {
                String[] linkedString = account.getAccountNum().split("-");
                System.out.println("이름 : " + account.getOwnerName()
                            + "\n 계좌번호 : " + linkedString[0]+"-"+linkedString[1]+accountNoMasking(linkedString[2])
                            + "\n 잔 액" + account.getBalance()
                            + "---------------------------------------------");
            }
        }
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

