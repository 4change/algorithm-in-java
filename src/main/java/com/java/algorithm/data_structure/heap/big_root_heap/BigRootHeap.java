package com.java.algorithm.data_structure.heap.big_root_heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author gongxiangfei
 * @description
 * @date 2021/2/23 15:50
 */
public class BigRootHeap {

    /**
     * 大根堆——重写比较方法后的 PriorityQueue
     * @param args
     */
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        pq.offer(3);
        pq.offer(5);
        pq.offer(2);
        pq.offer(4);
        pq.offer(1);

        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

}
