package com.java.algorithm.leetcode._0215_kth_largest_element_in_an_array.max_root_heap;

class Solution {

    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        // 建堆，建堆完成后最大元素位于数组尾部
        buildMaxHeap(nums, heapSize);

        // 建立大小为 (K - 1) 的堆
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);   // 交换，将最大元素放到数组尾部
            --heapSize;     //  堆大小减一，设置新堆大小
            maxHeapify(nums, 0, heapSize);  // 调整新堆
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(nums, i, heapSize);
        }
    }

    /**
     *
     * @param nums  建堆的数组
     * @param currentRootPos    当前父节点下标
     * @param heapSize  堆中节点总数
     */
    public void maxHeapify(int[] nums, int currentRootPos, int heapSize) {
        int left = currentRootPos * 2 + 1, right = currentRootPos * 2 + 2, largest = currentRootPos;
        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != currentRootPos) {
            swap(nums, currentRootPos, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
