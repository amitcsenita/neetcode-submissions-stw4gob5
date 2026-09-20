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
        if (head == null) return null;  
        Node temp = head;

        while (temp != null) {
            Node copy = new Node(temp.val);
            Node next = temp.next;
            temp.next = copy;
            copy.next = next;
            temp = copy.next;
        }
        Node newHead = head.next;

        temp = head;
        while (temp != null) {
            temp.next.random = temp.random != null ? temp.random.next : null;
            temp = temp.next.next;
        }

        temp = head;
        while (temp != null) {
            Node copy = temp.next;
            temp.next = copy.next;
            copy.next = temp.next != null ? temp.next.next : null;
            temp = temp.next;
        }
        return newHead;
    }    

}
