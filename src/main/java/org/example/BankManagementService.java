package org.example;

import java.util.Scanner;

public class BankManagementService {    // UI

    public void run(){
        showInitialMenu();
        int userInput = insertUserInput();

        switch(userInput){
            case 1:
                customerLogin();
            case 2:
                bankClerkMenu();
        }


    }


    public void showInitialMenu(){
        System.out.println("===============");
        System.out.println("1.고객으로 로그인");
        System.out.println("2.관리자 메뉴");
        System.out.println("3.프로그램 종료");
        System.out.println("===============");
    }

    public int insertUserInput(){
        Scanner s = new Scanner(System.in);

        int userInputNumber = -1;

        try {
            userInputNumber = Integer.parseInt(s.nextLine());
        } catch(NumberFormatException e){
            System.out.println("잘못된 입력입니다. 1~3사이 숫자로 다시 시도해주세요");
        }

        return userInputNumber;
    }


    // 고객으로 로그인
    public void customerLogin(){
        System.out.println("===============");
        System.out.printf("1. 성함을 입력해주세요 : ");
        Scanner s = new Scanner(System.in);
        String userName = s.nextLine();

        Bank bank = new Bank();


    }

    // 관리자 메뉴 = 은행원으로 로그인
    public void bankClerkMenu(){

    }




}
