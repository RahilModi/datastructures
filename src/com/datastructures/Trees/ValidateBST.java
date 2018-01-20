package com.datastructures.Trees;

public class ValidateBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left != null && root.val < findMax(root.left)) return false;
        if(root.left != null && root.val > findMin(root.right)) return false;
        if(!isValidBST(root.left) || !isValidBST(root.right)) return false;
        return true;
    }


    public int findMax(TreeNode crt){
        int max = Integer.MIN_VALUE;
        if(crt == null) return max;
        int leftMax, rightMax;
        leftMax = findMax(crt.left);
        rightMax = findMax(crt.right);
        int temp = leftMax > rightMax ? leftMax : rightMax;
        if(temp > max) max= temp;
        if(crt.val > max) max = crt.val;
        return max;
    }


    public int findMin(TreeNode crt){
        int min = Integer.MAX_VALUE;
        if(crt == null) return min;
        int leftMin,rightMin;
        leftMin = findMin(crt.left);
        rightMin = findMin(crt.right);
        int temp = leftMin > rightMin ? rightMin : leftMin;
        if(temp < min) min = temp;
        if(crt.val < min) min = crt.val;
        return min;
    }


    //methiod2 better prformance and clean code
    public boolean isValidBSTWithBound(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        return isValidWithBound(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidWithBound(TreeNode root, double low, double high){
        if(root == null) return true;
        if(root.val <= low || root.val >= high) return false;
        return isValidWithBound(root.left, low, root.val) && isValidWithBound(root.right, root.val, high);
    }
}
