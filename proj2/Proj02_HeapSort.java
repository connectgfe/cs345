

public class Proj02_HeapSort{

    public static void sort(Proj02_DataPair arr[]){
/*
        int[] arr = new int[indat.length];

        for(int i=0;i<arr.length;i++){

          arr[i]=indat[i].key;
        }
*/
 
        int n = arr.length;
 
        // Build heap (rearrange array)

        for (int i = n / 2 - 1; i >= 0; i--){

          System.out.println("building the max heap: bubbling down, starting at index "+i);


//          System.out.println("  current index: "+i+" (key="+indat[i].key+")");

           
            heapify(arr, n, i);


        } 


          System.out.println("--- Heap Sort: The heap is built.  Now extract max values...");

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--){
            // Move current root to end
            Proj02_DataPair temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            System.out.println("Bubbling down the value which was swapped into index [0]   (heapSize="+i+")");
 
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
/*
        for( int i : arr ){
         System.out.println(i);
        }
*/

        

    }
 
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    public static void heapify(Proj02_DataPair arr[], int n, int i)
    {

 
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2

        if(l<=arr.length){

        System.out.println("  current index: "+i+" (key="+arr[i].key+")");

        System.out.println("   left    index: "+l+" ("+arr[l].key+")");
        System.out.println("   right   index: "+r+" ("+arr[r].key+")");


        }

 
        // If left child is larger than root
        if (l < n && arr[l].key > arr[largest].key){
          System.out.println("In heap l > root");
            largest = l;
        }
 
        // If right child is larger than largest so far
        if (r < n && arr[r].key > arr[largest].key){
          System.out.println("In heap r > root");
            largest = r;
        } 

/*

        if (  !(l < n && arr[l] > arr[largest]) && !(r < n && arr[r] > arr[largest]) ){

          System.out.println(" YESSS In heap r > root");
         
        }
*/
         
        // If largest is not root
        if (largest != i)
        {
            Proj02_DataPair swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;


            System.out.println("swap("+i+","+largest+")");

 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);

        }


    }
 
}

