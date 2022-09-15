package com.java.algorithm.data_structure.heap.small_root_heap;

import java.util.PriorityQueue;

/**
 * @author gongxiangfei
 * @description
 * @date 2021/2/23 15:55
 */
public class SmallRootHeap {

    /**
     * 小根堆——PriorityQueue
     *
     * @param args
     */
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
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
