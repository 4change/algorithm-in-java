package com.java.algorithm.sword2offer._40_kth_smallest_number.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Java 队列的相关操作
 *
 */
public class Solution {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        // 返回的结果集
        ArrayList<Integer> list = new ArrayList<>();

        // 输入参数校验
        if (input == null || k > input.length || k <= 0) return list;

        // 创建数据容器, 此处使用优先级队列, 优先级队列会根据优先级对元素进行排序
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2.compareTo(i1);
            }
        });

        // 根据比较结果向数据容器中添加或删除元素
        int len = input.length;
        for (int i = 0; i < len; ++i) {
            if (queue.size() != k) {                    // 容器长度小于k时, 元素入容器
                queue.offer(input[i]);
            } else if (queue.peek() > input[i]) {       // 容器长度不小于k时, 比较并交换
                queue.poll();
                queue.offer(input[i]);
            }
        }

        Iterator<Integer> it = queue.iterator();
        while (it.hasNext()) {
            list.add(it.next());
        }

        return list;
    }
}
