package amazon_questions.mock.oa;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=-1;
        for(int candy: candies){
            max = Math.max(candy, max);
        }
        List<Boolean> result = new ArrayList();
        
        for(int candy: candies){
            result.add(candy+extraCandies>=max?true:false);
        }
        
        return result;
    }
}