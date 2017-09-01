package com.dsandalgos.LLProblems;

public class RemoveDuplicatesfromUnorderedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for(int i =0 ;i < 12; i++)
            list.insert(new Node(i+1));
        for(int i =0;i < 9; i++)
            list.insert(new Node(i-1));

        System.out.println(list);
        list.removeDuplicates();
        System.out.println(list);

        for(int i =0 ;i < 2; i++)
            list.insert(new Node(i));
        for(int i =0;i < 5; i++)
            list.insert(new Node(i+1));
        list.insert(new Node(100));
        list.insert(new Node(20));
        list.insert(new Node(1));

        System.out.println(list);
        list.removeDuplicatesUsingSet();
        System.out.println(list);
    }
}
