package com.java.algorithm.leetcode._1116_print_zero_even_odd.non_lock;

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
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        zeroEvenOdd.odd(intConsumer);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        zeroEvenOdd.even(intConsumer);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
