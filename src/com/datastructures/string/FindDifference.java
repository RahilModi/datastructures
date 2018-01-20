package com.datastructures.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindDifference {

    //method 1:
    public char findTheDifference(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }

        for(char ch: t.toCharArray()){
            if(map.containsKey(ch)){
                int count = map.get(ch);
                if(count == 1)
                    map.remove(ch);
                else
                    map.put(ch,--count);
            }else{
                return ch;
            }
        }
        return 0;
    }

    //method 2:
    public char findTheDifferenceUsingXOR(String s, String t) {
        char c = 0;
        for (int i = 0; i < s.length(); ++i) {
            c ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            c ^= t.charAt(i);
        }
        return c;
    }
}
