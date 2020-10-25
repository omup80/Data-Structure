package amazon_questions.mock.onsite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LetterCombinationPhoneNumber {
    Map<Character, char[]> dict;
    List<String> result;
    public LetterCombinationPhoneNumber(){
        dict = new HashMap();
        result = new ArrayList<String>();
        dict.put('2',new char[]{'a','b','c'});
        dict.put('3',new char[]{'d','e','f'});
        dict.put('4',new char[]{'g','h','i'});
        dict.put('5',new char[]{'j','k','l'});
        dict.put('6',new char[]{'m','n','o'});
        dict.put('7',new char[]{'p','q','r','s'});
        dict.put('8',new char[]{'t','u','v'});
        dict.put('9',new char[]{'w','x','y','z'});
    }
    public List<String> letterCombinations(String digits) {
        
        if(digits==null || digits.trim().length()==0)
            return result;
        createCombinations(0,digits, "");
            
        
        
        return result;
    }
    
    private void createCombinations(int i, String digits, String comb){
        if(i==digits.length()){
            result.add(comb);
            return;
        }
        
        char[] values = dict.get(digits.charAt(i++));
        for(char value: values){
            createCombinations(i, digits, comb+value);
        }
    }
}