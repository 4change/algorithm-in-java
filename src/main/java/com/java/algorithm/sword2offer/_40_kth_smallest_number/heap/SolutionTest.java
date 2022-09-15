package com.java.algorithm.sword2offer._40_kth_smallest_number.heap;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution solution = new Solution();

        int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8, 34, 56, 2, 4, 9};
        int k = 5;

        System.err.println(solution.GetLeastNumbers_Solution(arr, k));
    }

}
