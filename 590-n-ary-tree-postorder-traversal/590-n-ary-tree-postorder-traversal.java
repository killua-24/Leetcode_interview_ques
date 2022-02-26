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
    List<Integer> post = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root == null) return post;
        
       postOrder_(root);
        return post;
    }
    
    private void postOrder_(Node root){
        if(root == null) return;
        
        for(Node it : root.children){
            postOrder_(it);
        }
        post.add(root.val);
    }
}