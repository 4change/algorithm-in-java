package com.java.algorithm.leetcode._0079_climbing_stairs.dp_optimize;

public class Solution {

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int prev = 1, curr = 2;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

}
