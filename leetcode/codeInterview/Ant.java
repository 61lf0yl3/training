public class Ant {
    int position;
    int direction; // -1 means ants headed to the left, and 1 opposite
    final int left = -1;
    final int right = 1;

    // Create an ant at position startPos, facing left
    public Ant(int startPos) {
        position = startPos;
        direction = left;
    }

    // Move the ant by one unit in the direction it is facing.
    public void move() {
        position+= direction;
    }

    // Turn the ant in the opposite direction
    public void turn() {
        direction*=-1;
    }

     // Get the ant's current position
    public int getPosition() {
        return position;
    }

     // Return true iff the ant is facing right
    public boolean isFacingRight() {
        if (direction == right) {
            return true;
        }
        return false;
    }
}