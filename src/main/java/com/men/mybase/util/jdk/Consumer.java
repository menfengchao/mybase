package com.men.mybase.util.jdk;

import java.util.concurrent.DelayQueue;

public class Consumer implements Runnable {
    // 延时队列 ,消费者从其中获取消息进行消费
    private DelayQueue<Message> queue;

    public Consumer() {
        this.queue = DelayDequeMain.queue;
    }

    @Override
    public void run() {
        do {
            try {
                Message take = queue.take();
                System.out.println("消费消息id：" + take.getId() + " 消息体：" + take.getBody());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!queue.isEmpty());
    }
}