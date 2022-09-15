package com.java.algorithm.huawei.hj0014_string_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String input = null;
        PriorityQueue<String> pq = new PriorityQueue<>();
        while (((input = br.readLine()) != null) && num-- != 0) {
            pq.offer(input);
        }

        Iterator<String> iterator = pq.iterator();
        while (iterator.hasNext()) {
        	System.out.println(iterator.next());
        }
        
        br.close();
    }
}
