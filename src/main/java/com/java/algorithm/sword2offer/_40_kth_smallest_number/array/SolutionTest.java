package com.java.algorithm.sword2offer._40_kth_smallest_number.array;

import org.junit.Test;

import java.util.ArrayList;

public class SolutionTest {

    @Test
    public void test() {
        Solution solution = new Solution();

        int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8, 34, 56, 2, 4, 9};
        int k = 5;

        System.err.println(solution.GetLeastNumbers_Solution(arr, k));
    }

    @Test
    public void testGetMax() {
        Solution solution = new Solution();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(3);
        list.add(1);
        list.add(-1);
        list.add(7);

        System.out.println(solution.getMax(list));          // 4
    }

}
