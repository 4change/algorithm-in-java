package com.java.algorithm.leetcode._0104_maximum_depth_of_binary_tree.recursion;

import com.java.algorithm.leetcode.data_structure.TreeNode;

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
