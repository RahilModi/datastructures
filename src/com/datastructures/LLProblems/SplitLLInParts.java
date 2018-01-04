package com.datastructures.LLProblems;
//leetcode : 725
/*Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".

        The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.

        The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.

        Return a List of ListNode's representing the linked list parts that are formed.

        Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]*/

public class SplitLLInParts {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        int length = 0;
        ListNode temp = root;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        ListNode[] result = new ListNode[k];
        int r = length % k;
        int n = length / k;
        ListNode prev = null;
        ListNode node = root;
        for(int i = 0; i < k && node != null ; i++, r--){
            result[i] = node;
            int count = 0;
            for(int j = 0 ; j < n + (r > 0 ? 1 : 0 );j++){
                prev = node;
                node = node.next;
            }
            prev.next = null;
        }
        return result;
    }
}

