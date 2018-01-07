package com.datastructures.Trees;

public class SecondMinNode {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int min1 = Integer.MAX_VALUE;
    private int min2 = Integer.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {

        if(root == null) return -1;
        helper(root);
        if(min2 != Integer.MAX_VALUE) return min2;
        else return -1;
    }

    public void helper(TreeNode crt){
        if(crt == null) return;
        if(crt.val<min1){
            min2 = min1;
            min1 = crt.val;
        }else if(crt.val < min2 && crt.val != min1){
            min2 = crt.val;
        }
        helper(crt.left);
        helper(crt.right);
    }

    public static void main(String[] args) {
        SecondMinNode temp = new SecondMinNode();
        TreeNode node = temp.new TreeNode(2);
        TreeNode node1 = temp.new TreeNode(2);
        TreeNode node2 = temp.new TreeNode(2);
        TreeNode node3 = temp.new TreeNode(2);
        node.left = node1;
        node1.left = node2;
        node.right = node3;
        System.out.println(temp.findSecondMinimumValue(node));
    }
}
