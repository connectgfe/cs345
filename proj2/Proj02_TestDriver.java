import java.util.ArrayList;
import java.util.Scanner;


public class Proj02_TestDriver
{
	public static void main(String[] args)
	{
		/* we read all of the input, before we check the arguments,
		 * to reduce duplication.  Frankly, function pointers would
		 * really make this all work a lot better - but this is Java,
		 * not C.  (sigh)
		 */
		Proj02_DataPair[] vals = readInput();


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
			System.out.printf("    HeapSort\n");
			System.out.printf("    CountingSort   -- (only does a single pass!)\n");
			System.out.printf("    RadixSort\n");
			System.exit(1);
		}



		/* what algorithm should we run? */

		switch(args[0])
		{
		case "HeapSort":
			if (ex && trace)
				Proj02_example_HeapSort.sort_trace(vals);
			else if(ex)
				Proj02_example_HeapSort.sort(vals);
			else if (trace)
				Proj02_HeapSort.sort_trace(vals);
			else
				Proj02_HeapSort.sort(vals);
			break;

		case "CountingSort":
			if (ex && trace)
				Proj02_example_CountingSort.sort_trace(vals, 3);
			else if(ex)
				Proj02_example_CountingSort.sort(vals, 3);
			else if (trace)
  			Proj02_CountingSort.sort_trace(vals, 3);
			else
				Proj02_CountingSort.sort(vals, 3);
			break;

		case "RadixSort":
			if (ex && trace)
				Proj02_example_RadixSort.sort_trace(vals);
			else if(ex)
				Proj02_example_RadixSort.sort(vals);
			else if (trace)
				Proj02_RadixSort.sort_trace(vals);
		else
				Proj02_RadixSort.sort(vals);
			break;

		default:
			System.out.printf("ERROR: Unrecognized sort type '%s'\n", args[0]);
			System.exit(1);
		}

		// dump out the values after the sort has ended
		if (trace)
			System.out.printf("\n");
		for (Proj02_DataPair v: vals)
			System.out.printf("%d %s\n", v.key, v.value);
	}

	private static Proj02_DataPair[] readInput()
	{
		ArrayList<Proj02_DataPair> vals_in = new ArrayList<Proj02_DataPair>();

		Scanner in = new Scanner(System.in);
		while (in.hasNextInt())
		{
			Proj02_DataPair next = new Proj02_DataPair();
			next.key   = in.nextInt();
			next.value = in.next();      // a String

			if (next.key < 0 || next.key >= 1000*1000)
			{
				System.out.printf("ERROR in the input: the key is out of range.  Min: 0   Max: 999,999   Actual: %d\n", next.key);
				continue;
			}

			vals_in.add(next);
		}

		Proj02_DataPair[] vals = new Proj02_DataPair[vals_in.size()];
		for (int i=0; i<vals.length; i++)
			vals[i] = vals_in.get(i);

		for (Proj02_DataPair v: vals)
			System.out.printf("%d %s\n", v.key, v.value);
		System.out.printf("\n");

		return vals;
	}
}

