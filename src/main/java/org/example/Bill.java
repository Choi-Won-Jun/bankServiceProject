package org.example;

public class Bill {

    // ( �䱸���� 10 ) ������ �ŷ� ������ �ŷ� ����, �ŷ� �ð�, ���¹�ȣ, �Ա�/��� ����, �ŷ� �ݾ�, ���� ������ �����ȴ�.
    private String dealDate;   // �ŷ� ���� <- �ý��ۿ��� �Ϲ� �� ( �Ķ���ͷ� �����ʿ� x )
    private String dealTime;   // �ŷ� �ð� <- �ý��ۿ��� �Ϲ� �� ( �Ķ���ͷ� �����ʿ� x )
    private String accountNum; // ���� ��ȣ <- Account �� deposit / withdraw���� �Ѱ������. �޽�����
    private String depositOrWithdraw;  // �Ա�/��� ���� <- deposit / withdraw���� ����.
    private int dealAmount;    // �ŷ� �ݾ� <- Account�� deposit/withdraw���� �Ѱ���
    private String bankName;   // ���� �̸� : ��ź �������� ����


    // Constructor
    Bill(String accountNum, String depositOrWithdraw, int dealAmount ){
        this.accountNum = accountNum;
        this.depositOrWithdraw = depositOrWithdraw; // "�Ա�", "���"�� ����.
        this.dealAmount = dealAmount;

        // dealDate �ʱ�ȭ ���� ( ���� �ð� �޸��� ���񽺿��� LocalDate ����Ѱ�ó�� )

        // dealTime �ʱ�ȭ ����

        this.bankName = "��ź";  // �츮 ���迡���� ��ź ���ุ �ֽ��ϴ�.
    }


    // Getter
    public String getDealDate() {
        return this.dealDate;
    }

    public String getDdealTime(){
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
