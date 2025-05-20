import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {
        
        
        String[] comands = {
            "AllOne","inc","inc","inc","inc","getMaxKey","inc","inc","inc","dec","inc","inc","inc","getMaxKey"
        };

        String[] output = {
            "","hello","goodbye","hello","hello","","leet","code","leet","hello","leet","code","code",""
        };

        System.out.println("===================");

        test(comands, output);
    }

    public static void test(String[] comands, String[] output) {

        AllOne obj = new AllOne();


        String[] res = new String[comands.length];

        for (int i = 0; i < output.length; i++) {
            switch (comands[i]) {
                case "inc":
                    obj.inc(output[i]);
                    break;
                case "dec":
                    obj.dec(output[i]);
                    break;
                case "getMaxKey":
                    res[i] = obj.getMaxKey();
                    break;
                case "getMinKey":
                    res[i] = obj.getMinKey();
                    break;
                default:
                    break;
            }
        }

        System.out.println(Arrays.toString(res));
    }
}
