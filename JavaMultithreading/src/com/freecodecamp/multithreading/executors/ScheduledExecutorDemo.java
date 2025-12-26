package com.freecodecamp.multithreading.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);
        scheduledExecutor.scheduleAtFixedRate(new ProbeTask(), 1000, 2000, TimeUnit.MILLISECONDS);

        try {
            if (!scheduledExecutor.awaitTermination(10000, TimeUnit.MILLISECONDS)) {
                scheduledExecutor.shutdownNow(); // shuts down all the tasks including tasks being executed
            }
        } catch (InterruptedException e) {
            scheduledExecutor.shutdownNow();
        }
    }
}

class ProbeTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Probing end for updates...");
    }
}
