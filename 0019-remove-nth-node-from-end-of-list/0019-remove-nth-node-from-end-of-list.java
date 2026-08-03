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
        int length = 0;
        ListNode tail = head;

        while (tail != null) {
            tail = tail.next;
            length++;
        }

        int position = length - n - 1;

        if (position < 0) {
            return head.next;
        }

        tail = head;

        while (position != 0) {
            tail = tail.next;
            position--;
        }

        tail.next = tail.next.next;

        return head;
    }
}