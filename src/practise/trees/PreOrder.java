package practise.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
Given a binary tree, return the preorder traversal of its nodes' values.
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]

 */

/*
Complexity Analysis

Time complexity : we visit each predecessor exactly twice descending down from the node,
thus the time complexity is O(N), where NN is the number of nodes, i.e. the size of tree.

Space complexity : we use no additional memory for the computation itself,
but output list contains NN elements, and thus space complexity is O(N).

 */
public class PreOrder {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> preorderTraversal = new ArrayList<Integer>();
        Stack<TreeNode> preorder = new Stack<TreeNode>();


        if(root==null)
            return preorderTraversal;

        preorder.add(root);
        while(!preorder.isEmpty()){
            TreeNode node = preorder.pop();
            preorderTraversal.add(node.val);

            if(node.right != null)
                preorder.add(node.right);


            if(node.left != null)
                preorder.add(node.left);






        }

        return preorderTraversal;


    }
}
