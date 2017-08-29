package com.dsandalgos.LLProblems;

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }


    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
    public synchronized void insert(Node newNode){
        if(head == null){
            head = newNode;
        }else{
            Node temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    public synchronized void remove(Node node){
        if(head == null){
            System.out.println("List is empty...");
        }else{
            Node temp = head;
            Node prev = head;
            while(temp != null && !temp.equals(node)) {
                prev = temp;
                temp = temp.getNext();
            }

            if(temp == null){
                System.out.println("node is not present...");
            }else if(temp.equals(head)){
                head = temp.getNext();
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
        while(temp != null){
            strBld.append(temp.getData() + " -> ");
            temp = temp.getNext();
        }
        strBld.append(" ]");
        return strBld.toString();
    }

}
