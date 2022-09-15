package com.java.algorithm.leetcode._1114_print_in_order.semaphore;

import java.util.concurrent.Semaphore;

public class Foo {
 
	// Semaphore(0) 是信号量的一个特殊用法，这种情况下的信号量只有先 release，然后才能 acquire
	Semaphore stage2 = new Semaphore(0);
	Semaphore stage3 = new Semaphore(0);

	public void first(Runnable printFirst) throws InterruptedException {
		printFirst.run();
		stage2.release();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		stage2.acquire();
		printSecond.run();
		stage3.release();
	}

	public void third(Runnable printThird) throws InterruptedException {
		stage3.acquire();
		printThird.run();
	}

}
