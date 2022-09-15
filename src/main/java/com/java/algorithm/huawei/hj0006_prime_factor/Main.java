package com.java.algorithm.huawei.hj0006_prime_factor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        while (input.hasNextLong()) {
            long num = input.nextLong();
            
            String result = "";
            long temp = num;
            for (int i = 2; i <= num; i++) {
                if (temp % i == 0) {
                    result = result + i + " ";
                    temp = temp / i;
                    i--;
                }
            }
            
            System.out.println(result);
        }
        
        input.close();
    }
}
