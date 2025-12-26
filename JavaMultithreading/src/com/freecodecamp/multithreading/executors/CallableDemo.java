package com.freecodecamp.multithreading.executors;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService es = Executors.newFixedThreadPool(4);
        //es.execute(new ReturnValueTask());
        Future<Integer> future = es.submit(new ReturnValueTask());

        // future.get() is a blocking operation
        // System.out.println(future.get());
        // System.out.println(future.get(1, TimeUnit.SECONDS)); // => Exception in thread "main" java.util.concurrent.TimeoutException
                                                                 // at java.base/java.util.concurrent.FutureTask.get(FutureTask.java:204)

        System.out.println(future.get(6, TimeUnit.SECONDS));

        future.cancel(true);
        boolean cancelled = future.isCancelled();
        boolean done = future.isDone();

        System.out.println("Main thread execution completed!");
    }
}

class ReturnValueTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(3000);
        return 12;
    }
}