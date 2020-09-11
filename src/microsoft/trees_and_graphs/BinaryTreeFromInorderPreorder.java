package microsoft.trees_and_graphs;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/
//105. Construct Binary Tree from Preorder and Inorder Traversal


class BinaryTreeFromInorderPreorder {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int[] preorder;
    int[] inorder;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        this.preorder = preorder;
        this.inorder = inorder;
        return helper(0, inorder.length);
   }
    
  private TreeNode helper(int i_left, int i_right){
      if(i_left==i_right)
          return null;
      
      TreeNode root = new TreeNode(preorder[idx]);
      int index = map.get(preorder[idx]);
      idx++;
      
      root.left = helper(i_left, index);
      root.right = helper(index+1, i_right);
      return root;
  }  
}