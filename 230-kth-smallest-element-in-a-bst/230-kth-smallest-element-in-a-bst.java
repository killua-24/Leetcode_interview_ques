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
    int key = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        
        kth(root , k);
        return key;
    }
    
    public void kth(TreeNode root, int k) {
        if(root == null) return;
        
        kth(root.left , k);
        count++;
        if(count == k){
            key = root.val;
            return;
        }
        kth(root.right , k);
    }
    
    
}