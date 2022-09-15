package com.java.algorithm.huawei.hj0015_num_of_1_in_binary.count_1_in_binaray;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNextInt()) {
			int count = 0;
			String binary = Integer.toBinaryString(input.nextInt());
			for (int i = 0; i < binary.length(); i++) {
				if (binary.charAt(i) == '1') {
					count++;
				}
			}
			System.out.println(count);
		}
		input.close();
	}

}
