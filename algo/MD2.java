import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.awt.Point;

class MD2 {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print ("Please enter a file name: ");
            String fileName = in.next();
            DataObject data = readFile(fileName);
            data.process();
            data.printResults(System.out);
         }
         catch (IOException e) {
            System.out.println("Caught IOException. Exiting program."); 
        }
    }

    public static DataObject readFile2(String fileName) {
        DataObject data = new DataObject(); // create an empty data obejct File inFile = new File(fileName);
        Scanner fileScanner = new Scanner(inFile);
        while (fileScanner.hasNext()) {
        //... [readsandputsstuffin“data”] }
        fileScanner.close();
              return data;
    }

    public static void printList1(List<Integer> list) { 
        for (int i = 0; i < list.size(); i++) { 
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
     }
     
    public static void printList2(List<Integer> list) {
        ListIterator<Integer> iter = list.listIterator();
        while (iter.hasNext()) {
           System.out.print(iter.next() + " ");
        }
        System.out.println();
    }

    static boolean isUpDown(int[] a) {
        return isUpDownR(a, 1);
    }

    static boolean isUpDownR(int[] a, int nb) {
        if (a.length == 0) {
            return true;
        } 
        if (a.length == 1 && a[0] == nb) {
            return true;
        }
        if (a[0] == nb && a[0] == a[a.length-1]) {
            a = Arrays.copyOfRange(a, 1, a.length-1);
            return isUpDownR(a, nb+1);
        }
        return false;
    }

    
    // public static double averageScore(TreeMap<String, Integer> myMap) { 
    //     Set<String> keys = myMap.keySet();
    //     Iterator<String> iter = keys.iterator();
    //     //Set<Map<String, Integer>> = 
    //     int sum = 0;
    //     int count = 0;
    //     while (iter.hasNext()) {
    //     String name = iter.next(); Integer score = myMap.get(name); sum += score;
    //     count++;
    //     }
    //     return sum / (double) count; 
    // }

    public static int num3s(int num) {
        return num3sR(num, 0);
    }

    public static int num3sR(int num, int counter) {
        if (num <=0) {
            return counter;
        } else {
            if (num%10 == 3) {
                counter+=1;
            }
            return num3sR(num/10, counter);
        }
    }

    static void sortByDistance(ArrayList<Point> points, Point target) { 
        Collections.sort(points, new DistanceComparator());
            
    }

    // public static void paintItRed(Color[][] image, int row, int col) {
    // if(!inRange(image, row, col)) {
    //     return; // we're not in bounds of the image
    //     }
    //     if (image[row][col].equals(Color.BLACK) || image[row][col].equals(Color.RED)) {
    //     return; // we've hit the edge of the region
    //     }
    //     image[row][col] = Color.RED;
    //     // recursively call paintItRed on the neighbors of (row, col) 
    //     for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
    //         for (int colOffset = -1; colOffset <= 1; colOffset++) {
    //             if (!(rowOffset == 0 && colOffset == 0)) { // don't call it with same params
    //                 paintItRed(image, row + rowOffset, col + colOffset);
    //             }
    //         }
    //     }
    // }

    public static DataObject readFile(String fileName) throws IOException {
        DataObject data = new DataObject(); // create an empty data object
        File inFile = new File(fileName);
        try (Scanner fileScanner = new Scanner(inFile)) {
            while (fileScanner.hasNext()) {
                String input = fileScanner.next();
                int num = Integer.parseInt(input);
                data.add(num);
            }
        }
        return data;
    }

    public static void printVal(Map<Point, String> myMap, Point targetKey) {
        // System.out.println("My map: "+myMap);
        System.out.println("targetKey hashcode: " + targetKey.hashCode());
        String val = myMap.get(targetKey);
        if (val == null) {
            System.out.println("no such entry");
        } else {
            System.out.println(val);
        }
    }

    public static void printReversedSentence(Scanner in) {
        Stack<String> s = new Stack<>();
        boolean hasPeriod = false;
        while (in.hasNext()) {
            String word = in.next();
            if (word.charAt(word.length() - 1) == '.') {
                hasPeriod = true;
                word = word.substring(0, word.length() - 1);
            }
            s.push(word);
        }
        System.out.print(s.pop());
        while (!s.empty()) {
            System.out.print(" " + s.pop());
        }
        if (hasPeriod) {
            System.out.print(".");
        }
        System.out.println();
    }

    public static int binSearch(int[] vals, int target) {
        return binSearchR(vals, target, 0, vals.length - 1);
    }

    public static int binSearchR(int[] vals, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (vals[mid] == target) {
            return mid;
        } else if (vals[mid] > target) {
            return binSearchR(vals, target, low, mid - 1);
        } else {
            return binSearchR(vals, target, mid + 1, high);
        }
    }

    public static int numDouble(int[] nums) {
        return numDoubleR(nums, 0, 0);
    }

    public static int numDoubleR(int[] nums, int counter, int index) {
        if (index >= nums.length) {
            return counter;
        } else {
            if (nums[index] / 10 == nums[index] % 10) {
                counter += 1;
            }
            return numDoubleR(nums, counter, index + 1);
        }
    }

    // PRECONDITION: str.length() is even
    public static boolean mystery(String str) {
        Stack<Character> stack = new Stack<Character>();
        int loc = str.length() / 2;

        for (int i = 0; i < loc; i++) {
            stack.push(str.charAt(i));
        }

        // ***
        if (str.length() % 2 == 1) {
            // ***
            loc++;
            // ***
        }

        for (int i = loc; i < str.length(); i++) {
            if (str.charAt(i) != stack.peek()) {
                return false;
            }
            stack.pop();
        }
        return true;
    }

    // private static ArrayList<String> readFile() throws IOException {
    // ArrayList<String> lines = new ArrayList<>();
    // try (Scanner inFile = new Scanner(new File("error2.txt"))) {
    // for (int i = 0; i < 3; i++) {
    // lines.add(inFile.nextLine());
    // }
    // if (inFile.hasNext()) {
    // throw new MyException();
    // }
    // } catch (FileNotFoundException e) {
    // System.out.println("Error #3");
    // }
    // return lines;
    // }

    public static boolean hasTriple7(int[] nums) {
        return hasTriple7R(nums, 0, 0);
    }

    public static boolean hasTriple7R(int[] nums, int counter, int index) {
        if (index >= nums.length) {
            return false;
        } else {
            if (nums[index] == 7) {
                counter += 1;
            } else {
                counter = 0;
            }
            if (counter == 3) {
                return true;
            }
            return hasTriple7R(nums, counter, index + 1);
        }
    }

    public static Map<String, Integer> inBoth(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> res = new HashMap<>();
        Map<String, Integer> map;
        if (map1.size() < map2.size()) {
            map = map1;
        } else {
            map = map2;
        }
        for (String key : map.keySet()) {
            Integer value1 = map1.get(key);
            Integer value2 = map2.get(key);
            if (value1 == value2) {
                res.put(key, value1);
            }
        }
        return res;
    }

    public static void expection() {
        int num = 10;
        try {
            System.out.println("Opening file...");
            Scanner inFile = new Scanner(new File("data.txt"));
            int inVal = inFile.nextInt();
            num += inVal;
        } catch (NoSuchElementException exception) {
            System.out.println("Problem with file");
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }
        System.out.println(num);
        System.out.println("Exiting program");
    }

    public static int findLast(int[] nums, int target) {
        return findLastR(nums, target, -1, 0);
    }

    public static int findLastR(int[] nums, int target, int counter, int index) {
        if (index >= nums.length) {
            return counter;
        } else {
            if (nums[index] == target) {
                counter = index;
            }
            return findLastR(nums, target, counter, index + 1);
        }
    }

    public static void wordsMoreThanOnce() {
        ArrayList<String> ar = new ArrayList<String>();
        // ar.add("the");
        ar.add("big");
        // ar.add("dog");
        // ar.add("big");
        // ar.add("of");
        // ar.add("the");
        ar.add("big");
        ar.add("big");
        // ar.add("dog");

        System.out.println("Before map");
        for (int i = 0; i < ar.size(); i++)
            System.out.print(ar.get(i) + " ");
        System.out.println();

        Map<String, Boolean> m = new HashMap<>();

        for (int i = 0; i < ar.size(); i++) {
            if (m.containsKey(ar.get(i))) {
                m.put(ar.get(i), true);
            } else {
                m.put(ar.get(i), false);
            }
        }

        System.out.println(m);
    }

    public static void sortByArea(ArrayList<Rectangle> boxes) {
        Collections.sort(boxes, new SortbyArea());
    }
}

class SortbyArea implements Comparator<Rectangle> {
    // Used for sorting in descending order of
    // roll number
    public int compare(Rectangle a, Rectangle b) {
        return (int) ((b.getWidth() * b.getHeight()) - a.getWidth() * a.getHeight());
    }
}

class DataObject {
    ArrayList<Integer> nums;

    DataObject() {
        nums = new ArrayList<>();
    }

    void process() {
        return;
    }

    void add(int num) {
        nums.add(num);
    }

    void printResults() {
        System.out.println(nums);
    }

}

class DistanceComparator implements Comparator<Point> {
    public int compare(Point a, Point b) {
        return (int) a.distance(b);
    }
}

// class myClass implements BiConsumer<String,Integer> {
//     // Used for sorting in descending order of
//     // roll number
//     public int accept(String name, Integer score)
//     {
//          if (score < 60){
//               System.out.println(score + " " + name);
//          }
//     }
//  }
 