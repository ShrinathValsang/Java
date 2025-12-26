package com.freecodecamp.multithreading.synchronizedcollections;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


/**
 * Code example to demonstrate CyclicBarrier
 */
public class MultiStageTour {
    private static final int NO_OF_TOURITS = 5;
    private static final int NO_OF_STAGES = 3;

    // action performed after barrier is broken
    private static Runnable r = () -> {
        System.out.println("Tour guide starts speaking...");
    };
    private static final CyclicBarrier barrier = new CyclicBarrier(NO_OF_TOURITS, r);

    public static void main(String[] args) {
        for (int i = 0; i < NO_OF_TOURITS; i++) {
            Thread touristThread = new Thread(new Tourist(i));
            touristThread.start();
        }
    }

    static class Tourist implements Runnable {
        private final int touristId;

        public Tourist(int id) {
            this.touristId = id;
        }

        @Override
        public void run() {
            for (int i = 0; i < NO_OF_STAGES; i++) {
                try {
                    Thread.sleep(1500); // mimics tourist doing some activity
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Tourist " + touristId + " arrives at stage " + (i+1));

                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
