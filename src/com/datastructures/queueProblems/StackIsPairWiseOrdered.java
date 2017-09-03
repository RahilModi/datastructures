package com.datastructures.queueProblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackIsPairWiseOrdered {
    public static boolean checkPairOrdered(Stack<Integer> stack){

        Queue<Integer> q = new LinkedList<>();
        while(!stack.isEmpty()){
            q.add(stack.pop());
        }
        boolean PairwiseSorted = true;
        if(q.size()%2 != 0){
            stack.add(q.remove());
        }
        while(!q.isEmpty()){
            int n = q.remove();
            if(!q.isEmpty()){
               int m = q.remove();
               if(Math.abs(n-m) != 1){
                   PairwiseSorted = false;
               }
               stack.push(n);
               stack.push(m);
            }
            else{
                stack.push(n);
            }
        }
        return PairwiseSorted;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.add(111);
        s.add(112);
        s.add(1);
        s.add(2);
        s.add(0);
        s.add(1);
        s.add(-2);
        s.add(-1);
        s.add(16);
        s.add(13);
        System.out.println(s + " is pairwise ordered ? "+ checkPairOrdered(s));

    }
}
