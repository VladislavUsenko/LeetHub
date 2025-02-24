class Solution {

    public static void main(String[] args) {
        
        String time = "??:??";

        System.out.println("==============");
        System.out.println(countTime(time));
    }

    public static int countTime(String time) {
        
        String[] times = time.split(":");

        int hours = countHours(times[0]);
        int minutes = countMinutes(times[1]);

        return hours * minutes;
    }

    public static int countHours(String hours){

        if(!hours.contains("?")) return 1;

        if (hours.equals("??")) return 24;

        if (hours.charAt(1) == '?') {
            int i = Character.getNumericValue(hours.charAt(0));

            return i != 2 ? 10 : 4;
        } else {
            int i = Character.getNumericValue(hours.charAt(1));

            return i < 4 ? 3 : 2;
        }


    }

    public static int countMinutes(String minutes){

        if(!minutes.contains("?")) return 1;

        if (minutes.equals("??")) return 60;

        if (minutes.charAt(1) == '?') {
            return 10;
        } else {
            return 6;
        }
    }
}