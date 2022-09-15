package com.java.algorithm.huawei.hj0107_cube_root.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		String str = br.readLine();
		double d1 = Double.parseDouble(str);
		System.out.println(method1(d1));
	}

	public static double method1(double d1) {
		double x = 1;
		double x0 = x - (x * x * x - d1) / (3 * x * x);
		while (x - x0 > 0.000000001 || x - x0 < -0.000000001) {
			x = x0;
			x0 = x - (x * x * x - d1) / (3 * x * x);
		}
		return (double) Math.round(x0 * 10.0) / 10.0;
	}
}
