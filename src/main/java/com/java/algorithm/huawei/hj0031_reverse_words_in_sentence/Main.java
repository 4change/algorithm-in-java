package com.java.algorithm.huawei.hj0031_reverse_words_in_sentence;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNextLine()) {
			String str = input.nextLine();
			String[] strArr = str.split(" ");
			String result = "";
			for (int i = strArr.length - 1; i >= 0; i--) {
				result += strArr[i] + " ";
			}
			System.out.println(result);
		}
		input.close();
	}
}
