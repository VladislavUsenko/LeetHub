import java.util.*;

class LRUCache {

    LinkedHashMap<Integer, Integer> map;

    LinkedList<Integer> leastUsedKeys;

    int capacity;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
       leastUsedKeys = new LinkedList<>();
    }

    public int get(int key) {

        if(map.containsKey(key)) {
            leastUsedKeys.remove(Integer.valueOf(key));
            leastUsedKeys.addLast(key);
            return map.get(key);
        } else  return -1;
    }

    public void put(int key, int value) {

        if(map.containsKey(key)) {
            leastUsedKeys.remove(Integer.valueOf(key));
            leastUsedKeys.addLast(key);
            map.put(key, value);
        } else {
            if (leastUsedKeys.size() < capacity) {
                leastUsedKeys.addLast(key);
            } else {
                map.remove(leastUsedKeys.getFirst());
                leastUsedKeys.removeFirst();
                leastUsedKeys.addLast(key);
            }
            map.put(key, value);
        }
    }
}

/*
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */