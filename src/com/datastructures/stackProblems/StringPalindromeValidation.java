package com.datastructures.stackProblems;

import java.util.Stack;

public class StringPalindromeValidation {
    //to check whether the given string is palindrome or not
    //Here middle element has been given which is 'X'
    //using stack
    //here input string is made up of only a's and b's

    public static boolean isPalindrome(String str){
        boolean palindrome = true;

        char [] inputCharArray = str.toCharArray();
        int i = 0;
        Stack<Character> stack = new Stack<>();
        while(inputCharArray[i] != 'X'){
            stack.push(inputCharArray[i]);
            i++;
        }
        i++;
        while(i<inputCharArray.length){

            if(!stack.isEmpty() && inputCharArray[i] == (Character)stack.peek().charValue()){
                stack.pop();
                i++;
            }else{
                palindrome = false;
                return palindrome;
            }
        }
        return palindrome;
    }

    public static void main(String[] args) {
        String test = new String("abaababXbabaaba");
        System.out.println(test + "is Palindrome ? " + isPalindrome(test));
        test = new String("abaabaabXbabaaba");
        System.out.println(test + "is Palindrome ? " + isPalindrome(test));
        test = new String("abaaababXbabaaaba");
        System.out.println(test + "is Palindrome ? " + isPalindrome(test));
        test = new String("abaXbaa");
        System.out.println(test + "is Palindrome ? " + isPalindrome(test));
        test = new String("aXa");
        System.out.println(test + "is Palindrome ? " + isPalindrome(test));

    }



}
