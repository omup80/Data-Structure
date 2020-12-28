package top_questions.medium.design;

import java.util.*;
//https://leetcode.com/problems/insert-delete-getrandom-o1/
class RandomizedSet {

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    List<Integer> arr;
    
    Random r = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        arr = new ArrayList<Integer>();
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        
        
        map.put(val, arr.size());
        arr.add(val);
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        
        int index = map.get(val);
        int temp = arr.get(arr.size()-1);
        
        arr.set(index, temp);
        map.put(temp, index);
        
        arr.remove(arr.size()-1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        //Random r = new Random();
        return arr.get(r.nextInt(arr.size()));
    }
    
   
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */