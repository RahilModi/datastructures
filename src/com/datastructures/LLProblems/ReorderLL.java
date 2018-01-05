package com.datastructures.LLProblems;
    /*Given a singly linked list L: L0→L1→…→Ln-1→Ln,
            reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

            You must do this in-place without altering the nodes' values.

            For example,
            Given {1,2,3,4}, reorder it to {1,4,2,3}.*/
public class ReorderLL {
        private class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
        }
        public void reorderList(ListNode head) {
            if(head == null || head.next == null) return;
            ListNode slw=head,fast=head,prev = null;
            ListNode mid;
            while(fast!=null && fast.next!=null){
                prev=slw;
                fast=fast.next.next;
                slw=slw.next;
            }
            if(fast == null) {
                prev.next = null;
                mid = slw;
            }
            else{
                prev = slw;
                mid = slw.next;
                prev.next = null;
            }
            ListNode pre=null;
            ListNode crt = mid;
            while (crt.next!=null){
                ListNode temp = crt.next;
                crt.next=pre;
                pre=crt;
                crt = temp;
            }
            crt.next = pre;
            printList(head);
            printList(crt);
            ListNode l1 = head;
            ListNode preHead = head;
            while(l1 != null && crt!= null){
                ListNode t1 = l1.next;
                l1.next = crt;
                ListNode t2 = crt.next;
                l1 = l1.next;
                l1.next = t1;
                preHead = l1;
                l1 = l1.next;
                crt = t2;
            }

            return;
        }

        public void printList(ListNode node){
            while(node!=null){
                System.out.println(node.val+"->");
                node = node.next;
            }
        }

        public static void main(String[] args) {
            ReorderLL temp = new ReorderLL();
            ListNode node = temp.new ListNode(3);
            ListNode node1 = temp.new ListNode(1);
            ListNode node2 = temp.new ListNode(2);
            ListNode node3 = temp.new ListNode(5);
            ListNode node4 = temp.new ListNode(4);
//            ListNode node5 = temp.new ListNode(6);
            node.next= node1;
            node1.next= node2;
            node2.next= node3;
            node3.next= node4;
            node4.next= null;
//            node5.next= null;
            temp.reorderList(node);
        }
}
