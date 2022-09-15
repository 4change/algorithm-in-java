package com.java.algorithm.leetcode._1114_print_in_order.synchronize;

class Foo {

	private boolean firstFinished;				// first() 与 second() 方法之间的屏障
	private boolean secondFinished;				// second() 与 third() 方法之间的屏障
	private Object lock = new Object();			// 全局锁，保证方法执行的独占性

	public void first(Runnable printFirst) throws InterruptedException {
		synchronized (lock) {
			// 执行 first() 方法对应的线程
			printFirst.run();
			// 标记 first() 方法执行完毕
			firstFinished = true;
			// 唤醒所有等待中的线程继续执行
			lock.notifyAll();
		}
	}

	public void second(Runnable printSecond) throws InterruptedException {
		synchronized (lock) {
			// 等待第一个线程执行完毕
			while (!firstFinished) {
				lock.wait();
			}

			// 执行 second() 方法对应的线程
			printSecond.run();
			// 标记 second() 方法执行完毕
			secondFinished = true;
			// 唤醒所有等待中的线程继续执行
			lock.notifyAll();
		}
	}

	public void third(Runnable printThird) throws InterruptedException {
		synchronized (lock) {
			// 等待第二个线程执行完毕
			while (!secondFinished) {
				lock.wait();
			}
			// 执行 third() 方法对应的线程
			printThird.run();
		}
	}
}
