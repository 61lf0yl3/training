/**
   This class sorts an array, using the merge sort 
   algorithm
*/
public class MergeSorter
{
   /**
      Constructs a merge sorter.
      @param anArray the array to sort
   */
   public MergeSorter(int[] anArray)
   {
      a = anArray;
   }
   
   /**
      Sorts the array managed by this merge sorter
   */
   public void sort()
   {  
      if (a.length <= 1) return;
      int[] first = new int[a.length / 2];
      int[] second = new int[a.length - first.length];
      System.arraycopy(a, 0, first, 0, first.length);
      System.arraycopy(a, first.length, second, 0, second.length);
      MergeSorter firstSorter = new MergeSorter(first);
      MergeSorter secondSorter = new MergeSorter(second);
      firstSorter.sort();
      secondSorter.sort();
      merge(first, second);
   }

   /**
      Merges two sorted arrays into the array to be sorted by this
      merge sorter. 
      @param first the first sorted array
      @param second the second sorted array
   */
   private void merge(int[] first, int[] second)
   {  
      // merge both halves into the temporary array

      int iFirst = 0;
         // next element to consider in the first array
      int iSecond = 0;
         // next element to consider in the second array
      int j = 0; 
         // next open position in a

      // as long as neither i1 nor i2 past the end, move
      // the smaller element into a
      while (iFirst < first.length && iSecond < second.length)
      {  
         if (first[iFirst] < second[iSecond])
         {  
            a[j] = first[iFirst];
            iFirst++;
         }
         else
         {  
            a[j] = second[iSecond];
            iSecond++;
         }
         j++;
      }

      // note that only one of the two calls to arraycopy
      // below is executed

      // copy any remaining entries of the first array
      System.arraycopy(first, iFirst, a, j, first.length - iFirst);
      
      // copy any remaining entries of the second half
      System.arraycopy(second, iSecond, a, j, second.length - iSecond);
   }

   private int[] a;
}
