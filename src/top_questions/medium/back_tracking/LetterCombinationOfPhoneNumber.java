package top_questions.medium.back_tracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
class LetterCombinationOfPhoneNumber {
    Map<Character, char[]> map = new HashMap<Character, char[]>();
    public LetterCombinationOfPhoneNumber(){
        map.put('2', new char[]{'a', 'b','c'});
        map.put('3', new char[]{'d', 'e','f'});
        map.put('4', new char[]{'g', 'h','i'});
        map.put('5', new char[]{'j', 'k','l'});
        map.put('6', new char[]{'m', 'n','o'});
        map.put('7', new char[]{'p', 'q','r','s'});
        map.put('8', new char[]{'t', 'u','v'});
        map.put('9', new char[]{'w', 'x','y','z'});
        
        
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits.length()==0)
            return result;
        makeCombination(0, digits, "", result);
        return result;
    }
    private void makeCombination(int i, String digits, String combination, List<String> result){
        if(i==digits.length()){
            result.add(combination);
            return;
        }
            
        char digit = digits.charAt(i);
        char[] letters = map.get(digit);
        for(char letter: letters){
            makeCombination(i+1, digits, combination+""+letter, result);
        }
        
    }
}