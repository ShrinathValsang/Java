package com.freecodecamp.multithreading.executors;

import java.util.concurrent.CountDownLatch;

public class Driver {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(5);

        for (int i = 0; i < 5; ++i) { // create and start threads
            new Thread(new Worker1(startSignal, doneSignal)).start();
        }

        Thread.sleep(2000); //doSomethingElse();          // don't let run yet
        startSignal.countDown();    // let all Worker threads proceed
        Thread.sleep(3000); //doSomethingElse();          //
        doneSignal.await();         // wait for threads to finish
        System.out.println("All worker tasks complete!");
    }

    private static void doSomethingElse() {
        for (int j = 0; j < 1; j++) {
            System.out.print("count: " + j + ", ");
        }
    }
}

class Worker1 implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    public Worker1(CountDownLatch start, CountDownLatch done) {
        this.startSignal = start;
        this.doneSignal = done;
    }

    @Override
    public void run() {
        try {
            System.out.println("Worker thread: " + Thread.currentThread().getName());
            startSignal.await();
            doWork();
            System.out.println("Worker thread finished the work: " + Thread.currentThread().getName());
            doneSignal.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void doWork() throws InterruptedException {
        Thread.sleep(2000);
        /*int n = 5 ;
        while (n > 0) {
            System.out.print("do some work " + n-- + ".");
        }*/
    }
}
