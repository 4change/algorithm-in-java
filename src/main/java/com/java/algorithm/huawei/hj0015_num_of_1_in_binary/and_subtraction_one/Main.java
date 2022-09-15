package com.java.algorithm.huawei.hj0015_num_of_1_in_binary.and_subtraction_one;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNextInt()) {
			int x = input.nextInt();
			
			int count = 0;
			while (x != 0) {
				x &= (x - 1);
				count++;
			}
			
			System.out.println(count);
		}
		input.close();
	}

}
