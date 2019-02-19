package com.datastructures.LLProblems;

import java.util.Comparator;
import java.util.PriorityQueue;

//leetcode 23: Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
public class MergeKsortedLL {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        PriorityQueue<ListNode> q = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
//                if(o1.val < o2.val) return -1;
//                else if(o1.val == o2.val) return 0;
//                else return 1;
                    return Integer.compare(o1.val,o2.val);
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode n1 = dummy;
        for(ListNode node : lists){
            if(node!=null){
                q.add(node);
            }
        }
        while(!q.isEmpty()){
            n1.next = q.poll();
            n1 = n1.next;
            if(n1!=null){
                q.add(n1);
            }
        }

        return dummy.next;
    }

    public ListNode mergeKListsV1(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1,n2)-> n1.val-n2.val);
        ListNode res = new ListNode(0);
        for(ListNode node : lists){
            if(node !=null)
                pq.add(node);
        }
        ListNode temp = res;
        while (!pq.isEmpty()){
            ListNode crt = pq.poll();
            temp.next = crt;
            if(crt.next != null) pq.offer(crt.next);
            temp = temp.next;
        }
        return res.next;
    }

    public ListNode mergeKListsV2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return sort(lists, 0, lists.length - 1);
    }

    private ListNode sort(ListNode[] lists, int left, int right) {
        if (left >= right) {
            return lists[left];
        }

        int mid = left + (right - left) / 2;
        ListNode node1 = sort(lists, left, mid);
        ListNode node2 = sort(lists, mid + 1, right);
        return merge(node1, node2);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        if (node1.val < node2.val) {
            node1.next = merge(node1.next, node2);
            return node1;
        }

        node2.next = merge(node1, node2.next);
        return node2;
    }

}
