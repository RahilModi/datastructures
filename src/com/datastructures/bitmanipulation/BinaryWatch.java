package com.datastructures.bitmanipulation;


import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    private int[] bitCount;
    public BinaryWatch(){
        bitCount = new int[60];
        for(int i = 0; i<=59; i++){
            bitCount[i] = Integer.bitCount(i);
        }
    }

    public List<String> readBinaryWatch(int num) {

        List<String> answer = new ArrayList<>();
        for(int i = 0; i <=11; i++){
            if(bitCount[i] > num){
                continue;
            }
            else if(bitCount[i] == num){
                String str = i + ":00";
                answer.add(str);
            }else{
                int diff = num - bitCount[i];
                for(int j = 1; j<=59;j++){
                    if(bitCount[j] == diff){
                        if(j<=9)
                            answer.add(i+":0"+j);
                        else
                            answer.add(i+":"+j);
                    }
                }

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        BinaryWatch watch = new BinaryWatch();
        watch.readBinaryWatch(1);
    }
}
