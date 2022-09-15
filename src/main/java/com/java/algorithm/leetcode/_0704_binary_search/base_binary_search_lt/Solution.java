package com.java.algorithm.leetcode._0704_binary_search.base_binary_search_lt;

public class Solution {

	public int search(int[] nums, int target) {
	    int left = 0, right = nums.length - 1;

	    while (left < right) {
	        int mid = left + (right - left) / 2;

	        if (nums[mid] == target) return mid;
	        else if (nums[mid] < target) left = mid + 1;
	        else if (nums[mid] > target) right = mid - 1;
	    }

	    return nums[left] == target ? left : -1;
	}

}
