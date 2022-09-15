package com.java.algorithm.leetcode._1195_fizz_buzz_multithreaded.keyword_synchronized;

import java.util.function.IntConsumer;

public class FizzBuzz {
    // TODO final 关键字修饰类的成员变量的作用
    private final int n;
    private int i;
    private final Object lock = new Object();

    public FizzBuzz(int n) {
        this.n = n;
        this.i = 1;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        while (i <= n) {
            synchronized(lock) {
                while (i <= n && i % 3 == 0 && i % 5 != 0) {    // 能被 3 整除 && 不能被 5 整除
                    printFizz.run();
                    i++;
                }
            }
        }

    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (i <= n) {
            synchronized(lock) {
                while (i <= n && i % 3 != 0 && i % 5 == 0) {    // 不能被 3 整除 & 能被 5 整除
                    printBuzz.run();
                    i++;
                }
            }
        }

    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (i <= n) {
            synchronized(lock) {
                while (i <= n && i % 3 == 0 && i % 5 == 0) {    // 能被 3 整除 && 能被 5 整除
                    printFizzBuzz.run();
                    i++;
                }
            }
        }
    }

    // TODO synchronized 关键字修饰类的成员变量的作用和用法？
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            synchronized(lock) {
                while (i <= n && i % 3 != 0 && i % 5 != 0) {    // 不能被 3 整除 && 不能被 5 整除
                    printNumber.accept(i);
                    i++;
                }
            }
        }
    }
}
