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
class BSTIterator {
    Stack<TreeNode> st = new Stack();
    public BSTIterator(TreeNode root) {
        st = new Stack();
        getAllLefts(root);
    }
    
    void getAllLefts(TreeNode root){
        while(root != null){
            this.st.push(root);
            root = root.left;
        }
        
    }
    
    public int next() {
        TreeNode top = this.st.pop();
        getAllLefts(top.right);
        
        return top.val;
    }
    
    public boolean hasNext() {       
        return this.st.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */