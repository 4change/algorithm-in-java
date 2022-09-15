package com.java.algorithm.leetcode._0003_longest_substring_without_repeating_characters.force;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();

		int index = 0; // String s的索引
		int maxSize = 0; // 返回的值
		while (index < s.length()) {
			while (true) {
				char c = s.charAt(index);
				if (set.contains(c)) {
					index = index - set.size() + 1;// index回退到重复元素的后一个位置（不可以用indexOf）
					break;
				} else {
					set.add(c);// 元素与set集合里面的不重复，添加到set里
					index++;
				}
				if (index == s.length()) {
					break;
				}
			}
			if (maxSize < set.size()) { // 找出每次遍历中set最大的元素，即最大不重复子串
				maxSize = set.size();
			}
			set.clear(); // 每次有重复元素，重置set集合
		}
		return maxSize;
	}

}
