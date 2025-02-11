class Solution {

    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};

        System.out.println("===========");
        System.out.println("H index: " + hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        
        int[] freq = new int[citations.length + 1];

        for (int i = 0; i < citations.length; i++) {
            if (citations[i] < freq.length) {
                freq[citations[i]]++;
            } else {
                freq[citations.length]++;
            }
        }

        int s = freq[citations.length];
        int i = citations.length;
        
        while (s < i) {
            i--;
            s += freq[i];
        }
        

        return i;
    }
}