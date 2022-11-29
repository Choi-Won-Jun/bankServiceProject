package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class BankManagementService {    // UI

    public void run() {
        showInitialMenu();
        int userInput = insertUserInput();

        switch (userInput) {
            case 1: // 고객으로 로그인
                customerLogin();
                break;
            case 2: // 은행으로 로그인
                bankClerkMenu();
                break;
            case 3: // 프로그램 종료
                System.out.println("프로그램이 종료됩니다.");
                System.exit(0);
                break;
        }
    }


    public void showInitialMenu() {
        System.out.println("===============");
        System.out.println("1.고객으로 로그인");
        System.out.println("2.관리자 메뉴");
        System.out.println("3.프로그램 종료");
        System.out.println("===============");
    }

    public int insertUserInput() {
        Scanner s = new Scanner(System.in);

        int userInputNumber = -1;

        try {
            userInputNumber = Integer.parseInt(s.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 1~3사이 숫자로 다시 시도해주세요");
        }

        return userInputNumber;
    }


    // 고객으로 로그인
    public void customerLogin() {
        System.out.println("===============");
        System.out.printf("1. 성함을 입력해주세요 : ");

        Scanner s = new Scanner(System.in);
        String userName = s.nextLine();

        Bank bank = new Bank();


        if (bank.CheckIfAccountExistByOwnerName(userName))
            showAccountList(userName);  // 고객이 가진 계좌 보여주기
        else {
            System.out.println("등록된 사용자 이름이 아닙니다. 계좌를 생성하시겠습니까?");
            System.out.println("1. Yes \n2. 종료하기");

            int userInputNumber = Integer.parseInt(s.nextLine());

            switch (userInputNumber) {
                case 1:
                    createOwnerAccount(userName);
                    showAccountList(userName);
                    break;
                case 2:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;
            }
        }

    }

    public void showAccountList(String ownerName) {

        AccountRepository accountRepository = new AccountRepository();

        System.out.println("<" + ownerName + "님의 계좌 목록>");
        ArrayList<Account> ownerAccounts = accountRepository.customerFindAccounts(ownerName); // 마스킹 처리 후 출력까지 완료

        System.out.println("계좌를 선택해주세요. 0번을 누르시면 처음화면으로 돌아갑니다.");
        // 번호를 입력받고
        Scanner s = new Scanner(System.in);

        int inputNumber = Integer.parseInt(s.nextLine());

        if (inputNumber == 0)
            run();  // 처음 화면으로

        // 그 계좌의 정보를 기반으로 다음 UI 보여줌.

        Account account = ownerAccounts.get(inputNumber - 1);
        showBankingService(account);

    }

    public void createOwnerAccount(String ownerName) {
        Bank bank = new Bank();

        bank.registerAccount(ownerName);
        System.out.println("계좌가 성공적으로 생성되었습니다.\n");
    }

    public void showBankingService(Account account) {

        AccountRepository accountRepository = new AccountRepository();

        // System.out.println("이거 : " + account.getAccountNum());
        String[] linkedString = account.getAccountNum().split("-");

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("\n르탄 "
                    + linkedString[0] + "-" + linkedString[1] + "-" + accountRepository.accountNoMasking(linkedString[2]) + "\n");
            System.out.println("필요한 메뉴를 선택해주세요.");
            System.out.println("1. 입금하기");
            System.out.println("2. 출금하기");
            System.out.println("3. 잔고 확인하기");
            System.out.println("4. 거래내역 확인하기");
            System.out.println("5. 종료하기");
            System.out.println("\n 0번을 누르시면 처음 화면으로 돌아갑니다.");

            int userInputNumber = Integer.parseInt(s.nextLine());

            switch (userInputNumber) {
                case 1: // 입금하기
                    System.out.println("입금하실 금액을 입력해주세요(원)");
                    int inputAmount = Integer.parseInt(s.nextLine());
                    accountRepository.depositToAccount(account.getAccountNum(), inputAmount);
                    System.out.println("입금이 완료되었습니다.");
                    break;
                case 2: // 출금하기
                    System.out.println("출금하실 금액을 입력해주세요(원)");
                    int outputAmount = Integer.parseInt(s.nextLine());
                    boolean withdrawSuccess = accountRepository.withdrawFromAccount(account.getAccountNum(), outputAmount);
                    if (withdrawSuccess) {
                        System.out.println("출금이 완료되었습니다.");
                    } else {
                        System.out.println("출금 가능한 금액이 부족합니다.");
                    }
                    break;
                case 3: // 잔액 확인하기
                    System.out.println(String.format("현재 잔액 : ￦%,d", account.getBalance()));
                    break;
                case 4: // 거래내역 확인하기
                    System.out.println("<거래내역>\n");
                    BillManager.getAllBills(account.getAccountNum());
                    break;
                case 5: // 종료하기
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                case 0: // 처음 화면으로 돌아가기
                    run();
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }


    }


    // 관리자 메뉴 = 은행원으로 로그인
    public void bankClerkMenu() {

        System.out.printf("관리자 비밀번호를 입력해주세요. : ");

        Scanner s = new Scanner(System.in);

        String adminPassword = s.nextLine();

        if (adminPassword.equals(Bank.adminPassword)) // 비밀번호가 맞을 때
            showAdminMenu();
        else {
            System.out.println("로그인 실패! 다시 시도하시겠습니까?");
            System.out.println("1. Yes \n2. 처음으로 돌아가기");

            int userInput = -1;

            while (true) {
                userInput = Integer.parseInt(s.nextLine());
                switch (userInput) {
                    case 1:
                        bankClerkMenu();
                        break;
                    case 2:
                        run();
                        break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                }
            }
        }
    }

    public void showAdminMenu() {
        while (true) {
            System.out.println("<관리자 메뉴>");
            System.out.println("1. 계좌 등록");
            System.out.println("2. 계좌 삭제");
            System.out.println("3. 계좌 조회");
            System.out.println("\n 0번을 누르면 처음 화면으로 돌아갑니다.");

            Scanner s = new Scanner(System.in);

            int userInput = Integer.parseInt(s.nextLine());

            Bank bank = new Bank();

            switch (userInput) {
                case 1: // 계좌 등록
                    System.out.printf("계좌를 등록할 고객님의 이름을 입력해주세요. : ");
                    String ownerNameRegister = s.nextLine();
                    bank.registerAccount(ownerNameRegister);
                    break;
                case 2: // 계좌 삭제
                    System.out.printf("계좌를 삭제할 고객님의 이름을 입력해주세요. : ");
                    String ownerNameDelete = s.nextLine();
                    ArrayList<Account> accountList = bank.findAccountByOwnerName(ownerNameDelete);

                    if (accountList.size() > 0) {
                        int accountCounter = 0;
                        for (Account account : accountList) {
                            accountCounter += 1;
                            System.out.println(accountCounter + ". 르탄 " + account.getAccountNum() + " " + account.getOwnerName());
                        }
                    } else {    // 고객의 이름에 해당하는 계좌가 없는 경우 -> 관리자 메뉴로 돌아간다.
                        System.out.println("해당하는 고객의 계좌가 존재하지 않습니다.");
                        System.out.println("관리자 메뉴로 돌아갑니다.");
                        showAdminMenu();
                    }
                    System.out.printf("삭제할 계좌의 번호를 입력해주세요. : ");
                    int accountIndex = Integer.parseInt(s.nextLine());
                    bank.removeAccount(accountList.get(accountIndex - 1).getAccountNum());
                    System.out.println("해당 계좌를 삭제했습니다.");
                    break;
                case 3: // 계좌 조회
                    System.out.println("1. 계좌번호로 계좌 조회");
                    System.out.println("2. 이름으로 계좌 조회");
                    System.out.println("3. 전체 계좌 조회");

                    int choice = Integer.parseInt(s.nextLine());

                    switch(choice){
                        case 1: // 계좌번호로 계좌 조회
                            System.out.printf("계좌번호를 입력해주세요 : ");
                            String accountNum = s.nextLine();
                            bank.findAccountByAccountNum(accountNum);
                            break;
                        case 2: // 이름으로 계좌 조회
                            System.out.printf("고객의 이름을 입력해주세요. : ");
                            String ownerName = s.nextLine();
                            ArrayList<Account> searchedAccountList = bank.findAccountByOwnerName(ownerName);

                            if (searchedAccountList.size() > 0) {
                                int accountCounter = 0;
                                for (Account account : searchedAccountList) {
                                    accountCounter += 1;
                                    System.out.println(accountCounter + ". 르탄 " + account.getAccountNum() + " " + account.getOwnerName());
                                }
                            } else {    // 찾는 계좌가 없는 경우
                                System.out.println("해당하는 고객의 계좌가 존재하지 않습니다.");
                                System.out.println("관리자 메뉴로 돌아갑니다.");
                                showAdminMenu();
                            }
                            break;
                        case 3: // 전체 계좌 조회
                            bank.findAllAccounts();
                            break;
                    }
                    break;
                case 0:
                    run();
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}



