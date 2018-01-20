package com.datastructures.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubSequnceWithAllVowels {

    public int longestMagicSequence(String s){
        char [] vowels = {'a','e','i','o','u'};
        boolean aFound = false;
        int crtPtr = Integer.MIN_VALUE;
        int i = 0;
        StringBuilder temp = new StringBuilder();
        while(i < s.length()){
            char c = s.charAt(i);
            if(c != 'a' && !aFound){
                i++;
                continue;
            }
            else if(c == 'a' && !aFound){
                aFound = true;
                temp.append(c);
                crtPtr = 0;
            }else if(c == vowels[crtPtr]){
                temp.append(c);
            }else if(crtPtr < vowels.length-1 &&  c == vowels[crtPtr+1]){
                crtPtr++;
                temp.append(c);
            }
            i++;
        }
        return crtPtr == vowels.length-1 ? temp.length() : 0;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubSequnceWithAllVowels().longestMagicSequence("eeeeaeiaaioooaau"));
    }
}
