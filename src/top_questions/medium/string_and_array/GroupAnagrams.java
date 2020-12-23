package top_questions.medium.string_and_array;

import java.util.*;
//https://leetcode.com/problems/group-anagrams/
class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
      List<List<String>> result = new ArrayList<List<String>>();
      Map<String, List<String>> map = new HashMap();
      for(String word: strs){
          String key = getKey(word);
          List<String> anagrams = map.getOrDefault(key, new ArrayList<String>());
          anagrams.add(word);
          map.put(key, anagrams);
      }  
      result.addAll(map.values());  
      return result;  
    }
    
    private String getKey(String word){
        char[] key = word.toCharArray();
        Arrays.sort(key);
        StringBuilder s = new StringBuilder();
        for(char ch: key)
            s.append(ch);
        
        return s.toString();
    }
}