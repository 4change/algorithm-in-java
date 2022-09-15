package com.java.algorithm.leetcode._0088_merge_sorted_array.two_pointer_back_2_front;

public class SolutionTest {

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,0,0,0};
		int m = 3;
		int[] nums2 = {2,5,6};    
		int n = 3;
		
		new Solution().merge(nums1, m, nums2, n);
		
		for (int i = 0; i < nums1.length; i++) {
			System.out.println(nums1[i]);
		}
	}

}
