package org.example;



import java.util.Scanner;

public class Account {

	private String ownerName;
	private String accountNum;
	private int balance;


	
	//
	// ( 요구사항 7-1 ) 계좌는 입금기능이 있다.
	public void deposit(int amount) {

		this.balance += amount;

		// 거래내역 생성
		Bill bill = new Bill(this.accountNum, "입금", amount);

		// ( 요구사항 9 ) 계좌에서 잔고의 변화가 있을 때마다 거래 내역에 기록된다.
		BillManager.recordBill(bill);

	}

	// ( 요구사항 7-2 ) 계좌는 출금 기능이 있다. ( 출금액이 계좌에 들어있는 금액보다 작을 때 )
	public void withdraw(int amount) {

		if (amount <= balance) {
			this.balance -= amount;

			Bill bill = new Bill(this.accountNum, "출금", amount);

			// ( 요구사항 9 ) 계좌에서 잔고의 변화가 있을 때마다 거래 내역에 기록된다.
			BillManager.recordBill(bill);
		}
		else {
			System.out.println("계좌의 잔고가 부족합니다."); // 여기서 인코딩 문제 생길 수 있음! (*)
		}
	}

	// (요구사항 8)
	
	// ( 요구사항 11 ) 계좌는 모든 거래 내역을 조회할 수 있다. 	
	public void getAllBills() {
		BillManager.getAllBills(accountNum);
	}


	// Constructor
	public Account(String ownerName, String accountNum){
		this.ownerName = ownerName;
		this.accountNum = accountNum;
		this.balance = 0;
	}

	// Getter
	public String getOwnerName() {
		return this.ownerName;
	}
	public String getAccountNum() {
		return this.accountNum;
	}
	public int getBalance() { return this.balance; }
	
	
	
}


