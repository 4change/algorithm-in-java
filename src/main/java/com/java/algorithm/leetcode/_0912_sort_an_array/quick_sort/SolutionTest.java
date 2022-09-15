package com.java.algorithm.leetcode._0912_sort_an_array.quick_sort;

public class SolutionTest {

	public static void main(String[] args) {
		int[] nums = new int[] {5,1,1,2,0,0};
		int[] sortArray = new Solution().sortArray(nums);
		for (int i = 0; i < sortArray.length; i++) {
			System.out.print(sortArray[i] + "\t");
		}
	}

}
