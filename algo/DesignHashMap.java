import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

class DesighHashMap {
    public static void main(String[] args) {

    }
}

class MyHashMap {
    private int keySpace;
    private List<Bucket> hashTable;

    public MyHashMap() {
        keySpace = 2069;
        hashTable = new ArrayList<>();
        for (int i = 0; i < keySpace; i++) {
            hashTable.add(new Bucket());
        }
    }

    public void put(int key, int value) {
        int hashKey = key % keySpace;
        hashTable.get(hashKey).update(key, value);
    }

    public int get(int key) {
        int hashKey = key % keySpace;
        return hashTable.get(hashKey).get(key);
    }

    public void remove(int key) {
        int hashKey = key % keySpace;
        hashTable.get(hashKey).remove(key);
    }
}

class Bucket {

    private List<Pair<Integer, Integer>> bucket;

    public Bucket() {
        bucket = new LinkedList<>();
    }

    public Integer get(Integer key) {
        for (Pair<Integer, Integer> pair : bucket) {
            if (pair.first.equals(key)) {
                return pair.second;
            }
        }
        return -1;
    }

    public void update(Integer key, Integer value) {
        boolean FOUND = false;
        for (Pair<Integer, Integer> pair : bucket) {
            if (pair.first.equals(key)) {
                pair.second = value;
                FOUND = true;
            }
        }
        if (!FOUND) {
            bucket.add(new Pair<Integer, Integer>(key, value));
        }
    }

    public void remove(Integer key) {
        for (Pair<Integer, Integer> pair : bucket) {
            if (pair.first.equals(key)) {
                bucket.remove(pair);
                break;
            }
        }
    }

}

class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
