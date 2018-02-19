

public class MergeS{


  public static void sort(int[] arr){


    int mid;

    if(arr.length%2!=0){ 
      mid = (arr.length/2)+1;
    }else{ 
      mid = arr.length/2;
    }

    System.out.println(mid);

    for(int l=0;l<mid;l=l+2){
/*
      if( mid%2!=0 && l+2>mid ){

         break;

      }else{ 
*/
        System.out.print(arr[l]+","+arr[l+1]+": ");

        swap(arr,l,l+1);
//      }

    }
  

    System.out.println();
 

    for(int r=mid;r<arr.length;r=r+2){


      if( arr.length%2!=0 && r+2>arr.length ){

         break;


      }else{
       System.out.print(arr[r]+","+arr[r+1]+": ");
     
       swap(arr,r,r+1);
      }

    }

    System.out.println();
 
    printArr(arr); 
    
    merge(arr,0,2);
 
    merge(arr,4,6);

    merge(arr,0,4);     
 
    System.out.println();
 

  }



  public static void merge(int[] arr, int a, int b){

   int[] tmp;

   if(((2*b)-a)>arr.length){

     tmp = new int[2*(b-a)-1];

   }else{
     tmp = new int[2*(b-a)];
 
   }

   int aEnd=b;
   int beg=a;
   int end=(2*b)-a; 
   for(int i=0;i<tmp.length;i++){  

 
      if(b==tmp.length || b==arr.length){ tmp[i]=arr[a]; a++; continue;}
      if(a==aEnd){ tmp[i]=arr[b]; b++; continue;}

 
      if(arr[b]<arr[a]){

         tmp[i]=arr[b];
         b++;

         printArr(tmp);

      }else{
 
         tmp[i]=arr[a];
         a++;
      
         printArr(tmp);


      }

   }

   for(int i=beg,j=0;i<(beg+tmp.length);i++,j++){

     arr[i]=tmp[j];
   }
   

    printArr(tmp);

  }

  public static void printArr(int[] arr){

   for( int i: arr)
    System.out.printf("%d ",i);
   System.out.println();


  }



  public static void swap(int[] arr, int a, int b){

       int temp;

       if(arr[a]>arr[b]){

          temp = arr[a];
          arr[a]=arr[b];
          arr[b]=temp;

       }


  }


}




