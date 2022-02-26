/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
     List<Integer> pre= new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null) return pre;
        preorder_(root);
        
        return pre;
    }
    
    private void preorder_(Node root){
        if(root == null) return;
        
        pre.add(root.val);
        for(var it : root.children)
        preorder_(it);
        
    }
}