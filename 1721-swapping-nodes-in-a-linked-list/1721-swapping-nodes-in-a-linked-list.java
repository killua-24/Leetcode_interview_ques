/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        
        List<Integer> al = new ArrayList<>();
        while(head != null){
            al.add(head.val);
            head = head.next;
        }
        
        int temp = al.get(k-1);
        al.set(k-1 , al.get(al.size() - k));
        al.set(al.size() - k , temp );
        
        ListNode node = new ListNode(al.get(0));
        head = node;
        
        for(int i = 1 ; i < al.size() ; i++){
            ListNode add = new ListNode(al.get(i));
            node.next = add;
            node = add;
        }
            return head;
    }
}