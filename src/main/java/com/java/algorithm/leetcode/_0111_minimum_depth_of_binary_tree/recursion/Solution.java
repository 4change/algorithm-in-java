package com.java.algorithm.leetcode._0111_minimum_depth_of_binary_tree.recursion;

import com.java.algorithm.leetcode.data_structure.TreeNode;

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        // 注意根节点的左子树为空或根节点的右子树为空的处理情况
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) minDepth = Math.min(minDepth, minDepth(root.left));
        if (root.right != null) minDepth = Math.min(minDepth, minDepth(root.right));

        return minDepth + 1;
    }
}
