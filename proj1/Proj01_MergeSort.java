/* Project 1
 *
 * Author: TODO
 *
 * Implements the Merge Sort algorithm (conventional, recursive design).
 */

public class Proj01_MergeSort{


   public static void sort(int[] vals){

     int[] hpr = new int[vals.length];
//     int[] out = sortIt(vals,vals.length/2,hpr);
//     int[] out1 = sortIt2(vals,0,(vals.length/2),hpr);
      sortIt2(vals,0, vals.length-1);


     for(int i : vals){
        System.out.printf("%d ",i);
     }
     System.out.println();

   }


   public static void sort_trace(int[] vals){


   }


   public static void sortIt2(int[] arr, int a, int b){
/*
     if((b-a) < 3 ){ 
     // sort first 6

     helper2(arr,a,b);

     System.out.println("b-a<6 "+a+" "+b); 
       return arr;
     } 
      
     System.out.println("1 a b: "+a+" "+b); 
*/
     if( a < b ){

     int j = a+(b-a)/2;

     sortIt2(arr,a,j);
     sortIt2(arr,j+1,b);

//     helper(arr,(mid/2)+a,mid); 
//     System.out.println("2 a b: "+a+" "+b); 

     merge(arr,a,j,b);

     }
     

   }




/*
   public static int[] sortIt(int[] arr, int mid, int[] out){

     if(mid < 6 ){ 
     // sort first 6

     helper(arr,0,mid);

     System.out.println("mid<6"); 
       return arr;
     } 
      
     System.out.println("mid: "+mid); 

     sortIt(arr,mid/2,out);

     helper(arr,mid/2,mid); 
     System.out.println("mid2: "+mid); 


     return out;

     

   }
*/

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

/*
   public static int[] helper(int[] arr, int a, int b){

    int cnt=0;

    for(int i=a;i<b-1;i++){

       int temp;
       if(arr[i+1]<arr[i]){

          temp=arr[i];
          arr[i]=arr[i+1];
          arr[i+1]=temp;
          cnt++;
       }

//      System.out.println(arr[i]);

    }

     if(cnt==0){return arr;}

     return helper(arr,a,b);

   }

*/




  
}

