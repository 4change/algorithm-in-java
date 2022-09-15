package com.java.algorithm.huawei.hj0010_count_character_nums;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        HashMap<Character, Integer> map = new HashMap<>();
        while ((input = br.readLine()) != null) {
            char[] chrArr = input.toCharArray();
            for (int i = 0; i < chrArr.length; i++) {
                map.put(chrArr[i], i);
            }
        }
        System.out.println(map.size());
    }
}