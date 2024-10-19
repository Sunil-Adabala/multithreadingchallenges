package com.multithreading.threadpoolexecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setName("Custom Thread");
        th.setPriority(10);
        th.setDaemon(false);
        return th;
    }
}
