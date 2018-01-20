package com.datastructures.string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    private Map<Character,Integer> romanNumbers = new HashMap<>();

    public int romanToInt(String s) {
        populate();
        int number = 0;
        int prev = romanNumbers.get(s.charAt(0));
        for(int i =1; i < s.length(); i++){
                int next = romanNumbers.get(s.charAt(i));
                if(prev < next){
                    number -= prev;
                }else{
                    number += prev;
                }
                prev = next;
            }
            number += prev;
        return number;
    }

    private void populate(){
        romanNumbers.put('M',1000);
        romanNumbers.put('D',500);
        romanNumbers.put('C',100);
        romanNumbers.put('L',50);
        romanNumbers.put('X',10);
        romanNumbers.put('V',5);
        romanNumbers.put('I',1);
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInt().romanToInt("CCXLVI"));
    }
}
