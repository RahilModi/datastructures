package com.datastructures.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWORepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> charCountMap = new HashMap<>();

        int count = charCountMap.size();
        if(count == s.length()) return s.length(); //because all characters are unique
        int i = 0, begin = 0, len = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) +1);
            if(charCountMap.get(c) > 1) count++;
            i++;

            while(count > 0){
                char t = s.charAt(begin);
                if(charCountMap.get(t) > 1) count--;
                charCountMap.put(t,charCountMap.get(t) - 1);
                begin++;
            }
            len = Math.max(len, i -begin);
        }
        return len;
    }
}
