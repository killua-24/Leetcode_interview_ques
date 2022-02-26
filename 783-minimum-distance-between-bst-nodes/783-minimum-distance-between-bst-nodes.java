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
class Solution {
     List<Integer> in = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i < in.size() ;i++){
            min = Math.min(min , in.get(i) - in.get(i-1));
        }
        return min;
    }
    
    public void inorder(TreeNode root){
        if(root == null) return ;
        inorder(root.left);
        in.add(root.val);
        inorder(root.right);
     
    }
}