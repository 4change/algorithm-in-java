package com.java.algorithm.leetcode._1114_print_in_order.synchronize;

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
			foo.first(runnable1);
			foo.second(runnable2);
			foo.third(runnable3);
			System.out.println();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() throws InterruptedException {
		for (int i = 0; i < 200; i++) {
			execute();
		}
	}
	
}
