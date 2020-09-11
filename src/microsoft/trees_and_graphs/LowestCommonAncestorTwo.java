package microsoft.trees_and_graphs;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/
//236. Lowest Common Ancestor of a Binary Tree
class LowestCommonAncestorTwo {
    TreeNode ancestor=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
         dfs(root, p, q);
        return ancestor;
        
    }
    
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q){
            
        if(root==null)
            return false;
        
        int left = dfs(root.left,p,q)?1:0;
        int right = dfs(root.right,p, q)?1:0;
        
        int mid = (root==q|| root==p)?1:0;
        
        if(left+right+mid>=2){
            if(ancestor==null)
                ancestor = root;
        }
        
        return mid+left+right>0;
    
    }
}