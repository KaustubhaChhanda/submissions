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
    public ListNode deleteMiddle(ListNode head) {
        int len = 0;
        ListNode tail = head;

        while (tail != null) {
            len++;
            tail = tail.next;
        }

        if (len == 1) {
            return null;
        }

        if (len == 2) {
            head.next = null;
            return head;
        }

        int mid = len / 2;

        tail = head;
        
        for (int i = 0; i < mid - 1; i++) {
            tail = tail.next;
        }

        tail.next = tail.next.next;

        return head;
    }
}