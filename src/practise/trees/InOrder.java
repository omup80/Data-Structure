package practise.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
Given a binary tree, return the inorder traversal of its nodes' values.

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]


 */

/*
Complexity Analysis

Time complexity : O(n).

Space complexity : O(n).
 */
public class InOrder {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> inOrderTraversal = new ArrayList<Integer>();
        Stack<TreeNode> inOrder = new Stack<TreeNode>();


        if(root==null)
            return inOrderTraversal;

        while(root!=null || !inOrder.isEmpty()){
            while(root!=null){
                inOrder.push(root);
                root = root.left;
            }

            root = inOrder.pop();
            inOrderTraversal.add(root.val);
            root = root.right;


        }

        return inOrderTraversal;


    }

}
