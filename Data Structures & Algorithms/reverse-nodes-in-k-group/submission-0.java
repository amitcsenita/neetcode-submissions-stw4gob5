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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode currentGroupHead = head;
        int groupSize = k;

        ListNode groupScanPointer = currentGroupHead;
        int nodesCounted = 0;

        while (groupScanPointer != null && nodesCounted < groupSize) {
            groupScanPointer = groupScanPointer.next;
            nodesCounted++;
        }

        if (nodesCounted < groupSize) {
            return currentGroupHead;
        }

        ListNode resultHead = reverseKGroup(groupScanPointer, groupSize);

        ListNode nodeToReverse = currentGroupHead;

        for (int nodesReversed = 0; nodesReversed < groupSize; nodesReversed++) {
            ListNode nextUnProcessedNode = nodeToReverse.next;
            nodeToReverse.next = resultHead;
            resultHead = nodeToReverse;
            nodeToReverse = nextUnProcessedNode;
        }

        return resultHead;
    }
}
