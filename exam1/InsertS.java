

public class InsertS{


   public static void sort( int[] arr){


//        printArr(arr);
//        System.out.println();

        int cnt=0;

        int n = arr.length;
        for (int i=1; i<n; ++i)
        {

//         System.out.println(i+" "+arr[i]);
            int key = arr[i];
            int j = i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
                cnt++;
//                printArr(arr);

            }
            arr[j+1] = key;
//            cnt++;
//            printArr(arr);

        }

        System.out.println(cnt);


   }



  public static void printArr(int[] arr){

   for( int i: arr){

    System.out.printf("%d ", i);

   } 
   System.out.println();

  }



}
