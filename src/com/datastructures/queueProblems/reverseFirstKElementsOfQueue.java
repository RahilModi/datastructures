package com.datastructures.queueProblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reverseFirstKElementsOfQueue {

    public static void reverseFirstKElements(Queue<Integer> queue, int k){
        if(queue.isEmpty() || queue.size() < k){
            System.out.println("Queue is smaller than k or queue is empty ");
            return;
        }else{
            Stack<Integer> stack = new Stack<>();
            int count = k;
            while(k > 0){
                stack.push(queue.remove());
                k--;
            }
            while(!stack.isEmpty()){
                queue.add(stack.pop());
            }

            for(int i = 0; i<queue.size()-count ; i++){
                queue.add(queue.remove());
            }
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(100);
        queue.add(200);
        queue.add(300);
        queue.add(400);
        queue.add(500);
        queue.add(700);
        queue.add(800);
        queue.add(900);
        queue.add(1000);

        reverseFirstKElements(queue,5);
        System.out.println(queue);
    }
}
