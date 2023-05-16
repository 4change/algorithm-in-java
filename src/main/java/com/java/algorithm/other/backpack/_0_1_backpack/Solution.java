package com.java.algorithm.other.backpack._0_1_backpack;

public class Solution {

	public static void main(String[] args) {
		System.out.println(backpack(4, 3, new int[] {2, 1, 3}, new int[] {4, 2, 3}));
		System.out.println(backpack(11, 5, new int[] {1, 2, 5, 6, 7}, new int[] {1, 6, 18, 22, 28}));
	}

	/**
	 * 0-1 背包问题
	 *
	 * @param W		背包容量
	 * @param N		物品总量
	 * @param wt	物品总量数组
	 * @param val	物品价值数组
	 * @return
	 */
	public static int backpack(int W, int N, int[] wt, int[] val) {
	    int[][] dp = new int[N+1][W+1];

	    for (int i = 1; i <= N; i++) {
	        for (int w = 1; w <= W; w++) {
	            if (w - wt[i-1] < 0) {
	                // 当前背包容量装不下，只能选择不装入背包
	                dp[i][w] = dp[i - 1][w];
	            } else {
	                // 装入或者不装入背包，择优
	                dp[i][w] = Math.max(dp[i - 1][w - wt[i-1]] + val[i-1], dp[i - 1][w]);
	            }
	        }
	    }

//	    for (int i = 0; i <= N; i++) {
//	    	for (int j = 0; j <= W; j++) {
//	    		System.out.print(dp[i][j] + " ");
//	    	}
//
//	    	System.out.println();
//	    }

	    return dp[N][W];
	}

}
