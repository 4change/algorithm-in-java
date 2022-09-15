package com.java.algorithm.huawei.hj0012_reverse_string;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNextLine()) {
			System.out.println(new String(new StringBuffer(input.nextLine()).reverse()));
		}
		input.close();
	}
}