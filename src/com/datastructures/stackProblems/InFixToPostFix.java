package com.datastructures.stackProblems;

import java.util.HashMap;
import java.util.Stack;

public class InFixToPostFix {
    private static boolean isOperator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')';
    }


    public static String convertInFixToPostFix(String str){
        HashMap<Character,Integer> priorityMap = new HashMap<>();
        priorityMap.put('*',3);
        priorityMap.put('/',3);
        priorityMap.put('+',2);
        priorityMap.put('-',2);
        priorityMap.put('(',1);

        char[] inputCharArray = str.toCharArray();
        Stack<Character> stackOfChar = new Stack<>();
        StringBuilder postFix = new StringBuilder();
        int i = 0;
        while(i < inputCharArray.length){
            if(!isOperator(inputCharArray[i])){
                if(inputCharArray[i]==' '){
                    i++;
                    continue;
                }
                postFix.append(inputCharArray[i]);
            }else if(inputCharArray[i] == '('){
                stackOfChar.push(inputCharArray[i]);
            }else{
                if(inputCharArray[i] == ')'){
                    while (!stackOfChar.isEmpty() && stackOfChar.peek() != '(')
                    {
                        postFix.append(stackOfChar.pop());
                    }
                    if (!stackOfChar.isEmpty()) //to remove '(' left parenthesis
                    {
                        stackOfChar.pop();
                    }
                }
                else {
                    char c = inputCharArray[i];
                    while(!stackOfChar.isEmpty() && (priorityMap.get(stackOfChar.peek())>=priorityMap.get(c))){
                        postFix.append(stackOfChar.pop());
                    }
                    stackOfChar.push(c);
                }
            }
            i++;

        }
        while(!stackOfChar.isEmpty()){
            postFix.append(stackOfChar.pop());
        }
        return postFix.toString();
    }

    public static void main(String[] args) {
        String strInFix = new String("A*B-(C+D)+E");
        System.out.println("Infix string : "+strInFix+", converted PostFix : " +convertInFixToPostFix(strInFix));
        strInFix = new String("1");
        System.out.println("Infix string : "+strInFix+", converted PostFix : " +convertInFixToPostFix(strInFix));
        strInFix = new String("A + B * C");
        System.out.println("Infix string : "+strInFix+", converted PostFix : " +convertInFixToPostFix(strInFix));
        strInFix = new String("(A+B)*C-D");
        System.out.println("Infix string : "+strInFix+", converted PostFix : " +convertInFixToPostFix(strInFix));
        strInFix = new String("(A + B) * C - (D - E) * (F + G)");
        System.out.println("Infix string : "+strInFix+", converted PostFix : " +convertInFixToPostFix(strInFix));

    }
}
