package com.java.algorithm.sword2offer._38_combination_of_string;

import java.util.HashSet;

public class Solution {
	
    public String[] permutation(String s) {
    	HashSet<String> result = new HashSet<String>();
    	String track = "";
    	boolean[] visited = new boolean[s.length()];
    	backtrack(result, s, track, visited);
    	return result.toArray(new String[result.size()]);
    }
    
    public static void backtrack(HashSet<String> result, String choose, String track, boolean[] visited) {
    	if (track.length() == choose.length()) {
    		result.add(track);
    		return;
    	}
    	
    	for (int i = 0; i < choose.length(); i++) {
    		if (visited[i] == true) continue;
    		
    		String temp = track;
    		
    		// 做选择
    		track += choose.charAt(i);
    		visited[i] = true;
    		
    		// 回溯
    		backtrack(result, choose, track, visited);
    		
    		// 剪枝
    		track = temp;
    		visited[i] = false;
    	}
    }

}
