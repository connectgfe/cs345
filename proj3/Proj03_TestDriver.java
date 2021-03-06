/* Proj03_TestDriver
 *
 * Class to exercise the BST class.  It reads a command file from stdin, and
 * performs operations on the BSTs.
 *
 * It supports 4 BSTs, in order to expose students who use global variables.
 */

import java.util.*;

public class Proj03_TestDriver
{
  /* main
   *
   * Test driver for the BST_student class (and, for comparison,
   * the BST_example class).
   *
   * Reads commands from stdin; passes these commands as operations
   * on the tree.
   */
  public static void main(String[] args)
  {
    boolean  ex   = false;
    boolean debug = false;
    if (args.length == 1 && args[0].equals("example"))
    {
      ex    = true;
    }
    else if (args.length == 2 && args[0].equals("example") && args[1].equals("debug"))
    {
      ex    = true;
      debug = true;
    }
    else if (args.length == 0)
    {
      /* NOP, use the defaults */
    }
    else if (args.length == 1 && args[0].equals("debug"))
    {
      debug = true;
    }
    else
    {
      System.out.printf("SYNTAX: example? debug?\n");
      System.exit(1);
    }


    /* there are 4 trees (so that we can detect if a student is
     * using global variables or not).
     *
     * We will use the 'ex' flag to decide whether we build the
     * example BST, or the student version.  From here on, we
     * won't need the 'ex' switch - we'll just use virtual
     * dispatch, from the trees themselves, to automatically get
     * the correct implementation.
     */
    Proj03_BST[] trees = new Proj03_BST[4];
    for (int i=0; i<trees.length; i++)
    {
      if (ex)
        trees[i] = new Proj03_BST_example();
      else
        trees[i] = new Proj03_BST_student();
    }


    /* we'll read the commands from stdin.  Note that our input
     * parser is *VERY* forgiving; we'll always assume that the
     * input has valid format.
     */
    Scanner in = new Scanner(System.in);

    while (in.hasNext())
    {
      /* there's something left on stdin.  If that something
       * isn't an integer, then we have a problem.  (Unless
       * there's a comment.)
       */
      if (in.hasNextInt() == false)
      {
        /* is it a comment?
         *
         * We read this with nextLine() instead of
         * next() because, if we find a comment, we
         * need to be to consume the rest of the line -
         * and if we've called next(), then we have
         * *no way to know* if we're still on the
         * comment-line, or after it now.
         *
         * Problem is, nextLine() will happily read
         * empty lines.  So, since (a) we know that
         * there is another token; and (b) we don't
         * know how many lines to consume until we get
         * there we have a while() loop.
         *
         * Oh, and one more complication: we need to
         * trim leading and trailing whitespace - both
         * so we can detect whitespace-only lines (and
         * ignore them), and also so we can detect
         * comments that don't start at the head of
         * the line.
         */
        String nextLine = in.nextLine().trim();
        while (nextLine.equals(""))
          nextLine = in.nextLine().trim();

        if (nextLine.substring(0,1).equals("#"))
        {
          // this is a comment!
          continue;
        }

        /* otherwise, this is a syntax error */
        System.out.printf("TESTCASE ERROR: The a command started with some word which was *NOT* an integer.  line: '%s'\n", nextLine);
        System.exit(1);
      }
      int treeNum = in.nextInt();

      /* sanity check the *value* read */
      if (treeNum < 0 || treeNum >= trees.length)
      {
        System.out.printf("TESTCASE ERROR: The treeNum was invalid.  treeNum=%d\n", treeNum);
        System.exit(1);
      }
      Proj03_BST tree = trees[treeNum];


      if (in.hasNext() == false)
      {
        System.out.printf("TESTCASE ERROR: Invalid command.  A treeNum was not followed by anything else in the file\n");
        System.exit(1);
      }
      String cmd = in.next();


      boolean intParam = false;
      boolean strParam = false;
      switch (cmd)
      {
      default:
        System.out.printf("TESTCASE ERROR: Unrecognized command '%s'\n", cmd);
        System.exit(1);

      case "insert":
        intParam = strParam = true;
        break;

      case "search":
      case "delete":
      case "rotateLeft":
      case "rotateRight":
        intParam = true;
        break;

      case "inOrder":
      case "postOrder":
        break;   // no params for these two!

      case "debug":
        strParam = true;
        break;
      }


      int    paramI = -1;
      String paramS = null;

      if (intParam)
      {
        if (in.hasNextInt() == false)
        {
          System.out.printf("TESTCASE ERROR: The ommand did not have the type of parameters that it expected.\n");
          System.exit(1);
        }
        paramI = in.nextInt();
      }

      if (strParam)
      {
        if (in.hasNext() == false)
        {
          System.out.printf("TESTCASE ERROR: The ommand did not have the type of parameters that it expected.\n");
          System.exit(1);
        }
        paramS = in.next();
      }


      // now, perform thevarious commands.
      switch (cmd)
      {
      default:
        throw new IllegalArgumentException("INTERNAL ERROR: In the TesetDriver, the set of strings accepts by the 2nd switch() doesn't match the first.\n");

      case "insert":
        try {
          tree.insert(paramI, paramS);
          System.out.printf("inserted %d:%s\n", paramI,paramS);
        } catch(IllegalArgumentException e) {
          System.out.printf("FAILED to insert %d:%s: %s\n", paramI,paramS, e.getMessage());
        }
        break;

      case "search":
        {
          String searchResult = tree.search(paramI);

          if (searchResult != null)
          {
            System.out.printf("Found key %d - value=%s\n", paramI,searchResult);
          }
          else
          {
            System.out.printf("Key %d NOT FOUND\n", paramI);
          }
        }
        break;

      case "delete":
        try {
          tree.delete(paramI);
          System.out.printf("deleted key %d\n", paramI);
        } catch(IllegalArgumentException e) {
          System.out.printf("FAILED TO delete key %d: %s\n", paramI, e.getMessage());
        }
        break;

      case "rotateLeft":
        try {
          tree.rotateLeft(paramI);
          System.out.printf("rotated left at %d\n", paramI);
        } catch(IllegalArgumentException e) {
          System.out.printf("FAILED to rotate left at %d: %s\n", paramI, e.getMessage());
        }
        break;

      case "rotateRight":
        try {
          tree.rotateRight(paramI);
          System.out.printf("rotated right at %d\n", paramI);
        } catch(IllegalArgumentException e) {
          System.out.printf("FAILED to rotate right at %d: %s\n", paramI, e.getMessage());
        }
        break;

      case "inOrder":
        System.out.printf("IN   ORDER:");
        tree.printInOrder();
        System.out.printf("\n");
        break;

      case "postOrder":
        System.out.printf("POST ORDER:");
        tree.printPostOrder();
        System.out.printf("\n");
        break;

      case "debug":
        // ignore 'debug' commands if the user didn't
        // ask for debug.
        if (debug)
        {
          System.out.printf("Dumping to the file %s\n", paramS);
          tree.genDebugDot(paramS);
        }
        else
        {
          System.out.printf("Skipping a debug command (filename='%s'), because the user did not pass the 'debug' command-line option\n", paramS);
        }
        break;
      }
    }

    // we never get here!
  }
}

