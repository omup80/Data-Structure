package microsoft.arrays_and_strings;

import java.util.*;
//https://leetcode.com/problems/group-anagrams/
//49. Group Anagrams
class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<List<String>> result = new ArrayList<List<String>>();
        
        for(String s:strs){
            String key = getKeyEfficient(s);
            List<String> anagram = map.getOrDefault(key, new ArrayList<String>());
            anagram.add(s);
            map.put(key, anagram);
            
        }
        
        for(List<String> anagram: map.values()){
            result.add(anagram);
        }
        return result;
        
        
    }
    private String getKey(String s){
        char tempArray[] = s.toCharArray(); 
          
        // sort tempArray 
        Arrays.sort(tempArray);
          
        // return new sorted string 
        return new String(tempArray);
    }
    
   private String getKeyEfficient(String s){
        char tempArray[] = s.toCharArray(); 
        int[] count = new int[26];
       StringBuilder sb = new StringBuilder();
       Arrays.fill(count, 0);
       for(char c: tempArray){
           count[c-'a']++;
       }
        
       for(int i=0;i<26;i++){
         sb.append("#").append(count[i]);     
       } 
      return sb.toString();
    } 
}