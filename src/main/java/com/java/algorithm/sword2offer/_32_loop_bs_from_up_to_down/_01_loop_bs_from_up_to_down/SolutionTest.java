package com.java.algorithm.sword2offer._32_loop_bs_from_up_to_down._01_loop_bs_from_up_to_down;

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

		new Solution().levelOrder(root);
	}

}
