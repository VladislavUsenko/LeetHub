public class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) {this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int[] nums) {
        
        this.val = nums[0];
        ListNode next = new ListNode();
        this.next = next;
        for (int i = 1; i < nums.length; i++) {

            next.val = nums[i];
            next.next = new ListNode();
            next = next.next;
        }
    }

    @Override
    public String toString() {
        return "["+ val + "] -> " + next;
    }
}
