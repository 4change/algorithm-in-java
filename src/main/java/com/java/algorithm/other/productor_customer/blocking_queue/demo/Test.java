package com.java.algorithm.other.productor_customer.blocking_queue.demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author gongxiangfei
 * @description
 * @date 2021/2/23 10:15
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        // 不设置的话, LinkedBlockingQueue 默认大小为 Integer.MAX_VALUE
        BlockingQueue<String> queue = new LinkedBlockingDeque<>(2);

        Consumer consumer = new Consumer(queue);
        Producer producer = new Producer(queue);

        for (int i = 0; i < 1000000; i++) {
            new Thread(producer, "Producer" + (i + 1)).start();
            new Thread(consumer, "Consumer" + (i + 1)).start();
        }
    }

}
