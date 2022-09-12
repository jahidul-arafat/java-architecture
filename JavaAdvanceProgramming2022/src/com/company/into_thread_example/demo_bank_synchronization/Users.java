package com.company.into_thread_example.demo_bank_synchronization;

/**
 * @scenario suppose a user having two ATM cards through which he is trying to withdraw money at the sametime
 *
 * */
public class Users {
    private static final BankAccount userAccount = new BankAccount(50);

    public static void main(String[] args) {
        userAccount.topUp(100);     // balance become $100

        // user with card1 : trying to withdraw money
        Thread t1 = new Thread(()-> ATM.withdraw(userAccount,100));
        t1.setName("Card-1");

        Thread t2 = new Thread(()-> ATM.withdraw(userAccount,100));
        t2.setName("Card-2");


        // user with card2 : trying to withdraw money
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                ATM.withdraw(userAccount,100);
//            }
//        });
        t2.start();
        t1.start();




    }
}
