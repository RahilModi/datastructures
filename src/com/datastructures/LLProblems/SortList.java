package com.datastructures.LLProblems;

public class SortList {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slw = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            prev = slw;
            slw = slw.next;
            fast = fast.next.next;
        }

        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slw);

        return merge(l1,l2);
    }

    public ListNode merge(ListNode list1, ListNode list2){
        ListNode newHead = new ListNode(0);
        ListNode prev= newHead;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                prev.next = list1;
                list1 = list1.next;
            }else{
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        if(list1 != null){
            prev.next = list1;
        }
        if(list2 != null){
            prev.next = list2;
        }
        return newHead.next;
    }

    public ListNode sortListV1(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slw = head, fast = head, prev = null;
        while(fast != null && fast.next != null) {
            prev = slw;
            slw = slw.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return mergeV1(sortListV1(head),sortListV1(slw));
    }

    private ListNode mergeV1(ListNode node1, ListNode node2){
        if(node1 == null) return node2;
        if(node2 == null) return node1;
        if(node1.val < node2.val){
            node1.next = mergeV1(node1.next, node2);
            return node1;
        }

        node2.next = mergeV1(node1, node2.next);
        return node2;
    }

    public static void main(String[] args) {
        SortList temp = new SortList();
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
        temp.sortList(node);

    }

}
