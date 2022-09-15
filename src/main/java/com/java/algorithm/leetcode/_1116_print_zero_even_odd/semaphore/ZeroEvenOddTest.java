package com.java.algorithm.leetcode._1116_print_zero_even_odd.semaphore;

import java.util.function.IntConsumer;

public class ZeroEvenOddTest {

    public static void main(String[] args) {
        try {
            ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(12);
            IntConsumer intConsumer = value -> System.out.println(value);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        zeroEvenOdd.zero(intConsumer);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        zeroEvenOdd.odd(intConsumer);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        zeroEvenOdd.even(intConsumer);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
