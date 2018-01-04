package com.datastructures.LLProblems;

// Definition for singly-linked list.

public class DetectCycleInLL {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    //using floyd method O(1) space.
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slwPtr = head;
        ListNode fastPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slwPtr = slwPtr.next;
            if(fastPtr == slwPtr) return true;
        }
        return false;
    }

    //2nd solution
    public boolean hasCycle1(ListNode head) {
        while(head != null && head.next != null){
            if(head.val == Integer.MIN_VALUE) return true;
            head.val = Integer.MIN_VALUE;
            head = head.next;
        }
        return false;
    }
}
