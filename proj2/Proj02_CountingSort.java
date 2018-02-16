

public class Proj02_CountingSort{



   public static void sort(Proj02_DataPair[] vals, int pos){

/*
// print beg
                 for (Proj02_DataPair v: vals)
                        System.out.printf("%d %s\n", v.key, v.value);
                System.out.printf("\n");
*/

                sortIt(vals,pos);

/*
// print fin
                for (Proj02_DataPair v: vals)
                        System.out.printf("%d %s\n", v.key, v.value);
*/

       

   }

   public static void sortIt(Proj02_DataPair[] indat, int pos){

        int[] arr = new int[indat.length];

        for(int i=0;i<arr.length;i++){

          arr[i]=indat[i].key;
        }



        int n = arr.length;
 
        int output_pos[] = new int[n];
        Proj02_DataPair output_val[] = new Proj02_DataPair[n];
         
        int count[] = new int[10];
/*
        System.out.println("-- Beginning Counting Sort, with pos="+pos+" --");
        System.out.println("  Performing the count:");
*/

         for (int i = 0; i < arr.length; i++){


            int[] inVal = String.valueOf(arr[i]).chars().map(Character::getNumericValue).toArray();

             if(pos<=inVal.length-1){
 
                count[inVal[inVal.length-(1+pos)]]++;
                output_pos[i]=inVal[inVal.length-(1+pos)];
 //               System.out.println("    index="+i+" : Key="+arr[i]+" -> Bin="+inVal[inVal.length-(1+pos)]);

             }else{

                count[0]++;
                output_pos[i]=0;

  //              System.out.println("    index="+i+" : Key="+arr[i]+" -> Bin=0");


             }  

          } 




// stdout bin totals
   //        System.out.println("Count totals:");

           for (int i=0; i<10; ++i){

    //          System.out.println("  bin "+i+": count="+count[i]);
            } 


     //      System.out.println("Indices at beginning of copy:");
 
           int[] cnt2= count;
        
           for (int i=1; i<=9; ++i)
              cnt2[i] += cnt2[i-1];

           int[] cnt3 = new int[10];
           cnt3[0]=0; 
           for(int i=1;i<cnt3.length;i++){ 
             cnt3[i]=cnt2[i-1];
           }

       

           for (int i=0; i<10; ++i){

      //      System.out.println("  bin "+i+": pos="+cnt3[i]);
           } 


       //    System.out.println("Contents after sort:");
        //   System.out.print(" ");

        
// make new array
           int v=0;

           for( int i =0; i<10;i++){

              for(int j=0;j<arr.length;j++){
                
                if(output_pos[j]==i){
 
                 output_val[v++]=indat[j];  

                 }

               }

             }


           for (int i = 0; i<n; ++i)
              indat[i] = output_val[i];


   //        for (int i = 0; i<n; ++i)
         //     System.out.print(" "+indat[i].key+"("+indat[i].value+")" );



   //        System.out.println();
   //        System.out.println();

   }







   public static void sort_trace(Proj02_DataPair[] vals, int pos){

/*
// print beg
                 for (Proj02_DataPair v: vals)
                        System.out.printf("%d %s\n", v.key, v.value);
                System.out.printf("\n");
*/

                sortIt_trace(vals,pos);

/*
// print fin
                for (Proj02_DataPair v: vals)
                        System.out.printf("%d %s\n", v.key, v.value);
*/

       

   }

   public static void sortIt_trace(Proj02_DataPair[] indat, int pos){

        int[] arr = new int[indat.length];

        for(int i=0;i<arr.length;i++){

          arr[i]=indat[i].key;
        }



        int n = arr.length;
 
        int output_pos[] = new int[n];
        Proj02_DataPair output_val[] = new Proj02_DataPair[n];
         
        int count[] = new int[10];

        System.out.println("-- Beginning Counting Sort, with pos="+pos+" --");
        System.out.println("  Performing the count:");


         for (int i = 0; i < arr.length; i++){


            int[] inVal = String.valueOf(arr[i]).chars().map(Character::getNumericValue).toArray();

             if(pos<=inVal.length-1){
 
                count[inVal[inVal.length-(1+pos)]]++;
                output_pos[i]=inVal[inVal.length-(1+pos)];
                System.out.println("    index="+i+" : Key="+arr[i]+" -> Bin="+inVal[inVal.length-(1+pos)]);

             }else{

                count[0]++;
                output_pos[i]=0;

                System.out.println("    index="+i+" : Key="+arr[i]+" -> Bin=0");


             }  

          } 




// stdout bin totals
           System.out.println("Count totals:");

           for (int i=0; i<10; ++i){

              System.out.println("  bin "+i+": count="+count[i]);
            } 


           System.out.println("Indices at beginning of copy:");
 
           int[] cnt2= count;
        
           for (int i=1; i<=9; ++i)
              cnt2[i] += cnt2[i-1];

           int[] cnt3 = new int[10];
           cnt3[0]=0; 
           for(int i=1;i<cnt3.length;i++){ 
             cnt3[i]=cnt2[i-1];
           }

       

           for (int i=0; i<10; ++i){

            System.out.println("  bin "+i+": pos="+cnt3[i]);
           } 


           System.out.println("Contents after sort:");
           System.out.print(" ");

        
// make new array
           int v=0;

           for( int i =0; i<10;i++){

              for(int j=0;j<arr.length;j++){
                
                if(output_pos[j]==i){
 
                 output_val[v++]=indat[j];  

                 }

               }

             }


           for (int i = 0; i<n; ++i)
              indat[i] = output_val[i];


           for (int i = 0; i<n; ++i)
              System.out.print(" "+indat[i].key+"("+indat[i].value+")" );



           System.out.println();
//           System.out.println();

   }


}



