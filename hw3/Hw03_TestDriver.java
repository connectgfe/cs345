/* Homework 3 - Test driver for the CoolSort algorithm
 *
 * Implements main().  Handles command line arguments.  Reads integers in from
 * stdin.  Uses CoolSort.get() to read the sorted values out again, and prints
 * them.  Will call CoolSort.debug() to create .dot files as we go - if the
 * command line arguments require it.
 */


import java.util.*;

public class Hw03_TestDriver
{
	public static void main(String[] args)
	{
		if (args.length == 0 || args.length > 2)
		{
			System.err.println("SYNTAX: <mode> [<debugFileName>]");
			System.exit(1);
		}

		int mode = Integer.parseInt(args[0]);

		String debugBase = null;
		if (args.length == 2)
			debugBase = args[1];


		Hw03_CoolSort sorter = new Hw03_CoolSort();
		int i = 0;

		Scanner in = new Scanner(System.in);
		while (in.hasNextInt())
		{
			int key = in.nextInt();
			sorter.insert(key);

			if (debugBase != null)
			{
				sorter.debug(String.format("%s-%04d-i-%d.dot",
				                           debugBase, i, key));
				i++;
			}
		}


		while (sorter.isEmpty() == false)
		{
			int key = sorter.get(mode);

			if (debugBase != null)
			{
				sorter.debug(String.format("%s-%04d-g-%d.dot",
				                           debugBase, i, key));
				i++;
			}

			System.out.println(key);
		}
	}
}

