package com.java.algorithm.leetcode._1195_fizz_buzz_multithreaded.atomic_integer;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.function.IntConsumer;

public class FizzBuzz {
    // Initialize the flag.
    private AtomicInteger state = new AtomicInteger(1);

    // The current number.
    private int curNum = 1;

    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(;;) {
            // Update the current state using CAS in orde to run the logic exclusively.
            while (!this.state.compareAndSet(1, 0)) {
                // Alleviate the busy spin.
                LockSupport.parkNanos(1L);
            }

            if (this.curNum > n) {
                // Reset the state before return, then other waiting threads can terminate.
                this.state.set(1);
                return;
            }

            if ((this.curNum % 3 == 0) && (this.curNum % 5 != 0)) {
                printFizz.run();
                this.curNum++;
            }

            this.state.set(1);
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(;;) {
            while (!this.state.compareAndSet(1, 0)) {
                LockSupport.parkNanos(1L);
            }

            if (this.curNum > n) {
                this.state.set(1);
                return;
            }

            if ((this.curNum % 3 != 0) && (this.curNum % 5 == 0)) {
                printBuzz.run();
                this.curNum++;
            }

            this.state.set(1);
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(;;) {
            while (!this.state.compareAndSet(1, 0)) {
                LockSupport.parkNanos(1L);
            }

            if (this.curNum > n) {
                this.state.set(1);
                return;
            }

            if ((this.curNum % 3 == 0) && (this.curNum % 5 == 0)) {
                printFizzBuzz.run();
                this.curNum++;
            }

            this.state.set(1);
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(;;) {
            while (!this.state.compareAndSet(1, 0)) {
                LockSupport.parkNanos(1L);
            }

            if (this.curNum > n) {
                this.state.set(1);
                return;
            }

            if ((this.curNum % 3 != 0) && (this.curNum % 5 != 0)) {
                printNumber.accept(this.curNum);
                this.curNum++;
            }

            this.state.set(1);
        }
    }
}
