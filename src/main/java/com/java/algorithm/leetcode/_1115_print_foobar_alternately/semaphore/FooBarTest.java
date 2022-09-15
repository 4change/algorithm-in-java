package com.java.algorithm.leetcode._1115_print_foobar_alternately.semaphore;

public class FooBarTest {

	public static void main(String[] args) throws InterruptedException {
		FooBar fooBar = new FooBar(20);

		Thread t1 = new Thread(() -> {
			try {
				fooBar.foo(() -> {
					System.out.print("foo");
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread t2 = new Thread(() -> {
			try {
				fooBar.bar(() -> {
					System.out.print("bar");
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		t2.start();
		t1.start();

	}

}
