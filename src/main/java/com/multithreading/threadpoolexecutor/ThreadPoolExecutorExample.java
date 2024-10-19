package com.multithreading.threadpoolexecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {
    public static void main(String[] args){

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), new CustomThreadFactory(), new CustomRejectionHandler());

        for (int i = 0; i < 10; i++){

            threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    System.out.println("THREAD INTERRUPTED"+e);
                }
                System.out.println("Thread executed -> "+Thread.currentThread().getName());
            });

        }


    }
}
