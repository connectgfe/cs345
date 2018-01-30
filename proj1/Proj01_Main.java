
import java.util.Scanner;
import java.util.ArrayList;


public class Proj01_Main{


  public static void main(String[] args){



    int[] vals = readInput();

//    Proj01_BubbleSort.sort(vals);
//    Proj01_BubbleSort.sort_trace(vals);


//    Proj01_InsertionSort.sort_trace(vals);



    for( int value : vals){
       System.out.printf("%d\n",value);
    }

//    int[] temp = new int[vals.length];
//    testM.sort(vals,temp);

      Proj01_MergeSortBottomUp.sort(vals);
//    Proj01_MergeSort.sort(vals);
//     Proj01_QuickSort.sort(vals);

//      Merge.sort(vals);



    for( int value : vals){
       System.out.printf("%d ",value);
    }
//    System.out.println();  




/*
    Proj01_BubbleSort test1 = new Proj01_BubbleSort();
    Proj01_InsertionSort test2 = new Proj01_InsertionSort();
    System.out.println("BUBBLE");    
    test1.sort(vals);
    System.out.println("INSERT");
    test2.sort(vals);
*/





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

//		for (int v: vals)
//			System.out.printf("%d\n", v);
//		System.out.printf("\n");

		return vals;
	}


}
