/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummyHead = new Node(-1);
        Node cur = dummyHead;
        Node temp = head;
        Map<Node, Node> nodeMap = new HashMap<>();

        while (temp != null) {
            cur.next = new Node(temp.val);
            nodeMap.put(temp, cur.next);
            cur = cur.next;
            temp = temp.next;
        }

        temp = head;
        cur = dummyHead;

        while (temp != null) {
            cur.next.random = nodeMap.get(temp.random);
            temp = temp.next;
            cur = cur.next;
        }

        return dummyHead.next;
        
    }
}
