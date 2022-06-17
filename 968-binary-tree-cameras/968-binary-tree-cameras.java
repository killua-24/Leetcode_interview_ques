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
    private int camera = 0;
    public int minCameraCover(TreeNode root) {
        
        if(minCamera(root) == -1) camera++;
        return camera;
    }
    
    private int minCamera(TreeNode root){
        if(root == null) return 1;
        
        int left = minCamera(root.left);
        int right = minCamera(root.right);
        
        if(left == -1 || right == -1){
            camera++;
            return 0;
        }
        
        if(left == 0 || right == 0){
            return 1;
        }
        return -1;
    }
}