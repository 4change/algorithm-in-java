package com.java.algorithm.leetcode._0035_search_insert_position.left_bound_binary_search;

class Solution {
	public int searchInsert(int[] nums, int target) {
		if (nums.length == 0)
			return -1;

		int left = 0;
		int right = nums.length;

		while (left < right) {
			int mid = (left + right) / 2;

			if (nums[mid] == target)
				right = mid;
			else if (nums[mid] < target)
				left = mid + 1;
			else if (nums[mid] > target)
				right = mid;
		}

		return left;
	}
}
