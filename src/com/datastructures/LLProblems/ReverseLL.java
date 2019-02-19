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

    public ListNode reverseListV1(ListNode head) {
        /* iterative solution */
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public ListNode reverseListV2(ListNode head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
}
