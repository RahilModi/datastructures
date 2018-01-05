package com.datastructures.LLProblems;

public class RemoveDuplicatesFromSortedLL {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next == null) return head;
        ListNode crt =head;
        ListNode pre = null;
        while(crt != null && crt.next !=null){
            if(crt.val != crt.next.val){
                pre = crt;
            }else{
                while(crt.next !=null && crt.val == crt.next.val){
                    crt = crt.next;
                }
                if(pre != null){
                    pre.next = crt.next;
                }else{
                    head = crt.next;
                }
            }
            crt = crt.next;
        }
        return head;
    }
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedLL temp = new RemoveDuplicatesFromSortedLL();
        ListNode node = temp.new ListNode(1);
        ListNode node1 = temp.new ListNode(1);
        ListNode node2 = temp.new ListNode(2);
        ListNode node3 = temp.new ListNode(3);
//        ListNode node4 = temp.new ListNode(4);
//            ListNode node5 = temp.new ListNode(6);
        node.next= node1;
        node1.next= node2;
        node2.next= node3;
        node3.next= null;
//        node4.next= null;
//            node5.next= null;
        temp.deleteDuplicates(node);
    }
}
