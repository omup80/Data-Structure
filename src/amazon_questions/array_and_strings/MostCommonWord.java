package amazon_questions.array_and_strings;

import java.util.HashMap;
import java.util.HashSet;
/*
Given a paragraph and a list of banned words, return the most frequent word
that is not in the list of banned words.
 It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.
 Words in the paragraph are not case sensitive.  The answer is in lowercase.


 */
class MostCommonWord {
    int len;
    String para;
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        para = paragraph;
        len = para.length();
        HashSet<String> bannedHash = new HashSet<String>();
        String mostWord="";
        int mostWordCount=0;
        for(int i=0;i< banned.length;i++){
            bannedHash.add(banned[i]);
            
        }
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        
        int j=0,k=0;
        
        while(j<len && k<len){
            j =  getStartOfChunk(j);
            if(j==len)
                break;
            
            k = getEndOfChunk(j);
            
            String word = para.substring(j, k);
            
            int count = wordCount.getOrDefault(word,0);
            wordCount.put(word, count+1);
            
            if(!bannedHash.contains(word) && mostWordCount < wordCount.get(word)){
                mostWord = word;
                mostWordCount = wordCount.get(word);
            }
            
            j=k;
        
        }
        
        
        
        return mostWord;
        
    }
    
    public int getEndOfChunk(int k){
        int c = para.charAt(k) - 'a';
            while(c>=0 && c<=25 && k< len){
                k++;
                if(k<len)
                    c = para.charAt(k) - 'a';
            }
        return k;
    }
    
    public int getStartOfChunk(int j){
        
          int c = para.charAt(j)-'a';
            
            while(  (c<0 || c>25) && j<len) {
                j++;
                if(j<len)
                    c = para.charAt(j)-'a';
            }
       return j; 
    }
}