

class Solution {

    public static void main(String[] args) {
        String[]  logs = {"./","wz4/","../","mj2/","../","../","ik0/","il7/"};

        System.out.println("---------------");

        System.out.println(minOperations(logs));
    }

    public static int minOperations(String[] logs) {


        int result = 0;

        for (int i = 0; i < logs.length; i++) {
            if (logs[i].charAt(0) == '.') {
                if (logs[i].charAt(1) == '.') {
                    if (result != 0) result--;
                    continue;
                } else continue;
            } else {
                result ++;
            }

        }

        return result;
    }
}