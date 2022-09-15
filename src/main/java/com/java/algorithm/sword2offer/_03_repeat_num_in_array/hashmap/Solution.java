package com.java.algorithm.sword2offer._03_repeat_num_in_array.hashmap;

import java.util.HashMap;

/**
 * @Description:
 * @Auther: gongxiangfei
 * @Date: 2020/11/2 16:58
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) return nums[i];
            else map.put(nums[i], i);
        }

        return -1;
    }
}
