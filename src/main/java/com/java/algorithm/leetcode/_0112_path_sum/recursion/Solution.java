package com.java.algorithm.leetcode._0112_path_sum.recursion;

import com.java.algorithm.leetcode.data_structure.TreeNode;

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
