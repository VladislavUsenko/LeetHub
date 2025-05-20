import java.util.*;

class AllOne {

    public Node head;
    public Node tail;
    public Map<String, Node> map;

    public AllOne() {
        head = new Node("head");
        head.cout = -1;
        
        tail = new Node("tail");
        tail.cout = Integer.MAX_VALUE;
        head.next = tail;
        tail.prev = head;   
        map = new HashMap<>();

    }
    
    public void inc(String key) {

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.cout++;
            System.out.println("inc " + node);
            if (node.next != null && node.next.cout <= node.cout) {
                moveToTail(node);
            }

        } else {
            Node node = new Node(key);
            map.put(key, node);
            addNode(node);
            System.out.println("add new node " + node);
        }

    }
    
    public void dec(String key) {
        
        Node node = map.get(key);
        node.cout--;
        System.out.println("dec " + node);

        if (node.cout == 0) {
            map.remove(key);
            removeNode(node);
            return;
        }

        if (node.prev != null && node.prev.cout >= node.cout) {
                moveToHead(node);
        }
    }
    
    public String getMaxKey() {
        return tail.prev.str;
    }
    
    public String getMinKey() {
        return head.next.str;
    }

    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;

    }

    private void removeNode(Node node) {

        Node prev = node.prev;
        Node next = node.next;

        prev.next = node.next;
        next.prev = node.prev;

        node.prev = null;
        node.next = null;


    }

    private void moveToHead(Node node) {

    Node current = node.prev;
       
    removeNode(node);

    while (current != head && current.cout >= node.cout) {
        current = current.prev;
    }

    
    node.next = current.next;
    node.prev = current;
    current.next.prev = node;
    current.next = node;
}

private void moveToTail(Node node) {

    Node current = node.next;
    removeNode(node);

    while (current != tail && current.cout <= node.cout) {
        current = current.next;
    }

    
    node.prev = current.prev;
    node.next = current;
    current.prev.next = node;
    current.prev = node;
}

}