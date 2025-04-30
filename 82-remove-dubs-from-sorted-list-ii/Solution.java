class Solution {

    public static void main(String[] args) {
        
        int[] nums = {1,1,1,1,1};
        ListNode head = new ListNode(nums);

        System.out.println("================");
        System.out.println(deleteDuplicates(head));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        
        if(head == null || head.next == null) return head;

        ListNode runner = head.next;
        ListNode checker = head;
        ListNode dummy = null;

        while (runner != null) {
            if(runner.val == checker.val) {

                while (runner != null && runner.val == checker.val) {
                    runner = runner.next;
                }

                if(dummy == null) {
                    head = runner;   
                } else {
                    dummy.next = runner;
                }

                checker = runner;
                if(runner != null) {
                    runner = runner.next;
                }
                
                
            } else {
                dummy = checker;
                checker = checker.next;
                runner = runner.next;
            }
        }


        return head;
    }
}