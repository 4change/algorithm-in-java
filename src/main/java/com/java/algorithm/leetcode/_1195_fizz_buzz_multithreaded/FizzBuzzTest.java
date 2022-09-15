package com.java.algorithm.leetcode._1195_fizz_buzz_multithreaded;

import com.java.algorithm.leetcode._1195_fizz_buzz_multithreaded.cyclic_barrier.FizzBuzz;

public class FizzBuzzTest {

    public static void main(String[] args) {
        FizzBuzz pfb = new FizzBuzz(1000);

        Thread t1 = new Thread(() -> {
            try {
                pfb.fizz(() -> System.out.print("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                pfb.buzz(() -> System.out.print("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                pfb.fizzbuzz(() -> System.out.print("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t4 = new Thread(() -> {
            try {
                pfb.number(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
