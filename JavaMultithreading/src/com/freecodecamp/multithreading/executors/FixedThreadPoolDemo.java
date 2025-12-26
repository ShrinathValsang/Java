package com.freecodecamp.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo    {
    public static void main(String[] args) {
        try(ExecutorService es1 = Executors.newFixedThreadPool(3)) {
            for (int i = 0; i < 10; i++) {
                es1.execute(new Work(i));
            }
        }
    }
}

class Work implements Runnable {
    private final int workId;

    public Work(int workId) {
        this.workId = workId;
    }

    @Override
    public void run() {
        System.out.println("The work with id: " + workId + " is being executed by the thread: "
                + Thread.currentThread().getName());
    }
}