package com.java.algorithm.leetcode._0226_invert_binary_tree;

import com.java.algorithm.leetcode.data_structure.TreeNode;

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;

        TreeNode leftTree = invertTree(root.left);
        TreeNode rightTree = invertTree(root.right);

        root.left = rightTree;
        root.right = leftTree;

        return root;
    }
}
