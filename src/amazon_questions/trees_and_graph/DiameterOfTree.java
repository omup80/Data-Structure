package amazon_questions.trees_and_graph;

/**
 iven a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

 Example:
 Given a binary tree
     1
    / \
   2   3
  / \
 4   5
 Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 */
class DiameterOfTree {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        findHeight(root);
        return diameter;
    }
    
    int findHeight(TreeNode root){
      if(root==null)
          return 0;
      int leftDepth = findHeight(root.left);
      int rightDepth = findHeight(root.right);
      int currentDiamter = leftDepth+ rightDepth;
      
      if(diameter < currentDiamter)
          diameter = currentDiamter;
        
      return Math.max(leftDepth, rightDepth)+1;
        
        
    }
}