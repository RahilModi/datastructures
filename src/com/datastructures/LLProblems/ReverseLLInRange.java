package com.datastructures.LLProblems;

public class ReverseLLInRange {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode pre = temp;
        for(int i =1; i < m ;i++){
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode next = start.next;
        int dif = n - m;
        while(dif>0){
            ListNode t = next.next;
            start.next = t;
            next.next = pre.next;
            pre.next = next;
            next = t;
            dif--;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        ReverseLLInRange temp = new ReverseLLInRange();
        ListNode node = temp.new ListNode(1);
        ListNode node1 = temp.new ListNode(1);
        ListNode node2 = temp.new ListNode(2);
        ListNode node3 = temp.new ListNode(3);
        ListNode node4 = temp.new ListNode(4);
        ListNode node5 = temp.new ListNode(6);
        node.next= node1;
        node1.next= node2;
        node2.next= node3;
        node3.next= node4;
        node4.next= node5;
        node5.next= null;
        temp.reverseBetween(node, 2,4);
    }
}
