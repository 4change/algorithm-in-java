package com.java.algorithm.leetcode._0113_path_sum_ii.backtrack;

import com.java.algorithm.leetcode.data_structure.TreeNode;

public class SolutionTest {

	public static void main(String[] args) {
		TreeNode five1 = new TreeNode(5);
		
		TreeNode four1 = new TreeNode(4);
		TreeNode eight = new TreeNode(8);
		
		TreeNode eleven = new TreeNode(11);
		TreeNode thirteen = new TreeNode(13);
		TreeNode four2 = new TreeNode(4);
		
		TreeNode seven = new TreeNode(7);
		TreeNode two = new TreeNode(2);
		TreeNode five2 = new TreeNode(5);
		TreeNode one = new TreeNode(1);
		
		five1.left = four1;
		five1.right = eight;
		four1.left = eleven;
		eight.left = thirteen;
		eight.right = four2;
		eleven.left = seven;
		eleven.right = two;
		four2.left = five2;
		four2.right = one;
		
		System.out.println(new Solution().pathSum(five1, 22));
	}

}
