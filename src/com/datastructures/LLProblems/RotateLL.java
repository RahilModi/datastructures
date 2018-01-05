package com.datastructures.LLProblems;

public class RotateLL {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next == null || k<=0) return head;
        int length = 1;
        ListNode crt = head;
        while(crt.next != null){
            length++;
            crt = crt.next;
        }
        if(k == length) return head;
        crt.next = head;
        for(int j = length - k % length ; j>1;j--){
            head = head.next;
        }
        crt = head.next;
        head.next = null;

        return crt;
    }
}
