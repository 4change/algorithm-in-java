package com.java.algorithm.other.weight_random.wr_1;

import com.java.algorithm.other.weight_random.wr_1.WeightRandom;
import org.apache.commons.math3.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author gongxiangfei
 * @description
 * @date 2021/2/23 17:39
 */
public class WeightRandomTest {

    @Test
    public void test() {
        Pair<String, Integer> pair1 = new Pair<>("1", 1);
        Pair<String, Integer> pair2 = new Pair<>("2", 2);
        Pair<String, Integer> pair3 = new Pair<>("3", 3);
        Pair<String, Integer> pair4 = new Pair<>("4", 4);
        List<Pair<String, Integer>> list = new ArrayList<>();
        list.add(pair1);
        list.add(pair2);
        list.add(pair3);
        list.add(pair4);
        WeightRandom<String, Integer> random = new WeightRandom<>(list);

        String num;
        HashMap<String, Integer> totalCount = new HashMap<>();
        for (int i = 0; i < 10000000; i++) {
            num = random.random();
//            System.out.println("num----------" + num);
            if (totalCount.containsKey(num)) {
                totalCount.put(num, totalCount.get(num) + 1);
            } else {
                totalCount.put(num, 1);
            }
        }
        System.out.println(totalCount.toString());
    }

}
