package com.java.algorithm.other.prime;

public class Solution {

	public static void main(String[] args) {
		int count = 1;

		int num = 0;
		while (num < 10001) {
			if (isPrime(count)) {
				num++;
			}
			count++;
		}
		
		System.out.println("10001：" + (count - 1));
	}

	public static boolean isPrime(int n) {
		if (n < 2) return false;

		if (n == 2) return true;

		if (n % 2 == 0) return false;

		for (int i = 3; i < n; i += 2)
			if (n % i == 0) return false;

		return true;
	}

}
