class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();

        List<String> sortedProducts = new ArrayList<>(Arrays.asList(products));
        Collections.sort(sortedProducts);

        for (int i = 0; i < searchWord.length(); i++) {
            List<String> subResult = new ArrayList<>();
            String sub = searchWord.substring(0, i + 1);

            for (String product : sortedProducts) {
                if (sub.length() > product.length()) continue;
                
                String productSub = product.substring(0, i + 1);

                if (productSub.equals(sub)) {
                    subResult.add(product);
                }
            }

            if (subResult.size() > 3) {
                result.add(subResult.subList(0, 3));
            } else result.add(subResult);
        }


        return  result;
    }
}