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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        Map<Integer , Integer> map = new HashMap<>();
        ListNode newNode = head;
        while(head != null){
            map.put(head.val , map.getOrDefault(head.val , 0) + 1);
            head = head.next;
        }
        
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while(newNode!= null){
            if(newNode!= null && map.get(newNode.val) == 1){
                ListNode add = new ListNode(newNode.val);
                temp.next = add;
                temp = add;
            }
             newNode = newNode.next;
        }
        return dummy.next;
    }
}