package org.example;



import java.util.Scanner;

public class Account {

	private String ownerName;
	private String accountNum;
	private int balance;


	
	//
	// ( �䱸���� 7-1 ) ���´� �Աݱ���� �ִ�.
	public void deposit(int amount) {

		this.balance += amount;

		// �ŷ����� ����
		Bill bill = new Bill(this.accountNum, "�Ա�", amount);

		// ( �䱸���� 9 ) ���¿��� �ܰ��� ��ȭ�� ���� ������ �ŷ� ������ ��ϵȴ�.
		BillManager.recordBill(bill);

	}

	// ( �䱸���� 7-2 ) ���´� ��� ����� �ִ�. ( ��ݾ��� ���¿� ����ִ� �ݾ׺��� ���� �� )
	public void withdraw(int amount) {

		if (amount <= balance) {
			this.balance -= amount;

			Bill bill = new Bill(this.accountNum, "���", amount);

			// ( �䱸���� 9 ) ���¿��� �ܰ��� ��ȭ�� ���� ������ �ŷ� ������ ��ϵȴ�.
			BillManager.recordBill(bill);
		}
		else {
			System.out.println("������ �ܰ� �����մϴ�."); // ���⼭ ���ڵ� ���� ���� �� ����! (*)
		}
	}

	// (�䱸���� 8)
	
	// ( �䱸���� 11 ) ���´� ��� �ŷ� ������ ��ȸ�� �� �ִ�. 	
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


