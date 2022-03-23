/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null ) return null;
     
        Node t1= root;
        
        while(t1 != null)
        {
            Node t2=t1;
            
            while(t2 != null)
            {
                if(t2.left != null)
                    t2.left.next=t2.right;
                
                if(t2.right != null && t2.next != null)
                    t2.right.next=t2.next.left;
                
                t2=t2.next;
            }
            
            t1=t1.left;
        }
        
        return root;
    }
}