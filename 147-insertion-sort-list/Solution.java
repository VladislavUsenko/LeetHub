class Solution {

    public static void main(String[] args){

        int[] nums = {4, 2, 1, 3};
        ListNode head = new ListNode(nums);

        ListNode root = insertionSortList(head);

        System.out.println(root);

    }

    public static ListNode insertionSortList(ListNode head) {

        ListNode runner = head;
        ListNode dummy = new ListNode();
        dummy.next = head;

        while (runner != null && runner.next != null) {
            if(runner.val < runner.next.val) {
                runner = runner.next;
            } else {
                ListNode next = runner.next;
                runner.next = next.next;
                ListNode pre = dummy;
                while (pre.next.val < next.val) {
                    pre = pre.next;
                }
                next.next = pre.next;
                pre.next = next;
            }
        }

        return dummy.next;
    }


}