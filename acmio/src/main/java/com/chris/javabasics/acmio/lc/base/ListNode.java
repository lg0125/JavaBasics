package com.chris.javabasics.acmio.lc.base;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val     = val;
        this.next    = null;
    }

    public ListNode(int val, ListNode next) {
        this.val    = val;
        this.next   = next;
    }
}
