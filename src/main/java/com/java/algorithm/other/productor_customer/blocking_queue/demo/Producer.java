package com.java.algorithm.other.productor_customer.blocking_queue.demo;

import java.util.concurrent.BlockingQueue;

/**
 * @author gongxiangfei
 * @description
 * @date 2021/2/23 10:09
 */
public class Producer implements Runnable {

    BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String temp = "A Product, 生产线程: " + Thread.currentThread().getName();
            System.out.println("生产者-----I have made a product:" + Thread.currentThread().getName());
            queue.put(temp);        // 如果队列是满的话，会阻塞当前线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
