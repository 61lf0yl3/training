import java.util.ArrayList;

class s16md1{
    public static void main(String[] args){
        ArrayList<String> words = new ArrayList<>();
        words.add("i");
        // words.add("am");
        // words.add("a");
        // words.add("cat");
        printSentence(words);
    }
    public static void printSentence(ArrayList<String> words) { 
        for (int i = 0; i < words.size(); i++) {
            if (i != 0) {
                System.out.println(" ");
            }
            System.out.print(words.get(i));
        }
            System.out.println("."); 
    }
}