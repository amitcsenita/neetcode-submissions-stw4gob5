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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode first = l1, second = l2, sumNode = dummy;
        int carry = 0;

        while (first != null || second != null || carry != 0) {
            int v1 = (first != null) ? first.val : 0;
            int v2 = (second != null) ? second.val : 0;

            int sum = (carry + v1 + v2) % 10;
            carry = (carry + v1 + v2) / 10;
            sumNode.next = new ListNode(sum);
            first = (first != null) ? first.next: null;
            second = (second != null) ? second.next: null;
            sumNode = sumNode.next;
        }
        return dummy.next;
       
    }
}
