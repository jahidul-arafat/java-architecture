package com.company.into_thread_example.demo_runnable_thread;

public class RunnableExample implements Runnable{

    @Override
    public void run() {
        System.out.println("Into "+ this.getClass());
        int i=1;
        while (i<=100){
            System.out.println(String.format("%s --> %s", i,Thread.currentThread().getName()));
            i++;
        }
    }
}
