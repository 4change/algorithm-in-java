package com.java.algorithm.huawei.hj0007_approximate_value;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextDouble()) {
           double input = in.nextDouble();
           int temp = new Double(input * 10).intValue() % 10;
           if (temp >= 5) {
               System.out.println(new Double(input + 1).intValue());
           } else {
               System.out.println(new Double(input).intValue());
           }
        }
        in.close();
    }
}
