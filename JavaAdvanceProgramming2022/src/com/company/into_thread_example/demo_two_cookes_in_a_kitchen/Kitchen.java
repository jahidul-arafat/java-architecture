package com.company.into_thread_example.demo_two_cookes_in_a_kitchen;

public class Kitchen {
    public static Object spoon = new Object();
    public static Object bowl = new Object();

    public static void main(String[] args) {
        Thread cook1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (spoon)
                {
                    System.out.println("Cook1: Holding the spoon...");
                    System.out.println("Cook1: Waiting for the bowl...");

                    synchronized (bowl)
                    {
                        System.out.println("Cook1: Holding the spoon and the bowl.");
                    }
                }
            }
        });

        Thread cook2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (bowl)
                {
                    System.out.println("Cook2: Holding the bowl...");
                    System.out.println("Cook2: Waiting for the spoon...");

                    synchronized (spoon)
                    {
                        System.out.println("Cook2: Holding both the spoon and the bowl.");
                    }
                }
            }
        });

        Thread cook3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (spoon)
                {
                    System.out.println("Cook3: Holding the spoon...");
                    System.out.println("Cook3: Waiting for the bowl...");

                    synchronized (bowl)
                    {
                        System.out.println("Cook3: Holding both the spoon and the bowl.");
                    }
                }
            }
        });

        cook1.start();
        cook3.start();



    }

}
