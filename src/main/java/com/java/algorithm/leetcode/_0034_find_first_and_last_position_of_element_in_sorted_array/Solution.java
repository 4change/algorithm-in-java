package com.java.algorithm.leetcode._0034_find_first_and_last_position_of_element_in_sorted_array;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        int leftBound = leftBoundBinarySearch(nums, target);
        int rightBound = rightBoundBinarySearch(nums, target);

        return new int[]{leftBound, rightBound};
    }

    public static int leftBoundBinarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) right = mid -1;
            else if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
        }

        // 判断左指针是否越界
        if (left >= nums.length || nums[left] != target) return -1;

        return left;
    }

    public static int rightBoundBinarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) left = mid + 1;
            else if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
        }

        // 判断有指针是否越界
        if (right < 0 || nums[right] != target) return -1;

        return right;
    }
}
