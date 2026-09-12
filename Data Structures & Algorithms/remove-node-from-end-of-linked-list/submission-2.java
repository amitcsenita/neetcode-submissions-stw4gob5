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

void log(Object... args) {
    System.out.println(java.util.Arrays.deepToString(args));
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return removeRecursive(head, new int[]{n});
    }

    ListNode removeRecursive(ListNode head, int[] arr) {
        if(head == null) return null;
        head.next = removeRecursive(head.next, arr);
        arr[0]--;
        log("arr[0]: ", arr[0]);
        if (arr[0] == 0) {
            return head.next;
        }
        return head;

    }
}
