package com.java.algorithm.huawei.hj0086_max_continuously_bit_num;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while ((input = bReader.readLine()) != null) {
			int number = Integer.parseInt(input);
			String binaryString = Integer.toBinaryString(number);
			String[] string = binaryString.split("0");

			int num = 0;
			for (String str : string) {
				num = Math.max(num, str.length());
			}
			System.out.println(num);
		}
	}

//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		while (in.hasNextInt()) {
//			int n = in.nextInt();
//			String binaryStr = Integer.toBinaryString(n);
//			String[] binStrArr = binaryStr.split("0");
//
//			int max = 0;
//			for (int i = 0; i < binStrArr.length; i++) {
//				max = Math.max(max, binStrArr[i].length());
//			}
//
//			System.out.println(max);
//		}
//		in.close();
//	}
}
