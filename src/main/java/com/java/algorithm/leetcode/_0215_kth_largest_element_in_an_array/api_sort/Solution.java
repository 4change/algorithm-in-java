package com.java.algorithm.leetcode._0215_kth_largest_element_in_an_array.api_sort;

import java.util.Arrays;

public class Solution {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

}
