package com.datastructures.LLProblems;
//leetcode 234: Palindrome Linked List
public class IsPalindromeLL {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }



/*  METHOD 1 (Use a Stack)
        A simple solution is to use a stack of list nodes. This mainly involves three steps.
        1) Traverse the given list from head to tail and push every visited node to stack.
        2) Traverse the list again. For every visited node, pop a node from stack and compare data of popped node with currently visited node.
        3) If all nodes matched, then return true, else false.

    Time complexity of above method is O(n), but it requires O(n) extra space. Following methods solve this with constant extra space.*/
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode slwPtr = head;
        ListNode fastPtr = head;
        ListNode prevSlowPtr = null;
        while(fastPtr!=null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            prevSlowPtr = slwPtr;
            slwPtr = slwPtr.next;
        }
        ListNode midNode=null;
        if(fastPtr != null){
            midNode = slwPtr;
            slwPtr = slwPtr.next;
        }
        prevSlowPtr.next = null;
        ListNode temp = null;
        ListNode prev = null;
        ListNode node = slwPtr;
        while(node != null){
            temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        ListNode secondHalf = prev;
        ListNode firstHalf = head;
        while(secondHalf != null && firstHalf != null){
            if(secondHalf.val != firstHalf.val){
                return false;
            }
            secondHalf = secondHalf.next;
            firstHalf = firstHalf.next;
        }
        return true;
    }
    public static void main(String[] args) {
        IsPalindromeLL temp = new IsPalindromeLL();
        ListNode node = temp.new ListNode(1);
        ListNode node1 = temp.new ListNode(2);
        ListNode node2 = temp.new ListNode(3);
        ListNode node3 = temp.new ListNode(2);
        ListNode node4 = temp.new ListNode(1);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        System.out.println(temp.isPalindrome(node));

    }
}
