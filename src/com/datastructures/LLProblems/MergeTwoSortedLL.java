package com.datastructures.LLProblems;

public class MergeTwoSortedLL {

    //using recursion
    public static Node mergeTwoSortedList(Node head1,Node head2){
        if(head1 == null){
            return head2;
        }else if(head2 == null){
            return head1;
        }else{
            Node newHead = null;
            Node temp = null;
            if(head1.getData() < head2.getData()){
                newHead = head1;
                temp = mergeTwoSortedList(head1.getNext(),head2);
                newHead.setNext(temp);
            }else {
                newHead = head2;
                temp = mergeTwoSortedList(head1, head2.getNext());
                newHead.setNext(temp);
            }
            return newHead;
        }
    }

    public static String printList(Node head){
        Node temp = head;
        StringBuilder str = new StringBuilder("[ ");
        while(temp != null){
            str.append(temp.getData());
            temp = temp.getNext();
            str.append("->");
        }
        str.append(" ]");
        return str.toString();
    }

    //Merge sorted list w/o recursion
    public static Node mergeTwoSortedListWORecursion(Node head1,Node head2){
            Node newHead = null;
            if(head1 != null && head2 != null) {
                if (head1.getData() < head2.getData()) {
                    newHead = head1;
                    head1 = head1.getNext();
                } else {
                    newHead = head2;
                    head2 = head2.getNext();
                }
            }
            Node temp = newHead;
            while(head1!=null && head2!= null) {
                if (head1.getData() < head2.getData()) {
                        temp.setNext(head1);
                        temp = temp.getNext();
                        head1 = head1.getNext();
                } else{
                        temp.setNext(head2);
                        temp = temp.getNext();
                        head2 = head2.getNext();
                }
            }
            if(head1 != null){
                if(newHead == null){
                    newHead = head1;
                }else {
                    temp.setNext(head1);
                }
            }else if(head2 != null){
                if(newHead == null){
                    newHead = head2;
                }else {
                    temp.setNext(head2);
                }
            }
        return newHead;
    }
    public static void main(String[] args) {
        SortedLinkedListImp sortedList = new SortedLinkedListImp();
        sortedList.insertBySort(new Node(1001));
        sortedList.insertBySort(new Node(120));
        sortedList.insertBySort(new Node(1203));
        sortedList.insertBySort(new Node(10));
        System.out.println(sortedList);

        SortedLinkedListImp sortedList1 = new SortedLinkedListImp();
        sortedList1.insertBySort(new Node(101));
        sortedList1.insertBySort(new Node(1227));
        sortedList1.insertBySort(new Node(12));
        sortedList1.insertBySort(new Node(10));
        sortedList1.insertBySort(new Node(45));
        System.out.println(sortedList1);
        Node newList = mergeTwoSortedListWORecursion(sortedList.getHead(),sortedList1.getHead());
        System.out.println(printList(newList));
    }
}
