package com.java.algorithm.leetcode._1116_print_zero_even_odd.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    Lock lock = new ReentrantLock();
    Condition z = lock.newCondition();
    Condition num = lock.newCondition();
    volatile boolean zTurn = true;          // volatile: 保证线程可见性
    volatile int zIndex = 0;

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (; zIndex < n; ) {
            lock.lock();
            try {
                while (!zTurn) {
                    z.await();
                }
                printNumber.accept(0);
                zTurn = false;
                num.signalAll();
                zIndex++;
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            lock.lock();
            try {
                while (zTurn || (zIndex & 1) == 1) {
                    num.await();
                }
                printNumber.accept(i);
                zTurn = true;
                z.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            lock.lock();
            try {
                while (zTurn || (zIndex & 1) == 0) {
                    num.await();
                }
                printNumber.accept(i);
                zTurn = true;
                z.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
