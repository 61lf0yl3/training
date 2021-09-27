class CTSTester{
    public static void main(String[] args) {
        CTS cs = new CTS();
        testAndRun(cs, 1000, 1000);

    }

    public static void testAndRun(CTS cs, int numTrials, int expected) {
            System.out.println("After run("+ numTrials + "):");
            cs.run(numTrials);
            System.out.println("Number of trials [exp: " + expected +"]: " + cs.getNumTrials());
            System.out.println("Num heads: " + cs.getHeads());
            System.out.println("Num tails: " + cs.getTails());  
            System.out.println("Tosses add up correctly? " + (cs.getNumTrials() == (cs.getHeads() + cs.getTails());
            System.out.println();
    }
}