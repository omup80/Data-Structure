package practise.trees;


/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along
 the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1


return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

/*
Complexity Analysis

Time complexity : we visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes.
Space complexity : in the worst case, the tree is completely unbalanced, e.g. each node has only one child node, the recursion call would
occur N times (the height of the tree), therefore the storage to keep the call stack would be {O}(N).
But in the best case (the tree is completely balanced), the height of the tree would be log(N).
 Therefore, the space complexity in this case would be O(log(N)).
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;

        sum = sum - root.val;

        if(sum==0 && root.left==null && root.right==null)
            return true;

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);


    }
}
