package com.java.algorithm.other.hj001;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNextLine()) {
			String str = input.nextLine();
			char[] chrArray = str.toCharArray();
			
			TreeMap<Character, Integer> map = new TreeMap<>();
			for (int i = 0; i < chrArray.length; i++) {
				if (map.containsKey(chrArray[i])) {
					map.put(chrArray[i], ((int)map.get(chrArray[i])) + 1);
				} else {
					map.put(chrArray[i], 1);
				}
			}
			
			String result = "";
			for (Map.Entry<Character, Integer> set : map.entrySet()) {
				result += set.getKey() + ":" + set.getValue() + ";";
			}
			
			System.out.println(result);
			
//			ArrayList<Character, Integer> list = new ArrayList<>();
//			for (int i = 0; i < map.size() - 1; i++) {
//				for (int j = 0; j < map.size() - i - 1; j++) {
//					if (list.get(j).compareTo(list.get(j + 1)) < 0) {
//						
//					}
//				}
//			}
//			
//			Collection<Integer> values = map.values();
			
//			// 对 map 中元素按照 value 排序，若 value 相等，按照 key 排序
//			
//			TreeMap<Integer, HashMap<Character, Integer>> outerMap = new TreeMap<>();
//			for (Map.Entry<Character, Integer> set : map.entrySet()) {
//				if (outerMap.get(set.getValue()) != null) {
//					if (set.getKey().compareTo(anotherCharacter))
//				}
//			}
		}
		input.close();
	}

}
