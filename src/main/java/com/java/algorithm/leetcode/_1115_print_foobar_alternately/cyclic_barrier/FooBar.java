package com.java.algorithm.leetcode._1115_print_foobar_alternately.cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class FooBar {
	private int n;		// 交替打印的数量

	public FooBar(int n) {
		this.n = n;
	}

	// 大小为2的循环屏障
	CyclicBarrier cb = new CyclicBarrier(2);	
	volatile boolean fin = true;	// bar 是否打印结束的标志

	public void foo(Runnable printFoo) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			// 当 bar 的打印操作未结束时则进行等待
			while (!fin);
			// 打印 foo
			printFoo.run();
			// 更新 bar 是否打印结束的标志为 false
			fin = false;
			try {
				// 当前线程等待，等待2个线程都到达屏障再执行
				cb.await();
			} catch (BrokenBarrierException e) {
			}
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			try {
				// 当前线程等待，等待2个线程都到达屏障再执行
				cb.await();
			} catch (BrokenBarrierException e) {
			}
			// 打印 bar
			printBar.run();
			// 更新 bar 打印是否结束的标志为 true
			fin = true;
		}
	}
}
