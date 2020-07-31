package amazon_questions.trees_and_graph;

class MaxPathSum {
    int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    
    private int maxGain(TreeNode root){
        if(root==null)
            return 0;
        
        int leftGain = Math.max(maxGain(root.left),0);
        int rightGain = Math.max(maxGain(root.right), 0);
        
        int localMaxSum = leftGain + rightGain + root.val;
        maxSum = Math.max(maxSum, localMaxSum);
        
        return root.val + Math.max(leftGain, rightGain);    
    }
}