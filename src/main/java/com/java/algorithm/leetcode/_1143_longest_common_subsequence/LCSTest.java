package com.java.algorithm.leetcode._1143_longest_common_subsequence;

import com.java.algorithm.leetcode._1143_longest_common_subsequence.dp.Solution;

public class LCSTest {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String str1 = "A1BC2D3EFGH45I6JK7LMN";
        String str2 = "12OPQ3RST4U5V6W7XYZ";
        System.out.println(solution.lcse(str1, str2));
    }

}
