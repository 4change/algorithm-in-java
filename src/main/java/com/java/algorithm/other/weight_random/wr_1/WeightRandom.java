package com.java.algorithm.other.weight_random.wr_1;

import com.sun.istack.internal.NotNull;
import org.apache.commons.math3.util.Pair;

import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 权重随机算法
 *
 * @author gongxiangfei
 * @description
 * @date 2021/2/23 17:36
 */
public class WeightRandom<K, V extends Number> {
    private TreeMap<Double, K> weightMap = new TreeMap<>();

    public WeightRandom(@NotNull List<Pair<K, V>> list) {
        // 先排除权重为0的项
        Iterator<Pair<K, V>> it = list.iterator();
        while (it.hasNext()) {
            Pair<K, V> next = it.next();
            System.out.println("next-----" + next + "-----next.getSecond-----" + next.getSecond());
            if (next.getSecond().doubleValue() == 0) {
                it.remove();
            }
        }

        for (Pair<K, V> pair : list) {
            double lastWeight = this.weightMap.size() == 0 ? 0 : this.weightMap.lastKey();// 统一转为double
            this.weightMap.put(pair.getSecond().doubleValue() + lastWeight, pair.getFirst());// 权重累加
        }
    }

    public K random() {
        double randomWeight = this.weightMap.lastKey() * Math.random();
        SortedMap<Double, K> tailMap = this.weightMap.tailMap(randomWeight, false);
        return this.weightMap.get(tailMap.firstKey());
    }

}
