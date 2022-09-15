package com.java.algorithm.leetcode._0110_balanced_binary_tree.recursion;

import com.java.algorithm.leetcode.data_structure.TreeNode;

public class Solution {
	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		return (1 >= Math.abs(maxDepth(root.left) - maxDepth(root.right))) && isBalanced(root.left) && isBalanced(root.right);
	}

	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) return 1;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
