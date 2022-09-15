package com.java.algorithm.other.productor_customer.blocking_queue.data;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerThread implements Runnable {
    private BlockingQueue<String> queue;
    private AtomicInteger count = new AtomicInteger();
    private volatile boolean FLAG = true;

    public ProducerThread(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "生产者线程启动....");
        while (FLAG) {
            String data = count.incrementAndGet() + "";
            try {
                boolean offer = queue.offer(data, 2, TimeUnit.SECONDS);
                if (offer) {
                    System.out.println(Thread.currentThread().getName() + ",生产数据" + data + "成功..");
                } else {
                    System.out.println(Thread.currentThread().getName() + ",生产数据" + data + "失败..");
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ",生产者线程停止...");
    }

    public void stop() {
        this.FLAG = false;
    }

}
