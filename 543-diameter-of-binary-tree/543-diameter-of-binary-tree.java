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
    class Pair{
        int dia , h;
        // Pair(int dia , int h){
        //     this.dia = dia;
        //     this.h = h;
        // }
    } 
    
    public int diameterOfBinaryTree(TreeNode root) {
         if(root == null)
             return 0;
         return diameter(root).dia;
    }
    
    private Pair diameter(TreeNode root){
        if(root == null){
            Pair bp = new Pair();
            bp.dia = -1;
            bp.h = 0;
            return bp;
        }
        Pair left = diameter(root.left);
        Pair right = diameter(root.right);
        Pair max = new Pair();
        max.dia = Math.max(left.h + right.h , Math.max(left.dia , right.dia));
        max.h = 1 + Math.max(left.h , right.h);
        return max; 
            
    }
}