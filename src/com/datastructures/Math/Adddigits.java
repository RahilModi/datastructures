package com.datastructures.Math;

public class Adddigits {
    public int addDigits(int num) {
        int temp = num % 9;
        return num == 0? 0 : temp == 0 ? 9 : temp;
    }
}
