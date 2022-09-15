package com.java.algorithm.huawei.hj0108_lowest_common_multiple.division_algorithm;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		int y = input.nextInt();
		int originalX = x;
		int originalY = y;
		int temp = 0;
		while (y != 0) {
			temp = x % y;
			x = y;
			y = temp;
		}
		System.out.println(originalX * originalY / x);
		input.close();
	}
}

