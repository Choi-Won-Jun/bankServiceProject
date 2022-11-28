package org.example;


public class Main {
    public static void main(String[] args) {
        System.out.println("<1잘하조 은행 관리 프로그램>");
        BankManagementService bmService = new BankManagementService();
        bmService.run();
    }
}