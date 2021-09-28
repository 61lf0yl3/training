// Stores a list of unique names in alphabetical order. Allows // look-up, insert, and removal of elements in the list.
public class Names2 {
    private String[] namesArr;
    private int startLoc; // location of the first name in namesArr
    
    private final static int NOT_FOUND = -1;
    private final static int INITIAL_CAPACITY = 10;
    // Creates an empty names object 
    public Names() {
        namesArr = new String[INITIAL_CAPACITY];
        startLoc = namesArr.length;
    }
    
    // Returns the number of names in the list 
    public int numNames() {
        return namesArr.length - startLoc;
    }
    
    
    // Removes target from names, and returns true.
    // If target wasn't present in names, returns false and no change
    // made to names.
    public boolean remove (String target) {
       int index = lookupLoc(target);
        if (index ==  NOT_FOUND) {
            return false;
        }

        for (int i=index; i>= startLoc; i--) {
            namesArr[i] = namesArr[i-1];
        }
        startLoc++;
        return true;
    }
    // lookupLoc returns index of target in namesArr or NOT_FOUND
    // if it is not present
    private int lookupLoc(String target) { . . . } // do not implement . . . // other Names methods not shown
    // starting capacity of array
}