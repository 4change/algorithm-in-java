package com.java.algorithm.leetcode._1195_fizz_buzz_multithreaded.cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.function.IntConsumer;

public class FizzBuzz {

    // CyclicBarrier(4): 限制循环屏障的数量为 4
    private static final CyclicBarrier barrier = new CyclicBarrier(4);

    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {

            if (i % 3 == 0 && i % 5 != 0) printFizz.run();

            try {
                // 阻塞当前线程, 直到循环屏障数量到达 4
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {

            if (i % 3 != 0 && i % 5 == 0)  printBuzz.run();

            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) printFizzBuzz.run();

            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) printNumber.accept(i);

            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}