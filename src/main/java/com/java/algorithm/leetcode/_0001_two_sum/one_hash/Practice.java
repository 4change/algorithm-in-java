package com.java.algorithm.leetcode._0001_two_sum.one_hash;

import java.util.HashMap;

/**
 * @author gongxiangfei
 * @description
 * @date 2021/2/23 09:47
 */
public class Practice {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }

}
