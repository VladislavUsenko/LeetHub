import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {

        int finalSum = 26;
        List<Long> resultList = maximumEvenSplit(finalSum);

        System.out.println(resultList);
    }

    public static List<Long> maximumEvenSplit(long finalSum) {

        List<Long> resultList = new ArrayList<>();

        if (finalSum % 2 != 0) return resultList;

        long k = 2;
        while (k <= finalSum) {
            resultList.add(k);
            finalSum -= k;
            k += 2;
        }
        resultList.add(finalSum + resultList.removeLast());

        return resultList;
    }
}

