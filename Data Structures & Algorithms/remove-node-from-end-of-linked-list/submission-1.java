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
        ListNode cur = head;

        while (cur != null) {
            length++;
            cur = cur.next;
        }

        int removeNodePosition = length - n + 1;

        if (removeNodePosition == 1) {
            return head.next;
        } 
        cur = head;

        for (int position = 1; position < removeNodePosition; position++) {
            if (position == removeNodePosition - 1) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;

    }
}
