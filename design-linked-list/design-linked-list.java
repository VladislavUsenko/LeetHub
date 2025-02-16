
class MyLinkedList {
    ListNode head;
    int length;
    
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    
    public MyLinkedList() {
        this.head = null;
        this.length = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= this.length) {
            return -1;
        } else {
            int count = 0;
            ListNode curr = head;
            while (count < index) {
                curr = curr.next;
                count++;
            }
            return curr.val;
        }
    }
    
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    }
    
    public void addAtTail(int val) {
        if (this.length == 0) {
            addAtHead(val);
            return;
        }
        
        ListNode newNode = new ListNode(val);
        ListNode temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = null;
        this.length++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > this.length) {
            return;
        }
        
        if (index == 0) {
            addAtHead(val);
            return;
        }
        
        if (index == this.length) {
            addAtTail(val);
            return;
        }
        
        ListNode newNode = new ListNode(val);
        ListNode temp = this.head;
        int count = 0;
        
        while (count < index - 1) {
            temp = temp.next;
            count++;
        }
        
        newNode.next = temp.next;
        temp.next = newNode;
        this.length++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.length) {
            return;
        }
        
        ListNode curr = this.head;
        int count = 0;
        
        if (index == 0) {
            this.head = curr.next; 
            this.length--;
        } else {
            ListNode pre = null;
            while (count < index) {
                pre = curr;
                curr = curr.next;
                count++;
            }
            pre.next = curr.next;
            this.length--;
        }       
    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
