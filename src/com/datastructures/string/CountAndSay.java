package com.datastructures.string;
//LeetCode problem number 38
public class CountAndSay {
    public String countAndSay(int n) {
        if(n <= 1) return "1";
        String prev = countAndSay(n-1);
        StringBuilder strBld = new StringBuilder();
        int sequenceCount = 0;
        char lastCharacter=Character.MIN_VALUE;
        for(int j = 0; j < prev.length(); j++){
            if(j == 0) {
                lastCharacter = prev.charAt(j);
                sequenceCount++;
            }
            else{
                if(lastCharacter == prev.charAt(j)) sequenceCount++;
                else{
                    strBld.append(sequenceCount);
                    strBld.append(lastCharacter);
                    lastCharacter = prev.charAt(j);
                    sequenceCount = 1;
                }
            }
        }
        strBld.append(sequenceCount);
        strBld.append(lastCharacter);
        sequenceCount = 0;
        prev = strBld.toString();
        strBld.setLength(0);
        return prev;
    }

    public static void main(String[] args) {
        CountAndSay lookAndSay = new CountAndSay();
        System.out.println(lookAndSay.countAndSay(3));
    }
}
