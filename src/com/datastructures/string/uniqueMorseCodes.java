package com.datastructures.string;

import java.util.HashSet;

public class uniqueMorseCodes {

    String[] morseCodes = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> collectionOfUniqueMorseCodes = new HashSet<>();
        for(String word: words){
            StringBuffer morseCode = new StringBuffer();
            for(char c: word.toCharArray()){
                morseCode.append(morseCodes[c-'a']);
            }
            if(!collectionOfUniqueMorseCodes.contains(morseCode)){
                collectionOfUniqueMorseCodes.add(morseCode.toString());
            }
        }
        return collectionOfUniqueMorseCodes.size();
    }
}
