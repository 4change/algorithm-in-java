package com.java.algorithm.leetcode._1114_print_in_order.atomic_integer;

import org.junit.Test;

public class FooTest {

	public void execute() {
		Foo foo = new Foo();
		
		Runnable runnable1 = new Runnable() {
			@Override
			public void run() {
				System.out.print("one");
			}
		};
		Runnable runnable2 = new Runnable() {
			@Override
			public void run() {
				System.out.print("two");
			}
		};
		Runnable runnable3 = new Runnable() {
			@Override
			public void run() {
				System.out.print("three");
			}
		};

		try {
			foo.first(runnable1);	// 线程一执行，线程一执行完通知线程二执行
			foo.second(runnable2);	// 等待线程一执行完毕，线程一执行完毕后，开始执行线程二，线程二执行完毕后，通知线程三开始执行
			foo.third(runnable3);	// 等待线程二执行完毕，线程二执行完毕后，开始执行线程三
			System.out.println();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			execute();
		}
	}
	
}
