
class Main {

    public static void main(String[] args) {
        
        int[][] matrix = {
            {3, 0, 1, 4, 2}, 
            {5, 6, 3, 2, 1}, 
            {1, 2, 0, 1, 5}, 
            {4, 1, 0, 1, 7}, 
            {1, 0, 3, 0, 5}};

        matrix = new int[][]{{-4, -5}};

        NumMatrix num = new NumMatrix(matrix);
        //int res = num.sumRegion(2, 1, 4, 3);
        int res = num.sumRegion(0, 1, 0, 1);
        System.out.println(res);

        //res = num.sumRegion(1, 1, 2, 2);
        System.out.println(res);
    }
}