package com.dsandalgos.LLProblems;

import java.util.Random;

public class FindModularNode {
    //find last n%k==0 th node from the beginning
    public static Node findModularNodeFromBeginning(Node head,int k){
        Node temp = head;
        Node answer=null;
        int length = 0;
        if(k <= 0 ){
            return answer;
        }
        while(temp != null){
            length++;
            if(length%k == 0){
                answer = temp;
            }
            temp = temp.getNext();
        }
        return answer;
    }

    //find first n%k==0 th node from the end
    public static Node findModularNodeFromEnd(Node head,int k){
        Node temp = head;
        Node answer = null;
        if(k<=0){
            return answer;
        }
        for(int i = 0; i<k; i++)
        {
            if(temp != null){
                temp = temp.getNext();
            }else{
                return answer;
            }
        }
        answer = head;
        while (temp != null) {
            temp = temp.getNext();
            answer = answer.getNext();
        }
        return answer;
    }

    //find n/k th node
    public static Node findFractionalNode(Node head,int k){
        Node temp = head;
        Node slwPtr = null;
        while(temp != null){
            for(int i =0 ; i< k;i++){
                if(temp == null){
                    break;
                }
                else{
                    temp = temp.getNext();
                }
            }
            if(temp == null){
                return slwPtr;
            }else{
                if(slwPtr == null){
                    slwPtr = head;
                }else {
                    slwPtr = slwPtr.getNext();
                }
            }
        }
        return slwPtr;
    }

    public static void main(String[] args) {
        LinkedList list =  new LinkedList();

        for(int i = 0 ;i < 15;i++){
            list.insert(new Node(i+1));
        }
        System.out.println(list);
        Node temp = findModularNodeFromBeginning(list.getHead(),5);
        System.out.println(temp);
        temp = findModularNodeFromEnd(list.getHead(),15);
        System.out.println(temp);

        temp = findFractionalNode(list.getHead(),6);
        System.out.println(temp);
    }
}
