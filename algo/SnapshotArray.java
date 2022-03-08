import java.util.ArrayList;

// Approach 1: Intuitive way
// Time Complexity: O(N)
// Space Complexity: O(N*snap calls)
class SnapshotArray {
    ArrayList<int[]> snaps;

    public SnapshotArray(int length) {
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