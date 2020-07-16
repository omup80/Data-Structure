package practise.trees;
/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7


return its depth = 3.
 */

/*
Complexity analysis

Time complexity : we visit each node exactly once, thus the time complexity is {O}O(N), where N is the number of nodes.

Space complexity : in the worst case, the tree is completely unbalanced, e.g. each node has only left child node,
the recursion call would occur N times (the height of the tree), therefore the storage to keep the call stack would be
 {O}(N). But in the best case (the tree is completely balanced), the height of the tree would be log(N). Therefore,
 the space complexity in this case would be O(log(N)).
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return depth(root);


    }

    private int depth(TreeNode root){
        if(root.left == null && root.right == null){
            return 1;
        }


        int leftDepth=0;
        if(root.left!=null)
            leftDepth= depth(root.left);

        int rightDepth=0;
        if(root.right!=null)
            rightDepth = depth(root.right);

        return Math.max(leftDepth, rightDepth)+1;

    }

}
