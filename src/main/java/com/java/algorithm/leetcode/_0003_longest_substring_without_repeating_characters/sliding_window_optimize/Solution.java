package com.java.algorithm.leetcode._0003_longest_substring_without_repeating_characters.sliding_window_optimize;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>();

		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);// i直接跳到最新重复元素的位置
			}
			ans = Math.max(ans, j - i + 1);// 更新窗口最大值
			map.put(s.charAt(j), j + 1);// 更新map中记录的重复元素的索引位置
		}
		
		return ans;
	}

}
