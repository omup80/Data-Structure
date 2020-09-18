package google.others;

import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/jewels-and-stones/
//771. Jewels and Stones
class JewelInStone {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewel = new HashSet<Character>();
        
        for(int i=0;i<J.length();i++){
            jewel.add(J.charAt(i));
        }
        int numJewel=0;
        for(int i=0;i<S.length();i++){
            if(jewel.contains(S.charAt(i)))
                numJewel++;
        }
        
        return numJewel;
    }
}