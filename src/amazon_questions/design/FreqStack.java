package amazon_questions.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/maximum-frequency-stack/submissions/
//895. Maximum Frequency Stack
class FreqStack {
    private Map<Integer, Integer> freq;
    private Map<Integer, Stack<Integer>> group;
    private int maxFreq;
    public FreqStack() {
        freq = new HashMap<Integer, Integer>();
         group = new HashMap<Integer, Stack<Integer>>();
    }
    
    public void push(int x) {
        int f = freq.getOrDefault(x,0)+1;
        freq.put(x, f);
        
        if(f>maxFreq){
            maxFreq = f;
        }
        
        
        Stack<Integer> stack = group.getOrDefault(f, new Stack<Integer>());
        
        stack.push(x);
        group.put(f, stack);
    }
    
    public int pop() {
        Stack<Integer> stack = group.get(maxFreq);
        int x = stack.pop();
        freq.put(x, freq.get(x)-1);
        if(stack.size()==0){
            maxFreq--;
        }
        
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */