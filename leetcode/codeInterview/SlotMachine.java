import java.util.Random;

// SlotMachine simulates a simple slot machine. Payout rules are given in // the problem description
public class SlotMachine{
    public static final int SHORT_PAY = -1; 
    public static final int NUM_SYMBOLS = 6; 
    // space for instance variables here:
    int numbertOfTokens = 0;
    Random generator;
    int[] payoutList = {1, 2, 4, 6, 8, 10, 0};
    //int payout;
    int reelOutput1;
    int reelOutput2;
    int reelOutput3;

    // Creates slot machine with some number of tokens in it.
    // It initially displays three zeros (see “get” methods below).
    // @param startTokens the number of tokens in the machine at the start // PRECONDITION: startTokens >= 0
    public SlotMachine(int startTokens) {
        numbertOfTokens = startTokens;
        generator = new Random();
        reelOutput1 = 0;
        reelOutput2 = 0;
        reelOutput3 = 0;
    }

    // Simulate one play at the slot machine. A spin with no payout increases the
    // number of tokens in the machine by one. But if the play results in a payout,
    // the number of tokens could stay the same or decrease from what it was before
    // the spin. The rules for payouts are given in the problem description.
    // @return the payout from the result of this spin or SHORT_PAY if there aren’t
    // enough tokens in the machine to give the correct payout.
    public int spin() {
        int reelOutput1 = generator.nextInt();
        int reelOutput2 = generator.nextInt();
        int reelOutput3 = generator.nextInt();
        int payout =0;
        numbertOfTokens++;
        if (reelOutput1 == reelOutput2 && reelOutput2 == reelOutput3) {
            payout = payoutList[reelOutput1];
            if (payout > numbertOfTokens) {
                payout = SHORT_PAY;
            }
            return payout;
        }
        numbertOfTokens -= payout;
        return payout;
    }

    // Add some tokens to the machine. (This does not correspond to playing // the machine, but would be done by the machine operator.)
    // @param numTokens the number of tokens to add to the machine
    // PRECONDITION: numTokens >= 0
    public void addTokens(int numTokens) {
        numbertOfTokens+=numTokens;
    }

    // Accessor to get the number of tokens currently in the machine. //(This is a machine operator method.)
    public int getTokensLeft() {   
        return numbertOfTokens;
    }

    // the following three accessors, getReel1Symbol, etc., allow client to // access what’s currently being displayed on the reels.
    // @return a number in the range 0 through NUM_SYMBOLS - 1
    public int getReel1Symbol() {
        return reelOutput1;
    }

    public int getReel2Symbol() {
        return reelOutput2;
    }

    public int getReel3Symbol() {
        return reelOutput3;
    }
}
