
import java.util.Scanner;
import java.util.ArrayList;


public class Proj01_Main{


  public static void main(String[] args){


//    int[] vals = { 1, 343, 2, 23, 865, 32, 8};

    int[] vals = readInput();



    Proj01_BubbleSort test1 = new Proj01_BubbleSort();
    Proj01_InsertionSort test2 = new Proj01_InsertionSort();



    System.out.println("BUBBLE");    
    test1.sort(vals);
    System.out.println("INSERT");

    test2.sort(vals);



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
