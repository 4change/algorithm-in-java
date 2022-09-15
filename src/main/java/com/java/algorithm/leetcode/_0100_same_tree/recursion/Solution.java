package com.java.algorithm.leetcode._0100_same_tree.recursion;

import com.java.algorithm.leetcode.data_structure.TreeNode;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val;
    }
}
