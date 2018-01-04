package com.datastructures.LLProblems;

//Definition for singly-linked list.

public class RemoveDuplicatesFromSorted {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        ListNode prev = head;
        while(temp != null && temp.next != null){
            temp = temp.next;
            while(temp != null && temp.val == prev.val){
                temp = temp.next;
                prev.next = temp;
            }
            prev = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSorted temp = new RemoveDuplicatesFromSorted();
        ListNode node = temp.new ListNode(1);
        ListNode node1 = temp.new ListNode(1);
        ListNode node2 = temp.new ListNode(1);
        ListNode node3 = temp.new ListNode(3);
        ListNode node4 = temp.new ListNode(4);
        ListNode node5 = temp.new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        temp.deleteDuplicates(node);
    }
}
