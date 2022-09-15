package com.java.algorithm.leetcode._1195_fizz_buzz_multithreaded.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class FizzBuzz {

    private final int n;
    private final Lock lock = new ReentrantLock();
    private final Condition conNumber = lock.newCondition();
    private final Condition conFizz = lock.newCondition();
    private final Condition conBuzz = lock.newCondition();
    private final Condition conFizzBuzz = lock.newCondition();

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        try {
            lock.lock();

            for (int i = 3; i <= n; i += 3) {
                if (i % 5 != 0) {
                    conFizz.await();
                    printFizz.run();
                    conNumber.signalAll();
                }
            }

        } finally {
            lock.unlock();
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        try {
            lock.lock();

            for (int i = 5; i <= n; i += 5) {
                if (i % 3 != 0) {
                    conBuzz.await();
                    printBuzz.run();
                    conNumber.signalAll();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        try {
            lock.lock();

            for (int i = 15; i <= n; i += 15) {
                conFizzBuzz.await();        // 阻塞 conFizzBuzz 锁管理的所有线程
                printFizzBuzz.run();        // 能被 3 整除 && 能被 5 整除
                conNumber.signalAll();      // 唤醒 conNumber 锁管理的所有线程
            }

        } finally {
            lock.unlock();
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        try {
            lock.lock();

            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {                                     // 能被 3 整除 && 能被 5 整除
                    conFizzBuzz.signalAll();    // 唤醒 conFizzBuzz 锁管理的所有线程
                    conNumber.await();          // 阻塞 conNumber 锁管理的线程
                } else if (i % 3 == 0) {                                            // 能被 3 整除 && 不能被 5 整除
                    conFizz.signalAll();        // 唤醒 conFizz 锁管理的搜有线程
                    conNumber.await();          // 阻塞 conNumber 锁管理的所有线程
                } else if (i % 5 == 0) {                                            // 不能被 3 整除 && 能被 5 整除
                    conBuzz.signalAll();        // 唤醒 conBuzz 锁管理的所有的线程
                    conNumber.await();          // 阻塞 conNumber 锁管理的所有线程
                } else {                                                            // 不能被 3 整除 && 不能被 5 整除
                    printNumber.accept(i);
                }
            }

        } finally {
            lock.unlock();
        }
    }
}
