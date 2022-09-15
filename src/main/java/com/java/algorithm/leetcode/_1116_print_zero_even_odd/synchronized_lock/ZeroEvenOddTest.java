package com.java.algorithm.leetcode._1116_print_zero_even_odd.synchronized_lock;

import java.util.function.IntConsumer;

import com.java.algorithm.leetcode._1116_print_zero_even_odd.synchronized_lock.ZeroEvenOdd;

public class ZeroEvenOddTest {

    public static void main(String[] args) {
        try {
            char integer = (char) System.in.read();
            System.out.println("传入n: " + integer);
            int input = integer - '0';
            ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(input);
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
