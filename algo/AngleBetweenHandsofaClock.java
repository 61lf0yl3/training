public class AngleBetweenHandsofaClock {
    // Approach 1: Math
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public double angleClock(int hour, int minutes) {
        double minutesAngle = minutes * 6;
        double hourAngle = ((hour % 12) + minutes / 60.0) * 30;
        double diff = Math.abs(hourAngle - minutesAngle);
        return Math.min(diff, 360 - diff);
    }
}
