/* Proj03_BST
 *
 * Author: Russ Lewis
 *
 * Represents a single node in a BST.  Carries both a key and satellite data.
 * For simplicity, I have not made this a generic - though I might add that
 * later.  And since students will be using this as a utility class (rather
 * than modifying it for themselves), it does not have any methods.
 */

public interface Proj03_BST
{
  /* void insert(int,String)
   *
   * Inserts a given (key,value) pair into the tree.
   *
   * This call may assume that the key is non-negative, and that the
   * value is not null.  (It may, but is not required to, enforce
   * these assumptions.)
   *
   * Throws IllegalArgumentException if the key already exists in
   * the tree.
   */
  void   insert(int key, String value);


  /* String search(int)
   *
   * Searches the tree for a given key; returns the associated String
   * if the key is found, or null if it is not found.
   */
  String search(int key);


  /* void delete(int)
   *
   * Removes a given node from the tree, found by the key.
   *
   * Throws IllegalArgumentException if the key does not exist.
   */
  void   delete(int key);


  /* void rotateLeft(int)
   *
   * Searches the tree for a given key, and then performs a rotate left
   * at that location.  A "rotate left" means that the selected node
   * moves down, and the right child of that node moves up to be the new
   * root.
   *
   * Throws IllegalArgumentException if the key does not exist.
   * Throws IllegalArgumentException if the selected node does not have
   * a right child.
   */
  void   rotateLeft (int at);


  /* void rotateRight(int)
   *
   * Same as rotateLeft, except that it rotates right.
   */
  void   rotateRight(int at);


  /* void printInOrder()
   *
   * Performs an in-order traversal of the tree, and prints out all of
   * the nodes.  It does *not* print out a trailing newline.
   *
   * For each node, it prints both the key and the value, separated by
   * a colon; the various nodes are separated by a space.  (There is
   * also a space before the first node.)
   *
   * If the tree is empty, then it will not print out anything.
   */
  void printInOrder();


  /* void printPostOrder()
   *
   * Same as printInOrder(), except that it performs a post-order
   * traversal.
   */
  void printPostOrder();


  /* void genDebugDot(String)
   *
   * Generates a \texttt{.dot} file which represents the tree; the
   * String is the name of the file to generate.
   */
  void genDebugDot(String filename);
}

