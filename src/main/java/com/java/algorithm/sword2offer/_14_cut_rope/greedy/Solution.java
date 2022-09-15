package com.java.algorithm.sword2offer._14_cut_rope.greedy;

public class Solution {
    public int cutRope(int target) {
        if (target < 2) return 0;
        if (target == 2) return 1;
        if (target == 3) return 2;

        // 求解3的倍数
        int timesOf3 = target / 3;
        if (target - timesOf3 * 3 == 1) timesOf3 -= 1;

        // 求解2的倍数
        int timesOf2 = (target - timesOf3 * 3) / 2;

        return (int)Math.pow(3, timesOf3) * (int)Math.pow(2, timesOf2);
    }
}
