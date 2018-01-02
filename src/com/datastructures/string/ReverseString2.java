package com.datastructures.string;
//leetcode problem : 541
/*Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
        Example:
        Input: s = "abcdefg", k = 2
        Output: "bacdfeg"
        Restrictions:
        The string consists of lower English letters only.
        Length of the given string and k will in the range [1, 10000]*/
public class ReverseString2 {
    public String reverseStr(String s, int k) {
        if(k<=1) return s;
        char[] letters = s.toCharArray();
        boolean bSkip = false;
        for(int i = 0;i <letters.length; i += 2*k){
            int l = i;
            int r = i+k-1;

            while(r >= letters.length){
                r--;
            }
            while(l<r){
                char temp = letters[l];
                letters[l] = letters[r];
                letters[r] = temp;
                l++;
                r--;
            }
        }
        return new String(letters);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseString2().reverseStr("abcdefghijk",4));
    }
}
