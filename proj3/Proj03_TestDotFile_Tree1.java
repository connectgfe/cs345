/* Proj03_Main
 *
 * Class to exercise the GenDotFile class.  This hard-codes construction of
 * a single BST, and then gives that tree to GenDotFile.
 *
 * This class intentionally does *NOT* dynamically build a tree, since that
 * would effectively be a solution to the project!  So it hard-codes the
 * structure.
 *
 * However, students should be aware that we will use a *DIFFERENT* tree when
 * we grade their code - and thus, they *MUST* write a version of GenDotFile
 * which will work with *ANY* tree.
 *
 * Should the student write more testcases?  They are welcome to, but I don't
 * think it's necessary.  Instead, they should *USE* GenDotFile, throughout
 * their debug of their main BST code, to show themselves the shapes of the
 * trees they are building!
 */

import java.io.*;

public class Proj03_TestDotFile_Tree1
{
  /* main
   *
   * Test driver for the GenDotFile class.
   *
   * Builds a tree of BSTNode objects (with no wrapper BST class).
   * The shape and content of the tree is hard-coded.  It then
   * passes the entire tree to GenDotFile.gen().
   */
  public static void main(String[] args)
  {
    Proj03_BSTNode all[] = new Proj03_BSTNode[32];
    for (int i=0; i<all.length; i++)
      all[i]       = new Proj03_BSTNode(i, NAMES[i]);

    /* I randomly generated this sequence using a Python script:
     *     10, 30,  0, 22,  5,  4, 29,  2,
     *     17, 21,  7, 12, 15,  1, 28, 11,
     *     25,  9, 31, 16,  3, 19, 18, 14,
     *     24, 26, 13,  8, 20, 27, 23,  6
     *
     * I handled insertion into the BST manually, and used
     * indentation below to show the structure.
     *
     * left/right pointers which are not set are null, since
     * that's how Java handles defaults.
     */

      all[ 0].right       = all[ 5];

            all[ 2].left        = all[ 1];  // leaf 
            all[ 2].right       = all[ 3];  // leaf

          all[ 4].left        = all[ 2];

        all[ 5].left        = all[ 4];
        all[ 5].right       = all[ 7];

          all[ 7].left        = all[ 6];  // leaf
          all[ 7].right       = all[ 9];

            all[ 9].left        = all[ 8];  // leaf

    Proj03_BSTNode root = all[10];
    all[10].left        = all[ 0];
    all[10].right       = all[30];

            all[12].left        = all[11];  // leaf
            all[12].right       = all[15];

                all[14].left        = all[13];  // leaf

              all[15].left        = all[14];
              all[15].right       = all[16];

          all[17].left        = all[12];
          all[17].right       = all[21];

              all[19].left        = all[18];
              all[19].right       = all[20];

            all[21].left        = all[19];

        all[22].left        = all[17];
        all[22].right       = all[29];

                all[24].left        = all[23];  // leaf

              all[25].left        = all[24];
              all[25].right       = all[26];

                all[26].right       = all[27];  // leaf

            all[28].left        = all[25];

          all[29].left        = all[28];

      all[30].left        = all[22];
      all[30].right       = all[31];

    try {
      Proj03_GenDotFile.gen(root, "sanity_check.dot");
      System.out.println("Test done, gen() returned without throwing an exception.");
      System.out.println("Hopefully, it actually generated a file.");
    } catch (IOException e) {
      System.out.println("ERROR: Could not open the file for writing.");
    }
  }


  public static final String[] NAMES =
      { "Fred",     "Wilma",    "Alice",    "Bob",
        "Algernon", "Charlie",  "Breetai",  "Gloval",
        "Fido",     "Fido",     "Fido Again", "Can't Stop Saying Fido",
        "Russ",     "Emily",    "Eric",     "Rose",
        "Valar",    "Sindar",   "Vanyar",   "Noldor",
        "Andor",    "Cairhien", "Sheinar",  "Tear",
        "USA",      "UK",       "UAE",      "UFP",
        "Tree",     "List",     "Array",    "Pile of Index Cards"};
}

