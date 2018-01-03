package com.datastructures.string;

public class UsageOfCapital {
    public boolean detectCapitalUse(String word) {
        if(word.length() <= 1) return true;
        else {
            boolean bFirstIsUpper = false, bSecondIsUpper = false;
            if (Character.isUpperCase(word.charAt(0))) bFirstIsUpper = true;
            if (Character.isUpperCase(word.charAt(1))) bSecondIsUpper = true;
            if(!bFirstIsUpper && bSecondIsUpper) return false;
            char[] chAry = word.toCharArray();
            for (int i = 1; i < chAry.length; i++) {
                if (bFirstIsUpper && bSecondIsUpper && Character.isLowerCase(chAry[i])) {
                    return false;
                }else if(!bFirstIsUpper && !bSecondIsUpper && Character.isUpperCase(chAry[i])){
                    return false;
                }else if(bFirstIsUpper && !bSecondIsUpper && Character.isUpperCase(chAry[i])){
                    return false;
                }
            }
            return true;
        }
    }
}
