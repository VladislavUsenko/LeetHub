import java.util.*;
import java.util.regex.Pattern;

class Solution1 {

    public static void main(String[] args) {
        
        String[] logs = {"27 85717 7", "2 y xyr fc", "52 314 99", "d 046099 0", "m azv x f", "7e apw c y", "8 hyyq z p", "6 3272401", "c otdk cl", "8 ksif m u"};

        System.out.println(Arrays.toString(reorderLogFiles(logs)));

    }

    public static String[] reorderLogFiles(String[] logs) {

        if(logs.length == 1) return logs;

        List<String> letters = new ArrayList<>();
        List<String> digs = new ArrayList<>();
        for(int i = 0; i < logs.length; i++) {

            String[] words = logs[i].split(" ", 2);

            if(isNumber(words[1])) {
                digs.add(logs[i]);
            } else {
                letters.add(logs[i]);
            }
        }

        System.out.println(letters);

        letters = sortByValue(letters);

        String[] result  = new String[logs.length];

        int idx = 0;
        for(int i = 0; i < letters.size(); i++) {
            result[idx++] = letters.get(i);
        }

        for(int i = 0; i < digs.size(); i++) {
            result[idx++] = digs.get(i);
        }

        return result;
         
    }

    public static boolean isNumber(String str) {
        if (str == null || str.isEmpty()) {
            return false; // Handle null or empty strings
        }
        return Pattern.matches("[0-9\\s]+", str);
    }

    private static List<String> sortByValue(List<String> unsortedList) {
        
        Collections.sort(unsortedList, new Comparator<String>() {
            
            @Override
            public int compare(String o1, String o2) {

                String[] w1 = o1.split(" ", 2);
                String[] w2 = o2.split(" ", 2);

                String val1 = w1[1];
                String val2 = w2[1];

                if(val1.equals(val2)) {

                    String key1 = w1[0];
                    String key2 = w2[0];

                    return key1.compareTo(key2);
                }

                return val1.compareTo(val2);
            }

        });

        return unsortedList;
    }
}
