package com.chris.javabasics.acmio.lc;

import com.chris.javabasics.acmio.lc.base.TreeNode;

public class LC236 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p, q);
    }

    private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;

        TreeNode left   = lca(root.left, p, q);
        TreeNode right  = lca(root.right, p, q);

        // case 1
        if(left != null && right != null)
            return root;
        // case 2
        if(left == null && right == null)
            return null;
        // case 3
        return left == null ? right : left;
    }
}
