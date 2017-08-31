package com.dsandalgos.LLProblems;

import com.dsandalgos.CircularLinkedList.CircularLL;
import com.dsandalgos.CircularLinkedList.CircularListNode;

public class GetJosephousPosition {

        //recursive implementation of problem
//    int josephus(int n, int k)
//    {
//        if (n == 1)
//            return 1;
//        else
//    /* The position returned by josephus(n - 1, k) is adjusted because the
//       recursive call josephus(n - 1, k) considers the original position
//       k%n + 1 as position 1 */
//            return (josephus(n - 1, k) + k-1) % n + 1;
//    }

    //create circular linked list of n nodes
    public static CircularListNode getJosephousPos(int n,int m){
        CircularLL circularLL = createCircularLinkedList(n);
        CircularListNode p = circularLL.getTail();
        for(int i = n; i > 1;i--){
            for(int k = 0;k< m-1;k++){
                p = p.getNext();
            }
            p.setNext(p.getNext().getNext());
        }
        return p;
    }
    public static CircularLL createCircularLinkedList(int n){
        CircularLL circle = new CircularLL();
        for(int i = 0;i<n;i++){
            circle.insert(new CircularListNode(i));
        }
        return circle;
    }

    public static void main(String[] args) {
        CircularListNode lastOne = getJosephousPos(14,2);
        System.out.println("Last node is "+lastOne.getData());
    }

}
