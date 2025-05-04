import java.util.*;

class LFUCache {

    private int capacity;
    private HashMap<Integer, Node> cache;
    private PriorityQueue<Node> heap;
    private long timestamp;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.heap = new PriorityQueue<>();
        this.timestamp = 0;
    }

    public int get(int key) {

        if(!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        heap.remove(node);
        node.freq++;
        node.timestamp = timestamp++;
        heap.add(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {

            Node node = cache.get(key);
            heap.remove(node);
            node.freq++;
            node.timestamp = timestamp++;
            node.val = value;
            heap.add(node);
        } else {

            if (heap.size() < capacity) {
                Node node = new Node(key, value, 0, timestamp++);
                heap.add(node);
                cache.put(key, node);
            } else {
                Node old = heap.poll();
                cache.remove(old.key);

                Node node = new Node(key, value, 0, timestamp++);
                heap.add(node);
                cache.put(key, node);

            }
        }
    }
}