package com.datastructures.queueProblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterleavingQueue {

    //11,12,13,14,15,16,17,18 => 11,15,12,16,13,17,14,18
    public static void interleaveQueue(Queue<Integer> q){
        if(q.size() %2 != 0){
            System.out.println("queue length is odd.");
            return;
        }
        int halfsize = q.size() / 2;
        int i = 0;
        Queue<Integer> tempQ = new LinkedList<>();
        while(i <halfsize){
            tempQ.add(q.remove());
            i++;
        }

        while(!tempQ.isEmpty()){
            q.add(tempQ.remove());
            q.add(q.remove());
        }

    }
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(100);
        queue.add(200);
        queue.add(300);
        queue.add(400);
        queue.add(500);
        queue.add(600);
        queue.add(700);
        queue.add(800);
        queue.add(900);
        queue.add(1000);

        interleaveQueue(queue);
        System.out.println(queue);
    }
}
