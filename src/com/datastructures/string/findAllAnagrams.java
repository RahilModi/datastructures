package com.datastructures.string;

import java.util.*;
import java.util.stream.Collectors;

public class findAllAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        List<Integer> startPos = new ArrayList<>();
        if(p.length() > s.length()) return startPos;
        for(char c : p.toCharArray()){
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int count = charCountMap.size();
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(charCountMap.containsKey(s.charAt(i))){
                charCountMap.put(c,charCountMap.get(c)-1);
                if(charCountMap.get(c) == 0) count--;
            }
            i++;
            while(count == 0){
                char t = s.charAt(left);
                if(charCountMap.containsKey(t)){
                    charCountMap.put(t,charCountMap.get(t)+1);
                    if(charCountMap.get(t) > 0){
                        count++;
                    }
                }
                if(i - left == p.length()) startPos.add(left);
                left++;
            }
        }
        return startPos;
    }


    public static void main(String[] args) {
       List<Integer> t = new findAllAnagrams().findAnagrams("cbaebabacd",
               "abc");
       for(int i : t) System.out.println(i);
    }
}
