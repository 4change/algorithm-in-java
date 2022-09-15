package com.java.algorithm.leetcode._0101_symmetric_tree.recursion;

import com.java.algorithm.leetcode.data_structure.TreeNode;

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countNodes(root.left) + 1 + countNodes(root.right);
    }
}
