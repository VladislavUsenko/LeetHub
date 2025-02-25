import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        
        String text = "krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw";

        System.out.println("---------------");
        System.out.println(maxNumberOfBalloons(text));

    }

    public static int maxNumberOfBalloons(String text) {
        
        Map<Character, Integer> map = new HashMap<>();

        char[] balloon = {'b', 'a', 'l', 'o', 'n'};

        for(char c : balloon) map.put(c, 0);

        for(int i = 0; i < text.length(); i++) {

            char c = text.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
        }

        int res = Integer.MAX_VALUE;

        for(var entry : map.entrySet()){

            int count = entry.getValue();

            if (entry.getKey() == 'l' || entry.getKey() == 'o') count /= 2;
            if (count == 0) return 0;

            res = Math.min(count, res);
        }

        return res;
    }
}