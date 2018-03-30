/* Proj03_BSTNode
 *
 * Author: Russ Lewis
 *
 * Represents a single node in a BST.  Carries both a key and satellite data.
 * For simplicity, I have not made this a generic - though I might add that
 * later.  And since students will be using this as a utility class (rather
 * than modifying it for themselves), it does not have any methods.
 */

public class Proj03_BSTNode
{
  public int    key;
  public String value;

  public Proj03_BSTNode left,right;


  /* constructor
   *
   * Parameters: int,String
   *
   * Generates a single BSTNode (with no children), with the key/value
   * pair given.
   */
  public Proj03_BSTNode(int key, String value)
  {
    if (value == null)
      throw new IllegalArgumentException("BSTNode: The 'value' parameter was null");

    this.key   = key;
    this.value = value;

    // the left,right nodes default to 'null' (Java defaults)
  }
}

