package amazon_questions.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 */
class LetterCombination {
    Map<Character, char[]> dict = new HashMap<Character, char[]>();
    List<String> combinations = new ArrayList<String>();
    LetterCombination(){
        dict.put('2', new char[]{'a','b','c'});
        dict.put('3', new char[]{'d','e','f'});
        dict.put('4', new char[]{'g','h','i'});
        dict.put('5', new char[]{'j','k','l'});
        dict.put('6', new char[]{'m','n','o'});
        dict.put('7', new char[]{'p','q','r','s'});
        dict.put('8', new char[]{'t','u','v'});
        dict.put('9', new char[]{'w','x','y','z'});    
    }
    
    public List<String> letterCombinations(String digits) {
        
       if(digits.length()!=0){
           bfs("", digits);
       }
            
                
        
        
        
        return combinations;
    }
    private void bfs(String combination, String digits){
        if(digits.length()==0){
            
            combinations.add(combination);
        
        }else{
            char digit = digits.charAt(0);
            char[] alphabets = dict.get(digit);
            
            for(char alphabet: alphabets){
                bfs(combination+alphabet, digits.substring(1));
            }
            
            
        }
        
        
        
    }
    
}