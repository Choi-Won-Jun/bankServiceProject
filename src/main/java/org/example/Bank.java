package org.example;

import java.util.ArrayList;

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

    private String createAccountNum(){
        /* 계좌번호 생성 로직 = 정규 표현식 */
        return "";
    }
      //이거 내가 건드린건데 바뀌나 by진재혁

    // ( 요구사항 2 ) 은행은 계좌를 관리(수정/삭제)한다.

    // 계좌를 수정하는 경우 ( Account의 구성 요소 = 사용자 이름 / 계좌번호 / 잔액 )

    // 입금, 출금하는 기능.

    // 계좌를 삭제하는 경우



    // ( 요구사항 3 ) 은행은 계좌번호로 계좌를 찾을 수 있다.
    public Account findAccountByAccountNum(String accountNum){
        return accountRepository.findAccountByAccountNum(accountNum);
    }

    // ( 요구사항 4 ) 은행은 계좌의 소유자 명으로 계좌를 찾을 수 있다.
    public ArrayList<Account> findAccountByOwnerName(String ownerName){
        return accountRepository.findAccountByOwnerName(ownerName);
    }

    // ( 요구사항 5 ) 은행은 모든 계좌의 목록을 조회 할 수 있다.
    public ArrayList<Account> findAllAccounts(){
        return accountRepository.findAllAccounts();
    }



}
