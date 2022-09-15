package com.java.algorithm.other.gold_ratio_of_fibonacci;

import java.math.BigDecimal;

public class Solution {

	public static void main(String[] args) {
		int exponent = 16;
		BigDecimal t = new BigDecimal(1 / Math.pow(10, exponent));
		
		int n = 10;
		
		BigDecimal a = new BigDecimal(fibonacci(n+2)).divide(new BigDecimal(fibonacci(n + 1)), exponent, BigDecimal.ROUND_HALF_UP);
		BigDecimal b = new BigDecimal(fibonacci(n+1)).divide(new BigDecimal(fibonacci(n)), exponent, BigDecimal.ROUND_HALF_UP);
		BigDecimal ratio = a.subtract(b).abs();
		
		while (ratio.compareTo(t) > 0) {
			n++;
			
			a = new BigDecimal(fibonacci(n+2)).divide(new BigDecimal(fibonacci(n + 1)), exponent, BigDecimal.ROUND_HALF_UP);
			b = new BigDecimal(fibonacci(n+1)).divide(new BigDecimal(fibonacci(n)), exponent, BigDecimal.ROUND_HALF_UP);
			ratio = a.subtract(b).abs();
		}
		
		System.out.println("n: " + n + ", goldRatio: " + b);
	}
	
    public static int fibonacci(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;

        int prev = 0, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

}
