import java.util.*;

public class RandomizedSet {

    HashSet<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
    }

    public boolean insert(int val) {
        if (!set.contains(val)) {
            set.add(val);
            return true;
        } else  return false;
    }

    public boolean remove(int val) {
        if(!set.contains(val)) {
            return false;
        } else {
            set.remove(val);
            return true;
        }
    }

    public int getRandom() {
        ArrayList<Integer> list = new ArrayList<>(set);
        Random random = new Random();
        int idx = random.nextInt(list.size());
        return list.get(idx);
    }
}
