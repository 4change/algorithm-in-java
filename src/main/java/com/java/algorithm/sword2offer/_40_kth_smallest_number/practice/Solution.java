package com.java.algorithm.sword2offer._40_kth_smallest_number.practice;

import org.junit.Test;

import java.util.ArrayList;

public class Solution {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> resultList = new ArrayList<>();

        // 输入参数校验
        if (input == null || k <= 0 || input.length < k) return resultList;

        // 填充容器
        int[] container = new int[k];
        for (int i = 0; i < k; i++) {
            container[i] = input[i];
        }

        // 比较并交换
        int temp = 0;

        for (int i = k; i < input.length; i++) {
            int idx = getLargest(container);

            if (container[idx] > input[i]) {
                temp = container[idx];
                container[idx] = input[i];
                input[i] = temp;
            }
        }

        for (int i = 0; i < container.length; i++) {
            resultList.add(container[i]);
        }

        return resultList;
    }

    public static int getLargest(int[] arr) {
        int max = 0, maxIdx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIdx = i;
            }
        }

        return maxIdx;
    }

    @Test
    public void testGetLargest() {
        int[] arr = {4,5,1,6,2,7,3};
        System.out.println(getLargest(arr));
    }

    @Test
    public void test() {
        Solution solution = new Solution();

//        int[] arr = {4,5,1,6,2,7,3,8};
//        int k = 10;

        int[] arr = {4,5,1,6,2,7,3,8};
        int k = 0;

        System.out.println(solution.GetLeastNumbers_Solution(arr, k));
    }

}
