package com.java.algorithm.leetcode._0912_sort_an_array.heap_sort;

public class SolutionTest {

	public static void main(String[] args) {
		int[] nums = new int[] {6, 3, 8, 7, 5, 1, 2, 23, 4321, 432, 3,2,34234,2134,1234,5,132423, 234, 4, 2, 4, 1,2, 5};
		int[] sortArray = new Solution().sortArray(nums);
		for (int i = 0; i < sortArray.length; i++) {
			System.out.print(sortArray[i] + "\t");
		}
	}

}
