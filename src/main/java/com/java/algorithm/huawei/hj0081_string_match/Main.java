package com.java.algorithm.huawei.hj0081_string_match;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		String str2 = "";
		while ((str = br.readLine()) != null && !"".equals(str)) {
			str2 = br.readLine();
			char[] arr = str.toCharArray();
			boolean judge = true;
			for (char c : arr) {
				if (!str2.contains(String.valueOf(c))) {
					judge = false;
					break;
				}
			}
			System.out.println(judge);
		}
		br.close();
	}
}
