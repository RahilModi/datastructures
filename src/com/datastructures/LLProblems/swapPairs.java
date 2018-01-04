package com.datastructures.LLProblems;

public class swapPairs {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //method 2 - recursive
    public ListNode swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        head.next = swapPairs(nextNode.next);
        nextNode.next = head;
        return nextNode;
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode prev = head;
        ListNode crt = head.next;
        ListNode node = crt;
        while(true){
            ListNode next = crt.next;
            crt.next = prev;
            if(next == null || next.next == null){
                prev.next = next;
                break;
            }
            prev.next = next.next;
            prev = next;
            crt = prev.next;
        }
        return node;
    }

    public static void main(String[] args) {

        swapPairs temp = new swapPairs();
        ListNode node = temp.new ListNode(1);
        ListNode node1 = temp.new ListNode(2);
        ListNode node2 = temp.new ListNode(3);
        ListNode node3 = temp.new ListNode(4);
        ListNode node4 = temp.new ListNode(4);
        ListNode node5 = temp.new ListNode(6);
        node.next= node1;
        node1.next= node2;
        node2.next= node3;
        node3.next= node4;
        node4.next= node5;
        node5.next= null;
        temp.swapPairs(node);

    }
}
