

public class Proj02_HeapSort{

    public static void sort(Proj02_DataPair indat[]){

        int[] arr = new int[indat.length];

        for(int i=0;i<arr.length;i++){

          arr[i]=indat[i].key;
        }

 
        int n = arr.length;
 
        // Build heap (rearrange array)

        for (int i = n / 2 - 1; i >= 0; i--){

          System.out.println("building the max heap: bubbling down, starting at index "+i);


//          System.out.println("  current index: "+i+" (key="+indat[i].key+")");

           
            heapify(arr, n, i, indat);


        } 


          System.out.println("--- Heap Sort: The heap is built.  Now extract max values...");

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--){
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            System.out.println("Bubbling down the value which was swapped into index [0]   (heapSize="+i+")");
 
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0, indat);
        }

        for( int i : arr ){
         System.out.println(i);
        }

    }
 
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    public static void heapify(int arr[], int n, int i, Proj02_DataPair[] indat)
    {


        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2

        if(l<=arr.length){

          System.out.println("  current index: "+i+" (key="+indat[i].key+")");

        System.out.println("   left    index: "+l+" ("+indat[l].key+")");
        System.out.println("   right   index: "+r+" ("+indat[r].key+")");


        }

 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;


            System.out.println("swap("+i+","+largest+")");

 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest,indat);
        }
    }
 
}

