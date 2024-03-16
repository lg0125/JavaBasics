package com.chris.javabasics.acmio.lc;

import com.chris.javabasics.acmio.lc.base.ListNode;

public class LC21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy, p1 = l1, p2 = l2;

        while(p1 != null && p2 != null) {
            if(p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }

        if(p1 != null) p.next = p1;
        if(p2 != null) p.next = p2;

        return dummy.next;
    }
}
