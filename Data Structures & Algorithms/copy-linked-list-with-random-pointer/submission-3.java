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
        Node temp = head;
        Map<Node, Node> nodeMap = new HashMap<>();
        nodeMap.put(null, null);

        while (temp != null) {
            Node copy = new Node(temp.val);
            nodeMap.put(temp, copy);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            Node copy = nodeMap.get(temp);
            copy.next = nodeMap.get(temp.next);
            copy.random = nodeMap.get(temp.random);
            temp = temp.next;
        }

        return nodeMap.get(head);
        
    }
}
