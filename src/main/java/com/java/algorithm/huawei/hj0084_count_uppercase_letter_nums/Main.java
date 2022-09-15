package com.java.algorithm.huawei.hj0084_count_uppercase_letter_nums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		while ((input = br.readLine()) != null) {
			char[] chrArr = input.toCharArray();
			int num = 0;
			for (int i = 0; i < chrArr.length; i++) {
				if (chrArr[i] >= 'A' && chrArr[i] <= 'Z')
					num++;
			}
			System.out.println(num);
		}
	}
}