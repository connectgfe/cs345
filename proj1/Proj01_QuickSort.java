/* Project 1
 *
 * Author: TODO
 *
 * Implements the QuickSort algorithm.
 */

public class Proj01_QuickSort{
     

    public static void sort(int[] vals){
      
      sortIt(vals,0,vals.length-1);


    }




    public static void sort_trace(int[] vals){
 


    }


    public static int sortItHelper(int[] arr, int a, int b){

       int p = arr[b];
       int i = (a - 1);

       for(int j=a; j <= b-1; j++){
         if(arr[j] <= p){ 
            i++; 
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
         }
       }

       int temp2= arr[i+1];
       arr[i+1]=arr[b];
       arr[b] = temp2;

       return(i+1);

    }

   public static void sortIt(int[] arr, int a, int b){

      if(a<b){
         int p = sortItHelper(arr,a,b);

         sortIt(arr,a, p -1);
         sortIt(arr,p+1,b);

      }

   }



}

