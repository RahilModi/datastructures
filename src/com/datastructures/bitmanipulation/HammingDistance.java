package com.datastructures.bitmanipulation;

public class HammingDistance {

    /*The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

    Given two integers x and y, calculate the Hamming distance.
            Input: x = 1, y = 4

    Output: 2

    Explanation:
            1   (0 0 0 1)
            4   (0 1 0 0)
            ↑   ↑

    The above arrows point to positions where the corresponding bits are different.*/

    public int hammingDistance(int x, int y) {

        int res = x ^ y;
        return Integer.bitCount(res);

    }

    //efficient
    public int hammingDistance1(int x, int y) {

        int res = x ^ y;
        int count = 0;
        while(res != 0){
            if((res&1) != 0) count++;
            res>>>=1;
        }
        return count;
    }
}
