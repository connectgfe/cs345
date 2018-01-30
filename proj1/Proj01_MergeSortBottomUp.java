/* Project 1
 *
 * Author: TODO
 *
 * Implements the Merge Sort algorithm (bottom-up algorithm, in the
 * style of external merge sort.
 */

public class Proj01_MergeSortBottomUp{



     public static void sort(int[] vals){

       sortIt(vals); 


     }


     public static void sort_trace(int[] vals){

   

     }



       public static void sortIt(int[] a){
           
          int n  = a.length;
         
          int[] aux = new int[n];

          for (int sz = 1; sz < n; sz = sz+sz){
              for (int lo = 0; lo < n-sz; lo += sz+sz){
              
                 merge(a, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, n-1));
               } 
           }
        }



       private static void merge(int[] arr, int[] tmp, int l, int m, int h){


             for (int k = l; k <= h; k++){
                      tmp[k] = arr[k];
              }

                      int i = l; int j = m+1;

             for (int k = l; k <= h; k++){

                 if (i > m){ 
                   arr[k] = tmp[j++];
               
                  }else if (j > h){ 
                    arr[k] = tmp[i++];
                  }else if ((tmp[j] < tmp[i])){ 
                    arr[k] = tmp[j++];
                  }else{ 
                    arr[k] = tmp[i++];
                  } 
                
               }

        }

}

