package com.datastructures.LLProblems;

public class SortedLLToBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return toBST(head, null);
    }

    private TreeNode toBST(ListNode start, ListNode end){
        if(start == end) return null;
        ListNode fast = start;
        ListNode slow = start;
        while(fast != end && fast.next != end){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(start,slow);
        root.right = toBST(slow.next,end);
        return root;
    }
}
