package amazon_questions.mock.telephonic_interview;

import amazon_questions.trees_and_graph.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BoundaryOfBinaryTree {
        
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
       List<Integer> result = new ArrayList();
        
       if(root==null)
           return result;
       
       if(!leaf(root))
           result.add(root.val);
       TreeNode ptr = root.left;
       while(ptr!=null){
          if(!leaf(ptr)) 
                result.add(ptr.val);
           
           if(ptr.left!=null)
               ptr = ptr.left;
           else
               ptr = ptr.right;
       }
        
       leafNodes(root, result);
        
       Stack<Integer> st = new Stack<Integer>();
       if(root.right==null)
           return result;
        ptr = root.right;
       while(ptr!=null){
           if(!leaf(ptr))
                st.push(ptr.val);
           if(ptr.right!=null)
               ptr = ptr.right;
           else
               ptr = ptr.left;
       }
       
      while(!st.isEmpty()){
          result.add(st.pop());
      }  
       
        return result;
     }
    
    private boolean leaf(TreeNode root){
        if(root.left==null && root.right==null)
            return true;
        
        return false;
    }
    
    private void leafNodes(TreeNode root, List<Integer> result){
        if(leaf(root))
            result.add(root.val);
        if(root.left!=null)
            leafNodes(root.left, result);
        if(root.right!=null)
            leafNodes(root.right, result);
    }
}