import javafx.beans.binding.StringBinding;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        if(S == null || S.length() == 0) return null;
        List<String> output = new ArrayList<>();
        char[] temp = S.toCharArray();
        helper(temp, output,0  );
        return output;
    }

    public void helper(char[] temp, List<String> results, int index){
        results.add(new String(temp));
        for(int i=index ; i < temp.length; i++){
            if(!Character.isAlphabetic(temp[i])){
                continue;
            }
            char crt = temp[i];
            if(Character.isLowerCase(crt))
                temp[i] = Character.toUpperCase(crt);
            else
                temp[i] = Character.toLowerCase(crt);
            helper(temp,results,i+1);
            if(Character.isLowerCase(crt))
                temp[i] = Character.toLowerCase(temp[i]);
            else
                temp[i] = Character.toUpperCase(temp[i]);
        }
    }

    public static void main(String[] args) {
        List<String> result = new LetterCasePermutation().letterCasePermutation("12ab");
        for(String s: result){
            System.out.println(s);
        }
        result = new LetterCasePermutation().letterCasePermutation("C");
        for(String s: result){
            System.out.println(s);
        }
    }
}
