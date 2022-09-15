package com.java.algorithm.leetcode._0460_lfu_cache.linked_hash_map_lfu_cache;

import org.junit.Test;

public class LFUCacheTest {

    @Test
    public void test() {
        LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));        // 返回 1
        System.out.println(cache.get(1));        // 返回 1
        System.out.println(cache.get(1));        // 返回 1
        cache.put(3, 3);    // 去除 key 2
        System.out.println(cache.get(2));       // 返回 -1 (未找到key 2)
        System.out.println(cache.get(3));       // 返回 3
        System.out.println(cache.get(3));       // 返回 3
        System.out.println(cache.get(3));       // 返回 3

        cache.put(4, 4);    // 去除 key 1
        System.out.println(cache.get(1));       // 返回 -1 (未找到 key 1)
        System.out.println(cache.get(3));       // 返回 3
        System.out.println(cache.get(3));       // 返回 3
        System.out.println(cache.get(3));       // 返回 3
        System.out.println(cache.get(4));       // 返回 4
        System.out.println(cache.get(4));       // 返回 4
        System.out.println(cache.get(4));       // 返回 4
        cache.put(4, 41);
        System.out.println(cache.get(4));
    }

}
