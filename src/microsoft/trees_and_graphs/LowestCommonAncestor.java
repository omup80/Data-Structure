package microsoft.trees_and_graphs;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
//235. Lowest Common Ancestor of a Binary Search Tree
class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val)
            return lowestCommonAncestor(root, q, p);
        if(p.val==root.val || q.val==root.val)
            return root;
        if(p.val < root.val && q.val > root.val)
            return root;
        
        if(p.val< root.val && q.val<root.val)
            return lowestCommonAncestor(root.left, p, q);
        
        if(p.val> root.val && q.val>root.val)
            return lowestCommonAncestor(root.right, p, q);
        
        return null;
    }
}