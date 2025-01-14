import java.util.*;

class Solution {
    public static void main(String[] args) {
        //favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
        List<List<String>> favoriteCompanies = new ArrayList<>();
        List<String> first = new ArrayList<>();
        first.add("leetcode");
        first.add("google");
        first.add("facebook");
        favoriteCompanies.add(first);

        List<String> second = new ArrayList<>();
        second.add("google");
        second.add("microsoft");
        favoriteCompanies.add(second);

        List<String> third = new ArrayList<>();
        third.add("google");
        third.add("facebook");
        favoriteCompanies.add(third);

        List<String> last = new ArrayList<>();
        last.add("google");
        favoriteCompanies.add(last);

        List<String> totalLast = new ArrayList<>();
        totalLast.add("amazon");
        favoriteCompanies.add(totalLast);

        List<Integer> result = peopleIndexes(favoriteCompanies);
        System.out.println("\n" + result);

        
    }

    public static List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for(int i = 1; i < favoriteCompanies.size(); i++) {
            for(int j = 0; j < favoriteCompanies.size(); j++) {
                if(i == j) break;
                boolean compare = compareList(favoriteCompanies.get(i), favoriteCompanies.get(j));
                if(compare) {
                    result.add(i);
                    break;
                } else {
                    i++; 
                }
            }
        }


        return result;

    }

    public static boolean compareList(List<String> first, List<String> second) {

        int count = 0;
        for(String str: first) {
            for(String secondStr : second) {
                if(str.equals(secondStr)) count++;
            }
            if (count >= second.size()) return false;
        }

        return true;
    }

}