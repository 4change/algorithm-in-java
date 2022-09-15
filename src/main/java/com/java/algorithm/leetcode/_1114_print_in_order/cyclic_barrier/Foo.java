package com.java.algorithm.leetcode._1114_print_in_order.cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Foo {

	CyclicBarrier cb1 = new CyclicBarrier(2);
	CyclicBarrier cb2 = new CyclicBarrier(2);

	public void first(Runnable printFirst) throws InterruptedException {
		printFirst.run();
		try {
			cb1.await();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

	public void second(Runnable printSecond) throws InterruptedException {
		try {
			cb1.await();
			printSecond.run();
			cb2.await();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

	public void third(Runnable printThird) throws InterruptedException {
		try {
			cb2.await();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		printThird.run();
	}

}
