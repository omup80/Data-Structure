package mock_test.facebook.oa;


import java.util.*;

// This is the interface that allows for creating nested lists.
 // You should not implement it, or speculate about its implementation
interface NestedInteger {
     // Constructor initializes an empty nested list.
      //public NestedInteger();

      // Constructor initializes a single integer.
     // public NestedInteger(int value);

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // Set this NestedInteger to hold a single integer.
      public void setInteger(int value);

      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
      public void add(NestedInteger ni);

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return empty list if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }
class NestedSum {
    Map<Integer, List<Integer>> map = new HashMap();
    public int depthSumInverse(List<NestedInteger> nestedList) {
       fillMap(nestedList, 1);
       Map<Integer, List<Integer>> m = map;
       int totalLevel =findMaxLevel(map.keySet());
       int sum=0;
       for(Map.Entry<Integer, List<Integer> > e: map.entrySet()){
           int currentLevel = e.getKey();
           int weight = totalLevel - currentLevel + 1;
           List<Integer> level = e.getValue();
           for(Integer val: level)
               sum += weight*val;
       } 
       return sum; 
        
    }
    public int findMaxLevel(Set<Integer> values){
        int max = Integer.MIN_VALUE;
        for(Integer val: values)
            max = Math.max(max, val);
        return max;
    }
    public void fillMap(List<NestedInteger> nestedList, int level){
        for(NestedInteger ni: nestedList){
            if(ni.isInteger()){
                List<Integer> levelElements = map.getOrDefault(level, new ArrayList<Integer>());
                levelElements.add(ni.getInteger());
                map.put(level, levelElements);
            }else{
                fillMap(ni.getList(), level+1);
            }
        }
    }
    
    
}