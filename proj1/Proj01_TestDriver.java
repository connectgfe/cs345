import java.util.ArrayList;
import java.util.Scanner;


public class Proj01_TestDriver
{
	public static void main(String[] args)
	{
		/* we read all of the input, before we check the arguments,
		 * to reduce duplication.  Frankly, function pointers would
		 * really make this all work a lot better - but this is Java,
		 * not C.  (sigh)
		 */
		int[] vals = readInput();


		boolean  ex   = false;
		boolean trace = false;
		if (args.length == 2 && args[1].equals("example"))
		{
			ex    = true;
		}
		else if (args.length == 3 && args[1].equals("example") && args[2].equals("trace"))
		{
			ex    = true;
			trace = true;
		}
		else if (args.length == 1)
		{
			/* NOP, use the defaults */
		}
		else if (args.length == 2 && args[1].equals("trace"))
		{
			trace = true;
		}
		else
		{
			System.out.printf("SYNTAX: [sortType] example? trace?\n");
			System.out.printf("  Available sorts:\n");
			System.out.printf("    BubbleSort\n");
			System.out.printf("    InsertionSort\n");


			System.out.printf("    QuickSort\n");
			System.out.printf("    MergeSort\n");
//			System.out.printf("    MergeSortBottomUp\n");


	

			System.exit(1);
		}



		/* what algorithm should we run? */

		switch(args[0])
		{
		case "BubbleSort":
			if (ex && trace)
				Proj01_example_BubbleSort.sort_trace(vals);
			else if(ex)
				Proj01_example_BubbleSort.sort(vals);
			else if (trace)
				Proj01_BubbleSort.sort_trace(vals);
			else
				Proj01_BubbleSort.sort(vals);
			break;

		case "InsertionSort":
			if (ex && trace)
				Proj01_example_InsertionSort.sort_trace(vals);
			else if(ex)
				Proj01_example_InsertionSort.sort(vals);
			else if (trace)
				Proj01_InsertionSort.sort_trace(vals);
			else
				Proj01_InsertionSort.sort(vals);
			break;

		case "QuickSort":
			if (ex && trace)
				Proj01_example_QuickSort.sort_trace(vals);
			else if(ex)
				Proj01_example_QuickSort.sort(vals);
			else if (trace)
				Proj01_QuickSort.sort_trace(vals);
			else
				Proj01_QuickSort.sort(vals);
			break;

		case "MergeSort":
			if (ex && trace)
				Proj01_example_MergeSort.sort_trace(vals);
			else if(ex)
				Proj01_example_MergeSort.sort(vals);
			else if (trace)
				Proj01_MergeSort.sort_trace(vals);
			else
				Proj01_MergeSort.sort(vals);
			break;
/*
		case "MergeSortBottomUp":
			if (ex && trace)
				Proj01_example_MergeSortBottomUp.sort_trace(vals);
			else if(ex)
				Proj01_example_MergeSortBottomUp.sort(vals);
			else if (trace)
				Proj01_MergeSortBottomUp.sort_trace(vals);
			else
				Proj01_MergeSortBottomUp.sort(vals);
			break;
*/
		}



		// dump out the values after the sort has ended
		if (trace)
			System.out.printf("\n");
		for (int v: vals)
			System.out.printf("%d\n", v);
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

