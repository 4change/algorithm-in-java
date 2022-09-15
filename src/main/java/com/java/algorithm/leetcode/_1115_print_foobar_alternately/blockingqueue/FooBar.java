package com.java.algorithm.leetcode._1115_print_foobar_alternately.blockingqueue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class FooBar {
	private int n; // 交替打印的次数

	// 初始化设置交替打印的次数
	public FooBar(int n) {
		this.n = n;
	}

	// 双端阻塞队列，容量为 1
	// 阻塞队列的相关操作:
	//		put()——入队，如果队列已满则阻塞
	//		take()——出队，如果队列为空则阻塞
	private BlockingDeque<Integer> deque = new LinkedBlockingDeque<>(1);

	public void foo(Runnable printFoo) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			deque.put(i);		// put()——入队，如果队列已满则阻塞
			printFoo.run();
			deque.put(i);
			deque.put(i);
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			deque.take();		// take()——出队，如果队列为空则阻塞
			deque.take();
			printBar.run();
			deque.take();
		}
	}

}
