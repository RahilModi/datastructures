package com.datastructures.Trees;

public class InvertBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        return invert(root);
    }

    public TreeNode invert(TreeNode root){
        if(root == null) return root;
        if(root.right == null && root.left == null) return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invert(right);
        root.right = invert(left);
        return root;
    }
}
