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

    ListNode reorder(ListNode root, ListNode cur) {
        if (cur == null) return root;

        root = reorder(root, cur.next);

        if (root == null) return null;

        ListNode tmp = null ;

        if (root == cur || root.next == cur) {
            cur.next = null;
        } else {
            tmp = root.next;
            root.next = cur;
            cur.next = tmp;
        }
        return tmp;
    }
}
