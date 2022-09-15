package com.java.algorithm.leetcode._0322_coin_change.force_recursion;

public class Solution {

    public int coinChange(int[] coins, int amount) {
    	// 确定 base case 
        if (amount == 0) return 0;

        int result = Integer.MAX_VALUE;

        // 确定选择
        for (int coin: coins) {
            // 金额不可达
            if (amount - coin < 0) continue;
            int subProb = coinChange(coins, amount - coin);
            // 子问题无解
            if (subProb == -1) continue;
            result = Math.min(result, subProb + 1);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

}
