package com.java.algorithm.huawei.hj0009_non_repeat_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		while ((input = br.readLine()) != null) {
			input = new String(new StringBuffer(input).reverse());

			LinkedHashSet<Character> set = new LinkedHashSet<>();
			char[] chrArr = input.toCharArray();
			for (int i = 0; i < chrArr.length; i++) {
				if (!set.contains(chrArr[i])) {
					set.add(chrArr[i]);
				}
			}

			StringBuffer sb = new StringBuffer();
			Iterator<Character> it = set.iterator();
			while (it.hasNext()) {
				sb.append(it.next());
			}

			System.out.println(new String(sb));
		}
		br.close();
	}
}
