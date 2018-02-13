

public class Proj02_CountingSort{


   public static void sort2(Proj02_DataPair[] indat, int pos){

        int[] arr = new int[indat.length];

        for(int i=0;i<arr.length;i++){

          arr[i]=indat[i].key;
        }



        int n = arr.length;
 
        int output_pos[] = new int[n];
        int output_val[] = new int[n];
        
 
        int count[] = new int[10];


         for (int i = 0; i < arr.length; i++){


int[] intTab = String.valueOf(arr[i]).chars().map(Character::getNumericValue).toArray();

             if(pos<=intTab.length-1){
 
                count[intTab[intTab.length-(1+pos)]]++;
                output_pos[i]=intTab[intTab.length-(1+pos)];
             }else{

                count[0]++;
                output_pos[i]=0;
             }  

          } 




// stdout bin totals

        for( int i : count ){
         System.out.println(i);
        }

         System.out.println();

    
        int[] cnt2= count;
        
        for (int i=1; i<=9; ++i)
          cnt2[i] += cnt2[i-1];

         int[] cnt3 = new int[10];
         cnt3[0]=0; 
         for(int i=1;i<cnt3.length;i++){ 
            cnt3[i]=cnt2[i-1];
         }

// stdout updated bins
        for( int i : cnt3 ){
         System.out.println(i);
        }

         System.out.println();


        

// make new array
         int v=0;

        for( int i =0; i<10;i++){

          for(int j=0;j<arr.length;j++){
                
              if(output_pos[j]==i){
 
               output_val[v++]=arr[j];  

              }

          }


        }


        for (int i = 0; i<n; ++i)
            arr[i] = output_val[i];


        for( int i : arr ){
         System.out.println(i);
        }



   }



/*

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




         // getting positions in final array
 
         for (int i = 1; i < range; i++)
 
             count[i] += count[i - 1];
 
         
         //copy to output array, preserving order of inputs with equal keys
         int j = 0;
 
        for (int i = 0; i < range; i++)
 
             while (j < count[i])
 
                 input[j++] = input[i]; //+ min;
 

        for( int i : input ){
         System.out.println(i);
        }


     }    

*/


}
