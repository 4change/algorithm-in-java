package com.java.algorithm.sword2offer._32_loop_bs_from_up_to_down._01_loop_bs_from_up_to_down;

import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
	public int[] levelOrder(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();

		if (root == null) return new int[0];

		ArrayDeque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode tempNode = queue.poll();
			result.add(tempNode.val);

			if (tempNode.left != null) queue.offer(tempNode.left);
			if (tempNode.right != null) queue.offer(tempNode.right);
		}

		int[] arr = new int[result.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = result.get(i);
		}

		return arr;
	}
}
