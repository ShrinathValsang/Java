package com.barclays;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

class SumTask extends RecursiveTask<Integer> {

    private final int[] arr;
    private final int start, end;
    private final int THRESHOLD = 10;

    public SumTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if ((end - start) <= THRESHOLD) {
            int sum = 0;
            for (int i : arr) {
                sum += arr[i];
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            SumTask left = new SumTask(arr, start, mid);
            SumTask right = new SumTask(arr, mid, end);

            left.fork(); // asynchronously execute left
            int rightRes = right.compute(); // compute right directly
            int leftRes = left.join(); // wait for left result

            return rightRes + leftRes;
        }
    }
}

public class ForkJoinExample {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) arr[i] = i + 1;

        ForkJoinPool pool = new ForkJoinPool();
        int result = pool.invoke(new SumTask(arr, 0, arr.length));
        System.out.println("Sum = " + result);
    }
}
