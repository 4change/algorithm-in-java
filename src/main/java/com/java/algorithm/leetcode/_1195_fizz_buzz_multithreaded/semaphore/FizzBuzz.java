package com.java.algorithm.leetcode._1195_fizz_buzz_multithreaded.semaphore;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {

    // Semaphore(1): 限制并发访问的线程数量为 1
    private final Semaphore sema = new Semaphore(1);

    private int curNum = 1;

    private final int n;

    public FizzBuzz(int n) {
        this.n = n;
    }
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(true) {
            // 当前线程拿到锁, 则继续执行; 否则当前线程出让控制权
            this.sema.acquire(1);

            try {
                if (this.curNum > n) return;

                if ((this.curNum % 3 == 0) && (this.curNum % 5 != 0)) {
                    printFizz.run();
                    this.curNum++;
                }
            } finally {
                this.sema.release(1);
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(true) {
            this.sema.acquire(1);

            try {
                if (this.curNum > n)  return;

                if ((this.curNum % 3 != 0) && (this.curNum % 5 == 0)) {
                    printBuzz.run();
                    this.curNum++;
                }
            } finally {
                this.sema.release(1);
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(true) {
            try {
                this.sema.acquire(1);

                // 判断是否到达返回的临界值
                if (this.curNum > n) return;

                // 能被 3 整除 && 能被 5 整除
                if ((this.curNum % 3 == 0) && (this.curNum % 5 == 0)) {
                    printFizzBuzz.run();
                    this.curNum++;
                }
            } finally {
                this.sema.release(1);
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        while(true) {
            try {
                this.sema.acquire(1);

                // 判断是否到达返回的临界值
                if (this.curNum > n) return;

                // 不能被 3 整除 && 不能被 5 整除
                if ((this.curNum % 3 != 0) && (this.curNum % 5 != 0)) {
                    printNumber.accept(this.curNum);
                    this.curNum++;
                }
            } finally {
                this.sema.release(1);
            }
        }
    }
}
