package amazon_questions.mock.onsite;

import amazon_questions.trees_and_graph.TreeNode;

class MaxPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        helper(root);
        return max;
        
        
    }
    
    private Integer helper(TreeNode root){
        
        if(root==null)
            return Integer.MIN_VALUE;
        
        int leftMaxSum= helper(root.left);
        int rightMaxSum = helper(root.right);
        max = Math.max(max, root.val);
        
        int localMaxSum=Integer.MIN_VALUE;
        if(leftMaxSum!=Integer.MIN_VALUE){
            max = Math.max(max, leftMaxSum+root.val);
            localMaxSum = Math.max(localMaxSum, leftMaxSum+root.val);
        }
            
        
        
        if(rightMaxSum != Integer.MIN_VALUE){
            max = Math.max(max, rightMaxSum+root.val);
            localMaxSum = Math.max(localMaxSum, rightMaxSum+root.val);
        }

            
        
        if(leftMaxSum!=Integer.MIN_VALUE && rightMaxSum != Integer.MIN_VALUE){
            max = Math.max(max, leftMaxSum+rightMaxSum+root.val);
        }
        
        
        return Math.max(root.val, localMaxSum);
        
        
        
    }
    
    
}