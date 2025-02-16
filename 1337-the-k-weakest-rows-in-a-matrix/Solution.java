import java.util.*;

class Solution {

    public static void main(String[] args) {
        int[][] mat = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};

        System.out.println("--------------");
        int[] rows = kWeakestRows(mat, 3);
        System.out.println(Arrays.toString(rows));
    }


    public static int[] kWeakestRows(int[][] mat, int k) {
        
        int[] result = new int[k];

        ArrayList<Row> map = new ArrayList<>();

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) count++;
            }
            map.add(new Row(i, count));
        }

       map.sort(Comparator.comparing(Row::getCount));

        for (int i = 0; i < result.length; i++) {
            result[i] = map.get(i).getIndex();
        }

        return result;
    }
}

class Row {

    int index;
    int count;

    Row(int index, int count) {
        this.count = count;
        this.index = index;
    }

    public int getCount() {
        return count;
    }

    public int getIndex() {
        return index;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}