package com.java.algorithm.leetcode._0912_sort_an_array.quick_sort;

class Solution {
    public int[] sortArray(int[] nums) {
        return quickSort(nums, 0, nums.length - 1);
    }
    
    public static int[] quickSort(int[] nums, int left, int right) {
    	int i = left;
    	int j = right;
    	
    	int pivot = nums[(left + right) / 2];
    	
    	while (i <= j) {
    		while (nums[i] < pivot) i++;
    		while (nums[j] > pivot) j--;
    		
    		if (i <= j) {
    			int temp = nums[i];
    			nums[i] = nums[j];
    			nums[j] = temp;
    			
    			i++;
    			j--;
    		}
    	}
    	
    	if (i < right) quickSort(nums, i, right);
    	if (left < j) quickSort(nums, left, j);
    	
    	return nums;
    }
}
