package com.java.algorithm.leetcode._1115_print_foobar_alternately.semaphore;

import java.util.concurrent.Semaphore;

public class FooBar {
	private int n;
	private Semaphore foo = new Semaphore(1);
	// Sempaphore(0) 是信号量的一个特殊用法，这种信号量只有先 release，然后才能 acquire
	private Semaphore bar = new Semaphore(0);

	public FooBar(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			foo.acquire();
			printFoo.run();
			bar.release();
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			bar.acquire();
			printBar.run();
			foo.release();
		}
	}

}
