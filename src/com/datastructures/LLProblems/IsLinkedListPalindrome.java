package com.datastructures.LLProblems;

public class IsLinkedListPalindrome {
    public static boolean islistPalinedrome(LinkedList list) {
        if (list.getHead() == null) {
            System.out.println(list);
            return false;
        } else if (list.getHead().getNext() == null) {
            System.out.println(list);
            return true;
        } else {
            Node middleElement = list.middleElementOftheList();

            Node temp = middleElement.getNext();
            middleElement.setNext(null);
            Node prev = null;
            Node crnt = null;
            while (temp != null && temp.getNext() != null) {
                crnt = temp;
                temp = temp.getNext();
                crnt.setNext(prev);
                prev = crnt;
            }
            if(temp != null){
                temp.setNext(prev);
            }
            System.out.println(list.printList(list.getHead()));
            System.out.println(list.printList(temp));
            Node list2 = temp;
            Node list1 = list.getHead();
            while(list!=null && list2!=null){
                if(list1.equals(list2)) {
                    list1 = list1.getNext();
                    list2 = list2.getNext();
                }else {
                    return false;
                }
            }
            if(list2 != null) {
                return false;
            }else {
                return true;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(new Node(1));
        linkedList.insert(new Node(2));
        linkedList.insert(new Node(3));
        linkedList.insert(new Node(4));
        linkedList.insert(new Node(2));
        linkedList.insert(new Node(1));
        System.out.println(linkedList);
        if(islistPalinedrome(linkedList)){
            System.out.println("Yes given list is palindrome");
        }else{
            System.out.println("No given list is not palindrome");
        }

        LinkedList ll1 = new LinkedList();
        ll1.insert(new Node(1));
        //ll1.insert(new Node(2));
        ll1.insert(new Node(3));
        //ll1.insert(new Node(4));
        ll1.insert(new Node(3));
        ll1.insert(new Node(1));
        System.out.println(ll1);
        if(islistPalinedrome(ll1)){
            System.out.println("Yes given list is palindrome");
        }else{
            System.out.println("No given list is not palindrome");
        }


        LinkedList ll2 = new LinkedList();
        ll2.insert(new Node(1));
        //ll1.insert(new Node(2));
//        ll1.insert(new Node(3));
//        //ll1.insert(new Node(4));
//        ll1.insert(new Node(3));
        ll2.insert(new Node(1));
        System.out.println(ll2);
        if(islistPalinedrome(ll2)){
            System.out.println("Yes given list is palindrome");
        }else{
            System.out.println("No given list is not palindrome");
        }

        if(islistPalinedrome(new LinkedList())){
            System.out.println("Yes given list is palindrome");
        }else{
            System.out.println("No given list is not palindrome");
        }
        LinkedList ll3 = new LinkedList();
        ll3.insert(new Node(20));
        if(islistPalinedrome(ll3)){
            System.out.println("Yes given list is palindrome");
        }else{
            System.out.println("No given list is not palindrome");
        }
    }
}
