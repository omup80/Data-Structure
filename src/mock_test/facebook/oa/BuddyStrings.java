package mock_test.facebook.oa;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/buddy-strings/
class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length())
            return false;
        Integer firstChange=null;
        Integer secondChange=null;
        boolean isSame=false;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<A.length();i++){
            if(A.charAt(i) != B.charAt(i)){
                if(firstChange==null){
                    firstChange=i;
                }else if(secondChange==null){
                    secondChange=i;
                }else{
                    return false;
                }
            }else{
                int cnt = map.getOrDefault(A.charAt(i), 0);
                cnt++;
                if(cnt==2)
                    isSame = true;
                map.put(A.charAt(i), cnt);
            }
        }
        if(firstChange==null && secondChange==null && isSame)
            return true;
        if(firstChange==null || secondChange==null)
            return false;
        if(A.charAt(firstChange)==B.charAt(secondChange) && A.charAt(secondChange)==B.charAt(firstChange))
          return true;
        return false;
    
    }
}