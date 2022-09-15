package com.java.algorithm.leetcode._0239_sliding_window_maximum.my;

import com.java.algorithm.leetcode._0239_sliding_window_maximum.my.Solution;

import java.util.Arrays;

/**
 * @author gongxiangfei
 * @description
 * @date 2021/2/23 11:40
 */
public class SolutionTest {

    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, 4, 2, 6, 2, 5, 1};
//        int[] arr = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(arr, 3)));
    }

}
