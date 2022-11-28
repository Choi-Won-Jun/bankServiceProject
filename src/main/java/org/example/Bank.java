package org.example;

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


    // 입금, 출금하는 기능.

    // 계좌를 삭제하는 경우


}
