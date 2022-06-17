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
    
    public enum Camera{HAVE , NEED , COVERED};
    public int minCameraCover(TreeNode root) {
        
        return (minCamera(root) == Camera.NEED) ? ++camera : camera;
    }
    
    private Camera minCamera(TreeNode root){
        if(root == null) return Camera.COVERED;
        
        Camera left = minCamera(root.left);
        Camera right = minCamera(root.right);
        
        if(left == Camera.NEED || right == Camera.NEED){
            camera++;
            return Camera.HAVE;
        }
        
        if(left == Camera.HAVE || right == Camera.HAVE){
            return Camera.COVERED;
        }
        return Camera.NEED;
    }
}