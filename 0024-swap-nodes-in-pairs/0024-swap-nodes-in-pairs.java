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
        return swap(head);
    }

    private ListNode swap(ListNode node) {
        if (node == null) {
            return null;
        }

        if (node.next == null) {
            return node;
        }

        ListNode next = node.next;
        node.next = swap(node.next.next);
        next.next = node;

        return next;
    }
}