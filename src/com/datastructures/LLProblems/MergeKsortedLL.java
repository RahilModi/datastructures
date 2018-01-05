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
}
