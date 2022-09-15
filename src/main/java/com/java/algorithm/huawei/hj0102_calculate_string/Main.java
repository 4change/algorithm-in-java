package com.java.algorithm.huawei.hj0102_calculate_string;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s = in.nextLine();

            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 1) + 1);
            }

            ArrayList<Map.Entry> list=new ArrayList<>(map.entrySet());//把map放入list中。
            Collections.sort(list, (o1, o2) -> {
                if(o1.getValue()!=o2.getValue()){//若次数不同
                    return (int)(o2.getValue())-(int)(o1.getValue());//一定记得转换类型，否则报错Object不能使用'-'运算符。
                }else{//若次数相同
                    return (char)(o1.getKey())-(char)(o2.getKey());
                }
            });
            //打印key
            for (Map.Entry entry : list) {
                System.out.print(entry.getKey());
            }
            System.out.println();//打印完一组换行

        }
    }

}
