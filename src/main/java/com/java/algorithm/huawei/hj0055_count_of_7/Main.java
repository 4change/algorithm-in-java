package com.java.algorithm.huawei.hj0055_count_of_7;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNextInt()) {
			int num = input.nextInt();

			int numOf7 = 0;
			for (int i = num; i > 0; i--) {
				String temp = i + "";
				if ((i % 7 == 0) || temp.contains("7")) {
					numOf7++;
				}
			}

			System.out.println(numOf7);
		}
		input.close();
	}
}
