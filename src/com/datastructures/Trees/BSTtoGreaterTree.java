package com.datastructures.Trees;

public class BSTtoGreaterTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null)return root;
        convertToGreater(root);
        return root;
    }

    private void convertToGreater(TreeNode root){
        if(root == null) return;
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
    }
    //method 2 use stack push all the right child in stack and update the values. O(n) space complexity

    //method 3 morris inorder traversal o(1) space complexity
}
