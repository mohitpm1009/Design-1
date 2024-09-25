//Used array and Node implemetation 
//Time complexity for add(key)
//                   Avg time - O(1) - when distribution of keys are good
//                   Worst case - O(n) - when the nodes are placed in the same index
// Time complexity for remove(key)
//                   Avg time - O(1) - when distribution of keys are good and they are placed in different indices
//                   Worst case - O(n) - when nodes are placed in the same index
// Time complexity for contains(key)
//                   Avg time - O(1) - when distribution of keys are good and they are placed in different indices
//                   Worst case - O(n) - when nodes are placed in the same index 
// Space complexity - O(n) - because - for array - O[SIZE] + for Node O(n) because n nodes are created if we add O(SIZE+n) = O(n) because SIZE is constant

class MyHashSet {

    private static final int SIZE = 1000;
    private Node[] hashSet;

    private class Node {
        int key;
        Node next;

        Node (int key) {
            this.key = key;
            this.next = next;
        }
    }
    public MyHashSet() {
        hashSet = new Node[SIZE];
    }

    private int getIndex(int key) {
        return Math.abs(Integer.hashCode(key)) % SIZE;
    }
    
    public void add(int key) {
        int index = getIndex(key);
        Node current = hashSet[index];

        if (current == null) {
            hashSet[index] = new Node(key);
            return;
        }

        while (current != null) {
            if (current.key == key) {
                return;
            }
            if (current.next == null) break;
            current = current.next;
        }

        current.next = new Node(key);
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        Node current = hashSet[index];
        Node previous = null;

        while (current != null) {
            if (current.key == key) {
                if (previous == null) {
                    hashSet[index] = current.next;
                }
                else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }
    
    public boolean contains(int key) {
        int index = getIndex(key);
        Node current = hashSet[index];
        Node previous = null;

        while (current != null) {
            if (current.key == key) {
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */