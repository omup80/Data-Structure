package practise.trees;

import java.util.HashMap;
/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7
 */
/*
Algorithm

Build hashmap value -> its index for inorder traversal.

Return createTree function which takes as the arguments the left and right boundaries for the current subtree in the inorder traversal. These boundaries are used only to check if the subtree is empty or not. Here is how it works helper(in_left = 0, in_right = n - 1):

If leftIndex > rightIndex, the subtree is empty, return None.

Pick the last element in postorder traversal as a root.

Root value has index index in the inorder traversal, elements from leftIndex to index - 1 belong to the left subtree, and elements from index + 1 to rightIndex belong to the right subtree.

Following the postorder logic, proceed recursively first to construct the right subtree helper(index + 1, rightIndex) and then to construct the left subtree helper(leftIndex, index - 1).

Return root.
 */

/*
Complexity Analysis

Time complexity : O(N). Let's compute the solution with the help of master theorem T(N) = aT(b\N) + θ(N^d).
 The equation represents dividing the problem up into aa subproblems of size N/b in θ(N^d)
​. Here one divides the problem in two subproblemes a = 2, the size of each subproblem (to compute left and right subtree) is a half of initial problem b = 2, and all this happens in a constant time d = 0. That means that \log_b(a) > dlog
b
​
 (a)>d and hence we're dealing with case 1 that means \mathcal{O}(N^{\log_b(a)}) = \mathcal{O}(N)O(N
log
b
​
 (a)
 )=O(N) time complexity.

Space complexity : \mathcal{O}(N)O(N), since we store the entire tree.
 */
public class TreeFromInorderPostOrder {
    private int[] inorder;
    private int[] postorder;
    private HashMap<Integer, Integer> inorderIndexes = new HashMap<Integer, Integer>();
    private int postorderCurrentIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        for(int i=0;i<inorder.length;i++){
            inorderIndexes.put(inorder[i],i);
        }
        postorderCurrentIndex = postorder.length-1;
        return createTree(0, inorder.length-1);
    }
    private TreeNode createTree(int startIndex, int endIndex){
        if(startIndex > endIndex)
            return null;

        int rootValue = postorder[postorderCurrentIndex];
        TreeNode root = new TreeNode(rootValue);

        int rootIndexInInorder = inorderIndexes.get(rootValue);

        postorderCurrentIndex--;

        root.right = createTree(rootIndexInInorder+1, endIndex);
        root.left = createTree(startIndex, rootIndexInInorder - 1);

        return root;
    }
}

