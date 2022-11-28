package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountRepository {

    // ���¸� �� ������ ����.
    static ArrayList<Account> accounts = new ArrayList<>();

    // (�䱸���� 1) ������ ���¸� ����Ѵ� ( ��, ���¹�ȣ�� ���� ǥ�������� ���� )
    public void registerAccount(String ownerName, String accountNum) {
        // ���� ����
        Account account = new Account(ownerName, accountNum);

        // ���¸� account arraylist�� �����Ѵ�.
        accounts.add(account);
    }

    // ( �䱸���� 2 ) ������ ���¸� ����(����/����)�Ѵ�. ( ������ �ŷ� ���Ұ� ���� )
    // �ŷ� ���� ���·� ���� �� ��� > �ŷ� ������ ��ȸ ���� > ���� �޴��� �ǵ��ư���
    public void accessAccount(String accountNum) {
        for (Account account : accounts) {
            if (accountNum.equals(account)) {
                System.out.println("�ŷ��� ������ �����Դϴ�. \n ������ Ȯ���Ͻ÷��� 1�� �������� ���ư����� 2���� �����ּ���.");
            } else {
                System.out.println("���� ��ȣ�� �ùٸ��� �Է����ּ���.");
            }
        }
    }

    public void stopAccount(String accountNum){
        for (Account account : accounts) {
            if (accountNum.equals(account)) {
                System.out.println("�ŷ��� ������ �����Դϴ�. \n ������ Ȯ���Ͻ÷��� 1�� �������� ���ư����� 2���� �����ּ���.");
            } else {
                System.out.println("���� ��ȣ�� �ùٸ��� �Է����ּ���.");
            }
        }
    }

    public void removeAccount(String accountNum) {
        int check_count = 0;
        if (accounts.size() != 0) {
            for (Account account : accounts) {
                if (accountNum.equals(account.getAccountNum())) ;
                accounts.remove(account);
                check_count += 1;
                break;
            }
            if (check_count == 0) {
                System.out.println("��ϵ� ���°� �������� �ʽ��ϴ�.");
            }
        } else {
            System.out.println("��ϵ� ���°� �������� �ʽ��ϴ�.");
        }
    }

    // ( �䱸���� 3 ) ������ ���¹�ȣ�� ���¸� ã�� �� �ִ�.
    public void findAccountByAccountNum(String accountNum) {
        int check_count = 0;
        if (accounts.size() != 0) {
            for (Account account : accounts) {
                if (accountNum.equals(account.getAccountNum())) {
                    check_count += 1;
                    System.out.println("�̸� : " + account.getOwnerName()
                            + "\n ���¹�ȣ : " + account.getAccountNum()
                            + "\n �� ��" + account.getBalance());
                }
            }
            if (check_count == 0) {
                System.out.println("��ϵ� ���°� �������� �ʽ��ϴ�.");
            }
        } else {
            System.out.println("��ϵ� ���°� �������� �ʽ��ϴ�.");
        }
    }

    // ( �䱸���� 4 ) ������ ������ ������ ������ ���¸� ã�� �� �ִ�.
    public void findAccountByOwnerName(String ownerName) {
        int check_count = 0;
        if (accounts.size() != 0) {
            for (Account account : accounts) {
                check_count += 1;
                if (ownerName.equals(account.getOwnerName()))
                    System.out.println("�̸� : " + account.getOwnerName()
                            + "\n ���¹�ȣ : " + account.getAccountNum()
                            + "\n �� ��" + account.getBalance()
                            + "---------------------------------------------");
            }
            if (check_count == 0) {
                System.out.println("��ϵ� ���°� �������� �ʽ��ϴ�.");
            }
        } else {
            System.out.println("��ϵ� ���°� �������� �ʽ��ϴ�.");
        }
    }


    // ( �䱸���� 5 ) ������ ��� ������ ����� ��ȸ�� �� �ִ�.
    public void findAllAccounts() {
        if (accounts.size() != 0) {
            for (Account account : AccountRepository.accounts) {
                System.out.println("�̸� : " + account.getOwnerName()
                        + "\n ���¹�ȣ : " + account.getAccountNum()
                        + "\n �� ��" + account.getBalance()
                        + "---------------------------------------------");  //�ܾ��� ǥ���ؾ��ϴ����� �ǹ�
            }
        } else {
            System.out.println("��ϵ� ���°� �������� �ʽ��ϴ�.");
        }
    }

    //���� ��ȸ�Ҷ� : ���� �ڽ��� ���¸� ��ȸ ���� but ���� ǥ������ �ʿ� +����ŷ ó��
    //split ���� "-" ������ LinkedString [0,1,2]�� �����ؼ� ��Ƴ��� 2�� �ε����� ����ŷó�� �� �ε��� 0 + 1+ 2 �ϴ¹��
    public void customerFindAccount(String customerName) {
        for (Account account : accounts) {
            if (customerName.equals(account)) {
                String[] linkedString = account.getAccountNum().split("-");
                System.out.println("�̸� : " + account.getOwnerName()
                            + "\n ���¹�ȣ : " + linkedString[0]+"-"+linkedString[1]+accountNoMasking(linkedString[2])
                            + "\n �� ��" + account.getBalance()
                            + "---------------------------------------------");
            }
        }
    }
    //����ȸ�� ����ŷ ó�� ����
    public String accountNoMasking(String accountNo){
        // ���¹�ȣ�� ���ڸ� �ľ��ϹǷ�
        String regex = "(^[0-9]+)$";

        Matcher matcher = Pattern.compile(regex).matcher(accountNo);
        if(matcher.find()) {
            int length = accountNo.length();
            if(length >= 5) {
                char[] c = new char[5];
                Arrays.fill(c, '*');

                return accountNo.replace(accountNo, accountNo.substring(0, length-5) + String.valueOf(c));
            }
        }
        return accountNo;
    }
}

