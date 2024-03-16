package com.chris.javabasics.acmio.lc;

import com.chris.javabasics.acmio.lc.base.ListNode;

public class LC25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;

        ListNode a, b;
        a = b = head;
        for(int i = 0; i < k; ++i) {
            if(b == null) return head;
            b = b.next;
        }

        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    private static ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;

        while(cur != b) {
            nxt = cur.next;

            cur.next = pre;

            pre = cur;
            cur = nxt;
        }

        return pre;
    }
}
