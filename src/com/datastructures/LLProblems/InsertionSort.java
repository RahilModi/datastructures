package com.datastructures.LLProblems;

public class InsertionSort {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode helper =  new ListNode(0);
        ListNode pre =  helper;
        ListNode crt = head;
        ListNode next =  null;
        while(crt != null){
            next = crt.next;
            while(pre.next != null && pre.next.val < crt.val){
                pre = pre.next;
            }
            crt.next = pre.next;
            pre.next = crt;
            pre=helper;
            crt = next;
        }

        return helper.next;
    }

    public static void main(String[] args) {
        InsertionSort temp = new InsertionSort();
        ListNode node = temp.new ListNode(3);
        ListNode node1 = temp.new ListNode(1);
        ListNode node2 = temp.new ListNode(2);
        ListNode node3 = temp.new ListNode(5);
        ListNode node4 = temp.new ListNode(4);
        ListNode node5 = temp.new ListNode(6);
        node.next= node1;
        node1.next= node2;
        node2.next= node3;
        node3.next= node4;
        node4.next= node5;
        node5.next= null;
        temp.insertionSortList(node);
    }
}
