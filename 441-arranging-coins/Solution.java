class Solution {

    public static void main(String[] args) {
        
        System.out.println(arrangeCoins(24));

    }

    public static int arrangeCoins(int n) {
        
        long low = 1;
        long high = n;
        while(low<=high){
            long mid = low + (high-low)/2;
            long total = (mid*(mid+1))/2;
            if(total == n){
                return (int)mid;
            } else if(total<n){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return (int) high;
    }
}