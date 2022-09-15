package com.java.algorithm.leetcode._1115_print_foobar_alternately.non_lock;

public class FooBarTest {

	public static void main(String[] args) throws InterruptedException {
		FooBar t = new FooBar(20);
		
		Thread foo = new Thread(() -> {
			try {
				t.foo(() -> System.out.print("foo"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		foo.setDaemon(false); // 设置为非守护线程
		foo.start();

		Thread bar = new Thread(() -> {
			try {
				t.bar(() -> System.out.print("bar"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		bar.setDaemon(false); // 设置为非守护线程
		bar.start();
	}

}
