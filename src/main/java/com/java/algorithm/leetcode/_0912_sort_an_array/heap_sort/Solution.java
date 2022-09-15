package com.java.algorithm.leetcode._0912_sort_an_array.heap_sort;

class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length == 0 && nums == null) return null;

        heapSort(nums);

        return nums;
    }

    public static void heapSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            maxHeapify(nums, nums.length - i);

            int temp = nums[0];
            nums[0] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
    }

    public static void maxHeapify(int[] nums, int heapSize) {
        for (int i = heapSize - 1; i >= 0; i--) {
            heapify(nums, i, heapSize);
        }
    }

    public static void heapify(int[] nums, int currentRootPos, int heapSize) {
        int left = currentRootPos * 2 + 1, right = currentRootPos * 2 + 2, max = currentRootPos;

        if (left < heapSize && nums[max] < nums[left]) {
            max = left;
        }

        if (right < heapSize && nums[max] < nums[right]) {
            max = right;
        }

        if (max != currentRootPos) {
            int temp = nums[max];
            nums[max] = nums[currentRootPos];
            nums[currentRootPos] = temp;

            heapify(nums, max, heapSize);
        }
    }
}
