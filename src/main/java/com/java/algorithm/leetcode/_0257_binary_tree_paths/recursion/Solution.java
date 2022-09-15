package com.java.algorithm.leetcode._0257_binary_tree_paths.recursion;

import java.util.LinkedList;
import java.util.List;

import com.java.algorithm.leetcode.data_structure.TreeNode;

public class Solution {

	public void construct_paths(TreeNode root, String path, LinkedList<String> paths) {
		if (root != null) {
			path += Integer.toString(root.val);
			if ((root.left == null) && (root.right == null)) // 当前节点是叶子节点
				paths.add(path); // 把路径加入到答案中
			else {
				path += "->"; // 当前节点不是叶子节点，继续递归遍历
				construct_paths(root.left, path, paths);
				construct_paths(root.right, path, paths);
			}
		}
	}

	public List<String> binaryTreePaths(TreeNode root) {
		LinkedList<String> paths = new LinkedList<>();
		construct_paths(root, "", paths);
		return paths;
	}

}
