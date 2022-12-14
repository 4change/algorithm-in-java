package com.java.algorithm.leetcode._0704_binary_search.left_bound_binary_search;

public class Solution {
	public int search(int[] nums, int target) {
	    int left = 0, right = nums.length - 1;
	    // 搜索区间为 [left, right]
	    while (left <= right) {
	        int mid = left + (right - left) / 2;
	        if (nums[mid] < target) {
	            // 搜索区间变为 [mid+1, right]
	            left = mid + 1;
	        } else if (nums[mid] > target) {
	            // 搜索区间变为 [left, mid-1]
	            right = mid - 1;
	        } else if (nums[mid] == target) {
	            // 收缩右侧边界
	            right = mid - 1;
	        }
	    }
	    // 检查出界情况
	    if (left >= nums.length || nums[left] != target)
	        return -1;
	    return left;
	}
}
