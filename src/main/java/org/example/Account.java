package org.example;

import BillManager;
import Bill;

import java.util.Scanner;

public class Account {

	private String ownerName;
	private String accountNum;
	private int balance;

	
	// ( 요구사항 7-1 ) 계좌는 입기능이 있다.
	public void deposit (int amount) { 
		
		System.out.println("입금할 금액을 입력하세요.");
		int amount = scanner.nextInt();
		this.balance += amount;
		System.out.println("입금이 완료되었습니다.");
		
		Bill bill = new Bill();
		Bill.recordBill(bill);	
		
			// ( 요구사항 9 ) 계좌에서 잔고의 변화가 있을 때마다 거래 내역에 기록된다.
		BillManager billManager = new BillManager(); 
		billManager.recordBill(bill);
		
	// ( 요구사항 7-2 ) 계좌는 출금 기능이 있다.
	public void withdraw (int amount) {
		
		System.out.println("출금할 금액을 입력하세요.");
		int amount = scanner.nextInt();
		
		if (amount <= balance) {
			this.balance -= amount;
			
			// ( 요구사항 9 ) 계좌에서 잔고의 변화가 있을 때마다 거래 내역에 기록된다.
			BillManager billManager = new BillManager();
			billManager.recordBill(bill);}
		else {
		System.out.println("계좌의 잔고가 부족합니다.");
		} break;
		}
	
	// ( 요구사항 11 ) 계좌는 모든 거래 내역을 조회할 수 있다. 	
	public void getAllBills(accountNum) {
		BillManager billManager = new BillManager();
		billManager.getAllBills(accountNum);
	}
	
	
	}
	
	// Getter
	public String getOwnerName() {
		return this.ownerName;
	}
	
	public String getAccountNum() {
		return this.accountNum;
	}
	public int getBalance() {
		return this.balance;
	}
	
	
	
}


