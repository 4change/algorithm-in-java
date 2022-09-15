package com.java.algorithm.leetcode._1114_print_in_order.atomic_integer;

import java.util.concurrent.atomic.AtomicInteger;

class Foo {

	// firstJobDone 作为第一个线程和第二个线程之间的桥梁，第一个线程完成时通知第二个线程开始执行
	private AtomicInteger firstJobDone = new AtomicInteger(0);
	// secondJobDone 作为第二个线程和第三个线程之间的桥梁，第二个线程完成时通知第三个线程开始执行
	private AtomicInteger secondJobDone = new AtomicInteger(0);

	public void first(Runnable printFirst) throws InterruptedException {
		// 调用第一个线程的 run() 方法
		printFirst.run();
		// 标记第一个线程完成，并通知第二个线程开始执行
		firstJobDone.incrementAndGet();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		// 等待第一个线程完成
		while (firstJobDone.get() != 1) {
		}
		// 调用第二个线程的 run() 方法
		printSecond.run();
		// 标记第二个线程完成，并通知第三个线程开始执行
		secondJobDone.incrementAndGet();
	}

	public void third(Runnable printThird) throws InterruptedException {
		// 等待第三个线程完成
		while (secondJobDone.get() != 1) {
		}
		// 调用第三个线程的 run() 方法
		printThird.run();
	}
	
}
