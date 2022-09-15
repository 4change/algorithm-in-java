package com.java.algorithm.leetcode._0322_coin_change.memo_recursion;

public class Solution {

    public int coinChange(int[] coins, int amount) {
        // 备忘录初始化为-2
        int[] memo = new int[amount + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -2;
        }

        return helper(coins, amount, memo);
    }

    /**
     * 
     * @param coins
     * @param amount
     * @param memo 备忘录
     * @return
     */
    public int helper(int[] coins, int amount, int[] memo) {
    	// 
        if (amount == 0) return 0;
        if (memo[amount] != -2) return memo[amount];

        int ans = Integer.MAX_VALUE;
        for (int coin: coins) {
            // 金额不可达
            if (amount - coin < 0) continue;
            int subProb = helper(coins, amount - coin, memo);
            // 子问题无解
            if (subProb == -1) continue;
            ans = Integer.min(ans, subProb + 1);
        }

        // 记录本轮答案
        memo[amount] = (ans == Integer.MAX_VALUE) ? -1 : ans;
        return memo[amount];
    }

}
