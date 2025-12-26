package com.freecodecamp.multithreading.synchronizedcollections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
    private final Integer MAX_SIZE = 5;
    private final Lock lock = new ReentrantLock();
    private final Queue<Integer> buffer = new LinkedList<>();
    private final Condition bufferNotFull = lock.newCondition();
    private final Condition bufferNotEmpty = lock.newCondition();

    public static void main(String[] args) {
        ConditionDemo cdemo = new ConditionDemo();
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    cdemo.produce(i);
                    Thread.sleep(1200);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    cdemo.consume();
                    Thread.sleep(2500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer.start();
    }

    private void produce(int item) throws InterruptedException {
        lock.lock();

        try {
            // processing...
            while (buffer.size() == MAX_SIZE) {
                bufferNotFull.await();
            }

            buffer.offer(item); // inserts element to the queue, if fails returns false
            System.out.println("produced >>> " + item);
            bufferNotEmpty.signal(); // singals other waiting thread that buffer is not empty
        } finally {
            lock.unlock();
        }
    }

    private void consume() throws InterruptedException {
        lock.lock();

        try {
            while (buffer.isEmpty()) {
                bufferNotEmpty.await(); // if the buffer is empty, the consume method has to wait
                                        // signals producer to produce
            }
            System.out.println("Consumed >>> " + buffer.poll());
            bufferNotFull.signal();
        } finally {
            lock.unlock();
        }
    }

}
