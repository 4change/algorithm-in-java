package com.java.algorithm.leetcode._0047_permutations_ii;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	
    public List<List<Integer>> permuteUnique(int[] nums) {
    	LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
    	LinkedList<Integer> track = new LinkedList<Integer>();
    	boolean[] visited = new boolean[nums.length];
    	backtrack(result, nums, track, visited);
    	return result;
    }
    
    public static void backtrack(LinkedList<List<Integer>> result, int[] nums, 
    		LinkedList<Integer> track, boolean[] visited) {
    	if (nums.length == track.size()) {
    		result.add(new LinkedList<Integer>(track));
    		return;
    	}
    	
    	for (int i = 0; i < nums.length; i++) {
    		if (visited[i] == true) continue;
    		
    		track.add(nums[i]);
    		visited[i] = true;
    		backtrack(result, nums, track, visited);
    		track.removeLast();
    		visited[i] = false;
    	}
    }

}
