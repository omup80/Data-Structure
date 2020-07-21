package amazon_questions.trees_and_graph;

import java.util.LinkedList;
import java.util.Queue;
/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

        For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

         1
        / \
       2   2
      / \ / \
     3  4 4  3


        But the following [1,2,2,null,3,null,3] is not:

         1
        / \
        2   2
        \   \
        3    3


 */
class SymmetricTree {

    public boolean isSymmetricIterative(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    public boolean isSymmetricRecursive(TreeNode root) {
       
        if(root ==null)
            return true;
        
        return isMirror(root.left, root.right);
        
        
    }
    
    boolean isMirror(TreeNode leftTree, TreeNode rightTree){
        if(leftTree==null && rightTree==null)
            return true;
        
        if(leftTree==null || rightTree==null)
            return false;
        
        
        return leftTree.val == rightTree.val 
            && isMirror(leftTree.left, rightTree.right) && isMirror(leftTree.right, rightTree.left);
        
        
    }
    
    
       

}