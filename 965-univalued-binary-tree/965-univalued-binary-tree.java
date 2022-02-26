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
   
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
         int uni= root.val;
        return isUnivalTree(root , uni);
    }
    
    public boolean isUnivalTree(TreeNode root , int uni) {
        if(root == null) return true;
        
        return root.val == uni && isUnivalTree(root.left,uni) && isUnivalTree(root.right,uni);
    }
}