package com.freecodecamp.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorDemo {
    public static void main(String[] args) {
        try (ExecutorService es = Executors.newSingleThreadExecutor()) {
            for (int i = 0; i < 5; i++) {
                es.execute(new Task(i));
            }
        } catch (Exception e) {

        }
    }

}

class Task implements Runnable {
    private final int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task with Id: " + taskId + " being executed by the thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}