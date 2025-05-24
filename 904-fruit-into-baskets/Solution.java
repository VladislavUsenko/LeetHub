import java.util.HashMap;

class Solution {
    
    public int totalFruit(int[] arr) {

	    HashMap<Integer, Integer> baskets = new HashMap<>();
	    int maxFruit = 0;
        int j = 0;

        for(int i = 0; i < arr.length; i++) {
		    baskets.put(arr[i], baskets.getOrDefault(arr[i], 0) + 1);
		
		    while(baskets.size() > 2) {
			    baskets.put(arr[j], baskets.get(arr[j]) - 1);
			    if(baskets.get(arr[j]) == 0) baskets.remove(arr[j]);
			    j++;
            }

            maxFruit = Math.max(maxFruit, i - j + 1);
        }

        return maxFruit;

    }
}
