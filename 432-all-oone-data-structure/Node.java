public class Node {
    
    Node prev;
    Node next;
    String str;
    int cout;

    public Node(String str) {
            this.str = str;
            this.cout = 1;
    }

    @Override
    public String toString() {
        return "Node{" +
            "str='" + str + '\'' +
            ", cout=" + cout +
            ", prev=" + (prev != null ? prev.str : "null") +
            ", next=" + (next != null ? next.str : "null") +
            '}';
    }      
}
