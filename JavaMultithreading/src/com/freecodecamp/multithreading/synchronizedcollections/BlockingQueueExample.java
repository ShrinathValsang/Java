package com.freecodecamp.multithreading.synchronizedcollections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// https://medium.com/@rohitsingh341/thread-safe-queue-implementations-in-java-22dd75f85cd5
public class BlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(5);

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    bq.put(String.valueOf(i));
                    System.out.println(i + " is added to queue.");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    //throw new RuntimeException(e);
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        Thread.sleep(10000);

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println(bq.take() + " is removed from queue.");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    //throw new RuntimeException(e);
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }

}
