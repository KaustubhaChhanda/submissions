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
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode a = head;
        ListNode prev = dummy;

        while (a != null) {
            if (a .next == null) {
                prev.next = a;
                break;
            }
            
            ListNode b = a.next;
            ListNode c = b.next;

            prev.next = b;
            b.next = a;
            a.next = null;
            prev = a;
            a = c;
        }

        return dummy.next;
    }
}