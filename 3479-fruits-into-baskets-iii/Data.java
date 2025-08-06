import java.util.*;

public class Data {
    
    int key;
    Set<Integer> indexes;

    public Data() {

    }

    public Data (int key) {
        this.key = key;
    }

    @Override
    public int hashCode() {

        return ((Integer) key).hashCode();
    }


}
