/* Project 1
 *
 * Author: TODO
 *
 * Implements the Insertion Sort algorithm.
 */

public class Proj01_InsertionSort{


   public static void sort(int[] vals){

     int[] out = sortIt(vals,0,vals[0]);
       

   }


   public static void sort_trace(int[] vals){

     int[] out2 = sortItTrace(vals,0,vals[0]);
 

   }

   
   public static int[] sortIt(int[] arr, int swap, int val){


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

   public static int[] sortItTrace(int[] arr, int swap, int val){


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

