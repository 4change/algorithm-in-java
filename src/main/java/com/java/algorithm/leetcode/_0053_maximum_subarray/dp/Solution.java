package com.java.algorithm.leetcode._0053_maximum_subarray.dp;

class Solution {

	public int maxSubArray(int[] nums) {
		if (nums == null) {
			return 0;
		}
		int max = nums[0]; // 全局最大值
		int subMax = nums[0]; // 前一个子组合的最大值,状态压缩
		for (int i = 1; i < nums.length; i++) {
			if (subMax > 0) { // 前一个子组合最大值大于0，正增益
				subMax = subMax + nums[i];
			} else { // 前一个子组合最大值小于0，负增益，抛弃前面的结果
				subMax = nums[i];
			}
			// 计算全局最大值
			max = Math.max(max, subMax);
		}
		return max;
	}

}
