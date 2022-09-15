package com.java.algorithm.sword2offer._32_loop_bs_from_up_to_down._03_loop_bs_in_z_shape;

public class SolutionTest {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		TreeNode eight = new TreeNode(8);
		TreeNode nine = new TreeNode(9);
		TreeNode ten = new TreeNode(10);
		TreeNode eleven = new TreeNode(11);
		TreeNode twelve = new TreeNode(12);
		TreeNode thirteen = new TreeNode(13);
		TreeNode fourteen = new TreeNode(14);
		TreeNode fifteen = new TreeNode(15);

		root.left = two;
		root.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;
		four.left = eight;
		four.right = nine;
		five.left = ten;
		five.right = eleven;
		six.left = twelve;
		six.right = thirteen;
		seven.left = fourteen;
		seven.right = fifteen;
		
		System.out.println(new Solution().zigzagLevelOrder(root));
	}

}
