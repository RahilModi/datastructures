package com.datastructures.miscellaneous;

public class climbingStairs {

    public int climbStairs(int n) {
        int[] res = new int[n];
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        for(int i = 3; i < n ;i++){
            res[i] = res[i-1]+res[i-2];
        }
        return res[n-1];
    }

    public int climbStairs1(int n) {
        if(n==0 || n==1) return n;
        int pre = 1;
        int cur = 2;
        for(int i = 2; i < n ; i++){
            int temp = cur;
            cur = cur + pre;
            pre = temp;
        }
        return cur;
    }

}
