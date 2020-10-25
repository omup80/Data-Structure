package amazon_questions.mock.onsite;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class VowelSpellChecker {
    Set<String> exactMatch = new HashSet();
    Map<String, String> caseIMatch = new HashMap();
    Map<String, String> vovelMatch = new HashMap();
    
    public String[] spellchecker(String[] wordlist, String[] queries) {
       
        createDict(wordlist);
        String[] result = new String[queries.length];
        int i=0;
        for(String query: queries){
            result[i] = solve(query);
            i++;
            
        }
        return result;
    }
    
    private String solve(String word){
        if(exactMatch.contains(word))
            return word;
        
        String lc = word.toLowerCase();
        if(caseIMatch.containsKey(lc))
            return caseIMatch.get(lc);
        
        String gw = convertGenericVW(word.toLowerCase());
        if(vovelMatch.containsKey(gw))
            return vovelMatch.get(gw);
        
        return "";    
    }
    private void createDict(String[] wordlist){
        for(String word: wordlist){
            exactMatch.add(word);
            
            String lcWord = word.toLowerCase();
            caseIMatch.putIfAbsent(lcWord, word);
            String wv = convertGenericVW(word.toLowerCase());
            vovelMatch.putIfAbsent(wv, word);
        }
    }
    
    private String convertGenericVW(String word){
        StringBuffer ans = new StringBuffer();
        for(char c: word.toCharArray()){
            if(isVowel(c))
                ans.append("*");
            else
                ans.append(c);
        }
        return ans.toString();
    }
    
    private boolean isVowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
            return true;
        
        return false;
    }
}