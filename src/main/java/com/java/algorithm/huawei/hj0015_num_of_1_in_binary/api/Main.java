package com.java.algorithm.huawei.hj0015_num_of_1_in_binary.api;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNextInt()) {
			System.out.println(Integer.bitCount(input.nextInt()));
		}
		input.close();
	}

}
