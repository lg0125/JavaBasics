package com.chris.javabasics.acmio.lc;

import com.chris.javabasics.acmio.lc.base.ListNode;

public class LC141 {
    public static boolean hasCycle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
