package com.java.algorithm.sword2offer._32_loop_bs_from_up_to_down._02_loop_bs_by_level_from_up_to_down;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null) {
			return result;
		}
		
		Queue<TreeNode> layer = new LinkedList<TreeNode>();				// 存放树中所有元素的队列
		layer.add(pRoot);
		
		ArrayList<Integer> layerList = new ArrayList<Integer>();		// 存放树中每一层元素的 List 
		
		// 遍历，直到队列为空
		int start = 0, end = 1;		// start, end 指针，分别指向每层元素的开始和结束下标
		while (!layer.isEmpty()) {
			TreeNode cur = layer.remove();	// 从遍历队列中取出一个元素
			
			layerList.add(cur.val);		// 向层List中添加一个元素
			start++;
			if (cur.left != null) {
				layer.add(cur.left);
			}
			if (cur.right != null) {
				layer.add(cur.right);
			}
			
			// 遍历到每层的结尾，则将该层元素放入结果集，并重置对应容器
			if (start == end) {
				end = layer.size();
				start = 0;
				result.add(layerList);
				layerList = new ArrayList<Integer>();
			}
		}
		
		return result;
	}
}
