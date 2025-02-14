import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        
        int[] nums = {0,2,3,4,6,8,9};

        System.out.println("==============");
        System.out.println(summaryRanges(nums));

    }

    public static List<String> summaryRanges(int[] nums) {
        
        List<String> list = new ArrayList<>();
        
        if (nums.length == 0) return list;

        int j = 0;
        int i = 0;
        while( i < nums.length - 1) {
            
            if(nums[i] + 1 != nums[i + 1]) {
                if(j == i) {
                    list.add(nums[i] + "");
                } else {
                    list.add(nums[j] +"->" + nums[i]);
                }
                
                j = i + 1;
            }

            i++;
            
        }

        if(j == i) {
            list.add(nums[i] + "");
        } else {
            list.add(nums[j] +"->" + nums[i]);
        }

        return list;
    }
}