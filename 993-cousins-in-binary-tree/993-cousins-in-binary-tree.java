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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || root.left == null || root.right == null) return false;
        
        int a = getLevel(root , x , 1);
        int b = getLevel(root , y , 1);
        
        if(a == b && getParent(root,x).val != getParent(root,y).val) return true;
        return false;
    }
    
     private TreeNode getParent(TreeNode root, int val) {
        if (root == null) return null;
        
        if ((root.left != null && root.left.val == val) || (root.right != null && root.right.val == val)) {
            return root;
        }
        
        TreeNode leftParent = getParent(root.left, val);
        if (leftParent == null) {
            return getParent(root.right, val);
        }
        return leftParent;
    }
    
    private int getLevel(TreeNode node, int data, int level)
    {
        if (node == null)
            return 0;
 
        if (node.val == data)
            return level;
 
        int downlevel
            = getLevel(node.left, data, level + 1);
        if (downlevel != 0)
            return downlevel;
 
        downlevel
            = getLevel(node.right, data, level + 1);
        return downlevel;
    }
}