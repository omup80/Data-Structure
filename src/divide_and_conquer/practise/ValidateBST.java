package divide_and_conquer.practise;
/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {


        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer lowerBound, Integer upperBound){
        if(root == null)
            return true;

        if(lowerBound!=null && root.val<=lowerBound)
            return false;

        if(upperBound!=null && root.val >= upperBound)
            return false;

        return helper(root.left, lowerBound, root.val) && helper(root.right, root.val, upperBound);
    }
}



class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
