package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
/*

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
 */


/*
Complexity Analysis

Time complexity : we visit each node exactly once, thus the time complexity is {O}(N), where N is the number of nodes,
 i.e. the size of tree.

Space complexity : depending on the tree structure, we could keep up to the entire tree, therefore,
the space complexity is {O}(N).
 */
public class PostOrder {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> postorderTraversal = new LinkedList<Integer>();
        Stack<TreeNode> postorder = new Stack<TreeNode>();

        if(root==null)
            return postorderTraversal;

        postorder.push(root);

        while(!postorder.isEmpty()){
            TreeNode node = postorder.pop();
            postorderTraversal.addFirst(node.val);
            if(node.left != null){
                postorder.push(node.left);
            }

            if(node.right != null){
                postorder.push(node.right);
            }
        }
        return postorderTraversal;


    }
}
