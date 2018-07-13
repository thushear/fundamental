package com.github.thushear.cache.localcache.guava;


import com.google.common.cache.*;
import org.springframework.util.StringUtils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LocalCacheByGuava {



    public static void main(String[] args) throws ExecutionException {

        new Thread(new Runnable() {

              LoadingCache<String,String> localCache = CacheBuilder.newBuilder().recordStats().maximumSize(10)
                    .concurrencyLevel(16).expireAfterWrite(5,TimeUnit.SECONDS)
                    .removalListener(new RemovalListener<String,String>() {

                        @Override
                        public void onRemoval(RemovalNotification<String, String> removalNotification) {
                            System.err.println("remove:" + removalNotification.getKey() + " | " + removalNotification.getValue());
                        }
                    }).build(new CacheLoader<String, String>() {
                        @Override
                        public String load(String s) throws Exception {
                            TimeUnit.MILLISECONDS.sleep(1500);
                            return "cachevalue";
                        }
                    });


            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    localCache.put("" + i,i + "");
                }
                try {
                    System.err.println(localCache.get("5"));
                    System.err.println(localCache.get("5"));
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                localCache.put("1","value");
                localCache.put("2","2");
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }

                    try {
                        System.err.println(localCache.get("1"));
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();



        LockSupport.park();
        LockSupport.park();
    }

}
