package com.chris.javabasics.acmio.lc.base;

public class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode() {}
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
