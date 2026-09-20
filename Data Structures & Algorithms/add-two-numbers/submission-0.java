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

        while (first != null && second != null) {
            int sum = (carry + first.val + second.val) % 10;
            carry = (carry + first.val + second.val) / 10;
            sumNode.next = new ListNode(sum);
            first = first.next;
            second = second.next;
            sumNode = sumNode.next;
        }

        while (first != null) {
           int sum = (carry + first.val) % 10;
            carry = (carry + first.val) / 10;
            sumNode.next = new ListNode(sum);
            first = first.next;
            sumNode = sumNode.next;
        }

         while (second != null) {
           int sum = (carry + second.val) % 10;
            carry = (carry + second.val) / 10;
            sumNode.next = new ListNode(sum);
            second = second.next;
            sumNode = sumNode.next;
        }
        if (carry != 0) {
            sumNode.next = new ListNode(1);
        }

        return dummy.next;
       
    }
}
