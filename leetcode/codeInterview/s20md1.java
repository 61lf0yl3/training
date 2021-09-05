import java.util.Arrays;

class s20md1 {
    public static void main(String[] args) {
        //int temp =71;
        //System.out.println(getWeather(temp));
        
        
        // int numSteps = 7;
        // Drunkard1D d = new Drunkard1D(3); 
        // System.out.print(d.getCurrentLoc()); // prints initial location (3) 
        // for (int i = 0; i < numSteps; i++) {
        //     d.takeStep();
        //     //System.out.print(" " + d.getCurrentLoc());
        // }
        // System.out.println();
       
        // Names n = new Names();
        // System.out.println(n.lookupLoc2("Li"));
        
        
        int num = 5;
        System.out.println(Arrays.toString(createSequence(num)));

    }
    public static int[] createSequence(int n) {
        int sum = n*(n+1)/2;
        int[] arr = new int[sum];
        int index = 0;
        for (int i= 1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                arr[index] = j;
                index++;
            }
        }
        return arr;
    }

    public static String getWeather(int temp) {
        String weather = "cold";
        if (temp >= 60) {
           weather = "cold";
        }
        else if (temp >= 70) {
           weather = "just right";
        }
        else if (temp >= 80) {
           weather = "hot";
        }
        else if (temp >= 90) {
           weather = "boiling";
        }
        return weather;
     }
}