package top_questions.medium.tree_and_graph;

import amazon_questions.trees_and_graph.TreeNode;

import java.util.Stack;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
class KthSmallestElement {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            k--;
            root = st.pop();
            if(k==0)
                return root.val;
            root = root.right;
        }
        return 0;
    }
}