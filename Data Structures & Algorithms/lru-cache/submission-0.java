class LRUCache {

    class Node {
        int key;
        int value;

        Node prev;
        Node next;

        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        if (map.get(key) == null) return -1;

        Node cur = map.get(key);
        Node curPrev = cur.prev;
        Node curNext = cur.next;

        // remove cur from its place
        curPrev.next = curNext;
        curNext.prev = curPrev;

        // add cur to front of list
        Node next = head.next;
        head.next = cur;
        cur.prev = head;
        cur.next = next;
        next.prev = cur;

        return cur.value;
        
    }
    
    public void put(int key, int value) {
        Node existing = map.get(key);
        if (existing != null) {
            existing.value = value;
            get(key);
            return;
        }

        //new key has arrived and capacity already full
        if (map.size() == capacity) {
            //remove node at end of node
            Node last = tail.prev;
            Node prevLast = last.prev;
            prevLast.next = tail;
            tail.prev = prevLast;
            map.remove(last.key);
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        // add at front of node
        Node nextHead = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = nextHead;
        nextHead.prev = newNode;
    }
}
