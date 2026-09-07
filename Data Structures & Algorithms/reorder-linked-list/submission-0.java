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

// Amit | NeetCode | 2026-09-07 22:59 IST
class Solution {
    public void reorderList(ListNode head) {
         if (head == null || head.next == null) return;
         List<ListNode>nodes = new ArrayList<>();

         ListNode cur = head;
         while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
         }

         int i = 0, j = nodes.size()-1;

         while (i < j) {
            nodes.get(i).next = nodes.get(j);
            i++;
            if (i>=j) break;
            nodes.get(j).next = nodes.get(i);
            j--; 
         }

         nodes.get(i).next = null;
    }
}
