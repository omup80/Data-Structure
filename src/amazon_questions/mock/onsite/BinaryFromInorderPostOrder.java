package amazon_questions.mock.onsite;

import amazon_questions.trees_and_graph.TreeNode;

import java.util.HashMap;
import java.util.Map;

class BinaryFromInorderPostOrder {
    int idx;
    Map<Integer, Integer> map;
    int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        idx = inorder.length-1;
        this.postorder = postorder;
        return createTree(0, inorder.length-1);
        
    }
    
    private TreeNode createTree(int left, int right){
        if(left>right)
            return null;
        
        TreeNode root = new TreeNode(postorder[idx]);
        int index = map.get(postorder[idx]);
        idx--;
        root.right = createTree(index+1, right);
        root.left = createTree(left, index-1);
        return root;
    }
}