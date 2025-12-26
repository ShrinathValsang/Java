package com.freecodecamp.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CPUIntensiveTask {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("availableProcessors cores: " + cores);

        ExecutorService es = Executors.newFixedThreadPool(cores);
        System.out.println("Crated thread pool with: " + cores + " cores.");

        for (int i = 0; i < 20; i++) {
            es.execute(new CPUTask());
        }
    }
}

class CPUTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Some CPU intensive task being done by: " + Thread.currentThread().getName());
    }
}
