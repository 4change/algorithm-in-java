package com.java.algorithm.leetcode._0141_linked_list_cycle.hash;

import java.util.HashSet;

public class Solution {

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> seenNodeSet = new HashSet<>();

        while (head != null) {
            if (seenNodeSet.contains(head)) {
                return true;
            } else {
                seenNodeSet.add(head);
            }

            head = head.next;
        }

        return false;
    }

}
