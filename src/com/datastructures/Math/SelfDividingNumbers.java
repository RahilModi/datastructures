package com.datastructures.Math;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        if(left > right) return null;
        List<Integer> selfDividedNumbers = new ArrayList<>();
        for(int i = left; i <= right; i++){
            if(i%10 == 0) continue;
            if(isSelfDividedNumber(i)) selfDividedNumbers.add(i);
        }
        return  selfDividedNumbers;
    }

    public boolean isSelfDividedNumber(int num){
        if(num <= 9) return true;
        int inputNum = num;
        int singleDigit;
        while(num > 9) {
            singleDigit = num % 10;
            if(singleDigit == 0 || inputNum % singleDigit != 0){
                return false;
            }
            num /= 10;
        }
        if(inputNum % num != 0) return false;
        return true;
    }
}
