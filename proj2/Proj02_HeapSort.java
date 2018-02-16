

public class Proj02_HeapSort{


    public static void sort(Proj02_DataPair arr[]){

/*
// print beg
           for (Proj02_DataPair v: arr)
              System.out.printf("%d %s\n", v.key, v.value);
          
           System.out.printf("\n");
 */ 
           int n = arr.length;
 
// Build heap (rearrange array)

           for (int i = n / 2 - 1; i >= 0; i--){

//                System.out.println("building the max heap: bubbling down, starting at index "+i);
          
              heapify_quiet(arr, n, i);

            } 


//          System.out.println("--- Heap Sort: The heap is built.  Now extract max values...");

// extract an element from heap
          for (int i=n-1; i>0; i--){

            Proj02_DataPair temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
 //           System.out.println("Swapping the max value that remains in the heap, into the next-highest position in the array:\nswap(0,"+i+")");

  //          System.out.println("Bubbling down the value which was swapped into index [0]   (heapSize="+i+")");
  
            heapify_quiet(arr, i, 0);
           }


/*
// print fin
        for( Proj02_DataPair i : arr ){
         System.out.println(i.key+" "+i.value);
        }
*/


    }
 
    public static void heapify_quiet(Proj02_DataPair arr[], int n, int i) {


 
         int largest = i;  
         int l = 2*i + 1;  
         int r = 2*i + 2;  

         if(l<arr.length){
/*
           System.out.println("  current index: "+i+" (key="+arr[i].key+")");
           System.out.println("    left    index: "+l+" (key="+arr[l].key+")");
           System.out.println("    right   index: "+r+" (key="+arr[r].key+")");
*/

         }


        if(r<=arr.length){
 
            if(arr[i].key>arr[r].key && arr[i].key>arr[l].key){
             
//               System.out.println("  (parent is in correct position, terminating bubble-down)");
           }     
    
        }

 
// left child is larger than root
        if (l < n && arr[l].key > arr[largest].key){
            largest = l;
        }
 
// right child is larger than largest 
        if (r < n && arr[r].key > arr[largest].key){
            largest = r;
        } 

           
// largest is !root
        if (largest != i)
        {
            Proj02_DataPair swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

//            System.out.println("swap("+i+","+largest+")");
 
            heapify_quiet(arr, n, largest);

        }


    }
 





    public static void sort_trace(Proj02_DataPair arr[]){

/*
// print beg
           for (Proj02_DataPair v: arr)
              System.out.printf("%d %s\n", v.key, v.value);
          
          System.out.printf("\n");
*/
  
           int n = arr.length;
 
// Build heap (rearrange array)

           for (int i = n / 2 - 1; i >= 0; i--){

                System.out.println("building the max heap: bubbling down, starting at index "+i);
          
              heapify(arr, n, i);

            } 


          System.out.println("--- Heap Sort: The heap is built.  Now extract max values...");

// extract an element from heap
          for (int i=n-1; i>0; i--){

            Proj02_DataPair temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            System.out.println("Swapping the max value that remains in the heap, into the next-highest position in the array:\nswap(0,"+i+")");

            System.out.println("Bubbling down the value which was swapped into index [0]   (heapSize="+i+")");
  
            heapify(arr, i, 0);
           }


/*
// print fin
        System.out.println();
        for( Proj02_DataPair i : arr ){
         System.out.println(i.key+" "+i.value);
        }
*/


    }
 
    public static void heapify(Proj02_DataPair arr[], int n, int i) {


 
         int largest = i;  
         int l = 2*i + 1;  
         int r = 2*i + 2;  

         if(l<arr.length){

           System.out.println("  current index: "+i+" (key="+arr[i].key+")");
           System.out.println("    left    index: "+l+" (key="+arr[l].key+")");
           System.out.println("    right   index: "+r+" (key="+arr[r].key+")");

         }


        if(r<=arr.length){
 
            if(arr[i].key>arr[r].key && arr[i].key>arr[l].key){
             
               System.out.println("  (parent is in correct position, terminating bubble-down)");
           }     
    
        }

 
// left child is larger than root
        if (l < n && arr[l].key > arr[largest].key){
            largest = l;
        }
 
// right child is larger than largest 
        if (r < n && arr[r].key > arr[largest].key){
            largest = r;
        } 

           
// largest is !root
        if (largest != i)
        {
            Proj02_DataPair swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            System.out.println("swap("+i+","+largest+")");
 
            heapify(arr, n, largest);

        }


    }
 




}

