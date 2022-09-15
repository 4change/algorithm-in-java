package com.java.algorithm.huawei.hj0106_string_reverse;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            if (!str.equals("")) {
                char[] chrArr = str.toCharArray();
                for (int i = 0; i < chrArr.length / 2; i++) {
                	char temp = chrArr[i];
                    chrArr[i] = chrArr[chrArr.length - i - 1];
                    chrArr[chrArr.length - i - 1] = temp;
                }
                System.out.println(new String(chrArr));
            } else {
                System.out.println("请输入合法的字符串");
            }
        }
        in.close();
    }
}
