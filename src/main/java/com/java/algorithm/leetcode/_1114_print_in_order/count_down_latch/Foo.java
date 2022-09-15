package com.java.algorithm.leetcode._1114_print_in_order.count_down_latch;

import java.util.concurrent.CountDownLatch;

class Foo {
	// 使用 CountDownLatch 充当 first() 与 second()，second() 与 third() 方法间的屏障
    private CountDownLatch c2 = new CountDownLatch(1);	// 设置 c2 的初始值，作为 first() 与 second() 方法间的阻塞屏障
    private CountDownLatch c3 = new CountDownLatch(1);	// 设置 c3 的初始值，作为 second() 与 third() 方法间的阻塞屏障
    
    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        c2.countDown();		// c2 count 计数减 0，通知 second() 方法开始执行
    }

    public void second(Runnable printSecond) throws InterruptedException {
        c2.await();			// 等待 c2 count 计数减为 0，即等待 first() 方法执行完毕
        printSecond.run();
        c3.countDown();		// c3 count 计数减为 0，通知 third() 方法开始执行
    }

    public void third(Runnable printThird) throws InterruptedException {
        c3.await();			// 等待 c3 count 计数减为 0，即等待 second() 方法执行完毕
        printThird.run();
    }
}
