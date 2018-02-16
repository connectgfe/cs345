


public class Proj02_RadixSort{



  public static void sort(Proj02_DataPair[] arr){

/*
          for (Proj02_DataPair v: arr)
              System.out.printf("%d %s\n", v.key, v.value);
  
           System.out.printf("\n");
*/

           int pos=0;
   
           for (int i = 0; i < arr.length; i++){

              int[] inVal = String.valueOf(arr[i].key).chars().map(Character::getNumericValue).toArray();
       
               if(inVal.length>pos){ 
                 pos=inVal.length;
               } 

            } 



             for(int i=0; i<=pos; i++){ 
     
//                System.out.println("--- RADIX SORT: pos="+i+" ---"); 
                Proj02_CountingSort.sortIt(arr,i);

              }


 /*    
              for (Proj02_DataPair v: arr)
                 System.out.printf("%d %s\n", v.key, v.value);
*/     
  }


  public static void sort_trace(Proj02_DataPair[] arr){

/*
          for (Proj02_DataPair v: arr)
              System.out.printf("%d %s\n", v.key, v.value);
  
           System.out.printf("\n");
*/

           int pos=0;
   
           for (int i = 0; i < arr.length; i++){

              int[] inVal = String.valueOf(arr[i].key).chars().map(Character::getNumericValue).toArray();
       
               if(inVal.length>pos){ 
                 pos=inVal.length;
               } 

            } 



             for(int i=0; i<=pos; i++){ 
     
                System.out.println("--- RADIX SORT: pos="+i+" ---"); 
                Proj02_CountingSort.sortIt_trace(arr,i);
                System.out.println();

              }

/*
              System.out.printf("\n");
     
              for (Proj02_DataPair v: arr)
                 System.out.printf("%d %s\n", v.key, v.value);
 */     
  }







}
