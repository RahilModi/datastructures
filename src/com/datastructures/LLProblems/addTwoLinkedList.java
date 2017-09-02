package com.datastructures.LLProblems;

public class addTwoLinkedList {

    //for 3->4->3 + 5->6->4 = 8->0->8
    // numbers are in the reverse order
    // sum is also in the reverse order
    public static Node addTwoNumbers(Node head1, Node head2){
        if(head1 == null){
            return head2;
        }else if(head2 == null){
            return head1;
        }else{
            int carry=0,answer=0;
            Node newHead = new Node(0);
            Node current = newHead;
            while(head1 != null && head2 != null){
                int sum = head1.getData() + head2.getData() + carry;
                carry = sum/10;
                sum = sum%10;
                current.setNext(new Node(sum));
                current = current.getNext();
                head1 = head1.getNext();
                head2 = head2.getNext();
            }
            if(head1 !=null){
                if(carry != 0) {
                    current.setNext(addTwoNumbers(head1,new Node(carry)));
                }else{
                    current.setNext(head1);
                }
            }
            else if(head2 !=null){
                if(carry != 0) {
                    current.setNext(addTwoNumbers(head2,new Node(carry)));
                }else{
                    current.setNext(head2);
                }
            }else if(carry!=0){
                current.setNext(new Node(carry));
            }
            return newHead.getNext();
        }
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insert(new Node(3));
        list1.insert(new Node(4));
        list1.insert(new Node(5));
        list1.insert(new Node(7));
        System.out.println(list1);
        LinkedList list2 = new LinkedList();
        list2.insert(new Node(2));
        list2.insert(new Node(5));
        list2.insert(new Node(6));
        list2.insert(new Node(7));
        System.out.println(list2);

        Node newHead = addTwoNumbers(list1.getHead(), list2.getHead());
        System.out.println(list1.printList(newHead));


    }
}
