package com.datastructures.LLProblems;
//leetcode : 206 : Reverse Linked List
public class ReverseLL {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode node = head;
        ListNode temp = null;
        while(node.next != null){
            temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        node.next = prev;
        return node;
    }
}
