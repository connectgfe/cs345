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
      
      for(int i=0;i<out.length;i++){
       
         System.out.println(out[i]); 
      }


   }



   public static void sort_trace(int[] vals){


   
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
       }  
 
//      System.out.println(arr[i]);

    }

     if(cnt==0){return arr;}

     return sortIt(arr);

   }



	private static int[] readInput()
	{
		ArrayList<Integer> vals_in = new ArrayList<Integer>();

		Scanner in = new Scanner(System.in);
		while (in.hasNextInt())
			vals_in.add(in.nextInt());

		int[] vals = new int[vals_in.size()];
		for (int i=0; i<vals.length; i++)
			vals[i] = vals_in.get(i);

		for (int v: vals)
			System.out.printf("%d\n", v);
		System.out.printf("\n");

		return vals;
	}



}

