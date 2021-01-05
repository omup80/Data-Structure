package top_questions.hard.array_and_string;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/minimum-window-substring/
class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> dmap = new HashMap<Character, Integer>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        int ans = Integer.MAX_VALUE;
        String result="";
        for(char ch:t.toCharArray())
            dmap.put(ch, dmap.getOrDefault(ch, 0)+1);

        int i=0, j=0, formed=0, required=dmap.size();

        while(j<s.length()){

            char ch = s.charAt(j);
            int count = map.getOrDefault(ch, 0)+1;

            if(dmap.containsKey(ch)){
                if(count==dmap.get(ch))
                    formed++;
                map.put(ch, count);
            }



            if(formed==required){
                while(i<=j && formed==required){

                    char c = s.charAt(i);
                    if(dmap.containsKey(c) ){

                        if(map.get(c).intValue() == dmap.get(c).intValue() && formed==required){



                            if(j-i+1<ans){
                                ans = j-i+1;
                                result = s.substring(i,j+1);

                            }
                            formed--;

                        }

                        map.put(c, map.get(c)-1);

                    }
                    i++;
                }


            }

            j++;
        }
        return result;
    }
}