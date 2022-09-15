package com.java.algorithm.other.productor_customer.blocking_queue.data;

import java.util.concurrent.LinkedBlockingDeque;

public class Test {

	public static void main(String[] args) {
		LinkedBlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>(1);
		ProducerThread producerThread = new ProducerThread(blockingDeque);
		ConsumerThread consumerThread = new ConsumerThread(blockingDeque);
		Thread t1 = new Thread(producerThread, "生产者");		// 生产者线程
		Thread t2 = new Thread(consumerThread, "消费者");		// 消费者线程
		t1.start();
		t2.start();

		// 10秒后停止线程
		try {
			Thread.sleep(10 * 1000);
			producerThread.stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
