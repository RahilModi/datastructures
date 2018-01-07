package com.datastructures.Trees;
//leetcode 687

public class longestUnivaluePath {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    private  int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return max;
        countUnivaluePath(root);
        return max;
    }

    private  int countUnivaluePath(TreeNode crt){
        if(crt == null) return 0;
        int crtValue = crt.val;
        TreeNode left = crt.left;
        TreeNode right = crt.right;
        int leftCount = countUnivaluePath(left);
        int rightCount = countUnivaluePath(right);
        int leftPath = (left!= null && left.val == crtValue)?leftCount+1:0;
        int rightPath = (right!= null && right.val == crtValue)?rightCount+1:0;
        max = Math.max(max,leftPath+rightPath);
        return Math.max(leftPath,rightPath);
    }

    public static void main(String[] args) {
        longestUnivaluePath temp = new longestUnivaluePath();
        TreeNode root = temp.new TreeNode(5);
        root.left = temp.new TreeNode(5);
        root.right = temp.new TreeNode(5);
        root.right.right = temp.new TreeNode(5);
        temp.longestUnivaluePath(root);
    }
}
