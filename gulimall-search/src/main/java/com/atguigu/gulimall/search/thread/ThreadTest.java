package com.atguigu.gulimall.search.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

      /*  CompletableFuture.runAsync(()->{

        },executor);*/
//        CompletableFuture.supplyAsync(()->{
//            System.out.println("当前线程"+Thread.currentThread().getName());
//            int i = 10 / 4;
//            System.out.println("运行结果"+i);
//            return i;
//        },executor).thenApplyAsync(res->{});
    }
}
