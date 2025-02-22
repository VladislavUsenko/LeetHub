class Solution {

    public static void main(String[] args) {
        int[] vals = {1,4,3,2,5,2};
        ListNode head = new ListNode(vals);

        System.out.println("------------------");
        System.out.println(head);
        head = partition(head, 3);
        System.out.println(head);
    }

    public static ListNode partition(ListNode head, int x) {
        
        ListNode small = new ListNode();
        ListNode pointS = small;
        ListNode big = new ListNode();
        ListNode pointB = big;

        while (head != null) {
            
            if(head.val < x) {
                pointS.next = head;
                pointS = pointS.next;
            } else {
                pointB.next = head;
                pointB = pointB.next;
            }

            head = head.next;
        }

        pointB.next = null;
        pointS.next = big.next;

        return small.next;
    }
}