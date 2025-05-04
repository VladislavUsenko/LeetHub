public class Main {
    public static void main(String[] args) {

        LRUCache lRUCache = new LRUCache(2);
        //[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
        //["LRUCache","put","put","get","put","put","get"]

        lRUCache.put(2,1);
        lRUCache.put(2,2);

        int val = lRUCache.get(2);
        System.out.println(val);
        lRUCache.put(1,1);
        lRUCache.put(4,1);

        val = lRUCache.get(2);
        System.out.println(val);

    }
}