package com.datastructures.LLProblems;

public class exchangeAdjacentelements {

    //swapping data
    public static void exchangeAdjacentElements(Node head){
        Node temp = head;
        while(temp != null && temp.getNext() != null){
            int k = temp.getData();
            temp.setData(temp.getNext().getData());
            temp.getNext().setData(k);
            temp = temp.getNext().getNext();
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(new Node(11));
        list.insert(new Node(12));
        list.insert(new Node(13));
        list.insert(new Node(14));
      //  list.insert(new Node(15));
        list.insert(new Node(16));
        System.out.println(list);
        exchangeAdjacentElements(list.getHead());
        System.out.println(list);
    }
}
