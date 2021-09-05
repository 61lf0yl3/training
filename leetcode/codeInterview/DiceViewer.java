class DiceViewer {
    public static void main(String[] args) {
        DiceSimulator sim = new DiceSimulator(6); // two 6-sided dice
        sim.run(10000); // what happens over 10000 rolls of the pair of dice
        sim.printResults();
    }
}