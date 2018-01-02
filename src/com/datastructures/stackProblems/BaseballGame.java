package com.datastructures.stackProblems;

import java.util.Stack;

//leetcode problem:682
/*You're now a baseball game point recorder.

        Given a list of strings, each string can be one of the 4 following types:

        Integer (one round's score): Directly represents the number of points you get in this round.
        "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
        "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
        "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
        Each round's operation is permanent and could have an impact on the round before and the round after.

        You need to return the sum of the points you could get in all the rounds.*/
public class BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int score = 0;
        for(int i =0; i<ops.length; i++){
            if(ops[i].equals("C")){
                score-=stack.pop();
            }
            else if(ops[i].equals("D")){
                int _score =  2*stack.peek();
                score+=_score;
                stack.push(_score);
            }else if(ops[i].equals("+")){
                int lastScore = stack.pop();
                int secondLastScore = stack.peek();
                int gameScore = lastScore+secondLastScore;
                stack.push(lastScore);
                stack.push(gameScore);
                score += gameScore;
            }else{
                score+=Integer.parseInt(ops[i]);
                stack.push(Integer.parseInt(ops[i]));
            }
        }
        return score;
    }
}
