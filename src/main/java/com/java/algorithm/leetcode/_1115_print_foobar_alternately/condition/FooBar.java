package com.java.algorithm.leetcode._1115_print_foobar_alternately.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {
	private ReentrantLock lock = new ReentrantLock();
	private Condition fooCondition = lock.newCondition();
	private Condition barCondition = lock.newCondition();
	private int count = 1;
	private int n;	// 交替打印的次数

	// 初始化设置交替打印的次数
	public FooBar(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			lock.lock();
			if (count != 1) {
				fooCondition.await();
			}
			printFoo.run();
			barCondition.signal();
			count = 2;
			lock.unlock();
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			lock.lock();
			if (count != 2) {
				barCondition.await();
			}
			printBar.run();
			fooCondition.signal();
			count = 1;
			lock.unlock();
		}
	}
}