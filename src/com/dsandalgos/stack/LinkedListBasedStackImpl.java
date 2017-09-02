package com.dsandalgos.stack;

class Node{
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

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    private int data;
    private Node next;

}
public class LinkedListBasedStackImpl {
    protected int length;
    protected Node top;

    LinkedListBasedStackImpl(){
        this.top = null;
        length = 0;
    }

    public boolean isEmpty(){
        return (length<=0);
    }

    public void push(int data){
        if(isEmpty()){
            top = new Node(data);
        }else{
            Node newNode = new Node(data);
            newNode.setNext(top);
            top = newNode;
        }
        length++;
    }

    public Node top() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is empty..");
        }
        Node temp = this.top;
        return temp;
    }

    public void pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is empty..");
        }
        Node temp = this.top;
        top = top.getNext();
        temp.setNext(null);
        length--;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[ ");
        Node temp = this.top;
        while(temp != null){
            str.append(temp.getData());
            str.append(" | ");
            temp = temp.getNext();
        }
        str.append(" ]");
        return str.toString();
    }

    public static void main(String[] args) {
        LinkedListBasedStackImpl llstack = new LinkedListBasedStackImpl();
        llstack.push(1);
        llstack.push(22);
        llstack.push(88);
        llstack.push(2);
        llstack.push(21);
        System.out.println(llstack);
        try{
            System.out.println(llstack.top().getData());
            llstack.pop();
            System.out.println(llstack);
            llstack.pop();
            System.out.println(llstack);
            llstack.pop();
            System.out.println(llstack);
            llstack.pop();
            llstack.push(394);
            System.out.println(llstack);
            llstack.pop();
            llstack.push(203);
            System.out.println(llstack);
            llstack.pop();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



}
