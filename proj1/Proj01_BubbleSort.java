/* Project 1
 *
 * Author: TODO
 *
 * Implements the Bubble Sort algorithm.
 */

import java.util.ArrayList;
import java.util.Scanner;


public class Proj01_BubbleSort{


   public static void sort(int[] vals){


      int[] out=sortIt(vals); 
      

   }



   public static void sort_trace(int[] vals){
 
      int[] out2=sortItTrace(vals);
 
   
   }


   public static int[] sortIt(int[] arr){

    int cnt=0;

    for(int i=0;i<arr.length-1;i++){     

       int temp; 
       if(arr[i+1]<arr[i]){
         
          temp=arr[i];
          arr[i]=arr[i+1];
          arr[i+1]=temp; 
          cnt++;

//      System.out.println("swap("+i+","+(i+1)+")");

       }  
 
//      System.out.println(arr[i]);

    }




     if(cnt==0){return arr;}

     return sortIt(arr);

   }


   public static int[] sortItTrace(int[] arr){

    int cnt=0;

    for(int i=0;i<arr.length-1;i++){     

       int temp; 
       if(arr[i+1]<arr[i]){
         
          temp=arr[i];
          arr[i]=arr[i+1];
          arr[i+1]=temp; 
          cnt++;

      System.out.println("swap("+i+","+(i+1)+")");

       }  
 
//      System.out.println(arr[i]);

    }




     if(cnt==0){
      System.out.println();
     return arr;}

     return sortItTrace(arr);

   }







}

