package practise.trees;

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
/*
Complexity Analysis

Time complexity : O(n). Because we traverse the entire input tree once,
the total run time is O(n), where nn is the total number of nodes in the tree.

Space complexity : The number of recursive calls is bound by the height of the tree.
In the worst case, the tree is linear and the height is in O(n). Therefore, space complexity due to
recursive calls on the stack is O(n) in the worst case.
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isMirror(root.left, root.right);

    }

    private boolean isMirror(TreeNode leftTree, TreeNode rightTree){
        if(leftTree == null && rightTree == null)
            return true;

        if( leftTree==null || rightTree==null ||(leftTree.val != rightTree.val) )
            return false;

        return isMirror(leftTree.left, rightTree.right) && isMirror(leftTree.right, rightTree.left);

    }

    public boolean isSymmetricIterative(TreeNode root) {
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
}
