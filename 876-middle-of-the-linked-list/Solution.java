
class Solution {

    public static void main(String[] args) {
        
        ListNode head = new ListNode(new int[]{1,2,3,4,5});

        System.out.println("-------------");
        System.out.println(middleNode(head));
    }

    public static ListNode middleNode(ListNode head) {
        
        ListNode walker = head;
        ListNode runner = head;

        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }

        return walker;

    }
}