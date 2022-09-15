package com.java.algorithm.leetcode._0129_sum_root_to_leaf_numbers.recursion;

import com.java.algorithm.leetcode.data_structure.TreeNode;

class Solution {
	public int sumNumbers(TreeNode root) {
		return helper(root, 0);
	}

	public int helper(TreeNode root, int i) {
		if (root == null)
			return 0;
		int temp = i * 10 + root.val;
		if (root.left == null && root.right == null)
			return temp;
		return helper(root.left, temp) + helper(root.right, temp);
	}
}
