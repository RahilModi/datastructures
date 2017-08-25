package com.dsandalgos.LinkedList;

public class LinkedListNode {

    private int data;
    private LinkedListNode next = null;

    public LinkedListNode(){
        this.data = 0;
    }

    public LinkedListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    //overrided method to compare two node's data.
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof LinkedListNode){
            if(this.getData() == ((LinkedListNode) obj).getData()){
                return true;
            }
        }
        return false;
    }

    //overrided to print the node.
    @Override
    public String toString() {
        String str = "Node's data value is : " + this.getData();
        return str;
    }
}
