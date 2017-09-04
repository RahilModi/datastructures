package com.datastructures.stackProblems;

import java.util.Stack;

public class RemoveAdjacentDuplicates {

//    Input:  azxxzy
//    Output: ay
//    First "azxxzy" is reduced to "azzy". The string "azzy" contains duplicates,
//    so it is further reduced to "ay".
//
//    Input: geeksforgeeg
//    Output: gksfor
//    First "geeksforgeeg" is reduced to "gksforgg". The string "gksforgg" contains
//    duplicates, so it is further reduced to "gksfor".
//
//    Input: caaabbbaacdddd
//    Output: Empty String
//
//    Input: acaaabbbacdddd
//    Output: a

    public static String removeDuplicates(String str){
        if(str.length()<2)return str;
        Stack<Character> inputStack = new Stack<>();
        for(char ch:str.toCharArray()) {
            inputStack.push(ch);
        }

        return filteredString(inputStack);
    }

    public static String filteredString(Stack<Character> input){
        if(input.size()<2){
            return new StringBuilder(input.pop()).toString();
        }
        Stack<Character> filtered = new Stack<>();
        while(!input.isEmpty()){
            char ch = input.pop();
                if (filtered.isEmpty()||filtered.peek() != ch) {
                    filtered.push(ch);
                } else{
                    while(!input.isEmpty() && input.peek() == ch){
                        input.pop();
                    }
                    filtered.pop();
                }
            }
        StringBuilder output = new StringBuilder();
        while(!filtered.isEmpty()){
            output.append(filtered.pop());
        }
        return output.toString();
    }

    public static void main(String[] args) {
        String str = new String("azxxzy");

        System.out.println(removeDuplicates(str));

        str = "geeksforgeeg";
        System.out.println(removeDuplicates(str));

        str ="caaabbbaacdddd";
        System.out.println(removeDuplicates(str));

        str="acaaabbbacdddd";
        System.out.println(removeDuplicates(str));

        str="cooodefightssforrrcodee";
        System.out.println(removeDuplicates(str));
    }
}
