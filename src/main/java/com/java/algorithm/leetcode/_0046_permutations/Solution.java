package com.java.algorithm.leetcode._0046_permutations;

import java.util.LinkedList;
import java.util.List;

class Solution {
	
	// 存放最终结果的 list
	// 使用 LinkedList 是为了便于从尾部添加/删除元素
	private List<List<Integer>> res = new LinkedList<>();

	/* 主函数，输入一组不重复的数字，返回它们的全排列 */
	public List<List<Integer>> permute(int[] nums) {
		LinkedList<Integer> track = new LinkedList<>();	// 记录「路径」
		backtrack(nums, track);
		return res;
	}

	/**
	 * 路径: 记录在 track 中
	 * 选择列表: nums 中不存在于 track 的那些元素
	 * 结束条件: nums 中的元素全都在 track 中出现
	 * 
	 * @param nums 
	 * @param track 路径
	 */
	public void backtrack(int[] nums, LinkedList<Integer> track) {
		// 触发结束条件
		if (track.size() == nums.length) {
			res.add(new LinkedList<>(track));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			// 排除不合法的选择
			if (track.contains(nums[i])) continue;
			// 做选择
			track.add(nums[i]);
			// 进入下一层决策树
			backtrack(nums, track);
			// 取消选择
			track.removeLast();
		}
	}
	
}