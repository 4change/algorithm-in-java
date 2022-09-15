package com.java.algorithm.leetcode._1116_print_zero_even_odd.semaphore;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    Semaphore z = new Semaphore(1);     // 0的信号量
    Semaphore e = new Semaphore(0);     // 1的信号量
    Semaphore o = new Semaphore(0);     // 2的信号量

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // 获取信号量
            z.acquire();

            printNumber.accept(0);

            // 释放信号量
            if ((i & 1) == 0) { // 与 1 相 & 为 0, 偶数
                o.release();
            } else {            // 与 1 相 & 不为 0, 奇数
                e.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            e.acquire();

            printNumber.accept(i);

            z.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            o.acquire();

            printNumber.accept(i);

            z.release();
        }
    }
}
