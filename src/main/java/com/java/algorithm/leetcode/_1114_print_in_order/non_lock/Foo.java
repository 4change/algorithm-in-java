package com.java.algorithm.leetcode._1114_print_in_order.non_lock;

public class Foo {

	// 利用 volatile 的可见性，设置并修改屏障
	volatile int stage = 1;

	public void first(Runnable printFirst) throws InterruptedException {
		printFirst.run();
		stage = 2;
	}

	public void second(Runnable printSecond) throws InterruptedException {
		while (stage != 2);
		printSecond.run();
		stage = 3;
	}

	public void third(Runnable printThird) throws InterruptedException {
		while (stage != 3);
		printThird.run();
	}

}
