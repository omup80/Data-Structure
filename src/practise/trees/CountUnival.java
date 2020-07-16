package practise.trees;
/*
Given a binary tree, count the number of uni-value subtrees.
Given a node in our tree, we know that it is a univalue subtree if it meets one of the following criteria:
The node has no children (base case)
All of the node's children are univalue subtrees, and the node and its children all have the same value

A Uni-value subtree means all nodes of the subtree have the same value.
Input:  root = [5,1,5,5,5,null,5]

              5
             / \
            1   5
           / \   \
          5   5   5

Output: 4(all leaf 3-5,5,5,  5
                          \
                           5
)
 */

/*
Complexity Analysis

Time complexity : O(n)O(n).

Due to the algorithm's depth-first nature, the isUnival status of each node is computed from bottom up.
When given the isUnival status of its children, computing the isUnival status of a node occurs in O(1)

This gives us O(1) time for each node in the tree with O(N) total nodes for a time complexity of O(N)

Space complexity : O(H), with H being the height of the tree.
Each recursive call of isUnival requires stack space. Since we fully process is_uni(node.left) before calling is_uni(node.right),
the recursive stack is bound by the longest path from the root to a leaf - in other words the height of the tree.
 */
public class CountUnival {
    private int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root!=null)
            isUnival(root);

        return count;
    }

    private boolean isUnival(TreeNode root){


        if(root.left==null && root.right == null){
            count = count + 1;
            return true;
        }

        if(root.left == null && isUnival(root.right) && root.right.val == root.val){
            count = count + 1;
            return true;
        }

        if(root.right == null && isUnival(root.left) && root.left.val == root.val ){
            count = count + 1;
            return true;
        }

        boolean rightUnival = false;
        if(root.left != null && root.right!=null && isUnival(root.right) && root.right.val == root.val){
            rightUnival = true;
        }

        boolean leftUnival = false;
        if(root.right != null & root.left!=null && isUnival(root.left) && root.left.val == root.val ){
            leftUnival = true;
        }


        if(leftUnival && rightUnival){
            count = count + 1;
            return true;
        }

        return false;
    }
}
