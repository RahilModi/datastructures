package com.datastructures.LLProblems;

public class RemoveNthFromEnd {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode mainPtr = head, refPtr = head, prev=null;
        int difference = 1;
        while(difference < n && mainPtr.next != null){
            mainPtr = mainPtr.next;
            difference++;
        }
        while(mainPtr.next!=null){
            prev = refPtr;
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }

        if(prev != null) prev.next = refPtr.next;
        else{
            return refPtr.next;
        }
        return head;
    }
}
