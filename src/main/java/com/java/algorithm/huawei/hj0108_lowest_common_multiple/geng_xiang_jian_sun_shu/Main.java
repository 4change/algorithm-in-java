package com.java.algorithm.huawei.hj0108_lowest_common_multiple.geng_xiang_jian_sun_shu;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int int1 = input.nextInt();
		int int2 = input.nextInt();
		System.out.println(int1 * int2 / gxjss(int1, int2));
		input.close();
	}

	/**
	 * 更相减损术
	 * 
	 * @param int1
	 * @param int2
	 * @return
	 */
	public static int gxjss(int int1, int int2) {
		if (int1 == int2) {
			return int2;
		}
		if (int1 > int2) {
			int differ = int1 - int2;
			return gxjss(int2, differ);
		} else {
			int differ = int2 - int1;
			return gxjss(int1, differ);
		}
	}
	
}
