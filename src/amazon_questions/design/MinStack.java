package amazon_questions.design;

import java.util.Stack;
/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.


Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 */
class MinStack {
        
    /** initialize your data structure here. */
    Stack<Integer> stack = new Stack<Integer>();
    Stack<int[]> min_stack = new Stack<int[]>();
    public MinStack() {
        
    }
    
    public void push(int x) {
        stack.push(x);
        if(min_stack.isEmpty() || x < min_stack.peek()[0]){
            min_stack.push(new int[]{x,1});
        }else{
            int[] min = min_stack.pop();
            min[1] = min[1]+1;
            min_stack.push(min);
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            int[] min = min_stack.pop();
            if(min[1]>1){
                min[1] = min[1]-1;
                min_stack.push(min);
            }
        }
        
        
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek()[0];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */