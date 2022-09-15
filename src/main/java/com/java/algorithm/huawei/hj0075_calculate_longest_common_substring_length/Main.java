package com.java.algorithm.huawei.hj0075_calculate_longest_common_substring_length;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = null;
		String str2 = null;

		while ((str1 = br.readLine()) != null && (str2 = br.readLine()) != null) {
			char[] chrArr1 = str1.toCharArray();
			char[] chrArr2 = str2.toCharArray();
			int[][] dp = getDP(chrArr1, chrArr2);

			int max = 0;
			for (int i = 0; i < chrArr1.length; i++) {
				for (int j = 0; j < chrArr2.length; j++) {
					max = Math.max(dp[i][j], max);
				}
			}

			System.out.println(max);
		}
	}

	public static int[][] getDP(char[] chrArr1, char[] chrArr2) {
		int[][] dp = new int[chrArr1.length][chrArr2.length];

		// 第一行
		for (int j = 0; j < chrArr2.length; j++) {
			if (chrArr1[0] == chrArr2[j]) {
				dp[0][j] = 1;
			}
		}

		// 第一列
		for (int i = 0; i < chrArr1.length; i++) {
			if (chrArr2[0] == chrArr1[i]) {
				dp[i][0] = 1;
			}
		}

		// 其他行列，索引从1开始，避免数组越界
		for (int i = 1; i < chrArr1.length; i++) {
			for (int j = 1; j < chrArr2.length; j++) {
				if (chrArr1[i] == chrArr2[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
			}
		}

		return dp;
	}
}
