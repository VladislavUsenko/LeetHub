class MyQueue {

    List<Integer> list;

    public MyQueue() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
    }

    public int pop() {
        int x = list.get(0);
        list.remove(0);
        return x;
    }

    public int peek() {
        return list.get(0);
    }

    public boolean empty() {
        return list.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */