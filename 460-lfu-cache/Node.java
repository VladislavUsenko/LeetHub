

public class Node implements Comparable<Node>{

    int key;
    int val;
    int freq;
    long timestamp;

    public Node(int key, int val, int freq, long timestamp){
        this.key = key;
        this.val = val;
        this.freq = freq;
        this.timestamp = timestamp;
    }

    @Override
    public int compareTo(Node other) {
        if(freq == other.freq) {
            return Integer.compare((int)timestamp, (int)other.timestamp);
        }
        return Integer.compare(freq, other.freq);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Node node = (Node) obj;
        return key == node.key;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(key);
    }
}
