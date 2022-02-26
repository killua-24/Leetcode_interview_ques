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
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root , sb);
        String ans = sb.substring(1,sb.length()-1).toString();
        return ans;
    }
    
    private void preOrder(TreeNode root , StringBuilder sb){
        if(root == null)  return;
       
        
        sb.append("(");
        sb.append( root.val);
         if(root.left == null && root.right != null ) sb.append("()");
        preOrder(root.left , sb);
        
        preOrder(root.right , sb);
        sb.append(")");
    }
}