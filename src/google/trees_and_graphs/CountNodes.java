package google.trees_and_graphs;


//https://leetcode.com/problems/count-complete-tree-nodes/submissions/
//222. Count Complete Tree Nodes
class CountNodes {
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        int d = findDepth(root);
        if(d==0)
            return 1;
        
        int left = 1;
        int right = (int) Math.pow(2, d)-1;
        while(left<=right){
            int pivot = left+ (right-left)/2;
            if(exists(root, pivot, d))
                left = pivot+1;
            else
                right = pivot-1;
        }
        
        return (int)Math.pow(2,d)-1+left;
            
    }
    private boolean exists(TreeNode root, int idx, int d){
        int left = 0;
        int right= (int) Math.pow(2,d)-1;
        for(int i=0;i<d;i++){
            int pivot = left+(right-left)/2;
            if(idx<=pivot){
                right = pivot;
                root = root.left;
            }else{
                left = pivot+1;
                root = root.right;
            }
                
        }
        return root!=null;
    }
    private int findDepth(TreeNode root){
        int d=0;
        while(root.left!=null){
            root = root.left;
            d++;
        }
        return d;
    }
    
}