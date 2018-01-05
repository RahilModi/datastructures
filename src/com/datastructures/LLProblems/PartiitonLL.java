package com.datastructures.LLProblems;

public class PartiitonLL {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //very clean code;
    public ListNode partition1(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);//to know start of each list
        ListNode dummy2 = new ListNode(0);

        ListNode n1 = dummy1;
        ListNode n2 = dummy2;

            while(head !=null)

        {
            if (head.val < x) {
                n1.next = head;
                n1 = n1.next;
            } else {
                n2.next = head;
                n2 = n2.next;
            }
            head = head.next;
        }

        n2.next =null;
        n1.next =dummy2.next;
            return dummy1.next;
    }
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode newHead = null;
        ListNode temp = head;
        ListNode nextNode = null;
        ListNode crt = null;
        ListNode pivot = null, root = null;
        while(temp != null){
            nextNode =  temp.next;
            if(temp.val < x){
                if(newHead == null) {
                    newHead = temp;
//                    newHead.next = null;
                    crt = newHead;
                }else{
                    crt.next = temp;
//                    temp.next = null;
                    crt = crt.next;
                }
            }else{
                if(pivot == null){
                    pivot = temp;
                    root = pivot;
                }else{
                    pivot.next = temp;
//                    temp.next = null;
                    pivot = pivot.next;
                }
            }
            temp.next = null;
            temp = nextNode;
        }
        if(crt != null){
            crt.next = root;
        }else{
            newHead = root;
        }
        return newHead;
    }
}
