package com.java.algorithm.leetcode._0704_binary_search.right_bound_binary_search;

public class Solution {
	public int search(int[] nums, int target) {
	    int left = 0, right = nums.length - 1;
	    while (left <= right) {
	        int mid = left + (right - left) / 2;
	        if (nums[mid] < target) {
	            left = mid + 1;
	        } else if (nums[mid] > target) {
	            right = mid - 1;
	        } else if (nums[mid] == target) {
	            // 这里改成收缩左侧边界即可
	            left = mid + 1;
	        }
	    }
	    // 这里改为检查 right 越界的情况，见下图
	    if (right < 0 || nums[right] != target) return -1;
	    return right;
	}
}
