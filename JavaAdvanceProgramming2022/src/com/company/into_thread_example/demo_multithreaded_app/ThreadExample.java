package com.company.into_thread_example.demo_multithreaded_app;

public class ThreadExample extends Thread {
    @Override
    public void run() {
        int i = 1;
        while (i<=100){
            System.out.println(String.format("%s: %s",i,this.getName()));
            i++;
        }
    }
}
