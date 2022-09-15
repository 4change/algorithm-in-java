package com.java.algorithm.leetcode._0404_sum_of_left_leaves.recursion;

import com.java.algorithm.leetcode.data_structure.TreeNode;

class Solution {
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;

		int ans = 0;

		// 左子树
		if (root.left != null) {
			// 左叶子节点的值
			if (root.left.left == null && root.left.right == null)
				ans += root.left.val;
			else
				ans += sumOfLeftLeaves(root.left);
		}

		// 右子树
		if (root.right != null) {
			ans += sumOfLeftLeaves(root.right);
		}

		return ans;
	}
}
