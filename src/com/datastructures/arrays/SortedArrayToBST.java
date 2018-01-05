package com.datastructures.arrays;

public class SortedArrayToBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return toBST(nums,0,nums.length-1);
    }
    private TreeNode toBST(int[] nums, int start, int end){
        if(start > end) return null;
        int mid = start + (end -start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums,start,mid-1);
        root.right = toBST(nums,mid+1,end);
        return root;
    }

    public static void main(String[] args) {
        SortedArrayToBST temp =  new SortedArrayToBST();
        temp.sortedArrayToBST(new int[]{1,2,3,4,5});
    }
}
