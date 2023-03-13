package org.jarotball.oop.challenge.bankingapp;

public class BankAccount {
    private String owner;
    private double balance;
    private AccountType accountType;

    // Constructor
    public BankAccount(String owner, double balance, AccountType accountType) {
        this.owner = owner;
        this.balance = balance;
        this.accountType=accountType;
    }

    // Custom Methods - Instance Methods
    public void withdraw(double amount){
        if (amount<=this.balance)
            this.balance-=amount;

    }

    public void deposit(double amount ){
        this.balance+=amount;
    }

    // Getter and Setter
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Print the object

    @Override
    public String toString() {
        return "BankAccount{" +
                "owner='" + owner + '\'' +
                ", balance=" + balance +
                ", accountType=" + accountType +
                '}';
    }
}
