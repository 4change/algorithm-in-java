package com.java.algorithm.leetcode._0103_binary_tree_zigzag_level_order_traversal.bfs;

import com.java.algorithm.leetcode.data_structure.TreeNode;

public class SolutionTest {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		TreeNode six = new TreeNode(6);
		TreeNode ten = new TreeNode(10);
		TreeNode five = new TreeNode(5);
		TreeNode seven = new TreeNode(7);
		TreeNode nine = new TreeNode(9);
		TreeNode eleven = new TreeNode(11);

		root.left = six;
		root.right = ten;
		six.left = five;
		six.right = seven;
		ten.left = nine;
		ten.right = eleven;

		System.out.println(new Solution().zigzagLevelOrder(root));
	}

}
