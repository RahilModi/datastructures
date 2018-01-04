package com.datastructures.LLProblems;
/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

        You may assume the two numbers do not contain any leading zero, except the number 0 itself.*/

//leetcode 445 : Add 2 Numbers II

public class Add2NumbersII {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    int carry = 0, sum = 0;
    ListNode result = null;
    ListNode cur;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        int length1 = 0;
        int length2 = 0;
        ListNode list1 = l1;
        while(list1 != null){
            length1++;
            list1 = list1.next;
        }

        ListNode list2 = l2;
        while(list2 != null){
            length2++;
            list2 = list2.next;
        }

        int diff = 0;
        if(length1 > length2){
            diff = length1 - length2;
            list1 = l1;
            list2 = l2;
        }else{
            diff = length2 - length1;
            list1 = l2;
            list2 = l1;
        }
        if(diff == 0){
            addSameSizeList(list1, list2);
        }
        else {
            ListNode temp = list1;
            while (diff >= 0) {
                cur = temp;
                temp = temp.next;
                diff--;
            }

            addSameSizeList(cur, list2);
            propogateCarry(list1);
        }
        if(carry > 0){
            formResult(carry);
        }
        return result;
    }

    public void propogateCarry(ListNode node){
        if(node != cur){
            propogateCarry(node.next);
            sum = carry + node.val;
            carry = sum / 10;
            sum %= 10;

            formResult(sum);
        }
    }

    public void formResult(int val){
        ListNode node = new ListNode(val);
        node.next = result;
        result = node;
    }

    public void addSameSizeList(ListNode n1, ListNode n2){
        if(n1 == null) return;

        addSameSizeList(n1.next,n2.next);

        sum = n1.val + n2.val + carry;
        carry = sum / 10;
        sum %= 10;
        formResult(sum);
    }

    //method 2- to solve the problem using stacks

    public static void main(String[] args) {
        Add2NumbersII temp = new Add2NumbersII();
        ListNode node = temp.new ListNode(1);
        ListNode node1 = temp.new ListNode(2);
        ListNode node2 = temp.new ListNode(3);
        ListNode node3 = temp.new ListNode(4);
        ListNode node4 = temp.new ListNode(4);
        ListNode node5 = temp.new ListNode(6);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        node4.next = node5;
        node5.next = null;

        temp.addTwoNumbers(node, node4);
    }
}
