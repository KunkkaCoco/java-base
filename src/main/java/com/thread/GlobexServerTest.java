package com.thread;

import java.util.concurrent.*;


public class GlobexServerTest {

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        // 创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        // 创建两个有返回值的任务
        Callable c1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                for (int i = 0; i < 100000; i++) {
                    System.out.println("1:" + i);
                }
                ;
                return "1";
            }
        };
        Callable c2 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                for (int i = 0; i < 100000; i++) {
                    System.out.println("2:" + i);
                }
                ;
                return "2";
            }
        };
        // 执行任务并获取Future对象
        Future<String> f1 = pool.submit(c1);
        Future<String> f2 = pool.submit(c2);
        // 从Future对象上获取任务的返回值，并输出到控制台
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>" + f1.get());
        // 关闭线程池
        System.out.println("************************************begin end");
        pool.shutdown();
        System.out.println("************************************end");
    }

}
