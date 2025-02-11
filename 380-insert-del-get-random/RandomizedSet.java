import java.util.ArrayList;
import java.util.HashSet;

class RandomizedSet {

    HashSet<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(set.contains(val)) return false;

        set.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!set.contains(val)) return false;

        set.remove(val);
        return true;
    }
    
    public int getRandom() {
        int random = (int)(Math.random() * set.size() - 1) + 0;
        System.out.println("random" + random);
        System.out.println("size " + set.size());
        var list = new ArrayList<>(set);

        return list.get(random);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */