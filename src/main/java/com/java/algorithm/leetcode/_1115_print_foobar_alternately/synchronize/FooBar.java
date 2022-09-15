package com.java.algorithm.leetcode._1115_print_foobar_alternately.synchronize;

class FooBar {
	private int n;				// 打印的次数
	
	// 初始化设置打印的次数
	public FooBar(int n) {
		this.n = n;
	}
	
	private boolean fooTurn = true;			// 是否打印 Foo 的标志，true:打印 Foo，false:打印 Bar
	private Object lock = new Object();		// Object 锁，配合 synchronized 使用

	public void foo(Runnable printFoo) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			synchronized (lock) {			// 加锁
				if (!fooTurn) lock.wait();	// 不允许打印 Foo 时则进行等待
				printFoo.run();				// 打印 Foo
				fooTurn = false;			// 打印 Foo 完毕后，更新 fooTurn 标志为 false——不允许打印 Foo
				lock.notifyAll();			// 唤醒其他线程继续执行
			}
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			synchronized (lock) {			// 加锁
				if (fooTurn) lock.wait();	// 若允许打印 Foo，则代表不允许打印 Bar，打印 Bar 的线程需进行等待
				printBar.run();				// 打印 Bar
				fooTurn = true;				// 打印 Bar 完毕后，更新 fooTurn 标志为 true——允许打印 Foo
				lock.notifyAll();			// 唤醒其他线程继续执行
			}
		}
	}
}
