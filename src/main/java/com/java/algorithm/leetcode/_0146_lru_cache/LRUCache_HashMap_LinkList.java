package com.java.algorithm.leetcode._0146_lru_cache;

import java.util.HashMap;

/**
 * LRU（Least Recently Used）缓存算法
 * 使用HashMap+双向链表，使get和put的时间复杂度达到O(1)。
 * 读缓存时从HashMap中查找key，再根据key查找对应数据节点；
 * 更新缓存时同时更新HashMap和双向链表，双向链表始终按照访问时间的先后顺序排列，访问时间越早的数据节点排在双向链表的越前面
 *
 */
public class LRUCache_HashMap_LinkList {

    /**
     * @param args
     *
     * 测试程序，访问顺序为[[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]，其中成对的数调用put，单个数调用get。
     * get的结果为[1],[-1],[-1],[3],[4]，-1表示缓存未命中，其它数字表示命中。
     */
    public static void main(String[] args) {
        // 创建一个容量为2的LRUCache
        LRUCache_HashMap_LinkList cache = new LRUCache_HashMap_LinkList(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    private final int capacity;                         // LRUCache容量
    private HashMap<Integer, Entry> map;                // 用于加速缓存项随机访问性能的HashMap
    private Entry head;                                 // 双向链表头结点，该侧的缓存项访问时间较早
    private Entry tail;                                 // 双向链表尾结点，该侧的缓存项访问时间较晚

    // 创建一个指定容量的LRUCache
    public LRUCache_HashMap_LinkList(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>((int)(capacity / 0.75 + 1), 0.75f);
        head = new Entry(0, 0);
        tail = new Entry(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 从缓存中获取key对应的值，若未命中则返回-1;
     *
     * @param key 键
     * @return key对应的值，若未命中则返回-1
     */
    public int get(int key) {
        // 读缓存时，若缓存命中，则将命中的数据节点移动到双向链表的尾部，然后返回该数据节点的值
        if (map.containsKey(key)) {
            Entry entry = map.get(key);
            popToTail(entry);
            System.out.println("读缓存，缓存命中: " + entry.value);
            return entry.value;
        }

        // 缓存未命中，返回-1
        System.out.println("读缓存，缓存未命中: " + -1);
        return -1;
    }

    /**
     * 向缓存中插入或更新值
     *
     * @param key 待更新的键
     * @param value 待更新的值
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 写缓存且缓存命中时，更新缓存值，并将该数据节点移动到双向链表的尾部
            Entry entry = map.get(key);
            entry.value = value;
            popToTail(entry);
            System.out.println("写缓存，缓存命中，更新缓存到尾部: " + entry.value);
        }
        else {
            Entry newEntry = new Entry(key, value);
            if (map.size() >= capacity) {
                // 写缓存且缓存未命中时，若缓存已满，则删除双向链表头部的数据节点(最近最少使用)，
                // 然后将新添加的数据节点插入到双向链表的尾部
                Entry first = removeFirst();
                map.remove(first.key);
                System.out.println("写缓存且缓存未命中，缓存已满，删除头结点: " + newEntry.value);
            }
            // 写缓存且缓存未命中时，若缓存未满，则直接将新插入的数据节点添加到双向链表的尾部
            addToTail(newEntry);
            map.put(key, newEntry);
            System.out.println("写缓存且缓存未命中，插入新节点到尾部: " + newEntry.value);
        }
    }

    /**
     * 缓存项的包装类，包含键、值、前驱结点、后继结点
     *
     */
    class Entry {
        int key;
        int value;
        Entry prev;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 将entry结点移动到链表末端
    private void popToTail(Entry entry) {
        Entry prev = entry.prev;
        Entry next = entry.next;
        prev.next = next;
        next.prev = prev;
        Entry last = tail.prev;
        last.next = entry;
        tail.prev = entry;
        entry.prev = last;
        entry.next = tail;
    }

    // 移除链表首端的结点
    private Entry removeFirst() {
        Entry first = head.next;
        Entry second = first.next;
        head.next = second;
        second.prev = head;
        return first;
    }

    // 添加entry结点到链表末端
    private void addToTail(Entry entry) {
        Entry last = tail.prev;
        last.next = entry;
        tail.prev = entry;
        entry.prev = last;
        entry.next = tail;
    }

}
