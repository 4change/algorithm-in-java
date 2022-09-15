package com.java.algorithm.huawei.hj0059_first_only_char_in_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        
        while ((input = br.readLine()) != null) {
            LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
            char[] chrArr = input.toCharArray();
            
            for (int i = 0; i < chrArr.length; i++) {
                if (map.containsKey(chrArr[i])) {
                    map.put(chrArr[i],((Integer)map.get(chrArr[i])).intValue() + 1);
                } else {
                    map.put(chrArr[i], 1);
                }
            }
            
            int flag = 0;
            for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            	if (((Integer)entry.getValue()).intValue() == 1) {
            		flag++;
            		System.out.println(entry.getKey());
            	}
            }
            
            if (flag == 0) System.out.println(-1);
        }
        
        br.close();
    }
}
