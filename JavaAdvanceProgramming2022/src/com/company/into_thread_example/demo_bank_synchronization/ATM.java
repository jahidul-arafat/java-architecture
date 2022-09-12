package com.company.into_thread_example.demo_bank_synchronization;

public class ATM {
    // both Thread t1 and t2 will enter the method withdraw() at the sametime, results in both getting the $100 balance, which might not be true
    // to avoid this conflict, to let only one thread access the withdraw() method at a single time and let others to wait until thread-1 finishes
    // use keyword <synchronized>
    // public static void withdraw(BankAccount account, int amountToBeWithdrawn)
    // public static synchronized void withdraw(BankAccount account, int amountToBeWithdrawn)
    public static synchronized void withdraw(BankAccount account, int amountToBeWithdrawn) {
        int currentBalance = account.getBalance();

        /*
         * i.e. balance =0
         *      topUp = 100; so, balance = 0+100 =100
         *      overdraft = 50
         *      Means, user can withdraw upto 150 USD
         * that's why, 100 - 100 < 50  --> yes
         *            100 - 150 < 50 --> yes
         *            100 - 200 < 50 --> yes // but it should be "No", user cant withdraw $200
         *
         * */
        if ((currentBalance - amountToBeWithdrawn) <  - account.getOverdraft()) {
            System.out.println("Transaction denied "+ Thread.currentThread().getName());

        } else {
            account.debit(amountToBeWithdrawn);
            System.out.println(String.format("$ %s successfully withdrawn %s", amountToBeWithdrawn, Thread.currentThread().getName()));
        }

        System.out.println(String.format("Current Balance is: %s |%s", account.getBalance(),Thread.currentThread().getName()));
        System.out.println("--------\n");
    }

}
