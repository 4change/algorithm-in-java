package com.java.algorithm.leetcode._1115_print_foobar_alternately.cyclic_barrier;

public class FooBarTest {

	public static void main(String[] args) throws InterruptedException {
		FooBar t = new FooBar(20);
		
		// 开启一个线程，用于执行 FooBar 类的 foo() 方法
		Thread foo = new Thread(() -> {
			try {
				// 向 FooBar 类的 foo() 方法中传入了一个匿名线程
				t.foo(() -> System.out.print("foo"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		foo.setDaemon(false); // 设置为非守护线程
		foo.start();

		// 开启一个线程，用于执行 FooBar 类的 bar() 方法
		Thread bar = new Thread(() -> {
			try {
				// 向 FooBar 类的 bar() 方法中传入了一个匿名线程
				t.bar(() -> System.out.print("bar"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		bar.setDaemon(false); // 设置为非守护线程
		bar.start();
	}

}
