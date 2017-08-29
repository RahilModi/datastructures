package com.dsandalgos.LLProblems;

class cyclicListImp{

    private Node head = null;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public synchronized int calLength(){
        if(!findLoopExistsUsingFloyd()) {
            Node temp = head;
            int length = 0;
            while (temp != null) {
                length++;
                temp = temp.getNext();
            }
            return length;
        }else{
            return Integer.MIN_VALUE;
        }
    }

    public synchronized void insert(Node newNode){
        if(!findLoopExistsUsingFloyd()) {
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                }
                temp.setNext(newNode);
            }
        }else{
            System.out.println("Cyclic loop...");
        }
    }

    public synchronized void remove(Node node){

        if(!findLoopExistsUsingFloyd()) {
            if (head == null) {
                System.out.println("List is empty...");
            } else {
                Node temp = head;
                Node prev = head;
                while (temp != null && !temp.equals(node)) {
                    prev = temp;
                    temp = temp.getNext();
                }

                if (temp == null) {
                    System.out.println("node is not present...");
                } else if (temp.equals(head)) {
                    head = temp.getNext();
                } else {
                    prev.setNext(temp.getNext());
                    temp.setNext(null);
                }
            }
        }else{
            System.out.println("First remove cyclicity...");
        }
    }

    public void makeCyclicList(Node newNode, int pos){
        if(findLoopExistsUsingFloyd()){
            System.out.println("List is already cyclic....");
        }else if(calLength() == 0){
            System.out.println("list is empty....So..new element will be head...");
            head = newNode;
        }else if(pos > calLength()){
            System.out.println("Will not make cyclic list...bcz position should be less than to size of the list...");
            System.out.println("Node is added at the end");
            insert(newNode);
        }else if(pos == calLength()){
            Node temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setNext(newNode);
        }else{
            Node temp = head;
            Node samePointingNode = null;
            while(pos != 0){
                temp = temp.getNext();
                pos--;
            }
            samePointingNode = temp;
            insertNewNodeMakeCyclic(newNode,samePointingNode);
        }
    }

    private void insertNewNodeMakeCyclic(Node newNode, Node samePointingNode){
        if(head == null){
            head = newNode;
        }else{
            Node temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setNext(samePointingNode);
        }
    }
    public boolean findLoopExistsUsingFloyd() {
        Node slwPtr = head;
        Node fastPtr = head;
        if (head == null) {
            System.out.println("List is empty");
        } else {

            while (fastPtr != null && fastPtr.getNext() != null) {
                fastPtr = fastPtr.getNext().getNext();
                slwPtr = slwPtr.getNext();
                if(fastPtr == slwPtr){
                    return true;
                }
            }
        }
        return false;
    }

    public Node findBeginningOfLoop(){

        Node slwPtr = head;
        Node fastPtr = head;
        boolean loopExists = false;
        if (head == null) {
            System.out.println("List is empty");
        } else {

            while (fastPtr != null && fastPtr.getNext() != null) {
                fastPtr = fastPtr.getNext().getNext();
                slwPtr = slwPtr.getNext();
                if(fastPtr == slwPtr){
                    loopExists = true;
                    break;
                }
            }
            if(loopExists){
                slwPtr = head;
                while(slwPtr != fastPtr){
                    slwPtr = slwPtr.getNext();
                    fastPtr = fastPtr.getNext();
                }
                return fastPtr;
            }
        }
        return null;
    }

    public int findLengthOfLoop(){
        Node slwPtr = head;
        Node fastPtr = head;
        boolean loopExists = false;
        if (head == null) {
            System.out.println("List is empty");
        } else {

            while (fastPtr != null && fastPtr.getNext() != null) {
                fastPtr = fastPtr.getNext().getNext();
                slwPtr = slwPtr.getNext();
                if(fastPtr == slwPtr){
                    loopExists = true;
                    break;
                }
            }
            int length = 0;
            if(loopExists){
                do{
                    slwPtr = slwPtr.getNext();
                    length++;
                }while(slwPtr != fastPtr);
                return length;
            }
        }
        return 0;
    }

    public void removeCyclicity(){
        if(findLoopExistsUsingFloyd()) {
            Node temp = findBeginningOfLoop();
            Node t = head;
            while (t != temp) {
                t = t.getNext();
            }
            while (t.getNext() != temp) {
                t = t.getNext();
            }
            t.setNext(null);
        }else{
            System.out.println("list is acyclic...");
        }
    }

    @Override
    public String toString() {
        if(!findLoopExistsUsingFloyd()) {
            StringBuilder strBld = new StringBuilder("[ ");
            Node temp = getHead();
            while (temp != null) {
                strBld.append(temp.getData() + " -> ");
                temp = temp.getNext();
            }
            strBld.append(" ]");
            return strBld.toString();
        }else{
            Node temp = findBeginningOfLoop();
            Node t = head;
            StringBuilder str = new StringBuilder("[ ");
            while(t != temp){
                str.append(t.getData());
                str.append(" -> ");
                t = t.getNext();
            }
            str.append(t.getData() + " -> ");
            t =t.getNext();
            while(t != temp){
                str.append(t.getData() +" -> ");
                t= t.getNext();
            }
            str.append(t.getData() + " ]");
            return str.toString();
        }
    }
}

public class cyclicListTest {
    public static void main(String[] args) {
        cyclicListImp cyclicList = new cyclicListImp();

        cyclicList.insert(new Node(100));
        cyclicList.insert(new Node(103));
        cyclicList.insert(new Node(102));
        cyclicList.insert(new Node(101));
        System.out.println(cyclicList);

        cyclicList.makeCyclicList(new Node(1022),1);

        System.out.println(cyclicList);

        cyclicListImp list1 = new cyclicListImp();
        list1.makeCyclicList(new Node(1000),3);
        System.out.println(list1);
        list1.makeCyclicList(new Node(1001),1);
        System.out.println(list1);

        Node temp = cyclicList.findBeginningOfLoop();
        System.out.println(temp);

        //cyclicList.removeCyclicity();
        System.out.println(cyclicList.findLengthOfLoop());

        list1.removeCyclicity();
        //System.out.println(list1.findLengthOfLoop());

        cyclicList.insert(new Node(10022));
        System.out.println(cyclicList);
    }



}
