package com.java.algorithm.leetcode._0460_lfu_cache.linked_hash_map_lfu_cache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
class LFUCache {
    //key出现的频率为value
    HashMap<Integer, Integer> frequency = new HashMap<>();
    //频率为key的hashMap为value
    HashMap<Integer, LinkedHashMap<Integer, Integer>> a = new HashMap<>();
    //时刻记住需要更新哪些全局变量
    int min = 0;//最小频率
    int capacity;//容器的容量
    int nowsize = 0;//当前容器中元素个数
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    public String tos(Map<Integer, Integer> ma) {
        StringBuilder builder = new StringBuilder();
        for (int i : ma.keySet()) {
            builder.append(i + ":" + ma.get(i) + " ");
        }
        return builder.toString();
    }
    public void debug() {
        System.out.println(tos(frequency));
        for (int i : a.keySet()) {
            System.out.println(i + " " + tos(a.get(i)));
        }
        System.out.println("======");
    }
    public int get(int key) {
        Integer f = frequency.get(key);
        if (f == null) {
            return -1;
        }
        int value = a.get(f).get(key);
        active(key);//激活一下key,使其频率+1
        return value;
    }
    void active(int key) {
        int f = frequency.get(key);
        frequency.put(key, f + 1);
        LinkedHashMap<Integer, Integer> src = a.get(f), des = a.getOrDefault(f + 1, new LinkedHashMap<>());
        des.put(key, src.remove(key));
        tryRemove(f);
        a.put(f + 1, des);
    }
    void tryRemove(int frequency) {
        if (a.get(frequency).size() == 0) {
            if (frequency == min) {
                min++;
            }
            a.remove(frequency);
        }
    }
    void removeLFU() {
        LinkedHashMap<Integer, Integer> ma = a.get(min);
        int removing = ma.keySet().iterator().next();
        ma.remove(removing);//移除掉最早插入的那个结点
        tryRemove(min);
        frequency.remove(removing);
        nowsize--;
    }
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (frequency.get(key) == null) {
            if (capacity == nowsize) removeLFU();
            nowsize++;
            frequency.put(key, 1);
            LinkedHashMap<Integer, Integer> ff = a.getOrDefault(1, new LinkedHashMap<>());
            ff.put(key, value);
            a.put(1, ff);
            min = 1;//新插入结点之后,最低频率必然为1
        } else {
            active(key);
            a.get(frequency.get(key)).put(key, value);
        }
    }
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        String[] op = {"put", "put", "get", "put", "get", "get", "put", "get", "get", "get"};
        int[][] value = {{1, 1}, {2, 2}, {1}, {3, 3}, {2}, {3}, {4, 4}, {1}, {3}, {4}};
        for (int i = 0; i < op.length; i++) {
            System.out.println(op[i] + " " + value[i] + " " + cache.min);
            cache.debug();
            if (op[i].equals("put")) {
                cache.put(value[i][0], value[i][1]);
            } else {
                cache.get(value[i][0]);
            }
        }
    }
}

