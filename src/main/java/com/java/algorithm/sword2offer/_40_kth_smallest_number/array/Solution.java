package com.java.algorithm.sword2offer._40_kth_smallest_number.array;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        // 创建数据容器
        ArrayList<Integer> list = new ArrayList<>();

        // 输入参数校验
        if (input.length < k || k == 0) return list;

        // 向数据容器中添加k个元素
        for (int i = 0; i < k; i++) list.add(input[i]);

        // 依次取出输入数据，并与容器中的数据进行比较，输入数据较大说明容器中值为小的，不需要替换；输入数据较小说明需要替换
        for (int i = k; i < input.length; i++) {
            // 获取容器中最大元素的下标
            int j = this.getMax(list);
            // 获取容器中的最大值
            int temp = list.get(j);
            // 比较及交换
            if (input[i] < temp)
                list.set(j, input[i]);
        }
        return list;
    }

    /**
     * 查找 list 中的下标
     *
     * @param list
     * @return
     */
    public int getMax(ArrayList<Integer> list) {
        int max = list.get(0);
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                j = i;
            }
        }
        return j;
    }
}