package trees;

import java.util.ArrayList;
import java.util.List;
/*
As we mentioned before, we can traverse a tree recursively to retrieve all the data in pre-order, in-order or post-order.
 The time complexity is O(N) because we visit each node exactly once. And the depth of the tree might be N in the worst case.
 That is to say, the level of recursion might be at most N in the worst case. Therefore, taking system stack into consideration,
 the space complexity is O(N) as well.

To be cautious, the complexity might be different due to a different implementation.
It is comparatively easy to do traversal recursively but when the depth of the tree is too large,
we might suffer from stack overflow problem. That's one of the main reasons why we want to solve this problem iteratively sometimes.

For the iterative solution, the time complexity is apparently the same with recursion solution which is O(N).
 The space complexity is also O(N) since in the worst case, we will have all the nodes in the stack.
 There are some other solutions for iterative traversal which can reduce the space complexity to O(1).
 */
public class RecursiveInPostPreTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        preorderTraversal(root, answer);
        return answer;
    }

    private void preorderTraversal(TreeNode root, List<Integer> answer) {
        if (root == null) {
            return;
        }
        answer.add(root.val);                   // visit the root
        preorderTraversal(root.left, answer);   // traverse left subtree
        preorderTraversal(root.right, answer);  // traverse right subtree
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        inorderTraversal(root, answer);
        return answer;
    }

    private void inorderTraversal(TreeNode root, List<Integer> answer) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, answer);   // traverse left subtree
        answer.add(root.val);                  // visit the root
        inorderTraversal(root.right, answer);  // traverse right subtree
    }

    private void postorderTraversal(TreeNode root, List<Integer> answer) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, answer);   // traverse left subtree
        postorderTraversal(root.right, answer);  // traverse right subtree
        answer.add(root.val);                    // visit the root
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        postorderTraversal(root, answer);
        return answer;
    }

}
