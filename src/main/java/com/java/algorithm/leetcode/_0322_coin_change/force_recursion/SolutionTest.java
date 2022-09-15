package com.java.algorithm.leetcode._0322_coin_change.force_recursion;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();

//        int[] arr = { 100, 20, 5, 10, 2, 50, 1 };
//        int aim = 17019;

        // 10 = 5 + 5
        // dp[0][j]
        int[] arr = {2, 3, 4, 5};
        int aim = 10;

        System.out.println(solution.coinChange(arr, aim));
    }
}
