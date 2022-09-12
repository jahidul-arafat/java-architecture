package com.company.into_thread_example.demo_multithreaded_app;

public class ThreadExampleImpl {
    public static void main(String[] args) {
        //System.out.println(Thread.activeCount());
        ThreadExample thread1 = new ThreadExample();
        thread1.setName("FirstThread");
        thread1.start();

        ThreadExample thread2 = new ThreadExample();
        thread2.setName("SecondThread");
        thread2.start();



    }
}
