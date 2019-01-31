package com.example.demo.async;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import javax.annotation.Nullable;

/**
 * @author hongjin.zhu
 * @description
 * @date 2019年01月21日 11:59
 * @modified By
 */
public class GuavaAsyncDemo {

    public static void main(String[] args) throws InterruptedException {
        GuavaSycn sycn = new GuavaSycn();
        AtomicInteger sum = new AtomicInteger(0);
        LongAdder summ = new LongAdder();
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(3));
        for (int i = 0; i < 100; i++) {
//            Futures.addCallback(service.submit(() -> {
//                summ.increment();
//                System.out.println(summ.longValue());
//                return "call running" + sum.incrementAndGet() + "!";}), sycn);
        }

        long l = System.currentTimeMillis();
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("在回调中执行耗时操作...");
            timeConsumingOperation();
            return 100;
        });

        completableFuture = completableFuture.thenCompose(i -> {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("在回调的回调中执行耗时操作...");
                timeConsumingOperation();
                return i + 100;
            });
        });//<1>
        completableFuture.whenComplete((result, e) ->
            System.out.println("计算结果:" + result)
        );
        System.out.println("主线程运算耗时:" + (System.currentTimeMillis() - l) + " ms");

    }

    static void timeConsumingOperation(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
    }

    static class GuavaSycn implements FutureCallback {
        @Override
        public void onSuccess(@Nullable Object result) {
            System.out.println(" ==success== " + result);
        }

        @Override
        public void onFailure(Throwable t) {
            System.out.println(" ==fail== " + t.getMessage());
        }
    }
}

