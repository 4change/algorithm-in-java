package com.java.algorithm.leetcode._0113_path_sum_ii.backtrack;

import com.java.algorithm.leetcode.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> curPath = new LinkedList<>();
        recur(result, curPath, root, sum);
        return result;
    }

    private void recur(List<List<Integer>> result, List<Integer> curPath, TreeNode curNode, int sum){
        if(curNode == null){
            return;
        }
        curPath.add(curNode.val);
        if(curNode.val == sum && curNode.left == null && curNode.right == null){
            result.add(new ArrayList<>(curPath));
        }else{
            recur(result, curPath, curNode.left, sum - curNode.val);
            recur(result, curPath, curNode.right, sum - curNode.val);
        }
        curPath.remove(curPath.size() - 1);
    }
}
