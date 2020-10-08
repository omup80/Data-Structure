package amazon_questions.mock.oa;

import amazon_questions.trees_and_graph.TreeNode;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/subtree-of-another-tree/submissions/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CompareSubTree {
    List<TreeNode> matchingNodes = new ArrayList<TreeNode>();
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
       search(s, t.val);
        
       
      for(TreeNode node: matchingNodes){
          if(compare(node, t))
              return true;
      }  
      return false;
    }
    
    boolean compare(TreeNode s, TreeNode t){
        if(s==t)
            return true;
        if(s==null || t==null)
            return false;
        if(s.val!=t.val)
            return false;
        
        return compare(s.left, t.left) && compare(s.right, t.right);
    }
    private void search(TreeNode s, int val){
        if(s.val==val)
            matchingNodes.add(s);
        
        if(s.left!=null){
          search(s.left, val);
          
            
        }
          
        
        if(s.right!=null){
           search(s.right, val);
           
        }
       
        
    }
}