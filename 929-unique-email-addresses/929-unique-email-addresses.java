import java.util.HashSet;

class Solution {

    public static void main(String[] args) {
        
        String[] emails = {
            "test.email+alex@leetcode.com",
            "test.e.mail+bob.cathy@leetcode.com",
            "testemail+david@lee.tcode.com"};

        int num = numUniqueEmails(emails);
        System.out.println(num);
    }

    public static int numUniqueEmails(String[] emails) {

        HashSet<String> uniqueEmails = new HashSet<>();

        for(String email : emails) {

            String[] nameAndDomain = email.split("@");

            nameAndDomain[0] = nameAndDomain[0].replace(".", "");      

            if (nameAndDomain[0].contains("+")) {
                String[] nameParts = nameAndDomain[0].split("\\+");
                nameAndDomain[0] = nameParts[0];
            }

            uniqueEmails.add(nameAndDomain[0] + "@" + nameAndDomain[1]);
        }

        return uniqueEmails.size();
    }
}