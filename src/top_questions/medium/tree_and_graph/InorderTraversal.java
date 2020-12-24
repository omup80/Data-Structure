package top_questions.medium.tree_and_graph;


import amazon_questions.trees_and_graph.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//https://leetcode.com/problems/binary-tree-inorder-traversal/
class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode cur=root;
        Stack<TreeNode> st = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        
        while(cur!=null || !st.isEmpty()){
            while(cur!=null){
                st.push(cur);
                cur=cur.left;
            }
            cur = st.pop();
            result.add(cur.val);
            cur = cur.right;
            
            
        }
        
        return result;
    }
}