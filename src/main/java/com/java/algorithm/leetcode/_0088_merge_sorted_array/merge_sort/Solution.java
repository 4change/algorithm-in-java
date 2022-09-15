package com.java.algorithm.leetcode._0088_merge_sorted_array.merge_sort;

import java.util.Arrays;

class Solution {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		System.arraycopy(nums2, 0, nums1, m, n);
		Arrays.sort(nums1);
	}
	
}
