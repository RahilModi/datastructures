package com.datastructures.LLProblems;
//leetcode: 160. Intersection of Two Linked Lists
public class IntersectionInLLs {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //very clean code
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB){
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode list1 = headA;
        ListNode list2 = headB;
        int length1 = 0, length2 = 0, diff;
        
        while(list1 != null){
            length1++;
            list1 = list1.next;
        }

        while(list2 != null){
            length2++;
            list2 = list2.next;
        }
        
        if(length1 >= length2){
            diff = length1 - length2;
            list1 = headA;
            list2 = headB;
        }else{
            diff = length2 - length1;
            list1 = headB;
            list2 = headA;
        }
        while(diff!=0){
            list1 = list1.next;
            diff--;
        }
        while(list1 != null && list2 != null){
            if(list1 == list2){
                return list1;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return null;
    }
}
