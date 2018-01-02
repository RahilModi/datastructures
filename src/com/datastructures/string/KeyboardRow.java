package com.datastructures.string;

import java.util.ArrayList;
import java.util.List;

//leetcode problem : 500
public class KeyboardRow {
    private final char[][] rows = new char[][]{{'q','w','e','r','t','y','u','i','o','p'},{'a','s','d','f','g','h','j','k','l'},{'z','x','c','v','b','n','m'}};
    public String[] findWords(String[] words) {
        String temp;
        List<String> strs =  new ArrayList<>();
        int index = 0;
        int firstCharacterRow=Integer.MIN_VALUE;
        for(String word:words){
            temp = word.toLowerCase();
            int i = 0;
            boolean b = false;
            for(char ch: temp.toCharArray()){
                if(i == 0) firstCharacterRow = charInRow(ch);
                else {
                    if (firstCharacterRow != charInRow(ch)) {
                        b = true;
                        break;
                    }
                }
                i++;
            }
            if(!b) strs.add(word);
        }
        String[] results =  new String[strs.size()];
        for(String opt: strs){
            results[index++] = opt;
        }
        return results;
    }

    public int charInRow(char c){
        for(int i = 0; i < rows.length ; i++){
            for(int j = 0;j<rows[i].length;j++){
                if(c == rows[i][j]){
                    return i;
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
