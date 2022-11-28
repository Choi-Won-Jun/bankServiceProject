package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private AccountRepository accountRepository;
    private String bankName;

    Bank() {
        accountRepository = new AccountRepository();
        bankName = "르탄";   // 우리 세계에서는 르탄은행만 있습니다.
    }

    // ( 요구사항 1 ) 은행은 계좌를 등록한다 ( 단, 계좌번호는 정규 표현식으로 제한 )
    public void registerAccount(String ownerName){
        // 1. 계좌번호 만드는 로직
        String accountNum = createAccountNum();

        accountRepository.registerAccount(ownerName, accountNum);
    }


    //계좌번호 생성시 앞자리 4자리 은행 고유값 + 중간 4자리는 일정하게 증가 +뒷5자리는 난수로 구성
    static int counter = 1;
    private String createAccountNum(){
        /* 계좌번호 생성 로직 = 정규 표현식 */
        Random random = new Random();
        int createNum = 0;
        String ranNum = "";
        String randomNum = "";
        for (int i=0; i<5; i++) {
            createNum = random.nextInt(9);
            ranNum = Integer.toString(createNum);
            randomNum += ranNum;
        }
        String onlyBankNum = "8016";
        String countAccountNum = String.format("%04d",counter);

        counter++;
        String accountNum = onlyBankNum+"-"+countAccountNum+"-"+randomNum;
        return accountNum;
    }


    // ( 요구사항 2 ) 은행은 계좌를 관리(삭제)한다.
    public void deleteAccount(String accountNum){
        accountRepository.removeAccount(accountNum);
    }

    // 입금, 출금하는 기능.

    // 계좌를 삭제하는 경우
    public void removeAccount(String accountNum){
        accountRepository.removeAccount(accountNum);
    }

    // 요구사항 3. 은행은 계좌번호로 계좌를 찾을 수 있다.
    public void findAccountByAccountNum(String accountNum){
        accountRepository.findAccountByAccountNum(accountNum);
    }

    // 요구사항 4. 은행은 계좌의 소유명으로 계좌를 찾을 수 있다.
    public ArrayList<Account> findAccountByOwnerName(String ownerName){
        return accountRepository.findAccountByOwnerName(ownerName);
    }

    // 요구사항 5. 은행은 모든 계좌의 목록을 조회할 수 있다.
    public void findAllAccounts(){
        accountRepository.findAllAccounts();
    }

    public boolean CheckIfAccountExistByOwnerName(String ownerName){
        return accountRepository.CheckIfAccountExistByOwnerName(ownerName);
    }


}
