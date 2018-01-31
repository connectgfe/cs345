/* Project 1
 *
 * Author: TODO
 *
 * Implements the Insertion Sort algorithm.
 */

public class Temp2_Proj01_InsertionSort{


   public static void sort(int[] vals){

      sortIt(vals);
       

   }


   public static void sort_trace(int[] vals){

      sortItTrace(vals);
 

   }

   
   public static void sortIt(int[] numbers){

      int i = 0;
      int j = 0;
      int temp = 0;  // Temporary variable for swap

      for (i = 1; i < numbers.length; ++i) {
         j = i;
         // Insert numbers[i] into sorted part 
         // stopping once numbers[i] in correct position
         while (j > 0 && numbers[j] < numbers[j - 1]) {

            // Swap numbers[j] and numbers[j - 1]
            temp = numbers[j];
            numbers[j] = numbers[j - 1];
            numbers[j - 1] = temp;
            --j;
         }
      }

   }


   public static void sortItTrace(int[] numbers){

      int i = 0;
      int j = 0;
      int temp = 0;  // Temporary variable for swap

      for (i = 1; i < numbers.length; ++i) {
         j = i;
         // Insert numbers[i] into sorted part 
         // stopping once numbers[i] in correct position
         while (j > 0 && numbers[j] < numbers[j - 1]) {

            // Swap numbers[j] and numbers[j - 1]
            temp = numbers[j];
            numbers[j] = numbers[j - 1];
            numbers[j - 1] = temp;
            --j;
            System.out.println("swap("+j+","+i+")");


         }
//            System.out.println("swap("+j+","+i+")");




      }

   }






}

