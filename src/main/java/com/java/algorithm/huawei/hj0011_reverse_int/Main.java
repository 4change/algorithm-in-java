package com.java.algorithm.huawei.hj0011_reverse_int;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            System.out.println(new String(new StringBuffer(input.nextInt() + "").reverse()));
        }
        input.close();
    }
}
