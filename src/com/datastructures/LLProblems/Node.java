package com.datastructures.LLProblems;

public class Node {

    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Node){
            if(((Node) obj).getData() == this.getData()){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if(this == null){
            return "";
        }
        StringBuilder str = new StringBuilder("[ "+ this.getData());

        if(this.getNext() != null){
            str.append("-> " + this.getNext().getData());
        }

        str.append(" ]");
        return  str.toString();
    }
}
