package com.github.thushear.executor;


import java.util.concurrent.*;

public class ExecutorIV {

    public static void main(String[] args) throws InterruptedException {

        TimeUnit.SECONDS.sleep(5);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Executor executor = new ThreadPoolExecutor(2,5,5L,TimeUnit.SECONDS,new LinkedBlockingQueue<>(2),new ThreadPoolExecutor.AbortPolicy());
        executor.execute(runnable);

        TimeUnit.SECONDS.sleep(10);

        for (int i = 0; i < 20; i++) {
            executor.execute(runnable);
        }

//        new ThreadPoolExecutor(nThreads, nThreads,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>());

    }

}
