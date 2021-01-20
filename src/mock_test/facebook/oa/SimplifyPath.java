package mock_test.facebook.oa;

import java.util.Stack;
//https://leetcode.com/problems/simplify-path/
class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] paths = path.split("/");
        for(String p: paths){
            if(".".equals(p) || p.isEmpty()){
                continue;
            }else if("..".equals(p)){
                if(!stack.isEmpty())
                    stack.pop();
            }else{
                stack.push(p);
            }
                
        }
        
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        return result.length() > 0 ? result.toString() : "/" ;
    }
}