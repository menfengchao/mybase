package com.men.mybase.util.jdk;



import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DelayDequeMain {

    // 创建延时队列
    public static  DelayQueue<Message> queue = new DelayQueue<Message>();

    public static void main(String[] args) {

        // 添加延时消息,m1 延时1s
        Message m1 = new Message(1000, "world", 1000);
        // 添加延时消息,m2 延时10s
        Message m2 = new Message(10000, "hello", 10000);
        // 添加延时消息,m3 延时5s
        Message m3 = new Message(5000, "menfengchao", 5000);
        //将延时消息放到延时队列中
        queue.offer(m2);
        queue.offer(m1);
        // 启动消费线程 消费添加到延时队列中的消息，前提是任务到了延期时间
        ExecutorService exec = Executors.newFixedThreadPool(1);
        exec.execute(new Consumer());
        queue.offer(m3);
        exec.shutdown();
    }
}
