/* Project 1
 *
 * Author: TODO
 *
 * Implements the Merge Sort algorithm (conventional, recursive design).
 */

public class Proj01_MergeSort{


   public static void sort(int[] vals){

      sortIt(vals,0, vals.length-1);

   }


   public static void sort_trace(int[] vals){


   }


   public static void sortIt(int[] arr, int a, int b){

     if( a < b ){

     int j = a+(b-a)/2;

     sortIt(arr,a,j);
     sortIt(arr,j+1,b);

     merge(arr,a,j,b);

     }
     

   }





   public static void merge(int[] arr, int a, int b, int c){


          int i, j, k;
          int v1 = b - a +1;
          int v2 = c -b;

          int l[] = new int[v1]; int r[] = new int[v2];

          for(i =0; i< v1; i++){
             l[i]=arr[a+i];
          }

          for( j =0; j< v2; j++){
             r[j]=arr[b+j+1];
          }

          i=0; j =0; k = a;
         
          while ( i < v1 && j < v2){

            if(l[i] <= r[j]){ 
              arr[k]=l[i]; i++;
            }else{
              arr[k]=r[j]; j++; 
            }
            k++;

          }

          while (i < v1){
            arr[k] = l[i];
            i++;
            k++;
          }

          while (j < v2){
            arr[k] = r[j];
            j++;
            k++;
          }

       }



  
}

