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

class TwoSumBST {
    Set<Integer> set = new HashSet();
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        createSet(root1, target);
            Set<Integer> s = set;
        return search(root2);
    }
    
    private boolean search(TreeNode root){
        
        boolean left=false;
        boolean right=false;
        if(set.contains(root.val))
            return true;
        
        if(root.left!=null)
            left= search(root.left);
        
        if(root.right!=null)
            right= search(root.right);
        return left||right;
            
    }
    private void createSet(TreeNode root, int target){
        if(root==null)
            return;
        set.add(target-root.val);
        createSet(root.left, target);
        createSet(root.right, target);
    }
    
   
    
    
}
