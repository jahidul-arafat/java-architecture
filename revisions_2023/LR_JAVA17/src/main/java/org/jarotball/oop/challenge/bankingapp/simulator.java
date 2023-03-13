package org.jarotball.oop.challenge.bankingapp;

public class simulator {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount("Alice",1000,AccountType.CURRENT);
        BankAccount bankAccount2 = new BankAccount("Bob", 500, AccountType.SAVINGS);

        System.out.println(bankAccount1);
        System.out.println(bankAccount2);

        bankAccount1.withdraw(400.45);
        System.out.println(bankAccount1.getBalance());

        bankAccount2.deposit(1000.55);
        System.out.println(bankAccount2.getBalance());
    }
}
