import java.util.Random;

// Represents a "drunkard" doing a random walk along an integer number line. // Drunkard chooses direction and step size randomly. Steps range in
// distance from 1 to MAX_STEP_SIZE, inclusive.
public class Drunkard1D {
    public static final int MAX_STEP_SIZE = 10;
    Random generator;
    int location;
    // Creates drunkard with given starting location. 
    // @param startLoc starting location of drunkard 
    public Drunkard1D(int startLoc) {
        generator = new Random();
        location = startLoc;
    }
    
    
    // Takes a random-length step of size in the range [1, MAX_STEP_SIZE] in 
    // a random direction on the number line.
    public void takeStep() {
        int output1 = generator.nextInt(10)+1;
        boolean output2 = generator.nextBoolean();  //true is step forward and fakse is step back
        if (!output2) {
            output1*=-1;
        }
        // System.out.println("output: "+ output1);
        // System.out.println("direction: "+ output2);
        location += output1;
        // System.out.println("location: "+ location);
        // System.out.println();
    }
    
    
    // Gets the current location of the drunkard. (accessor) 
    // @return an int representing drunkard's current location 
    public int getCurrentLoc() {
        return location;
    }
}
