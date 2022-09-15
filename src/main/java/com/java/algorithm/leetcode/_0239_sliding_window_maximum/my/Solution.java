package com.java.algorithm.leetcode._0239_sliding_window_maximum.my;

import java.util.PriorityQueue;

/**
 * @author gongxiangfei
 * @description
 * @date 2021/2/23 11:17
 */
public class Solution {

    /**
     * 超时
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < result.length; i++) {
            for (int j = i; j < i + k; j++) {
                pq.offer(nums[j]);
            }

            while (pq.size() != 1) {
                pq.poll();
            }

            result[i] = pq.poll();
        }

        return result;
    }

}
