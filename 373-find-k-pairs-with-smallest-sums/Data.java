import java.util.*;

public class Data {
    
    int sum = 0;
    List<Integer> list = new ArrayList<>();

    @Override
    public String toString() {
        return sum + " {" + list.toString() + "}";
    }

}
