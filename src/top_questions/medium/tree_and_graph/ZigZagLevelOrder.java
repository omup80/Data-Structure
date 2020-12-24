package top_questions.medium.tree_and_graph;

import amazon_questions.trees_and_graph.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> lr = new Stack<TreeNode>();
        Stack<TreeNode> rl = new Stack<TreeNode>();
        List<List<Integer>> result = new ArrayList();
        if(root==null)
            return result;
        rl.push(root);
        
        while(!rl.isEmpty() || !lr.isEmpty()){
            List<Integer> ans = new ArrayList();
            if(!rl.isEmpty()){
                while(!rl.isEmpty()){
                    TreeNode cur = rl.pop();
                    ans.add(cur.val);
                    if(cur.left!=null)
                        lr.push(cur.left);
                    if(cur.right!=null)
                        lr.push(cur.right);
                        
                }
            }else{
                while(!lr.isEmpty()){
                    TreeNode cur = lr.pop();
                    ans.add(cur.val);
                    if(cur.right!=null)
                        rl.push(cur.right);
                    if(cur.left!=null)
                        rl.push(cur.left);
                        
                }
            }
            
            result.add(ans);
        }
        return result;
    }
}