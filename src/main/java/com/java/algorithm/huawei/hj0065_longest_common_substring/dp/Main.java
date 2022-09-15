package com.java.algorithm.huawei.hj0065_longest_common_substring.dp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        while (input.hasNextLine() && input.hasNextLine()) {
            String str1 = input.nextLine();
            String str2 = input.nextLine();
            
            // 因为题目要求"若有多个，输出在较短串中最先出现的那个"，因此将短串放在前
            String temp = null;
            if (str1.length() > str2.length()) {
                temp = str1;
                str1 = str2;
                str2 = temp;
            }
            
            char[] chrArr1 = str1.toCharArray();
            char[] chrArr2 = str2.toCharArray();
            
            int[][] dp = getDP(chrArr1, chrArr2);
            
            int max = 0;
            int end = 0;
            for (int i = 0; i < chrArr1.length; i++) {
                for (int j = 0; j < chrArr2.length; j++) {
                    if (max < dp[i][j]) {
                        max = dp[i][j];
                        end = j;
                    }
                }
            }
            
            System.out.println(str2.substring(end - max + 1, end + 1));
        }
        
        input.close();
    }
    
    public static int[][] getDP(char[] chrArr1, char[] chrArr2) {
        int[][] dp = new int[chrArr1.length][chrArr2.length];
        
        for (int j = 0; j < chrArr2.length; j++) {
            if (chrArr1[0] == chrArr2[j]) {
                dp[0][j] = 1;
            }
        }
        
        for (int i = 0; i < chrArr1.length; i++) {
            if (chrArr1[i] == chrArr2[0]) {
                dp[i][0] = 1;
            }
        }
        
        for (int i = 1; i < chrArr1.length; i++) {
            for (int j = 1; j < chrArr2.length; j++) {
                if (chrArr1[i] == chrArr2[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }
        
        return dp;
    }
 }