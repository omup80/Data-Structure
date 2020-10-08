package amazon_questions.mock.oa;

import amazon_questions.trees_and_graph.TreeNode;

import java.util.HashSet;
import java.util.Set;

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
class FindTarget {
    Set<Integer> set = new HashSet();
    
    public boolean findTarget(TreeNode root, int k) {
        return inorder(root, k);    
    }
    
    private boolean inorder(TreeNode root, int k){
        
      if(set.contains(root.val))
          return true;
      
      set.add(k-root.val);
    
      boolean left = root.left==null?false:inorder(root.left, k);
      boolean right = root.right==null?false:inorder(root.right, k);
     
    return left||right;
    }
}