class Solution {

    public static void main(String[] args) {
        String[] ops = {"5","2","C","D","+"};
        System.out.println("---------------");
        System.out.println("result: " + calPoints(ops)  );
    }

    public static int calPoints(String[] operations) {
        
    
        int index = 0, result = 0;
        int[] score = new int[operations.length];

        for (int i = 0; i < operations.length; i++) {
            if (operations[i].charAt(0) == 'C') {
                result -= score[--index];
                continue;
            }
            if (operations[i].charAt(0) == 'D') {

                score[index] = score[index - 1] * 2;

                result += score[index];
                index++;
                continue;
            }
            if(operations[i].charAt(0) == '+') {
                score[index] = score[index - 2] + score[index - 1];
                result += score[index];
                index++;
                continue;
            }

            score[index] = Integer.parseInt(operations[i]);
            result += score[index];
            index++;

        }

        return result;
    }
}