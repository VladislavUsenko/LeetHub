public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }

        this.val = nums[0];
        ListNode current = this;
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            sb.append(current.val).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
