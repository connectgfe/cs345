/* Project 1
 *
 * Author: TODO
 *
 * Implements the Insertion Sort algorithm.
 */

public class Proj01_InsertionSort{


   public static void sort(int[] vals){

     int[] out = sortIt(vals,0,vals[0]);
       
     for(int i=0;i<out.length;i++){
       System.out.println(out[i]);
     }


   }


   public static void sort_trace(int[] vals){



   }

   
   public static int[] sortIt(int[] arr, int swap, int val){

//    if(swap==arr.length){ return arr;}

     for(int i=0;i<swap;i++){

        if(arr[i]>val){
          arr[swap]=arr[i];
          arr[i]=val;
          break;
        }
     
     }

     for(int i=0;i<arr.length-1;i++){

        if(arr[i+1]<arr[i]){

          swap = i+1;
          val = arr[i+1]; 
          return sortIt(arr,swap,val);
        }

     }
   
    return arr;

   }


}

