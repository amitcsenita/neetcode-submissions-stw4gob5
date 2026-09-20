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
        Map<Node, Node> nodeMap = new HashMap<>();
        nodeMap.put(null, null);

        Node temp = head;
        while (temp != null) {
            if (!nodeMap.containsKey(temp)) {
                nodeMap.put(temp, new Node(temp.val));
            }
            if (temp.next != null && !nodeMap.containsKey(temp.next)) {
                 nodeMap.put(temp.next, new Node(temp.next.val));
            }
            nodeMap.get(temp).next = nodeMap.get(temp.next);
            if (temp.random != null && !nodeMap.containsKey(temp.random)) {
                nodeMap.put(temp.random, new Node(temp.random.val));
            }
            nodeMap.get(temp).random = nodeMap.get(temp.random);
            temp = temp.next;
        }
        return nodeMap.get(head);         
    }
}
