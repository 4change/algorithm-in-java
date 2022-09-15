package com.java.algorithm.leetcode._1115_print_foobar_alternately.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {
	private int n; // 并发调用的次数

	// 初始化设置并发调用的次数
	public FooBar(int n) {
		this.n = n;
	}

	// 可重入锁、公平锁
	Lock lock = new ReentrantLock(true);
	// 是否允许打印 Foo 的标志，volatile 保证线程可见性
	volatile boolean permitFoo = true;

	public void foo(Runnable printFoo) throws InterruptedException {
		for (int i = 0; i < n;) {
			try {
				lock.lock();
				if (permitFoo) {
					printFoo.run();
					i++;
					permitFoo = false;
				}
			} finally {
				lock.unlock();
			}
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {
		for (int i = 0; i < n;) {
			try {
				lock.lock();
				if (!permitFoo) {
					printBar.run();
					i++;
					permitFoo = true;
				}
			} finally {
				lock.unlock();
			}
		}
	}
}