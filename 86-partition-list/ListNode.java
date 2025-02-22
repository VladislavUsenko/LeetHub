public class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    ListNode(int[] vals) {
        this.val = vals[0];
        ListNode next = new ListNode(vals[1]);
        this.next = next;
        for (int i = 2; i < vals.length; i++) {
            next.next = new ListNode(vals[i]);
            next = next.next;
        }
    }

    @Override
    public String toString() {
        return val + " -> " + next;
    }
}