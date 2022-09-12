package com.company.into_thread_example.demo_runnable_thread;

public class RunnableExampleImpl {
    public static void main(String[] args) {
        System.out.println("Active Thread Count: " + Thread.activeCount());

        Thread thread1 = new Thread(new RunnableExample());
        thread1.setName("FirstThread");
        thread1.start();

        // Create anotherThread, without the class <RunnableExample> used earlier, instead directly implementing the interface<Runnable>
        Thread thread2 = new Thread(() -> {
            System.out.println("SecondThread");
        });
        thread2.setName("SecondThread");
        thread2.start();

        // Thread 3
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("ThirdThread");
            }
        });
        thread3.start();


    }
}
