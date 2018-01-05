package com.datastructures.LLProblems;

public class ReverseInGroupOfKNodes {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        int count = k;
        ListNode prev=null;
        ListNode next=null;
        ListNode curr = head;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if(count == k) {
            while (current != null && count > 0) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count--;
            }
            if (current != null) {
                ListNode temp = reverseKGroup(current, k);
                head.next = temp;
            }
            return prev;
        }else{
            return head;
        }
    }
}
