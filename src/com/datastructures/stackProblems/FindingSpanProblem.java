package com.datastructures.stackProblems;

import java.util.Stack;

public class FindingSpanProblem {

    //using array O(n^2) complexity..
    public static void findSpan(int[] inputArray,int[] span){
        span[0] = 1;
        for(int i = 1; i< inputArray.length ; i++){
            int spanDays = 1;
            int j = i;
            while(j >= 1 && inputArray[i]>inputArray[j-1]){
                spanDays++;
                j--;
            }
            span[i] = spanDays;
        }

    }

    //using stack..
    public static void findSpanOfStock(int[] inputArray,int[] span){
        Stack<Integer> spans = new Stack<>();
        spans.push(0);
        span[0] = 1;

        for(int i = 1; i < inputArray.length; i++){
            while(!spans.isEmpty() && inputArray[spans.peek()] <= inputArray[i]){
                spans.pop();
            }
            span[i] = (spans.isEmpty())?i+1:i-spans.peek();
            spans.push(i);
        }

    }
    public static void main(String[] args) {
        int [] inputs = new int[6];
        inputs[0] = 6;
        inputs[1] = 2;
        inputs[2] = 3;
        inputs[3] = 5;
        inputs[4] = 3;
        inputs[5] = 7;
        int[] spans = new int[inputs.length];
        findSpan(inputs,spans);
        for(int i = 0;i<inputs.length;i++){
            System.out.println(inputs[i] +" span : "+ spans[i]);
        }
        System.out.println("------------------");
        int[] newspans = new int[inputs.length];
        findSpanOfStock(inputs,newspans);
        for(int i = 0;i<inputs.length;i++){
            System.out.println(inputs[i] +" span : "+ newspans[i]);
        }
    }
}
