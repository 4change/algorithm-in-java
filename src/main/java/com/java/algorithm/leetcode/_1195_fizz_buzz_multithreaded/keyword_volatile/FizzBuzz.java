package com.java.algorithm.leetcode._1195_fizz_buzz_multithreaded.keyword_volatile;

import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;
    private volatile int state = -1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if (i % 15 == 0) continue;      // 排除能被 5 整除的数字

            while (state != 3) Thread.sleep(1);     // 休眠, 直到拿到控制权

            printFizz.run();                // 能被 3 整除 && 不能被 5 整除

            state = -1;                     // 出让控制权给 number() 方法
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if (i % 15 == 0) continue;      // 排除能被 3 整除的数字

            while (state != 5) Thread.sleep(1);     // 休眠, 直到拿到控制权

            printBuzz.run();                // 不能被 3 整除 && 能被 5 整除

            state = -1;                     // 出让控制权给 number() 方法
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            while (state != 15) Thread.sleep(1);    // 休眠，直到拿到控制权

            printFizzBuzz.run();    // 能被 3 整除 && 能被 5 整除

            state = -1;    // 出让控制权给 number() 方法
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; ++i) {
            while (state != -1) Thread.sleep(1);    // 休眠，直到拿到控制权

            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);          // 不能被 3 整除 && 不能被 5 整除
            } else {
                if (i % 15 == 0) state = 15;        // 出让控制权给 fizzbuzz() 方法
                else if (i % 5 == 0) state = 5;     // 出让控制权给 buzz() 方法
                else state = 3;                     // 出让控制权给 fizz() 方法
            }
        }
    }
}
