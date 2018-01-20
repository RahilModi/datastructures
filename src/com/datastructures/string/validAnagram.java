package com.datastructures.string;

public class validAnagram {
        public boolean isAnagram(String s, String t) {
            if(s.length() != t.length()) return false;
            s = s.toLowerCase();
            t = t.toLowerCase();
            int[] arr = new int[1<<8];  //1<<8 == 256
            for(char c : s.toCharArray()){
                arr[c]++;
            }

            for(char c : t.toCharArray()){
                arr[c]--;
            }

            for(int i : arr){
                if(i != 0) return false;
            }

            return true;
        }
}
