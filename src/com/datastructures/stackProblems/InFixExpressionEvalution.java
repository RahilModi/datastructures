package com.datastructures.stackProblems;

import java.util.Stack;

public class InFixExpressionEvalution {

    private static boolean isOperator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')';
    }

    public static int evaluate(String str){
        int result = Integer.MIN_VALUE;

        char [] inputCharArray = str.toCharArray();
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for(int i = 0; i < inputCharArray.length ; i++){
            if(inputCharArray[i] == ' '){
                continue;
            }
            if(!isOperator(inputCharArray[i]) || (inputCharArray[i] >= '0' && inputCharArray[i] <= '9')){
                    StringBuilder sbld = new StringBuilder();
                    // There may be more than one digits in number
                    while (i < inputCharArray.length && inputCharArray[i] >= '0' && inputCharArray[i] <= '9')
                        sbld.append(inputCharArray[i++]);
                    operands.push(Integer.parseInt(sbld.toString()));
            }
            else{
                if(inputCharArray[i] == '('){
                    operators.push(inputCharArray[i]);
                }
                else if(inputCharArray[i] == ')'){
                    while(operators.peek() != '('){
                        operands.push(doMath(operators.pop(),operands.pop(),operands.pop()));
                    }
                    operators.pop();
                }else{
                    while(!operators.isEmpty() && hasPrecedence(inputCharArray[i],operators.peek())){
                        operands.push(doMath(operators.pop(),operands.pop(),operands.pop()));
                    }
                    operators.push(inputCharArray[i]);
                }
            }
        }
        while (!operators.isEmpty()){
            operands.push(doMath(operators.pop(),operands.pop(),operands.pop()));
        }
        result = operands.pop();
        return result;
    }

    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public static int doMath(char operator,int operand1, int operand2){
        switch(operator) {
            case '+':
                return operand2 + operand1;
            case '-':
                return operand2 - operand1;
            case '/':
                return operand2 / operand1;
            case '*':
                return operand2 * operand1;
        }
        return Integer.MIN_VALUE;
        }

    public static void main(String[] args) {
        System.out.println(InFixExpressionEvalution.evaluate("10 + 2 * 6"));
        System.out.println(InFixExpressionEvalution.evaluate("100 * 2 + 12"));
        System.out.println(InFixExpressionEvalution.evaluate("100 * ( 2 + 12 )"));
        System.out.println(InFixExpressionEvalution.evaluate("100 * ( 2 + 12 ) / 14"));
    }
}
