/**
   This program tests the merge sort algorithm by
   sorting an array that is filled with random numbers.
*/
public class MergeSortTest
{  
   public static void main(String[] args)
   {  
      int[] a = ArrayUtil.randomIntArray(20, 100);
      ArrayUtil.print(a);
      MergeSorter sorter = new MergeSorter(a);
      sorter.sort();
      ArrayUtil.print(a);
   }
}

