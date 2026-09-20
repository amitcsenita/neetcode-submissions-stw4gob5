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
        return add (l1, l2, 0);
    }

    public ListNode add(ListNode first, ListNode second, int carry) {
        if (first == null && second == null && carry == 0) {
            return null;
        }

        int v1 = (first != null ) ? first.val : 0;
        int v2 = (second != null ) ? second.val : 0;

        int sum = v1 + v2 + carry;
        int newCarry = sum/10;
        int nodeValue = sum %10;

        ListNode nextNode = add (first != null ? first.next: null, second != null ? second.next: null, newCarry);
        return new ListNode(nodeValue, nextNode);


    }
}
