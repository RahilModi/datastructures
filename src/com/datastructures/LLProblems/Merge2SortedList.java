package com.datastructures.LLProblems;

public class Merge2SortedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = null;
        if(l1 == null && l2 == null) return newList;
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
        else{
            newList = new ListNode(0);
        }
        ListNode temp = newList;
        while(l1 != null && l2 != null){
            if(l1.val >= l2.val){
                temp.next = l2;
                l2 = l2.next;
            }else{
                temp.next =  l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return newList;
    }

    //method 2 using recursion
    public ListNode mergeTwoSortedList(ListNode head1,ListNode head2){
        if(head1 == null && head2 == null) return null;
        if(head1 == null){
            return head2;
        }else if(head2 == null){
            return head1;
        }else{
            ListNode newHead = null;
            if(head1.val < head2.val){
                newHead = head1;
                newHead.next = mergeTwoSortedList(head1.next,head2);
            }else {
                newHead = head2;
                newHead.next = mergeTwoSortedList(head1, head2.next);
            }
            return newHead;
        }
    }

    public static void main(String[] args) {
        Merge2SortedList temp = new Merge2SortedList();
        ListNode node = temp.new ListNode(1);
        ListNode node1 = temp.new ListNode(2);
        ListNode node2 = temp.new ListNode(3);
        ListNode node3 = temp.new ListNode(1);
        ListNode node4 = temp.new ListNode(2);
        node.next = node1;
        node1.next = node2;
        node2.next = null;
        node3.next = node4;
        node4.next = null;
        System.out.println(temp.mergeTwoLists(node, node3));
    }
}
