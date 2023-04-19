package section163.application;

import section163.entities.Account;
import section163.entities.BusinessAccount;
import section163.entities.SavingsAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Program {

    public static void main(String[] args) {

        //Account acc1 = new Account(1001, "Alex", 1000.0); deu erro porque agora account é uma classe abstrata
        Locale.setDefault(Locale.US);
        List<Account> list = new ArrayList<>();

        list.add(new SavingsAccount(1001, "Alex", 500.00, 0.01));
        list.add(new BusinessAccount(1002, "Maria", 1000.00, 400.00));
        list.add(new SavingsAccount(1004, "Bob", 300.00, 0.01));
        list.add(new BusinessAccount(1005, "Ana", 500.00, 500.00));

        double sum = 0.0;
        for (Account acc : list) { //funciona pois todos os tipos de contas são-uma conta
            sum += acc.getBalance();
        }

        System.out.printf("Total balance: %.2f%n" , sum);

        for (Account acc : list) { //deposita 10 reais em cada conta
            acc.deposit(10.0);
        }

        for (Account acc : list) {
            System.out.printf("Update balance for account %d: %.2f%n", acc.getNumber(), acc.getBalance()); //o %d serve pra inteiro
        }

    }
}