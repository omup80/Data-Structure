package microsoft.backtracking;

import java.util.*;
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
//17. Letter Combinations of a Phone Number
class LetterCombinationOfPhoneNumber {
    Map<Character, List<Character>> map = new HashMap<Character, List<Character>>();
    public LetterCombinationOfPhoneNumber(){
        map.put('2', new ArrayList<>(Arrays.asList('a','b','c')));
        map.put('3', new ArrayList<>(Arrays.asList('d','e','f')));
        map.put('4', new ArrayList<>(Arrays.asList('g','h','i')));
        map.put('5', new ArrayList<>(Arrays.asList('j','k','l')));
        map.put('6', new ArrayList<>(Arrays.asList('m','n','o')));
        map.put('7', new ArrayList<>(Arrays.asList('p','q','r','s')));
        map.put('8', new ArrayList<>(Arrays.asList('t','u','v'))); 
        map.put('9', new ArrayList<>(Arrays.asList('w','x','y','z')));

    }
    public List<String> letterCombinations(String digits) {
        List<String> combination = new ArrayList<String>();
        if(digits.length()==0)
            return combination;
        combination.add("");
        return createCombination(digits, combination);
    }
    
    public List<String> createCombination(String digits, List<String> combinations){
        if(digits.length()==0)
            return combinations;
        List<String> result = new ArrayList<String>();
        List<Character> alphabets = map.get(digits.charAt(0));
        
        for(String combination: combinations){
            for(Character alphabet: alphabets){
                result.add(combination+alphabet);
            }
            
        }
        
        return createCombination(digits.substring(1), result);
        
    }
}