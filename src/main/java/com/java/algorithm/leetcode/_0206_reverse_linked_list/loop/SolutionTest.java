package com.java.algorithm.leetcode._0206_reverse_linked_list.loop;

import java.util.List;

public class SolutionTest {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;

        ListNode list = new Solution().reverseList(one);

        while (list != null) {
            System.out.print(list.val + "-->");
            list = list.next;
        }
    }

}
