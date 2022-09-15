package com.java.algorithm.leetcode._0912_sort_an_array.bubble_sort;

class Solution {
    public int[] sortArray(int[] nums) {
        return bubbleSort(nums);
    }
    
    public static int[] bubbleSort(int[] nums) {
    	int temp;
    	
    	for (int i = 0; i < nums.length - 1; i++) {
    		for (int j = 0; j < nums.length - i - 1; j++) {
    			if (nums[j] > nums[j + 1]) {
    				temp = nums[j];
    				nums[j] = nums[j + 1];
    				nums[j + 1] = temp;
    			}
    		}
    	}
    	
    	return nums;
    }

}
