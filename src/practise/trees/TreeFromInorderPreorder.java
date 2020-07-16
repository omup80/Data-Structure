package practise.trees;

import java.util.HashMap;
/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */
public class TreeFromInorderPreorder {
    private int[] inorder;
    private int[] preorder;
    private HashMap<Integer, Integer> inorderIndexes = new HashMap<Integer, Integer>();
    private int preOrderCurrentIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        for(int i=0;i<inorder.length;i++){
            inorderIndexes.put(inorder[i],i);
        }
        preOrderCurrentIndex = 0;
        return createTree(0, inorder.length-1);

    }

    private TreeNode createTree(int startIndex, int endIndex){
        if(startIndex > endIndex)
            return null;

        int rootValue = preorder[preOrderCurrentIndex];
        TreeNode root = new TreeNode(rootValue);

        int rootIndexInInorder = inorderIndexes.get(rootValue);

        preOrderCurrentIndex++;

        root.left = createTree(startIndex, rootIndexInInorder - 1);
        root.right = createTree(rootIndexInInorder+1, endIndex);


        return root;
    }
}
