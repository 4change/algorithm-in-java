package com.java.algorithm.leetcode._0053_maximum_subarray.force;

class Solution {

	public int maxSubArray(int[] nums) {
		int n = nums.length;
		int ans = nums[0];
		int sum;
		for (int i = 0; i < n; i++) {
			sum = 0;
			for (int j = i; j < n; j++) {
				sum += nums[j];
				System.out.print(sum + "\t");
				ans = Math.max(ans, sum);
			}
			System.out.println();
		}
		return ans;
	}
	
}
