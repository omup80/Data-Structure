package top_questions.hard.trees;

import amazon_questions.trees_and_graph.TreeNode;

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
//
class MaxPathSum {
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return ans;
    }
    
    public int maxPath(TreeNode root){
        int max;
        if(root.left==null && root.right==null){
            max = root.val;
            ans = Math.max(ans, max);
        }else if(root.left==null){
            int right = maxPath(root.right);
            max = Math.max(root.val, right+root.val);
            ans =Math.max(ans, max);
        }else if(root.right==null){
            int left = maxPath(root.left);
            max = Math.max(root.val, left+root.val);
            ans = Math.max(max, ans);
        }else{
            int left = maxPath(root.right);
            int right = maxPath(root.left);
            max = Math.max(left, right);
            ans = Math.max(ans, root.val+ Math.max(max, left+right));
            max = max+root.val;   
        }
        
        
        return max<0?0:max;
    }
}