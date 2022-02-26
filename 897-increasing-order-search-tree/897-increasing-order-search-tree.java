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
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return null;
        inorder(root);
        TreeNode inOrder = new TreeNode(in.get(0));
        TreeNode newNode = inOrder;
        for(int i = 1 ; i < in.size() ;i++){
            TreeNode right = new TreeNode(in.get(i));
            inOrder.left = null;
            inOrder.right = right;
            inOrder = inOrder.right;
        }
        return newNode;
    }
    
    private void inorder(TreeNode root){
        if(root== null) return ;
        
        inorder(root.left);
        in.add(root.val);
        inorder(root.right);
    }
}