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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1 = list1;
        ListNode head2 = list2;
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode merged = new ListNode();
        ListNode output = merged;

        while (head1 != null && head2 != null) {
           if (head1.val < head2.val) {
             merged.next = head1;
             head1 = head1.next;
           } else {
             merged.next = head2;
             head2 = head2.next;
           } 
           merged = merged.next; 
        }

        merged.next = head1 != null ? head1 : head2;
   
        return output.next;
    }
}