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
        int num ;
        TreeNode node; 
        
        Pair(TreeNode node , int num){
            this.num = num ;
             this.node = node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        if(root == null) return ans;
        
        q.add(new Pair(root , 0));
        while(!q.isEmpty()){
            int size = q.size();
            int main = q.peek().num;
            int first = 0,last = 0;
            for(int i = 0 ; i <size ; i++){
                int curr = q.peek().num - main;
                TreeNode tmp = q.peek().node;
                q.poll();
                if(i == 0) first = curr;
                if(i == size -1) last = curr;    
                if(tmp.left != null){
                    q.offer(new Pair(tmp.left,curr*2 + 1));
                }
                if(tmp.right != null){
                    q.offer(new Pair(tmp.right,curr*2 + 2));
                }
            }
            ans = Math.max(ans, last - first +1);
        }
        return ans;
    }
}