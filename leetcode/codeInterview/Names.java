import java.util.ArrayList;

public class Names {
    // representation invariant:
    // values in namesArr are unique and in increasing alphabetical order 
    private ArrayList<String> namesArr;
    
    public Names() {
        namesArr = new ArrayList<>();
        namesArr.add("Avinash");
        namesArr.add("Carly");
        namesArr.add("John");
        namesArr.add("Mana");
        namesArr.add("Peter");
        namesArr.add("Sa");
        namesArr.add("Yiqi");
    }

    // returns location of target in namesArr or -1 if not found
    public int lookupLoc(String target) { //[do not change the method header]
        int index = -1;
        for (int i = 1; i < namesArr.size(); i++) {
            
            if (target.compareTo(namesArr.get(i-1)) > 0  && target.compareTo(namesArr.get(i)) < 0) { 
                index = i;
            }
        }
        return index;
    } 

    public int lookupLoc2(String target) {

        for (int i = 0; i < namesArr.size(); i++) {
  
           int result = target.compareTo(namesArr.get(i));
  
            if (result < 0) { 
               return -1;
            }
  
            if (result == 0) {
                return i;
            }
           
        }
        
        return -1;
     }
}

/*
s1.compareTo(s2)
For Strings s1 and s2 in the call above,
compareTo returns an int value either greater than zero,
less than zero, or equal to zero,
depending on which one has the greater lexicographic value 
(effectively, alphabetical comparison for words). 
If the return value is:

 < 0   s1 comes before s2 in an alphabetical ordering
 > 0 s1 comes after s2 in an alphabetical ordering
*/