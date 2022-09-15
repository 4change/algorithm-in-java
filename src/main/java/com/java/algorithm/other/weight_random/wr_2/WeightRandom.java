package com.java.algorithm.other.weight_random.wr_2;

import com.google.common.base.Preconditions;
import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author gongxiangfei
 * @description
 * @date 2021/2/23 18:20
 */
class WeightRandom<K, V extends Number> {
    private TreeMap<Double, K> weightMap = new TreeMap<>();

    public WeightRandom(List<Pair<K, V>> list) {
        Preconditions.checkNotNull(list, "list can NOT be null!");
        for (Pair<K, V> pair : list) {
            double lastWeight = this.weightMap.size() == 0 ? 0 : this.weightMap.lastKey().doubleValue();//统一转为double
            this.weightMap.put(pair.getValue().doubleValue() + lastWeight, pair.getKey());//权重累加
        }

        System.out.println("------Tree init OK!--------");
    }

    public K random() {
        double randomWeight = this.weightMap.lastKey() * Math.random();
        SortedMap<Double, K> tailMap = this.weightMap.tailMap(randomWeight, true);
        return this.weightMap.get(tailMap.firstKey());
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) {
        List<Pair<String, Double>> list = new ArrayList<Pair<String, Double>>();
        list.add(new Pair<>("A", 0.20));
        list.add(new Pair<>("C", 0.50));
        list.add(new Pair<>("B", 0.30));

        WeightRandom weightRandom = new WeightRandom(list);
        Object random = weightRandom.random();
        System.out.println("----Key----" + random);
    }
}
