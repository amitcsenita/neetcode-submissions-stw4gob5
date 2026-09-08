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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        reorder(head, head.next);
    }

    ListNode reorder(ListNode front, ListNode cur) {
        if (cur == null) return front;

        front = reorder(front, cur.next);
        if (front == null) return null;

        ListNode tmp = null;

        if (front == cur || front.next == cur) {
            cur.next = null;
        } else {
            tmp = front.next;
            front.next = cur;
            cur.next = tmp;
        }
        return tmp;       
    }
}
