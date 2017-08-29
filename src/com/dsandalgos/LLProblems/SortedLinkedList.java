package com.dsandalgos.LLProblems;

class SortedLinkedListImp{

    private Node head; //using Node class

    public SortedLinkedListImp() {
        this.head = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    //insert in ascending sort
    public void insertBySort(Node newNode) {
        Node temp = head;
        if (temp == null) {
            System.out.println("List is empty...So given node would be head...");
            head = newNode;
        } else {
            Node prev = null;
            while (temp != null && temp.getData() < newNode.getData()) {
                prev = temp;
                temp = temp.getNext();
            }
            if(prev == null){
                newNode.setNext(head);
                head = newNode;
            }else {
                newNode.setNext(temp);
                prev.setNext(newNode);
            }
        }
    }

    //works for both ascending and descending sorted list..
    public void removeSortedNode(Node node){
        Node temp = head;
        if(head == null){
            System.out.println("List is empty...");
        }else{
            Node prev = null;
            while(temp != null && !temp.equals(node)){
                prev = temp;
                temp = temp.getNext();
            }
            if(prev == null){
                head = temp.getNext();
            }else if(temp == null){
                System.out.println("Sorry...given node is not in the list.." + node);
            }else{
                prev.setNext(temp.getNext());
                temp.setNext(null);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder strBld = new StringBuilder("[ ");
        Node temp = getHead();
        while (temp != null) {
            strBld.append(temp.getData() + " -> ");
            temp = temp.getNext();
        }
        strBld.append(" ]");
        return strBld.toString();
    }


    public void insertByDescendingSort(Node newNode){
        Node temp = head;
        if(temp == null){
            System.out.println("List is empty...So given node would be head...");
            head = newNode;
        }else{
            Node prev = null;
            while(temp != null && temp.getData() > newNode.getData()){
                prev = temp;
                temp = temp.getNext();
            }
            if(prev == null){
                newNode.setNext(head);
                head = newNode;
            }else{
                newNode.setNext(temp);
                prev.setNext(newNode);
            }
        }
    }


}

public class SortedLinkedList {

    public static void main(String[] args) {
        SortedLinkedListImp sortedList = new SortedLinkedListImp();
        sortedList.insertBySort(new Node(100));
        System.out.println(sortedList);
        sortedList.insertBySort(new Node(101));
        sortedList.insertBySort(new Node(90));
        sortedList.insertBySort(new Node(99));
        System.out.println(sortedList);
        sortedList.removeSortedNode(new Node(90));
        System.out.println(sortedList);


        SortedLinkedListImp descendingSortedList = new SortedLinkedListImp();
        descendingSortedList.insertByDescendingSort(new Node(100));
        System.out.println(descendingSortedList);
        descendingSortedList.insertByDescendingSort(new Node(101));
        descendingSortedList.insertByDescendingSort(new Node(90));
        descendingSortedList.insertByDescendingSort(new Node(99));
        System.out.println(descendingSortedList);
        descendingSortedList.removeSortedNode(new Node(101));
        System.out.println(descendingSortedList);

    }

}
