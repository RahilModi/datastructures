package com.datastructures.string;

public class NonRepeatedFirst {

    public String nonRepeatedFirstCharacter(String str){
        int[] chars = new int[256];
        for(int i = 0 ; i < str.length(); i++){
            chars[(int)str.charAt(i)] += 1;
        }
        int  index = 0;
        for(; index< str.length(); index++){
            if(chars[(int)str.charAt(index)] == 1) {
                break;
            }
        }

        return String.valueOf(str.charAt(index));

    }

    public static void main(String[] args) {
        System.out.println(new NonRepeatedFirst().nonRepeatedFirstCharacter("mnonmpsms"));
    }
}

