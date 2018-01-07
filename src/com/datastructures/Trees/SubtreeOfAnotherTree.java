package com.datastructures.Trees;

public class SubtreeOfAnotherTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        if(checkBothSame(s,t)) return true;
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public boolean checkBothSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if ((root1 == null || root2 == null) || (root1.val != root2.val)) {
            return false;
        }
        return checkBothSame(root1.left, root2.left) && checkBothSame(root1.right, root2.right);
    }
}
