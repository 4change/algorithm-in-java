package com.java.algorithm.huawei.hj0090_valid_ip;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        while (input.hasNextLine()) {
        	String result = "";
            String ip = input.nextLine();
            String[] ipArr = ip.split("\\.");
            if (ipArr != null && ipArr.length > 0 && ipArr.length == 4) {
                for (int i = 0; i < ipArr.length; i++) {
                    Integer ipNum = Integer.parseInt(ipArr[i]);
                    if (!(ipNum >= 0 && ipNum <= 255)) {
                        result = "NO";
                    }
                }
                if (result.equals("")) {
                	result = "YES";
                }
                System.out.println(result);
            } else {
                System.out.println("NO");
            }
		}
        input.close();
    }
}
