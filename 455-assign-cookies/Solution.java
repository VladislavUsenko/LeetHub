import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        
        int[] g = {1,2,3};
        int[] s = {1,1};

        System.out.println("======================");
        System.out.println(findContentChildren(g, s));
    }


    public static int findContentChildren(int[] g, int[] s) {
         Arrays.sort(s);
         Arrays.sort(g);
         int i=0,j=0;
         while(i<g.length && j<s.length ){
            if(s[j]>=g[i]){
             i++;
                
         }
         j++;
    }
     return i;
}
}