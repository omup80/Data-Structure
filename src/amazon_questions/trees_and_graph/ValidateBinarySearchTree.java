package amazon_questions.trees_and_graph;



class ValidateBinarySearchTree {
    
    
    public boolean isValidBST(TreeNode root) {
        
       return helper(root, null, null);
        
    }
    
    public boolean helper(TreeNode root, Integer lowerBound, Integer upperBound){
        
         if(root==null)
             return true;
        
         if(lowerBound!=null && root.val <= lowerBound)
             return false;
        
         if(upperBound!=null && root.val >= upperBound)
             return false;
         
         return helper(root.left, lowerBound , root.val) && helper(root.right, root.val, upperBound);
           
        
    }
    
         
           
        
    
            
    
}