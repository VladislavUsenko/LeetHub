class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(Integer[][] array) {

        this.val = array[0][0];
        Node next = new Node(array[1][0]);
        this.next = next;
        for (int i = 2; i < array.length; i++) {
            next.next = new Node(array[i][0]);
            next = next.next;
        }

        Node head = this;
        int i = 0;
        while (head.next != null) {

            if (array[i][1] == null) {
                head = head.next;
                i++;
                continue;
            }
            
            Node loop = this;
            int j = array[i][1];
            while (j > 0) {
                loop = loop.next;
                j--;
            }

            head.random = loop;
            i++;
            head = head.next;
        }
    }

    @Override
    public String toString() {

        String randomVal = "null";

        if(this.random != null) {
            randomVal = this.random.toString();
        }
        
        return "[" + this.val + ", "
         + randomVal
         + "] -> " + this.next;
    }
}