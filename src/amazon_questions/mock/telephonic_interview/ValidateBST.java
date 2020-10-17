package amazon_questions.mock.telephonic_interview;

import amazon_questions.trees_and_graph.TreeNode;

class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode root, Integer lowerLimit, Integer higherLimit){
        if(root==null)
            return true;
        if(lowerLimit!=null && root.val<=lowerLimit)
            return false;
        if(higherLimit!=null && root.val>=higherLimit)
            return false;
        
        return helper(root.left,lowerLimit,root.val) && helper(root.right, root.val, higherLimit);
    }
}