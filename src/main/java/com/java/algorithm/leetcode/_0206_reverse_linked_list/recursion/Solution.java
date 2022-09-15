package com.java.algorithm.leetcode._0206_reverse_linked_list.recursion;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head.next;
        head.next = null;
        return p;
    }
}
