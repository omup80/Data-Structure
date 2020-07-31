package amazon_questions.trees_and_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
class BinaryMaxPathSum {
    
    List<List<Integer>> zigzagTraversal = new ArrayList<List<Integer>>();
    Stack<TreeNode> level = new Stack<TreeNode>();
    Stack<TreeNode> anotherLevel = new Stack<TreeNode>();
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    
    if(root == null)
        return zigzagTraversal;
    level.push(root);
        
     while(!level.isEmpty() || !anotherLevel.isEmpty()){
        
         
         if(!level.isEmpty()){
               
             fillLevelFromLeft(true);                               
         
         }else if(!anotherLevel.isEmpty()){
             
             fillLevelFromLeft(false);
         }
         
         
         
     }   
        
        
     return zigzagTraversal;
    }
    
    public void fillLevelFromLeft(boolean isLeft){
    
    List<Integer> traversal = new ArrayList<Integer>();
    Stack<TreeNode> l = isLeft ? level : anotherLevel;
    while(!l.isEmpty()){
            
        TreeNode node = l.pop();
        traversal.add(node.val);
        
        if(isLeft){
             
            if(node.left!=null)
                anotherLevel.push(node.left);
            if(node.right!=null)
                anotherLevel.push(node.right);
                
          }else{
                
             if(node.right!=null)
                    level.push(node.right);
              if(node.left!=null)
                    level.push(node.left);
            
            }
        }
        
        zigzagTraversal.add(traversal);
        
    }
    
}