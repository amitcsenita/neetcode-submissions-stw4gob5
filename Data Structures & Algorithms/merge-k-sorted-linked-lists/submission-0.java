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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>pq = new PriorityQueue<>(
            (nodeA, nodeB) -> Integer.compare(nodeA.val, nodeB.val)
        );

        for (int i=0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);

            }
        }

        ListNode mergedList = new ListNode(-1);
        ListNode temp = mergedList;

        while (!pq.isEmpty()) {
            ListNode lowest = pq.poll();
            temp.next = lowest;
            if (lowest.next != null) {
                pq.add(lowest.next);
            }
            lowest.next = null;
            temp = temp.next;
        }

        
        return mergedList.next;
    }
}
