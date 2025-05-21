import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int[] arr) {
        this.val = arr[0];
        ListNode current = this;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
    }

    public void madeLoop(int pos) {
        
        ListNode posNode = this;

        while (pos > 0) {
            posNode = posNode.next;
            pos--;
        }

        ListNode tail = this;

        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = posNode;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        Set<ListNode> visited = new HashSet<>();

        ListNode current = this;
        
        while (current != null) {
            if (visited.contains(current)) {
                sb.append("...");
                return sb.toString();
            }
            visited.add(current);
            sb.append(current.val).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
}