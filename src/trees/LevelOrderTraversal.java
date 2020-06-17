package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
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


/*
Complexity Analysis

Time complexity : {O}(N) since each node is processed exactly once.

Space complexity : {O}(N) to keep the output structure which contains N node values.


Since each node in the tree will be pushed into the queue exactly once, the time complexity for level-order traversal is O(N),
 where N is the total number of nodes in the tree.

What about the space complexity? We have to maintain a queue to help us to do the traversal.
And the size of the queue will be at most N because each node will be pushed into the queue exactly once.
Therefore, the space complexity of level-order traversal is also O(N).
 */
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> output = new LinkedList<List<Integer>>();

        if(root == null)
            return output;


        Queue<TreeNode> nodesQueue = new LinkedList<TreeNode>();
        nodesQueue.add(root);

        while(!nodesQueue.isEmpty()){
            List<Integer> currentLevel = new LinkedList<Integer>();
            int size =   nodesQueue.size();
            for(int i=0;i<size;i++){
                TreeNode node = nodesQueue.remove();
                currentLevel.add(node.val);
                if(node.left!=null){
                    nodesQueue.add(node.left);

                }
                if(node.right != null){
                    nodesQueue.add(node.right);
                }

            }

            output.add(currentLevel);
        }



        return output;

    }


}
