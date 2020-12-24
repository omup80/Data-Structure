package top_questions.medium.tree_and_graph;


import amazon_questions.trees_and_graph.TreeNode;
//https://leetcode.com/problems/inorder-successor-in-bst/submissions/
class InorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode result=null;
        
        while(root!=null){
            if(root.val > p.val){
                result = root;
                root = root.left;
            }else{
                root = root.right;
            }
            
        }
        return result;
    }
}