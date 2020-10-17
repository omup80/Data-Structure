package amazon_questions.mock.telephonic_interview;

import amazon_questions.trees_and_graph.TreeNode;

class SumEvenGrandParent {
    int sum=0;
    public int sumEvenGrandparent(TreeNode root) {
        if(root==null)
            return sum;
        sumEven(root.left, root.val%2==0);
        sumEven(root.right, root.val%2==0);    
            
       return sum;     
    }
    
    private void sumEven(TreeNode root, boolean isEven){
        if(root==null)
            return;
        
        if(root.left!=null){
           sum = isEven? root.left.val+sum:sum;
           sumEven(root.left, root.val%2==0); 
        }
        
        
        if(root.right!=null){
           sum = isEven? root.right.val+sum:sum;
           sumEven(root.right, root.val%2==0); 
        }
    }
}