package com.java.algorithm.leetcode._0460_lfu_cache.linked_hash_set_lfu_cache;

import java.util.HashMap;
import java.util.LinkedHashSet;

class LFUCache {

    /**
     * 缓存容量大小
     */
    public int capacity;
    /**
     * 缓存容器, key: 缓存索引, value: 缓存值
     */
    public HashMap<Integer, Integer> map = new HashMap<>();
    /**
     * 缓存访问频次容器, key: 缓存索引, value: 缓存对应的访问频次
     */
    public HashMap<Integer, Integer> frequent = new HashMap<>();
    /**
     * 存储每个频率的相应的key的值的集合，这里用HashSet是因为其是由HashMap底层实现的，可以O(1)时间复杂度查找元素
     * 而且linked是有序的，同一频率值越往后越最近访问
     *
     * 缓存访问频次-缓存索引的集合的容器, key: 缓存的访问频次, value: LinkedHashSet, 访问频次对应的缓索引的集合
     */
    public HashMap<Integer, LinkedHashSet<Integer>> list = new HashMap<>();
    /**
     * 标记当前频率中的最小值
     */
    int min = -1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        // 缓存容器中不包含对应元素的key, 直接返回-1
        if (!map.containsKey(key)) {
            return -1;

        // 缓存容器中存在对应元素的key, 则返回对应元素, 并更新其访问频次
        } else {
            // 根据key获取对应元素值
            int value = map.get(key);
            // 根据key获取对应元素访问频次
            int count = frequent.get(key);
            // 更新key对应元素的访问频次
            frequent.put(key, count + 1);

            //先移除当前key
            list.get(count).remove(key);
            //更改min的值
            if (count == min && list.get(count).size() == 0) {
                min++;
            }
            LinkedHashSet<Integer> set = list.containsKey(count + 1) ? list.get(count + 1) : new LinkedHashSet<>();
            set.add(key);
            list.put(count + 1, set);
            return value;
        }
    }

    public void put(int key, int value) {
        // 缓存容量校验
        if (capacity <= 0) {
            return;
        }

        // 缓存中包含对应key, 则进行更新操作
        if (map.containsKey(key)) {
            // 更新key对应的缓存值
            map.put(key, value);
            // 更新key对应的缓存访问频次
            int count = frequent.get(key);
            frequent.put(key, count + 1);

            // 先移除当前key
            list.get(count).remove(key);

            // 更改min的值
            if (count == min && list.get(count).size() == 0) {
                min++;
            }

            LinkedHashSet<Integer> set = list.containsKey(count + 1) ? list.get(count + 1) : new LinkedHashSet<>();
            set.add(key);
            list.put(count + 1, set);

            // 缓存已满的情况下, 先进行元素淘汰(访问频次最低的 --> 访问时间最久的), 在进行元素放入
        } else {
            // 缓存已满的情况下, 进行元素淘汰
            if (map.size() >= capacity) {
                // 获取被移除元素的key
                Integer removeKey = list.get(min).iterator().next();
                // 从缓存访问频次-缓存索引的集合的容器中移除元素的key
                list.get(min).remove(removeKey);
                // 从缓存容器中溢出元素的key
                map.remove(removeKey);
                // 从缓存访问频次容器中移除元素的key
                frequent.remove(removeKey);
            }

            // 添加新元素到缓存容器
            map.put(key, value);
            // 添加新元素key到缓存访问频次容器
            frequent.put(key, 1);
            // 添加新元素到“缓存访问频次-缓存索引的集合的容器”
            LinkedHashSet<Integer> set = list.containsKey(1) ? list.get(1) : new LinkedHashSet<>();
            set.add(key);
            list.put(1, set);

            min = 1;
        }
    }

//    public static void main(String[] args) {
//        LFUCache lfuCache = new LFUCache(2);
//        lfuCache.put(2, 1);
//        lfuCache.put(3, 2);
//        System.out.println(lfuCache.get(3));
//        System.out.println(lfuCache.get(2));
//        lfuCache.put(4, 3);
//        System.out.println(lfuCache.get(2));
//        System.out.println(lfuCache.get(3));
//        System.out.println(lfuCache.get(4));
//    }
}