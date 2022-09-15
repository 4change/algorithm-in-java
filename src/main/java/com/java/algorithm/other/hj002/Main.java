package com.java.algorithm.other.hj002;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNextLine()) {
			String str = input.nextLine();
			int[][] dp = getDP(str);
			
			int max = 0;
			for (int i = 0; i < str.length(); i++) {
				for (int j = 0; j < str.length(); j++) {
					if (dp[i][j] > max) {
						max = dp[i][j];
					}
				}
			}
			
			System.out.println(max);
		}
		input.close();
	}
	
	public static int[][] getDP(String str) {
		char[] chrArr = str.toCharArray();
		
		String yy = "aeiouAEIOU";
		
		int[][] result = new int[chrArr.length][chrArr.length];
		
		for (int j = 0; j < chrArr.length; j++) {
			if (chrArr[0] == chrArr[j] && yy.indexOf(chrArr[j]) != -1) {
				result[0][j] = 1;
			}
		}
		
		for (int i = 0; i < chrArr.length; i++) {
			if (chrArr[0] == chrArr[i] && yy.indexOf(chrArr[i]) != -1) {
				result[i][0] = 1;
			}
		}
		
		for (int i = 1; i < chrArr.length; i++) {
			for (int j = 1; j < chrArr.length; j++) {
				if (chrArr[i] == chrArr[j] && yy.indexOf(chrArr[i]) != -1) {
					result[i][j] = result[i-1][j-1] + 1;
				}
			}
		}
		
		return result;
	}
	
//	public static int[][] getDP(String str1, String str2) {
//		char[] chrArr1 = str1.toCharArray();
//		char[] chrArr2 = str2.toCharArray();
//		
//		String yy = "aeiouAEIOU";
//		
//		int[][] result = new int[chrArr1.length][chrArr2.length];
//		
//		for (int j = 0; j < chrArr2.length; j++) {
//			if (chrArr1[0] == chrArr2[j] && yy.indexOf(chrArr2[j]) != -1) {
//				result[0][j] = 1;
//			}
//		}
//		
//		for (int i = 0; i < chrArr1.length; i++) {
//			if (chrArr2[0] == chrArr1[i] && yy.indexOf(chrArr1[i]) != -1) {
//				result[i][0] = 1;
//			}
//		}
//		
//		for (int i = 1; i < chrArr1.length; i++) {
//			for (int j = 1; j < chrArr2.length; j++) {
//				if (chrArr1[i] == chrArr2[j] && yy.indexOf(chrArr1[i]) != -1) {
//					result[i][j] = result[i-1][j-1] + 1;
//				}
//			}
//		}
//		
//		return result;
//	}

}
