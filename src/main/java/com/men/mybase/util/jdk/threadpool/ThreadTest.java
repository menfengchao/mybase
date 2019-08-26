package com.men.mybase.util.jdk.threadpool;

import java.util.concurrent.*;

/**
 * 线程池测试
 */
public class ThreadTest {

    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread();
            }
        };
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(500);
        //1:corePoolSize 线程池核心线程最大数
        //2:maximumPoolSize 线程池最大线程数
        //3:keepAliveTime 线程池非核心线程空闲的存活时间
        //4:unit 线程空闲存活时间单位 枚举值
        //5:workQueue 存放任务的阻塞队列
        //6:threadFactory 用于设置创建线程的工厂，可以给创建的线程设置有意义的名字，可方便排查问题 （待学习自定义 todo）
        //7:handler 线程池的饱和策略时间，主要有四种类型
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 8, 0, TimeUnit.MILLISECONDS, arrayBlockingQueue, Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i =0;i<50;i++){
            System.out.println("i="+i);
            Future<?> submit = threadPoolExecutor.submit(() -> {
                System.out.println("线程名字"+Thread.currentThread().getName());
            });
            try{if (submit.get() == null) {
                System.out.println(submit.get());
            }}catch (Exception e){
                e.printStackTrace();
            }
        }
        threadPoolExecutor.shutdown();
        executorService.shutdown();

    }
}
