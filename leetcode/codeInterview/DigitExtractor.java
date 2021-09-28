// DigitExtractor breaks up a positive integer into its individual digits. 
public class DigitExtractor{
    private int inputNumber;
    private int largestPowerOf10;
    // Creates digit extractor for the given integer. 
    // @param anInt the integer to extract from
    // PRECONDITION: anInt > 0
    public DigitExtractor(int anInt) {
        inputNumber = anInt;
        largestPowerOf10 = largestPowerOf10(inputNumber);
    }

    // Returns true iff there are more digits left to extract. 
    public boolean hasNextDigit() {
        return inputNumber>0;
    }

    // Extracts the the "next" digit in the integer (starts from leftmost 
    // (most significant) digit, and goes rightward)
    // PRECONDITION: hasNextDigit()
    // @return the digit
    public int nextDigit() {
        int res = inputNumber/largestPowerOf10;
        inputNumber %=largestPowerOf10;
        largestPowerOf10 /=10;
        return res;
    }

    // largestPowerOf10: see comment on previous page
    private static int largestPowerOf10(int num) { /* already written */ }
}
