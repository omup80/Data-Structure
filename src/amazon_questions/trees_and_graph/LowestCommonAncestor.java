package amazon_questions.trees_and_graph;

/*

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]




Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.findHeight
 */

class LowestCommonAncestor {
    
    private TreeNode commonAncenstor;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfsSearchNode(root, p, q);
        return this.commonAncenstor;
        
    }
    
    private boolean dfsSearchNode(TreeNode root, TreeNode p, TreeNode q){
        
        if(root==null)
            return false;
        
        boolean left = dfsSearchNode(root.left,  p, q);
        int leftR = left?1:0;
        
        boolean right = dfsSearchNode(root.right, p, q);
        int rightR = right?1:0;
        
        
        int mid = (root==p || root == q) ? 1 : 0;
        
        if(leftR+rightR+ mid>=2)
            this.commonAncenstor = root;
        
        return leftR+mid+rightR>0;
    }
}