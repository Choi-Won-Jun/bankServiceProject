package org.example;

public class Account {

    /* Field */

    private String ownerName;

    private String accountNum; // ���¹�ȣ

    private int balance; //�ܰ�


    /* Method */

    // Construtor
    Account(String ownerName, String accountNum){

    } // balance = 0 ���� �����ع�����.


    // Getter

    public String getOwnerName(){
        return this.ownerName;
    }

    public String getAccountNum(){
        return this.accountNum;
    }


    // ( �䱸���� 8 ) ���´� �ܰ� Ȯ�� ����� �ִ�.
    public int getBalance() {
        // Bank�� ȣ���� ��. -> Bank�� AccountRepository ����,
        // accountNum�� �Ѱ� ��.
        //	-> AccountRepository�� ������ �ִ� ���� ��������, ������. �� Account�� ã�Ƽ�
        // getBalance(). �� �Ἥ, �ܰ� �����´�.
        return this.balance;
    }


    // ( �䱸���� 7-1 ) ���´� �Ա� ����� �ִ�.
    public void deposit(int amount) {

        this.balance += amount;


    }


    // ( �䱸���� 7-2 ) ���´� ��� ����� �ִ�.
    public void withdraw(int amount) {
        // ����, ����� �ݾ� > ������ ���� �ݾ� �� ��� ����ó��
        // �׿� �´� ����

        this.balance -= amount;



    }


    // ( �䱸���� 9 ) ���¿��� �ܰ��� ��ȭ�� ���� ������ �ŷ� ������ ��ϵȴ�.
    public void recordBill(Bill bill) {
        BillManager billManager = new BillManager();
        billManager.recordBill(bill);
    }


    // ( �䱸���� 11 ) ���´� ��� �ŷ� ������ ��ȸ�� �� �ִ�.
    public void getAllBills( String accountNum ){
        BillManager billManager = new BillManager();
        billManager.getAllBills(accountNum);
    }
}
