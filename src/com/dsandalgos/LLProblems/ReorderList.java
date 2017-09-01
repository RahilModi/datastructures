package com.dsandalgos.LLProblems;

public class ReorderList {

    public static Node reorderList(LinkedList list){
        Node middle = list.middleElementOftheList();
        if(middle == null){
            System.out.println("length of the list is not sufficient to reorder");
            return list.getHead();
        }else{
            Node temp = middle.getNext();
            middle.setNext(null);
            Node prev = null;
            Node next;
            while(temp.getNext() != null){
                next = temp.getNext();
                temp.setNext(prev);
                prev = temp;
                temp = next;
            }
            temp.setNext(prev);
            System.out.println(list.printList(temp));
            System.out.println(list);
            Node list1 = list.getHead();
            Node list2 = temp;
            Node current = null;
            Node newHead = null;
            while(list1 != null && list2!=null){
                if(newHead == null){
                    newHead = list1;
                    list1 = list1.getNext();
                    newHead.setNext(list2);
                    list2 = list2.getNext();
                    current = newHead.getNext();
                }else {
                    current.setNext(list1);
                    list1 = list1.getNext();
                    current = current.getNext();
                    current.setNext(list2);
                    list2 = list2.getNext();
                    current = current.getNext();
                }
            }
            if(list1 != null){
                current.setNext(list1);
            }
            return newHead;
        }

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for(int i = 0 ;i < 121;i++){
            list.insert(new Node(i+1));
        }

        Node newN = reorderList(list);
        System.out.println(list.printList(newN));
    }
}
