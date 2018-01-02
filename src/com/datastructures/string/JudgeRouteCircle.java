package com.datastructures.string;

public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        char[] inputArray = moves.toCharArray();
        int leftRight=0;
        int upDown=0;
        for(char move: inputArray){
            switch (move){
                case 'U':{
                    upDown++;
                    break;
                }
                case 'D':{
                    upDown--;
                    break;
                }
                case 'L':{
                    leftRight--;
                    break;
                }
                case 'R':{
                    leftRight++;
                    break;
                }
            }
        }
        if(leftRight != 0 || upDown != 0) return false;
        return true;
    }
}
