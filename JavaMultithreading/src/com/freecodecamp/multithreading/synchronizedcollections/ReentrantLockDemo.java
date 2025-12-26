package com.freecodecamp.multithreading.synchronizedcollections;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private final ReentrantLock lock = new ReentrantLock();
    private int sharedData = 0;

    public static void main(String[] args) {
        ReentrantLockDemo demo = new ReentrantLockDemo();
        for (int i = 0; i < 5; i++) {
            new Thread(demo::methodA).start();
        }
    }

    public void methodA() {
        lock.lock(); 
        try {
            sharedData++;
            System.out.println("methodA: sharedData = " + sharedData);
            methodB(); // call a method which also requires the lock
        } finally {
            lock.unlock();
        }
    }

    private void methodB() {
        lock.lock();
        try {
            sharedData--;
            System.out.println("methodB: sharedData = " + sharedData);
        } finally {
            lock.unlock();
        }
    }
}
