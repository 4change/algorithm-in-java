package com.java.algorithm.leetcode._0322_coin_change.dp;

public class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) dp[i] = amount + 1;
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin: coins) {
                if (coin <= i) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

}
