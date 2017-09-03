package com.datastructures.queueProblems;

class Node{
    int data;
    Node next;

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
    public String toString() {
        String str = Integer.toString(this.data);
        return str;

    }
}
class stack{

    int length;
    Node top;

    public stack() {
        this.length = 0;
        this.top = null;
    }

    public void push(Node newNode){

        newNode.setNext(this.top);
        this.top = newNode;
        length++;
    }

    public boolean isEmpty(){
        return (length<=0);
    }

    public Node pop(){
        if(isEmpty()){
            System.out.println("queue is empty..");
            return null;
        }
        Node peek = this.top;
        top = this.top.getNext();
        length--;
        return peek;
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
}

public class QueueUsingTwoStack {

    stack stackIn;
    stack stackOut;

    public QueueUsingTwoStack() {
        this.stackIn = new stack();
        this.stackOut = new stack();
    }

    public void enqueue(Node newNode){
        newNode.setNext(this.stackIn.top);
        this.stackIn.push(newNode);
        this.stackIn.top = newNode;
    }

    public Node dequeue(){
        if(stackOut.isEmpty()) {
            moveOneStackToAnother();
        }
        return stackOut.pop();
    }

    public void moveOneStackToAnother(){
        while(!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
    }

    public static void main(String[] args) {

        QueueUsingTwoStack queue = new QueueUsingTwoStack();
        queue.enqueue(new Node(100));
        queue.enqueue(new Node(122));
        queue.enqueue(new Node(21));

        System.out.println(queue.dequeue());

        queue.enqueue(new Node(221));
        System.out.println("Enqueue stack :" + queue.stackIn);
        System.out.println("Dequeue stack : " + queue.stackOut);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(new Node(123));
        System.out.println("Enqueue stack :" + queue.stackIn);
        System.out.println("Dequeue stack : " + queue.stackOut);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());



    }
}
