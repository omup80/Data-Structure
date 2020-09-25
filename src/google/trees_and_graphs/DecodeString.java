package google.trees_and_graphs;

import java.util.Stack;
//https://leetcode.com/problems/decode-string/
//394. Decode String

class DecodeString {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<Character>();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=']'){
                st.push(s.charAt(i));
            }else{
                StringBuilder p = new StringBuilder();
                while(st.peek()!='['){
                    p.insert(0, st.pop());
                }
                st.pop();
                StringBuilder times = new StringBuilder();
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    times.insert(0, st.pop());
                }
                
                int l = p.length();
                for(int k=0;k<Integer.parseInt(times.toString())-1;k++){
                    for(int j=0;j<l;j++){
                        p.append(p.charAt(j));
                    }
                }
                
                for(int j=0;j<p.length();j++){
                    st.push(p.charAt(j));
                }
            }
                
            
        }
        
       StringBuilder result = new StringBuilder();
        
        while(!st.isEmpty()){
            result.insert(0, st.pop());
        }
        return result.toString();
    }
}