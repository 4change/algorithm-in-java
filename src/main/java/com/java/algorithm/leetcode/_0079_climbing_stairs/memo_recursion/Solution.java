package com.java.algorithm.leetcode._0079_climbing_stairs.memo_recursion;

public class Solution {

//    int fib(int N) {
//        if (N < 1) return 0;
//        // 备忘录全初始化为 0
//        vector<int> memo(N + 1, 0);
//        return helper(memo, N);
//    }
//    int helper(vector<int>& memo, int n) {
//        if (n == 1 || n == 2) return 1;
//        if (memo[n] != 0) return memo[n];
//        // 未被计算过
//        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
//        return memo[n];
//    }

    public int climbStairs(int n) {
        if (n < 1) return 0;
        // 动态规划的备忘录, 全初始化为0
        int[] arr = new int[n + 1];
        return helper(arr, n);
    }

    public int helper(int[] arr, int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (arr[n] != 0) return arr[n];

        // 未被计算过, 则进行计算, 并添加到备忘录中
        arr[n] = helper(arr, n - 1) + helper(arr, n - 2);

        return arr[n];
    }

}
