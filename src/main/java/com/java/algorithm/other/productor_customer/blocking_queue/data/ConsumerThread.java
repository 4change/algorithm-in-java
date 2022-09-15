package com.java.algorithm.other.productor_customer.blocking_queue.data;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConsumerThread implements Runnable {
    private volatile boolean FLAG = true;
    private BlockingQueue<String> blockingQueue;

    public ConsumerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "消费者线程启动....");
        String data;
        while (FLAG) {
            try {
                data = blockingQueue.poll(2, TimeUnit.SECONDS);
                if (data == null || data == "") {
                    FLAG = false;
                    System.out.println("消费者超过2秒时间未获取到消息.");
                    return;
                }
                System.out.println("消费者获取队列数据成功,data:" + data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
