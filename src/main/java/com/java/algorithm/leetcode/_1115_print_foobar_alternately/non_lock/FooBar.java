package com.java.algorithm.leetcode._1115_print_foobar_alternately.non_lock;

class FooBar {
	private int n;				// 交替打印的次数

	// 初始化时设置交替打印的次数
	public FooBar(int n) {
		this.n = n;
	}
	
	// permitFoo: 允许打印 Foo 的标志，volatile 用于保证线程的可见性
	volatile boolean permitFoo = true;

	public void foo(Runnable printFoo) throws InterruptedException {
		for (int i = 0; i < n;) {
			if (permitFoo) {			// 允许打印 Foo 时，进行 Foo 的打印，并更新该标志
				printFoo.run();
				i++;
				permitFoo = false;
			}
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {
		for (int i = 0; i < n;) {		// 不允许打印 Foo 时，进行 Bar 的打印，并更新该标志
			if (!permitFoo) {
				printBar.run();
				i++;
				permitFoo = true;
			}
		}
	}
}
