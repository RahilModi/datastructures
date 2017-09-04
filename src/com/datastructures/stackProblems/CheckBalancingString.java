package com.datastructures.stackProblems;

import java.util.Stack;

public class CheckBalancingString {

    public static boolean isValidSymbolPattern(String str){
        Stack<Character> stackOfChars = new Stack<>();
        if(str == null || str.length() == 0){
            System.out.println("string...is null or empty");
            return true;
        }
        for(int i = 0; i < str.length() ;i++){
            if(str.charAt(i) == ')'){
                if(!stackOfChars.isEmpty() && stackOfChars.peek()=='('){
                    stackOfChars.pop();
                }
                else{
                    return false;
                }
            }else if(str.charAt(i) == ']'){
                if(!stackOfChars.isEmpty() && stackOfChars.peek()=='['){
                    stackOfChars.pop();
                }
                else{
                    return false;
                }
            }else if(str.charAt(i) == '}'){
                if(!stackOfChars.isEmpty() && stackOfChars.peek()=='{'){
                    stackOfChars.pop();
                }
                else{
                    return false;
                }
            }else if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[' ){
                stackOfChars.push(str.charAt(i));
            }

        }
        if(stackOfChars.isEmpty()){
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args) {
        String test = new String("{(A+B)-[(C+D)]}");
        System.out.println("Given string " + test + "is valid ? :"+isValidSymbolPattern(test));
        test = new String("){(A+B)-[(C+D)]}");
        System.out.println("Given string " + test + "is valid ? :"+isValidSymbolPattern(test));
        test = new String("{{{(A+B)}-[(C+D)]}}]");
        System.out.println("Given string " + test + "is valid ? :"+isValidSymbolPattern(test));

    }
}
