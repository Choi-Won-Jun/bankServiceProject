package org.example;

import java.util.Random;

public class Bank {
    private AccountRepository accountRepository;
    private String bankName;

    Bank() {
        accountRepository = new AccountRepository();
        bankName = "��ź";   // �츮 ���迡���� ��ź���ุ �ֽ��ϴ�.
    }

    // ( �䱸���� 1 ) ������ ���¸� ����Ѵ� ( ��, ���¹�ȣ�� ���� ǥ�������� ���� )
    public void registerAccount(String ownerName){
        // 1. ���¹�ȣ ����� ����
        String accountNum = createAccountNum();

        accountRepository.registerAccount(ownerName, accountNum);
    }


    //���¹�ȣ ������ ���ڸ� 4�ڸ� ���� ������ + �߰� 4�ڸ��� �����ϰ� ���� +��5�ڸ��� ������ ����
    static int counter = 1;
    private String createAccountNum(){
        /* ���¹�ȣ ���� ���� = ���� ǥ���� */
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


    // ( �䱸���� 2 ) ������ ���¸� ����(����/����)�Ѵ�.

    // ���¸� �����ϴ� ��� ( Account�� ���� ��� = ����� �̸� / ���¹�ȣ / �ܾ� )

    // �Ա�, ����ϴ� ���.sd

    // ���¸� �����ϴ� ���


}
