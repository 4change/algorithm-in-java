package com.java.algorithm.leetcode._0146_lru_cache.linked_hash_map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private LinkedHashMap<Integer, Integer> map;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
        	@Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

}
