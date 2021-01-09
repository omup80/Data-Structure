package top_questions.hard.trees;

import amazon_questions.trees_and_graph.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
class LowestCommonAncenstor {
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return result;
        
        
    }
    
    public int find(TreeNode root, TreeNode p, TreeNode q){
        
        if(root==null)
            return 0;
        int left = find(root.left, p, q);
        int right = find(root.right, p, q);
        int mid=root.val==p.val || root.val==q.val?1:0;
        if(left+right+mid>=2)
            result=root;
        
        
        return left+right+mid>=2?0:left+right+mid;
        
        
    }
}