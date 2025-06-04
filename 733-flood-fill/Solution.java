import java.util.*;

class Solution {

    public static void main(String[] args) {
        
        int[][] image = {
            {1,1,1},
            {1,1,0},
            {1,0,1}
        };

        int sr = 1;
        int sc = 1;
        int color = 2;

        System.out.println("---------------");
        image = floodFill(image, sr, sc, color);

        for(int[] row: image) {
            System.out.println(Arrays.toString(row));
        }
    }


    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int oldColor = image[sr][sc];
        if(oldColor == color) return image;
        fill(image, sr, sc, color, oldColor);

        return image;

    }

    public static void fill(int[][] image, int x, int y, int newColor, int oldColor) {

        if(0 <= x && x < image.length &&
           0 <= y && y < image[0].length &&
           image[x][y] == oldColor) {
             image[x][y] = newColor;
             fill(image, x + 1, y, newColor, oldColor);
             fill(image, x - 1, y, newColor, oldColor);
             fill(image, x, y + 1, newColor, oldColor);
             fill(image, x, y - 1, newColor, oldColor);
        }
    }

}