import java.util.Random;


public class Main{


   public static void main(String[] args){


     Random rand = new Random();
/*
     int[] arr = new int[10000];

     for(int i=0;i<arr.length;i++){ 

       arr[i]=rand.nextInt();
     }
*/


     int[] arr = { 3, 8, 1, 2, 6, 4,1 ,4,3,22, 143, 829, 28, 18};


     for( int i: arr )
       System.out.printf("%d ",i );
     System.out.println();




//    InsertS.sort(arr);
      MergeS.sort(arr);





     for( int i: arr )
       System.out.printf("%d ",i );
     System.out.println();




   }


}

