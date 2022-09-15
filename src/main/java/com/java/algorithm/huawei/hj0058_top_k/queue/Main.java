package com.java.algorithm.huawei.hj0058_top_k.queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int len = sc.nextInt();
			int k = sc.nextInt();
			int[] nums = new int[len];
			for (int i = 0; i < len; i++) {
				nums[i] = sc.nextInt();
			}
			PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;

				}
			});
			for (int i = 0; i < len; i++) {
				if (i < k) {
					q.offer(nums[i]);
				} else {
					if (nums[i] < q.peek()) {
						q.poll();
						q.offer(nums[i]);
					}
				}
			}
			ArrayList<Integer> list = new ArrayList<>();
			while (!q.isEmpty()) {
				list.add(q.poll());
			}
			for (int i = list.size() - 1; i > 0; i--) {// 按顺序
				System.out.print(list.get(i) + " ");
			}
			System.out.println(list.get(0));// 有多个测试用例 最后换行 代表结束
		}
		sc.close();
	}
}
