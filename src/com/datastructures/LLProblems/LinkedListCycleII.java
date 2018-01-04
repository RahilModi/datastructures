package com.datastructures.LLProblems;

public class LinkedListCycleII {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //return node where cycle begins
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slwPtr = head;
        ListNode fastPtr = head;
        boolean loopExists = false;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slwPtr = slwPtr.next;
            if(fastPtr == slwPtr){
                loopExists = true;
                break;
            }
        }
        if(loopExists){
            slwPtr = head;
            while(slwPtr != fastPtr){
                slwPtr = slwPtr.next;
                fastPtr = fastPtr.next;
            }
            return fastPtr;
        }
        return null;
    }
}
