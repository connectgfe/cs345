/* Project 1
 *
 * Author: TODO
 *
 * Implements the Merge Sort algorithm (conventional, recursive design).
 */

public class Proj01_MergeSort{


   public static void sort(int[] vals){

//      sortIt(vals,0, vals.length-1);
//      sortItB(vals);
          sort3(vals);

   }


   public static void sort_trace(int[] vals){


   }



private static void merge3(int[] a, int[] aux, int lo, int mid, int hi)
{
 for (int k = lo; k <= hi; k++)
 aux[k] = a[k];
 int i = lo, j = mid+1;
 for (int k = lo; k <= hi; k++)
 {
 if (i > mid) a[k] = aux[j++];
 else if (j > hi) a[k] = aux[i++];
 else if ((aux[j] < aux[i])) a[k] = aux[j++];
 else a[k] = aux[i++];
 }
}

 public static void sort3(int[] a)
 {
 int N = a.length;
 int[] aux = new int[N];
 for (int sz = 1; sz < N; sz = sz+sz)
 for (int lo = 0; lo < N-sz; lo += sz+sz)
 merge3(a, aux,lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
 }






    public static void sortItB(int[] arr){

      int w;
      int[] tmp = new int[arr.length];

      for( w =1; w < arr.length; w = 2*w ){

          int i;
          for( i =0; i< arr.length-w; i = i + 2*w){

            int l, m, r;

            l=i;
            m= i +w;
            r= i + 2*w;

            mergeB(arr,l,m,r,tmp);

          }

         for(i =0;i<arr.length;i++){

             arr[i]=tmp[i];
         }

      }

    }


  public static void mergeB(int[] arr,int l, int r, int e, int[] tmp){

       int i=l; int j= r; int k;
      
       for(k =l; k<e; k++){

         if(i<r &&(j>e || arr[i]<=arr[j])) {

            tmp[k]= arr[i];
            i = i+1; 
          }else{

            tmp[k]= arr[j];
            j = j+1; 
         }

       }

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

