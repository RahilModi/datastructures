package com.datastructures.string;
//leetcode problem: 344
public class ReverseString {
    public String reverseString(String s) {
        if(s == null || s.length() == 0) return s;
        StringBuilder str =  new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--){
            str.append(s.charAt(i));
        }
        return str.toString();
    }

    public String reverseString2(String s) {
        if(s == null || s.length() == 0) return s;
        char [] letters = s.toCharArray();
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            char temp = letters[l];
            letters[l] = letters[r];
            letters[r] = temp;
            l++;
            r--;
        }
        System.out.println(letters);
        return new String(letters);
    }

    public String reverseString3(String s) {
        if(s == null || s.length() <= 1) return s;
        return reverseString3(s.substring(1)) + s.charAt(0);
    }


    public static void main(String[] args) {
        System.out.println(new ReverseString().reverseString3("hello"));
    }

}
