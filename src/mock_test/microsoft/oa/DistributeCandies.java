package mock_test.microsoft.oa;

import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/distribute-candies/
class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<Integer>();
        for(int candy:candyType)
            if(!set.contains(candy))
                set.add(candy);
        
        return Math.min(set.size(), candyType.length/2);
    }
}