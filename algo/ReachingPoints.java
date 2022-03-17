import java.util.HashSet;
import java.util.Set;
import java.awt.Point;

class ReachingPoints {
    // Approach 1: Work Backwards (Modulo Variant) [Accepted]
    // Time Complexity: O(log(max(tx+ty))
    // Space Complexity: O(1)
    public boolean reachingPoints3(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == ty) {
                break;
            }
            if (tx > ty) {
                if (ty > sy) {
                    tx %= ty;
                } else {
                    return (tx - sx) % ty == 0;
                }
            } else {
                if (tx > sx) {
                    ty %= tx;
                } else {
                    return (ty - sy) % tx == 0;
                }
            }
        }
        return (tx == sx && ty == sy);
    }

    // Approach 1: Exhaustive Search (TLE)
    // Time Complexity: O(2^tx+ty)
    // Space Complexity: O(tx*ty)
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) {
            return false;
        }
        if (sx == tx && sy == ty) {
            return true;
        }
        return reachingPoints(sx, sx + sy, tx, ty) || reachingPoints(sx + sy, sx, tx, ty);
    }

    // Approach 3: DP (TLE)
    // Time Complexity: O(tx*ty)
    // Space Complexity: O(tx*ty)
    Set<Point> seen;
    int tx;
    int ty;

    public boolean reachingPoints2(int sx, int sy, int tx, int ty) {
        seen = new HashSet<>();
        this.tx = tx;
        this.ty = ty;
        search(new Point(sx, sy));
        return seen.contains(new Point(tx, ty));
    }

    private void search(Point P) {
        if (seen.contains(P)) {
            return;
        }
        if (P.x > tx || P.y > ty) {
            return;
        }
        seen.add(P);
        search(new Point(P.x + P.y, P.y));
        search(new Point(P.x, P.x + P.y));
    }
}