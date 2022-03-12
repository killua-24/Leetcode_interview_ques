/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node , Node> map = new HashMap<>();
        Node ptr = head;
        while(ptr != null){
            Node copy = new Node(ptr.val);
            map.put(ptr , copy);
            ptr = ptr.next;
        }
        
        ptr = head;
        while(ptr != null){
            Node copy = map.get(ptr);
            copy.next = map.get(ptr.next);
            copy.random = map.get(ptr.random);
            ptr = ptr.next;
        }
        return map.get(head);
    }
}