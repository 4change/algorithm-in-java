package com.java.algorithm.other.productor_customer.blocking_queue.demo;

import java.util.concurrent.BlockingQueue;

/**
 * @author gongxiangfei
 * @description
 * @date 2021/2/23 10:14
 */
public class Consumer implements Runnable {

    BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String temp = queue.take();     // 如果队列为空，会阻塞当前线程
            System.out.println("消费者-----" + temp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
