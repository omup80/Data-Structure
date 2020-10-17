package amazon_questions.mock.telephonic_interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class FreqStack {
    Map<Integer, Stack<Integer>> group;
    Map<Integer, Integer> count;
    int maxFreq=0;
    public FreqStack() {
        count = new HashMap();
        group = new HashMap();
    }
    
    public void push(int x) {
        int freq =  count.getOrDefault(x,0)+1;
        count.put(x, freq);
        Stack st = group.getOrDefault(freq, new Stack<Integer>());
        st.push(x);
        group.put(freq, st);
        maxFreq = Math.max(maxFreq, freq);
        
    }
    
    public int pop() {
        Stack<Integer> st = group.get(maxFreq);
        int x = st.pop();
        count.put(x, count.get(x)-1);
        if(count.get(x)==0)
            count.remove(x);
        if(st.isEmpty()){
            group.remove(maxFreq);
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