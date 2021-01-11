package top_questions.hard.trees;

import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/count-of-smaller-numbers-after-self/
class CountSmaller {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        int i=nums.length-1;
        Node root=null;
        while(i>=0){
            root = insert(root, nums[i], ans, i, 0);
            i--;
        }
        
        return Arrays.asList(ans);
    }
    
    private Node insert(Node root, int val, Integer[] ans, int i, int presum){
        
        if(root==null){
            root=new Node(val, 0);
            ans[i] = presum;
        }else if(root.val == val){
            root.dup++;
            ans[i] = presum + root.leftSum;
        }else if(root.val>val){
            root.leftSum++;
            root.left = insert(root.left, val, ans, i, presum);
        }else if(root.val<val){
            presum = presum + root.leftSum + root.dup+1;
            root.right = insert(root.right, val, ans, i, presum);
        }
        
        return root;
        
    }
    
    
 class Node{
   Node left;
   Node right;
   int val, dup, leftSum=0;
   public Node(int val, int dup){
       this.val = val;
       this.dup = dup;
   }
     
 }
}