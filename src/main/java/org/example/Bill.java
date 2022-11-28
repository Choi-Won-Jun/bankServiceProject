package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Bill {

    // ( 요구사항 10 ) 계좌의 거래 내역은 거래 일자, 거래 시간, 계좌번호, 입금/출금 여부, 거래 금액, 은행 명으로 구성된다.
    private String dealDate;   // 거래 일자 <- 시스템에서 하믄 됨 ( 파라미터로 받을필요 x )
    private String dealTime;   // 거래 시간 <- 시스템에서 하믄 됨 ( 파라미터로 받을필요 x )
    private String accountNum; // 계좌 번호 <- Account 의 deposit / withdraw에서 넘겨줘야함. 메시지로
    private String depositOrWithdraw;  // 입금/출금 여부 <- deposit / withdraw에서 받음.
    private int dealAmount;    // 거래 금액 <- Account의 deposit/withdraw에서 넘겨줌
    private String bankName;   // 은행 이름 : 르탄 은행으로 고정


    // Constructor
    Bill(String accountNum, String depositOrWithdraw, int dealAmount ){
        this.accountNum = accountNum;
        this.depositOrWithdraw = depositOrWithdraw; // "입금", "출금"만 가능.
        this.dealAmount = dealAmount;
        // dealDate 초기화 로직 ( 현재 시간 메모장 서비스에서 LocalDate 사용한거처럼 )
        // 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
        LocalDate nowMonth = LocalDate.now();
        DateTimeFormatter formatterMonth = DateTimeFormatter.ofPattern("yyyy/MM/dd");//포멧
        this.dealDate = nowMonth.format(formatterMonth); // 저장
        // dealTime 초기화 로직
        // 현재 시간
        LocalTime nowTime = LocalTime.now();
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.dealTime= nowTime.format(formatterTime);
        this.bankName = "르탄";  // 우리 세계에서는 르탄 은행만 있습니다.
    }


    // Getter
    public String getDealDate() {
        return this.dealDate;
    }

    public String getDealTime(){
        return this.dealTime;
    }

    public String getAccountNum(){
        return this.accountNum;
    }

    public String getDepositOrWithdraw(){
        return this.depositOrWithdraw;
    }

    public int getDealAmount(){
        return this.dealAmount;
    }

    public String getBankName(){
        return this.bankName;
    }

}