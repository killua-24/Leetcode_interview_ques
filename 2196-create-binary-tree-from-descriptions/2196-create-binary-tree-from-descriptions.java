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
    public TreeNode createBinaryTree(int[][] desc) {
        Map<Integer , TreeNode > map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int[] d : desc){
            set.add(d[1]);
            TreeNode par = null , ch = null;
            if(map.containsKey(d[0])) {
                par = map.get(d[0]);
            }else {
                par = new TreeNode(d[0]);
                map.put(par.val , par);
            }
            if(map.containsKey(d[1])) ch = map.get(d[1]);
            else{
                ch=new TreeNode(d[1]);
                map.put(ch.val , ch);
            }
            
            if(d[2] == 1) par.left = ch ;
            else par.right = ch;
            map.put(par.val , par);
            
        }
        int root = -1;
        for(int[] d : desc){
            if(!set.contains(d[0])){
                root = d[0];
                break;
            }
        }
        
        return map.getOrDefault(root , null);
    }
    
}