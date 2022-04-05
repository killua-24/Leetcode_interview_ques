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
    public String smallestFromLeaf(TreeNode root) {
        String[] ans = new String[1];
        ans[0] = "~";
        helper(root , new StringBuilder(),ans);
        return ans[0];
    }
    
    void helper(TreeNode root , StringBuilder sb, String[] ans){
        if(root == null) return;
        sb.append((char)('a' + root.val));
        if(root.left == null && root.right == null){
            sb.reverse();
            String str = sb.toString();
            sb.reverse();
            
            if(str.compareTo(ans[0]) < 0) ans[0] = str;
        }
        
        helper(root.left , sb , ans);
        helper(root.right , sb , ans);
        sb.deleteCharAt(sb.length() -1);
    }
    
    
}