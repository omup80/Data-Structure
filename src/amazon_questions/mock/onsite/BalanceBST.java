package amazon_questions.mock.onsite;

import amazon_questions.trees_and_graph.TreeNode;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/balance-a-binary-search-tree/submissions/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BalanceBST {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> nodes = new ArrayList();
        createList(nodes, root);
        return createBST(nodes, 0, nodes.size()-1);
    }
    private TreeNode createBST(List<TreeNode> nodes, int left, int right){
        if(left>right)
            return null;
        int mid = left+(right-left)/2;
        TreeNode root = nodes.get(mid);
        root.left = createBST(nodes, left, mid-1);
        root.right = createBST(nodes, mid+1, right);
        return root;
        
    }
    private void createList(List<TreeNode>  nodes, TreeNode root){
        if(root==null)
            return;
        createList(nodes, root.left);
        nodes.add(root);
        createList(nodes,root.right);
    }
}