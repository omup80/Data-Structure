package amazon_questions.mock.onsite;

import amazon_questions.trees_and_graph.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList();
        createArray(root, inorder);
        int i=0;
        int j=inorder.size()-1;
        
        while(i<j){
            if(inorder.get(i)+inorder.get(j)>k)
                j--;
            else if(inorder.get(i)+inorder.get(j)<k)
                i++;
            else 
                return true;
        }
        
        return false;
            
    }
    
    
    private void createArray(TreeNode root, List<Integer> inorder){
        if(root==null)
            return ;
        createArray(root.left, inorder);
        inorder.add(root.val);
        createArray(root.right, inorder);
    }
}