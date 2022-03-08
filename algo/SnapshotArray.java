import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Approach 1: Using HashMap
// Time Complexity: O(N)
// Space Complexity: O(N*snap calls)
class SnapshotArray {
    // SnapId, Value
    Map<Integer, Integer>[] snaps;
    int SnapId;

    Map<Integer, Integer> changes;

    public SnapshotArray(int length) {
        snaps = new HashMap[length];
        for (int i = 0; i < length; i++) {
            snaps[i] = new HashMap<>();
        }
        SnapId = 0;
        changes = new HashMap<>();
    }

    public void set(int index, int val) {
        changes.put(index, val);
    }

    public int snap() {
        for (int key : changes.keySet()) {
            snaps[key].put(SnapId, changes.get(key));
        }
        changes = new HashMap<>();
        return SnapId++;
    }

    public int get(int index, int snap_id) {
        while (snap_id >= 0) {
            if (snaps[index].containsKey(snap_id)) {
                return snaps[index].get(snap_id);
            }
            snap_id--;
        }
        return 0;
    }
}

// Approach 1: Intuitive way (MLE)
// Time Complexity: O(N)
// Space Complexity: O(N*snap calls)
class SnapshotArray2 {
    ArrayList<int[]> snaps;

    public SnapshotArray2(int length) {
        snaps = new ArrayList<>();
        snaps.add(new int[length]);
    }

    public void set(int index, int val) {
        snaps.get(snaps.size() - 1)[index] = val;
    }

    public int snap() {
        int[] temp = snaps.get(snaps.size() - 1).clone();
        snaps.add(temp);
        return snaps.size() - 2;
    }

    public int get(int index, int snap_id) {
        return snaps.get(snap_id)[index];
    }
}