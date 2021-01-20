package mock_test.facebook.oa;

import amazon_questions.trees_and_graph.TreeNode;
//https://leetcode.com/problems/closest-binary-search-tree-value/
class Solution {
    Double diff = null;
    int ans;
    public int closestValue(TreeNode root, double target) {
       search(root, target);
        return ans;
    }
    private void search(TreeNode root, double target){
        if(diff== null || Math.abs(root.val-target) < diff){
            diff = Math.abs( root.val-target ) ;
            ans = root.val;
        }
            
        if(root.right!=null)
            search(root.right, target);
        
        if(root.left!=null)
            search(root.left, target);
    }
    
}