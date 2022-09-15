package com.java.algorithm.leetcode._1116_print_zero_even_odd.non_lock;

import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    volatile int stage = 0;

    public void zero(IntConsumer printNumber) {
        for (int i = 0; i < n; i++) {
            while (stage > 0) ;
            printNumber.accept(0);
            if ((i & 1) == 0) {
                stage = 1;
            } else {
                stage = 2;
            }
        }
    }

    public void even(IntConsumer printNumber) {
        for (int i = 2; i <= n; i += 2) {
            while (stage != 2) ;
            printNumber.accept(i);
            stage = 0;
        }
    }

    public void odd(IntConsumer printNumber) {
        for (int i = 1; i <= n; i += 2) {
            while (stage != 1) ;
            printNumber.accept(i);
            stage = 0;
        }
    }
}
