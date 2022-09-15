package com.java.algorithm.leetcode._1114_print_in_order.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Foo {

	volatile int stage = 1;
	// Conditon 对象的创建依赖于 Lock 对象
	Lock lock = new ReentrantLock();
	Condition stage2 = lock.newCondition();
	Condition stage3 = lock.newCondition();

	public void first(Runnable printFirst) throws InterruptedException {
		// condition 对象的 await()/signal() 方法的调用必须包裹在 lock 对象的 lock()/unlock() 方法中
		lock.lock();
		try {
			printFirst.run();
			stage = 2;
			// 发出信号，通知调用 stage2 对象的另一个线程恢复执行
			stage2.signal();
		} finally {
			lock.unlock();
		}
	}

	public void second(Runnable printSecond) throws InterruptedException {
		// condition 对象的 await()/signal() 方法的调用必须包裹在 lock 对象的 lock()/unlock() 方法中
		lock.lock();
		try {
			while (stage != 2) {
				// 等待信号，等待调用 stage2 对象的另一个线程发出信号
				stage2.await();
			}
			printSecond.run();
			stage = 3;
			// 发出信号，通知调用 stage3 对象的另一个线程恢复执行
			stage3.signal();
		} finally {
			lock.unlock();
		}
	}

	public void third(Runnable printThird) throws InterruptedException {
		// condition 对象的 await()/signal() 方法的调用必须包裹在 lock 对象的 lock()/unlock() 方法中
		lock.lock();
		try {
			while (stage != 3) {
				// 等待信号，等待调用 stage3 对象的另一个线程发出信号
				stage3.await();
			}
			printThird.run();
		} finally {
			lock.unlock();
		}
	}

}
