package com.datastructures.LLProblems;
//leetcode 2. Add Two Numbers

public class Add2Numbers {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbersV1(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
        int sum = 0;
        int carry = 0;

        ListNode ans = new ListNode(0);
        ListNode crt = ans;
        while(l1 != null && l2 != null){
            sum = carry + l1.val + l2.val;
            carry = sum / 10;
            sum %= 10;
            crt.next = new ListNode(sum);
            crt = crt.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null){
            if(carry != 0){
                crt.next = addTwoNumbers(l1,new ListNode(carry));
            }else{
                crt.next = l1;
            }
        }
        else if(l2 != null){
            if(carry != 0){
                crt.next = addTwoNumbers(l2,new ListNode(carry));
            }else{
                crt.next = l2;
            }
        }
        else if(carry != 0){
            crt.next = new ListNode(carry);
        }
        return ans;
    }

    public static void main(String[] args) {
        Add2Numbers temp = new Add2Numbers();
        ListNode node = temp.new ListNode(9);
        ListNode node1 = temp.new ListNode(8);
        ListNode node3 = temp.new ListNode(1);
        node.next = node1;
        node1.next = null;
        node3.next = null;
        System.out.println(temp.addTwoNumbers(node, node3));
    }
}
