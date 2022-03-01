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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<Integer> al = new ArrayList<>();
        while(head != null){
            al.add(head.val);
            head= head.next;
        }
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        int len = al.size() - n;
        for(int i = 0 ; i < al.size() ;i++){
            if(i != len){
                ListNode add = new ListNode(al.get(i));
                node.next = add;
                node = add;
            }
        }
        return dummy.next;
    }
}