package com.java.algorithm.leetcode._0215_kth_largest_element_in_an_array.priority_queue;

import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 小顶堆
        for (int val : nums) {
            pq.add(val);

            if (pq.size() > k) pq.poll();  // 维护堆的大小为 K
        }
        return pq.peek();
    }
}
