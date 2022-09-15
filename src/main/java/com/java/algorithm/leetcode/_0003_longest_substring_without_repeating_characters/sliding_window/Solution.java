package com.java.algorithm.leetcode._0003_longest_substring_without_repeating_characters.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int maxSize = 0, i = 0, j = 0;
		while (i < n && j < n) {
			if (!set.contains(s.charAt(j))) { // set 中不含 j 处的字符
				set.add(s.charAt(j++));// 注意j++和j+1不是同一个意思
				maxSize = Math.max(maxSize, j - i);// 更新窗口最大值
			} else { // set 中含 j 处的字符
				set.remove(s.charAt(i++));
			}
		}
		return maxSize;
	}

}
