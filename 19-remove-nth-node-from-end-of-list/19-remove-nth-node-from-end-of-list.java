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
        if(head.next == null) return null;  
       ListNode dummy = new ListNode(); 
       ListNode slow = dummy , fast = dummy;
        dummy.next = head;
        for(int i = 0 ; i <= n ;i++){
            fast = fast.next;
        }
        
        while(fast != null ){
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    }
}