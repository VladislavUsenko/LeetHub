public class Main {
    
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("aa", 3);

        System.out.println(mapSum.sum("a"));

        mapSum.insert("ab", 2);

        System.out.println(mapSum.sum("a"));

    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
