package com.company.into_thread_example.demo_bank_synchronization;

public class BankAccount {
    private int balance =0; // amount of money in the account
    private final int overdraft; // means, can't be changed later after being initialized in the constructor
                                 // a final variable can't have setter, instead a getter
                                 // the overdraft limit, which can't be changed after being initialized


    // constructor
    public BankAccount(int overdraft) {
        this.overdraft = overdraft;
    }

    // getter and setter
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getOverdraft() {
        return overdraft;
    }

    // other methods
    // topUp(amt) --> recharge your account
    public void topUp(int amount){
        balance+=amount;
    }

    // debit(amt) --> debit from your account
    public void debit(int amount){
        balance-=amount;
    }
}
