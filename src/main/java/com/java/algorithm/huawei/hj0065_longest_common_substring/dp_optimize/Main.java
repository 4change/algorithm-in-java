package com.java.algorithm.huawei.hj0065_longest_common_substring.dp_optimize;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine() && input.hasNextLine()) {
            String str1 = input.nextLine();
            String str2 = input.nextLine();
            
            String temp = null;
            if (str1.length() > str2.length()) {
                temp = str1;
                str1 = str2;
                str2 = temp;
            }
            
            char[] chrArr1 = str1.toCharArray();
            char[] chrArr2 = str2.toCharArray();
            
            int row = 0;
            int col = chrArr2.length - 1;
            
            int max = 0;
            int end = 0;
            while (row < chrArr1.length) {
                int i = row;
                int j = col;
                
                int len = 0;
                
                while (i < chrArr1.length && j < chrArr2.length) {
                    if (chrArr1[i] == chrArr2[j]) {
                        len++;
                    } else {
                        len = 0;
                    }
                    
                    if (len > max) {
                        max = len;
                        end = i;
                    }
                    
                    i++;
                    j++;
                }
                
                if (col > 0) {
                    col--;
                } else {
                    row++;
                }
            }
            
            System.out.println(str1.substring(end - max + 1, end + 1));
        }
        input.close();
    }
}
