package amazon_questions.trees_and_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

 */
class LevelTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
    List<List<Integer>> orderTraversal = new ArrayList<List<Integer>>();
    
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    
    if(root == null)
        return orderTraversal;
        
     q.add(root);
    List<Integer> level;
     while(!q.isEmpty()){
         int nextLevelIndex = q.size();
         int i=0;
         
         level = new ArrayList<Integer>();
         while(i<nextLevelIndex){
             
             TreeNode node = q.remove();
             level.add(node.val);
             
             if(node.left != null)
                 q.add(node.left);
             
             if(node.right != null)
                 q.add(node.right);
             
              i++;
         }
         if(level.size() > 0)
             orderTraversal.add(level);
         
     }   
     return orderTraversal;
}
    
 
}