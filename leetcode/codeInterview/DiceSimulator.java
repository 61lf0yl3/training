import java.util.Random;

public class DiceSimulator {
    private int numSides;
    Random generator1;
    private int numRolls;
    int possibleNumberOutput = 11;
    private int[] results = new int[possibleNumberOutput+2];
    
    // constructs a dice simulator using dice with the given number of side
    // pre: numSides >= 1
    public DiceSimulator(int numSides) {
        this.numSides = numSides;
        generator1 = new Random();
    }
    
    // run the simulation for the given number of rolls of the pair of die
    // pre: numRolls >= 0
    public void run(int numRolls) {
        this.numRolls = numRolls;
        for (int i = 0; i<numRolls; i++) {
            int output1 = generator1.nextInt(numSides)+1;
            int output2 = generator1.nextInt(numSides)+1;
            results[output1+output2]++;
        }
    }
    
    // prints out the results of the simulation:
    // shows for each of the values from 2 to 2*numSides,
    // how many times the roll of the pair summed up to that value
    // [see sample output for details of output format]
    public void printResults() {
    // to save you some typing... here's *part* of the code for printig
    // the headers for the table of results
        System.out.print("Results of rolling the dice ");
        System.out.print(numRolls);
        System.out.println(" times:");
        System.out.println("sum   number of rolls");
        for (int i=2; i< results.length; i++) {
            System.out.print(i);
            System.out.print("   ");
            System.out.println(results[i]);
        }

    }
}
      