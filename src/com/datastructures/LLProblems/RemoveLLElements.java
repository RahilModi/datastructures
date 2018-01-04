package com.datastructures.LLProblems;
/*Remove all elements from a linked list of integers that have value val.

        Example
        Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
        Return: 1 --> 2 --> 3 --> 4 --> 5*/
//leetcode problem : 203
public class RemoveLLElements {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        ListNode prev = head;
        while(node != null){
            if(node.val == val){
                if(node == head){
                    head = head.next;
                }else{
                    prev.next = node.next;
                }
            }else{
                prev = node;
            }
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveLLElements temp = new RemoveLLElements();
        ListNode node = temp.new ListNode(1);
        ListNode node1 = temp.new ListNode(2);
        ListNode node2 = temp.new ListNode(2);
        ListNode node3 = temp.new ListNode(1);
        ListNode node4 = temp.new ListNode(1);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        temp.removeElements(node,1);
    }
}
