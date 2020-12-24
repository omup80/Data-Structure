package top_questions.medium.tree_and_graph;

import amazon_questions.trees_and_graph.TreeNode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
class TreeFromInorderPreorder {
    int[] preorder;
    int idx=0;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i], i);
        this.preorder=preorder;
        return helper(0, preorder.length-1);
    }
    
    private TreeNode helper(int i, int j){
      if(i>j || idx==preorder.length)
          return null;
        

        TreeNode root = new TreeNode(preorder[idx]);
        int index = map.get(preorder[idx]);
        idx++;
        root.left = helper(i, index-1);
        root.right = helper(index+1, j);
        
        return root;
    }
}