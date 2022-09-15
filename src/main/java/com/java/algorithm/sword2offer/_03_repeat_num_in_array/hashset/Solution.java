package com.java.algorithm.sword2offer._03_repeat_num_in_array.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Auther: gongxiangfei
 * @Date: 2020/11/2 17:01
 */
public class Solution {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }
}
