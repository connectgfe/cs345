

public class Proj02_CountingSort{


   public static void sort2(Proj02_DataPair[] indat){

        int[] arr = new int[indat.length];

        for(int i=0;i<arr.length;i++){

          arr[i]=indat[i].key;
        }



        int n = arr.length;
 
        // The output character array that will have sorted arr
        int output[] = new int[n];
 
        // Create a count array to store count of inidividul
        // characters and initialize count array as 0
        int count[] = new int[999999];
        for (int i=0; i<999999; ++i)
            count[i] = 0;
 
        // store count of each character
        for (int i=0; i<n; ++i)
            ++count[arr[i]];
 
        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i=1; i<=999998; ++i)
            count[i] += count[i-1];
 
        // Build the output character array
        for (int i = 0; i<n; ++i)
        {
            output[count[arr[i]]-1] = arr[i];
            --count[arr[i]];
        }
 
        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i<n; ++i)
            arr[i] = output[i];


        for( int i : arr ){
         System.out.println(i);
        }

   }

    public static void sort( Proj02_DataPair[] indat,int pos)
 
     {


        int[] input = new int[indat.length];

        for(int i=0;i<input.length;i++){

          input[i]=indat[i].key;


int[] intTab = String.valueOf(input[i]).chars().map(Character::getNumericValue).toArray();


//         System.out.println(intTab[intTab.length-1]);


        }




 
         int min=0,max=0;
 
         for (int i = 1; i < input.length; i++)
 
         {
 
             if (input[i] > max)
 
                 max = input[i];
 
             if (input[i] < min)
 
                 min = input[i];
 
         }
 
         int range =  10; //max - min + 1;

 
 System.out.println("max/min "+max+" "+min);

 
 
         int[] count = new int[range];
 
         //counts frequencies for each element
 
         for (int i = 0; i < input.length; i++){


int[] intTab = String.valueOf(input[i]).chars().map(Character::getNumericValue).toArray();

             if(pos<=intTab.length-1){
 
                count[intTab[intTab.length-(1+pos)]]++;
             }else{

                count[0]++;
             }  

          } 


//checking count arr
          for( int i : count ){
            System.out.println(i);
          }

/*
         // getting positions in final array
 
         for (int i = 1; i < range; i++)
 
             count[i] += count[i - 1];
 
         
         //copy to output array, preserving order of inputs with equal keys
         int j = 0;
 
        for (int i = 0; i < range; i++)
 
             while (j < count[i])
 
                 input[j++] = i + min;
 

        for( int i : input ){
         System.out.println(i);
        }
*/

     }    

}