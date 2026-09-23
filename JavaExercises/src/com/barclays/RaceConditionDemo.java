package com.barclays;

public class RaceConditionDemo {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        /*Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter++;
                }
            }
        };*/
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join(); t2.join();
        System.out.println("Counter: " + counter); // expected: 20000, actual output: 12778
    }
}
