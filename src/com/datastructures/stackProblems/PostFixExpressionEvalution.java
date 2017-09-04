package com.datastructures.stackProblems;

import java.util.Stack;

public class PostFixExpressionEvalution {
    private static boolean isOperator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static int postFixExpressionEvaluator(String postFixStr){

        char [] inputChars = postFixStr.toCharArray();
        Stack<Integer> stackOfOperands = new Stack<>();
        int i =0;
        while(i < inputChars.length) {
            if (!isOperator(inputChars[i])) {
                stackOfOperands.push(Integer.parseInt(String.valueOf(inputChars[i])));
            } else {
                char operator = inputChars[i];
                int num2 = stackOfOperands.pop();
                int num1 = stackOfOperands.pop();
                int result = 0;
                switch (operator){
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    default:
                        System.out.println("Not supported...");
                        return Integer.MIN_VALUE;
                }
                stackOfOperands.push(result);
            }
            i++;
        }

        while(!stackOfOperands.isEmpty()){
            return stackOfOperands.pop();
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {

        String strInFix = new String("1*2-(3+4)+5");
        String convertedPostFix = InFixToPostFix.convertInFixToPostFix(strInFix);
        System.out.println("Infix string : " + strInFix + ", converted PostFix : " + convertedPostFix + " Computed Result : " + postFixExpressionEvaluator(convertedPostFix));
        strInFix = new String("1");
        convertedPostFix = InFixToPostFix.convertInFixToPostFix(strInFix);
        System.out.println("Infix string : " + strInFix + ", converted PostFix : " + convertedPostFix + " Computed Result : " + postFixExpressionEvaluator(convertedPostFix));
        strInFix = new String("1 + 9 * 8");
        convertedPostFix = InFixToPostFix.convertInFixToPostFix(strInFix);
        System.out.println("Infix string : " + strInFix + ", converted PostFix : " + convertedPostFix + " Computed Result : " + postFixExpressionEvaluator(convertedPostFix));
        strInFix = new String("(3+5)*8-9");
        convertedPostFix = InFixToPostFix.convertInFixToPostFix(strInFix);
        System.out.println("Infix string : " + strInFix + ", converted PostFix : " + convertedPostFix + " Computed Result : " + postFixExpressionEvaluator(convertedPostFix));
        strInFix = new String("(3 + 2) * 6 - (2 - 3) * (2 + 9)");
        convertedPostFix = InFixToPostFix.convertInFixToPostFix(strInFix);
        System.out.println("Infix string : " + strInFix + ", converted PostFix : " + convertedPostFix + " Computed Result : " + postFixExpressionEvaluator(convertedPostFix));
    }
}
