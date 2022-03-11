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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        List<Integer> a = new ArrayList<>();
        
        while(head != null){
            a.add(head.val);
            head = head.next;
        }
        int n = a.size();
        k = k%a.size();
        reverse(a,0,n-1);
        reverse(a,0,k-1);
        reverse(a,k,n-1);
        
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        for(int i = 0 ; i < a.size() ; i++){
            ListNode add = new ListNode(a.get(i));
            temp.next = add;
            temp = add;
        }
        return dummy.next;
    }
    
    public void reverse( List<Integer> a, int s, int l){
        
        while(s<l){
            int temp = a.get(s);
            a.set(s , a.get(l));
            a.set(l,temp);
            s++;
            l--;
        }
    }
}