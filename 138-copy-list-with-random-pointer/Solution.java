import java.util.HashMap;

class Solution {

    public static void main(String[] args) {
        
        Integer[][] array = {
            {7, null},
            {13, 0},
            {11, 4},
            {10, 2},
            {1, 0}
        };

        Node head = new Node(array);
        System.out.println("-------------");
        copyRandomList(head);
        //System.out.println(head);
    }

    public static Node copyRandomList(Node head) {

        if (head == null) return null;
        
        HashMap<Node, Node> oldToNew = new HashMap<>();
        
        Node curr = head;
        while (curr != null) {
            oldToNew.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        
        curr = head;
        while (curr != null) {
            oldToNew.get(curr).next = oldToNew.get(curr.next);
            oldToNew.get(curr).random = oldToNew.get(curr.random);
            curr = curr.next;
        }
        
        return oldToNew.get(head);
    }
}